package com.lucio.crmspring.dto;

import java.util.Map;

public class MapDTO {

    private Map<String,Integer> dataInteger;
    private Map<String,Double> dataDouble;

    public Map<String, Integer> getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(Map<String, Integer> dataInteger) {
        this.dataInteger = dataInteger;
    }

    public Map<String, Double> getDataDouble() {
        return dataDouble;
    }

    public void setDataDouble(Map<String, Double> dataDouble) {
        this.dataDouble = dataDouble;
    }
}
