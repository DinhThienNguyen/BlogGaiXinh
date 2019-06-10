package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ultilities.TimeAgo;

@Entity
@Table(name = "comments")
public class PostCommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "content")
	private String content;

	@Column(name = "vote")
	private Integer vote;

	@Column(name = "createtimestamp")
	private Long createTimestamp;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity userEntity;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostEntity postEntity;

	public PostCommentEntity() {
		super();
	}

	public PostCommentEntity(Integer id, Integer vote, String content, UserEntity userEntity) {
		super();
		this.id = id;
		this.vote = vote;
		this.content = content;
		this.userEntity = userEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public PostEntity getPostEntity() {
		return postEntity;
	}

	public void setPostEntity(PostEntity postEntity) {
		this.postEntity = postEntity;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getVoteAsString() {
		return String.valueOf(vote);
	}

	public String getCreateTimestampAsString() {
		return TimeAgo.toDuration(createTimestamp);
	}

}
