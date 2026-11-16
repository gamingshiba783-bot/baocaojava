package com.javaweb.converter;

import com.javaweb.builder.AuthorSearchBuilder;
import com.javaweb.utils.MapUtil;

import java.rmi.MarshalledObject;
import java.util.Map;

public class AuthorSearchConverter {
    public AuthorSearchBuilder toAuthorSearchBuilder(Map<String, Object> params) {
        AuthorSearchBuilder authorSearchBuilder=new AuthorSearchBuilder.Builder().setId(MapUtil.getObject(params,"id", Long.class))
                .setAddress(MapUtil.getObject(params,"address",String.class))
                .setAuthorname(MapUtil.getObject(params,"authorname",String.class))
                .setBirthyear(MapUtil.getObject(params,"birthyear", Integer.class)).build();
        return authorSearchBuilder;
    }
}
