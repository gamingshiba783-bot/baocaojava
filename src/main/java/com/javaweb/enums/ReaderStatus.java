package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum ReaderStatus {
    ONLINE(1,"Hoạt động"),
    OFFLINE(0,"Hết hạn"),
    BAN(2,"Khóa");
    private Integer code;
    private String value;
    ReaderStatus(int code, String value) {
        this.code = code;
        this.value = value;
    }
    public int getCode() {
        return code;
    }
    public String getValue() {
        return value;
    }
    public static Map<Integer, String> type() {
        Map<Integer, String> status = new TreeMap<>();
        for (ReaderStatus item : ReaderStatus.values()) {
            status.put(item.getCode(), item.getValue());
        }
        return status;
    }
    public static ReaderStatus getByCode(Integer code){
        if(code != null){
            for(ReaderStatus statuss : values()){
                if(statuss.code == code)return statuss;
            }
        }return ONLINE;
    }
}
