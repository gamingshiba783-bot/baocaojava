package com.javaweb.converter;

import com.javaweb.builder.PublisherSearchBuilder;
import com.javaweb.utils.MapUtil;

import java.util.Map;

public class PublisherSearchConverter {
    public PublisherSearchBuilder toPublisher(Map<String, Object> params) {
        PublisherSearchBuilder publisherSearchBuilder = new PublisherSearchBuilder.Builder().setId(MapUtil.getObject(params,"id",Long.class))
                .setAddress(MapUtil.getObject(params,"address",String.class))
                .setEmail(MapUtil.getObject(params,"email",String.class))
                .setPublishername(MapUtil.getObject(params,"publishername",String.class))
                .setPhone(MapUtil.getObject(params,"phone",String.class)).build();
        return publisherSearchBuilder;
    }
}
