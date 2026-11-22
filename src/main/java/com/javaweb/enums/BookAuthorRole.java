package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum BookAuthorRole {
    TacGia("Tác giả"),
    DongTacGia("Đồng tác giả"),
    DichGia("Dịch giả");
    private final String rolestring;
    BookAuthorRole(String rolestring) {
        this.rolestring = rolestring;
    }
    public String getRolestring() {
        return rolestring;
    }
    public static Map<String, String> getRoleMap() {
        Map<String, String> map = new HashMap<>();
        for (BookAuthorRole role : BookAuthorRole.values()) {
            map.put(role.getRolestring(), role.getRolestring());
        }
        return map;
    }
}
