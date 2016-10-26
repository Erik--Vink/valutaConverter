package com.infosupport;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Erik on 25-10-2016.
 */
@Named
@SessionScoped
@Data
public class ValutaConverter implements Serializable {

    private Double value;
    private String valuta;
    private ValutaList valutaList;
    private String sortDirection;

    public ValutaConverter(){
        valutaList = ValutaList.getInstance();
        sortDirection = "asc";
    }

    public String convertEuroToSelectedValuta(){
        Valuta valuta = valutaList.getValutas().stream().filter(v -> v.getName().equals(this.valuta)).findFirst().get();
        Double value = this.value * valuta.getValue();
        return valuta.getSymbol() + (value.toString().substring(0, value.toString().indexOf('.')+3));
    }

    public String sortValutasByName(){
        sortDirection = sortDirection.equals("asc")? "desc" : "asc";
        Collections.sort(valutaList.getValutas(), (key_1, key_2) -> {
            if (sortDirection.equals("asc")) {
                return key_1.getName().
                        compareTo(key_2.getName());
            } else {
                return key_2.getName().compareTo(key_1.getName());
            }
        });
        return null;
    }

    public String sortValutasByValue(){
        sortDirection = sortDirection.equals("asc")? "desc" : "asc";
        Collections.sort(valutaList.getValutas(), (key_1, key_2) -> (sortDirection.equals("asc") ? 1 : -1) * ((int) key_1.getValue() - (int) key_2.getValue()));
        return null;
    }
}
