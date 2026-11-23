package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum LoanDetail {
    Tot("Tốt"),
    Rach("Rách"),
    Mat("Mất");
    private final String NameReturnCondition;
    LoanDetail(String NameReturnCondition) {
        this.NameReturnCondition = NameReturnCondition;
    }
    public String getNameReturnCondition() {return NameReturnCondition;}
    public static Map<String,String> type(){
        Map<String,String> returncondition = new TreeMap<>();
        for(LoanDetail detail : LoanDetail.values()){
            returncondition.put(detail.toString(),detail.NameReturnCondition);
        }
        return returncondition ;
    }

}
