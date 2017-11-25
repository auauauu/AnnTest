package com.anntest.action;

@Table("User")
public class MapperClass {
	@Column("id")
	private String id;
	@Column("name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
