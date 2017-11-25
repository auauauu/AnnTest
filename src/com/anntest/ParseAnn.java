package com.anntest;

import java.lang.reflect.Method;

public class ParseAnn {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.anntest.UseAnnTest");
			if (clazz.isAnnotationPresent(AnnTest.class)) {
				AnnTest anntest = (AnnTest) clazz.getAnnotation(AnnTest.class);
				System.out.println(anntest.value());
			}
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if(method.isAnnotationPresent(AnnTest.class)) {
					AnnTest mAnntest = method.getAnnotation(AnnTest.class);
					System.out.println(mAnntest.value());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
