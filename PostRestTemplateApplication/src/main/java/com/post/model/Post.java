package com.post.model;

public class Post {

	private int userId;//this fields will store the data 
	private int id;
	private String title;
	private String body;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Post(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	//creating a default constructor
	public Post() {
		super();
	}
	@Override 
	public String toString() {
		return "Post [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
}
