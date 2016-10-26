package com.infosupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik on 25-10-2016.
 */
public class ValutaList {
    private static ValutaList valutaList;
    private static List<Valuta> valutas;

    private ValutaList(){
        valutas = new ArrayList<>();
        valutas.add(Valuta.builder().name("USD").value(1.0885).symbol("$").build());
        valutas.add(Valuta.builder().name("YEN").value(113.693336).symbol("¥").build());
        valutas.add(Valuta.builder().name("GBP").value(0.889624453).symbol("£").build());
    }

    public static ValutaList getInstance(){
        if(valutaList == null){
            valutaList = new ValutaList();
        }
        return valutaList;
    }

    public List<Valuta> getValutas(){
        return valutas;
    }
}
