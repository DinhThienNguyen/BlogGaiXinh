package user;

import java.util.List;

import post.Post;

public class User {
	private Integer id;
	private String name;
	private String gender;
	private String email;
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}

	public User(Integer id, String name, String gender, String email, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.posts = posts;
	}

}
