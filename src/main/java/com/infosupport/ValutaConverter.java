package com.infosupport;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * Created by Erik on 25-10-2016.
 */
@Named
@RequestScoped
@Data
public class ValutaConverter {

    private Double value;
    private String valuta;
    private ValutaList valutaList;

    public ValutaConverter(){
        valutaList = ValutaList.getInstance();
    }

    public String convertEuroToSelectedValuta(){
        Valuta valuta = valutaList.getValutas().stream().filter(v -> v.getName().equals(this.valuta)).findFirst().get();
        Double value = this.value * valuta.getValue();
        return valuta.getSymbol() + (value.toString().substring(0, value.toString().indexOf('.')+3));
    }
}
