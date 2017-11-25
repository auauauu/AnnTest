package com.anntest.action;

public class TestAnn {
	public static void main(String[] args) {
		MapperClass mapper = new MapperClass();
		mapper.setId("1");
		mapper.setName("иш╣о");
		DAO dao = new DAO();
		try {
			System.out.println(dao.genQuerySQL(mapper));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
