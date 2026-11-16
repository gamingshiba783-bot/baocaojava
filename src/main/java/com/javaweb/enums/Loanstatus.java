package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum Loanstatus {
    BORROWING(1,"Đang mượn"),
    OVERDUE(0,"Quá hạn");

    private final int code;
    private final String statusname;
    Loanstatus(int code,String statusname) {
        this.statusname = statusname;
        this.code = code;
    }
    public String getStatusname() {
        return this.statusname;
    }

    public int getCode() {
        return code;
    }

    public static Map<String,String> type(){
        Map<String,String> loanstatus = new TreeMap<>();
        for(Loanstatus ls : Loanstatus.values()){
            loanstatus.put(ls.toString(), ls.statusname);
        }
        return loanstatus;
    }
    public static Loanstatus fromCode(Integer code) {
        if (code != null) {
            for (Loanstatus s : values()) {
                if (s.code == code) return s;
            }
        }
        return BORROWING;
    }

}
