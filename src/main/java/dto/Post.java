package dto;

import java.util.List;

import user.User;

public class Post {
	private Integer id;
	private String title;
	private Long createTimestamp;
	private Integer vote;

	private User user;
	private PostImage postImage;
	private List<PostComment> comments;

	public Post() {
		super();
	}

	public Post(Integer id, String title, Long createTimestamp, Integer vote, User user, PostImage postImage,
			List<PostComment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.createTimestamp = createTimestamp;
		this.vote = vote;
		this.user = user;
		this.postImage = postImage;
		this.comments = comments;
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

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
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

	public void setVoteAsString(String voteAsString) {
		this.vote = Integer.valueOf(voteAsString);
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

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

}
