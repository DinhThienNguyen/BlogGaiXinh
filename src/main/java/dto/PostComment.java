package dto;

import user.User;

public class PostComment {
	private Integer id;
	private Integer vote;
	private String content;
	private User user;
	private Post post;

	public PostComment() {
		super();
	}

	public PostComment(Integer id, Integer vote, String content, User user) {
		super();
		this.id = id;
		this.vote = vote;
		this.content = content;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public String getVoteAsString() {
		return String.valueOf(vote);
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
