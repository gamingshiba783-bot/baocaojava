package com.javaweb.utils;

import java.time.LocalDate;
import java.util.Map;

public class MapUtil {
	public static <T> T getObject(Map<String,Object> params,String key,Class<T> Tclass) {
		Object obj = params.getOrDefault(key, null);
		if(obj != null) {
			if(Tclass.getTypeName().equals("java.lang.Long")) {
				obj = obj != "" ? Long.valueOf(obj.toString()) : null;
			}else if(Tclass.getTypeName().equals("java.lang.Integer")) {
				obj = obj != "" ?Integer.valueOf(obj.toString()):null;
			}else if(Tclass.getTypeName().equals("java.lang.String")) {
				obj = obj.toString();
			}else if(Tclass.equals(LocalDate.class)) {
				obj = !obj.toString().isEmpty()? LocalDate.parse(obj.toString())
			:null;			
			}
			return Tclass.cast(obj);
			
		}return null;
	}
}
