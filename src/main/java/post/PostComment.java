package post;

import user.User;

public class PostComment {
	private Integer id;
	private Integer upvote;
	private String upvoteAsString;
	private Integer downvote;
	private String downvoteAsString;
	private String content;
	private User user;

	public PostComment() {
		super();
	}

	public PostComment(Integer id, Integer upvote, Integer downvote, String content, User user) {
		super();
		this.id = id;
		this.upvote = upvote;
		this.downvote = downvote;
		this.content = content;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
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

	public String getUpvoteAsString() {
		return upvoteAsString;
	}

	public void setUpvoteAsString(String upvoteAsString) {
		this.upvoteAsString = upvoteAsString;
	}

	public String getDownvoteAsString() {
		return downvoteAsString;
	}

	public void setDownvoteAsString(String downvoteAsString) {
		this.downvoteAsString = downvoteAsString;
	}
}
