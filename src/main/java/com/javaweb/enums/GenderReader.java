package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum GenderReader {
    Nam("Nam"),
    Nu("Nữ");
    private final String value;
    GenderReader(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static Map<String,String> fromValue() {
        Map<String,String> Gender = new TreeMap<>();
        for (GenderReader gender : GenderReader.values()) {
            Gender.put(gender.name(), gender.getValue());
        }
        return Gender;
    }

}
