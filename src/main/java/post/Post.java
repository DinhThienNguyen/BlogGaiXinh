package post;

import user.User;

public class Post {
	private Integer id;
	private String title;
	private Integer timestamp;
	private Integer upvote;
	private Integer downvote;
	private User user;
	private PostImage postImage;

	public Post() {
		super();
	}

	public Post(Integer id, String title, Integer timestamp, Integer upvote, Integer downvote, User user,
			PostImage postImage) {
		super();
		this.id = id;
		this.title = title;
		this.timestamp = timestamp;
		this.upvote = upvote;
		this.downvote = downvote;
		this.user = user;
		this.postImage = postImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostImage getPostImage() {
		return postImage;
	}

	public void setPostImage(PostImage postImage) {
		this.postImage = postImage;
	}
	
	public String getUpvoteAsString() {
		return String.valueOf(upvote);
	}
	
	public void setUpvoteAsString(String upvoteAsString) {
		this.upvote = Integer.valueOf(upvoteAsString);
	}
	
	public String getDownvoteAsString() {
		return String.valueOf(downvote);
	}
	
	public void setDownvoteAsString(String downvoteAsString) {
		this.downvote = Integer.valueOf(downvoteAsString);
	}

}
