package entity;

import java.sql.Connection;

public class categories {
	private int id;
	private String name;
	private String description;

	public categories() {
	}

	public categories(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getCid() {
		return id;
	}

	public void setCid(int id) {
		this.id = id;
	}

	public String getCname() {
		return name;
	}

	public void setCname(String name) {
		this.name = name;
	}

	public String getCdescription() {
		return description;
	}

	public void setCdescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "categories{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
	}

}
