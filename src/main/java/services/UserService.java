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

//	@Override
//	public UserEntity toEntity(User bom) {
//		if (Objects.isNull(bom)) {
//			return null;
//		}
//		return new UserEntity(bom.getId(), bom.getUsername(), bom.getPassword(), bom.getFullname(), bom.getGender(),
//				bom.getEmail());
//	}
//
//	@Override
//	public User toBom(UserEntity entity) {
//		if (Objects.isNull(entity)) {
//			return null;
//		}
//		return new User(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getFullname(),
//				entity.getGender(), entity.getEmail());
//	}

	@Override
	public UserEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	public UserEntity find(Integer id) {
		return this.getEm().find(UserEntity.class, id);
	}

	@Override
	public UserEntity save(UserEntity entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	public UserEntity find(String username, String password) {
		Query query = this.getEm()
				.createQuery("SELECT e from " + UserEntity.class.getSimpleName()
						+ " e WHERE e.username = :username and e.password = :password", UserEntity.class)
				.setParameter("username", username).setParameter("password", password);

		List<UserEntity> entities = query.getResultList();
		if (entities.isEmpty())
			return null;
		return entities.get(0);
	}

	public UserEntity find(String username) {
		Query query = this.getEm()
				.createQuery("SELECT e from " + UserEntity.class.getSimpleName() + " e WHERE e.username = :username",
						UserEntity.class)
				.setParameter("username", username);

		List<UserEntity> entities = query.getResultList();
		if (entities.isEmpty())
			return null;
		return entities.get(0);
	}
}
