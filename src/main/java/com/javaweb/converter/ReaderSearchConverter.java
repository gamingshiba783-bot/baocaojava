package com.javaweb.converter;

import com.javaweb.builder.ReaderSearchBuilder;
import com.javaweb.utils.MapUtil;

import java.time.LocalDate;
import java.util.Map;

public class ReaderSearchConverter {
    public ReaderSearchBuilder toreadersearch(Map<String, Object> params) {
        ReaderSearchBuilder readerSearchBuilder = new ReaderSearchBuilder.Builder().setId(MapUtil.getObject(params,"id", Long.class))
                .setFullname(MapUtil.getObject(params,"fullname",String.class))
                .setAddress(MapUtil.getObject(params,"address",String.class))
                .setDataofbirth(MapUtil.getObject(params,"dataofbirth", LocalDate.class))
                .setPhone(MapUtil.getObject(params,"phone",String.class))
                .setExpirydate(MapUtil.getObject(params,"expirydate", LocalDate.class))
                .setRegistrationdate(MapUtil.getObject(params,"registrationdate", LocalDate.class))
                .setStatus(MapUtil.getObject(params,"status", Integer.class)).build();
        return readerSearchBuilder;
    }
}
