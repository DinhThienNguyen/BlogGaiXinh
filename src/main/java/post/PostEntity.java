package post;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import user.UserEntity;

@Entity
@Table(name = "posts")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "timestamp")
	private Integer timestamp;
	
	@Column(name = "upvote")
	private Integer upvote;
	
	@Column(name = "downvote")
	private Integer downvote;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity userEntity;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id", nullable = true)
	private PostImageEntity imageEntity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="postEntity")
    private List<PostCommentEntity> comments;

	public PostEntity(Integer id, String title, Integer timestamp, Integer upvote, Integer downvote,
			UserEntity userEntity, PostImageEntity imageEntity) {
		super();
		this.id = id;
		this.title = title;
		this.timestamp = timestamp;
		this.upvote = upvote;
		this.downvote = downvote;
		this.userEntity = userEntity;
		this.imageEntity = imageEntity;
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
	
	
}
