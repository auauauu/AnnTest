package com.anntest.action;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DAO {

	public String genQuerySQL(MapperClass pojo) throws Exception {
		StringBuffer sqlbuf = new StringBuffer();
		Class<?> pojoclass = pojo.getClass();
		if (pojoclass.isAnnotationPresent(Table.class)) {
			sqlbuf.append("select * from " + pojoclass.getAnnotation(Table.class).value() + " where 1=1");
		}
		for (Field field : pojoclass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class)) {
				String getterMethodName = "get" + field.getName().substring(0, 1).toUpperCase()
						+ field.getName().substring(1);
				Method getterMethod = pojoclass.getMethod(getterMethodName);
				String fieldVal = (String) getterMethod.invoke(pojo);
				if (fieldVal != null && !"".equals(fieldVal)) {
					sqlbuf.append(" and ").append(field.getAnnotation(Column.class).value()).append("=").append("'")
							.append(fieldVal).append("'");
				}
			}
		}
		return sqlbuf.toString();
	}

}
