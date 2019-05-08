package post;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import user.User;
import user.UserEntity;

public class Post {
	private Integer id;
	private Integer title;
	private Integer timestamp;
	private Integer upvote;
	private Integer downvote;
	private User user;
	private PostImage postImage;
	public Post() {
		super();
	}
	public Post(Integer id, Integer title, Integer timestamp, Integer upvote, Integer downvote, User user,
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
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
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
	
	
}
