package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "createtimestamp")
	private Long createTimestamp;

	@Column(name = "vote")
	private Integer vote;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity userEntity;

	@OneToOne
	@JoinColumn(name = "image_id", nullable = true)
	private PostImageEntity imageEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postEntity")
	private List<PostCommentEntity> comments;

	public PostEntity(Integer id, String title, Long createTimestamp, Integer vote, UserEntity userEntity,
			PostImageEntity imageEntity, List<PostCommentEntity> comments) {
		super();
		this.id = id;
		this.title = title;
		this.createTimestamp = createTimestamp;
		this.vote = vote;
		this.userEntity = userEntity;
		this.imageEntity = imageEntity;
		this.comments = comments;
	}

	public PostEntity() {
		super();
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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public PostImageEntity getImageEntity() {
		return imageEntity;
	}

	public void setImageEntity(PostImageEntity imageEntity) {
		this.imageEntity = imageEntity;
	}

	public List<PostCommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<PostCommentEntity> comments) {
		this.comments = comments;
	}
	
	public String getVoteAsString() {
		return String.valueOf(vote);
	}

}
