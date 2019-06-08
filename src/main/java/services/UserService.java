package services;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Query;

import dto.Post;
import entities.UserEntity;
import ultilities.GenericService;
import user.User;

@Stateless
public class UserService extends GenericService<UserEntity, User> {

	@EJB
	PostService postService;

	public UserService() {
		super(UserEntity.class);
	}

	@Override
	public UserEntity toEntity(User bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new UserEntity(bom.getId(), bom.getUsername(), bom.getPassword(), bom.getGender(), bom.getEmail());
	}

	@Override
	public User toBom(UserEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new User(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getGender(),
				entity.getEmail());
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public UserEntity save(UserEntity entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	public UserEntity find(String username, String password) {
		return this.getEm().createQuery("SELECT e from " + UserEntity.class.getSimpleName()
				+ " e WHERE e.username = :username and e.password = :password", UserEntity.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.setMaxResults(1)
				.getSingleResult();				
	}
}
