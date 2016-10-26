package com.infosupport;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Erik on 25-10-2016.
 */
@Data
@Builder
public class Valuta {
    private String name;
    private double value;
    private String symbol;
}
