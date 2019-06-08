package user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import post.PostEntity;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
	private List<PostEntity> postEntities;

	public List<PostEntity> getPostEntities() {
		return postEntities;
	}

	public void setPostEntities(List<PostEntity> postEntities) {
		this.postEntities = postEntities;
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

	public UserEntity(Integer id, String name, String gender, String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	public UserEntity() {
		super();
	}

}
