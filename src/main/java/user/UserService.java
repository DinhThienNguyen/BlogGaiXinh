package user;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import services.PostService;
import ultilities.GenericService;

@Stateless
public class UserService extends GenericService<UserEntity, User> {
	
	@EJB
	PostService postService;
	
	public UserService() {
		super(UserEntity.class);
	}
	
	public UserEntity toEntity(User bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new UserEntity(
				bom.getId(),
				bom.getName(),
				bom.getGender(),
				bom.getEmail(),
				postService.toEntities(bom.getPosts()));
	}

	public User toBom(UserEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new User(
				entity.getId(),
				entity.getName(),
				entity.getGender(),
				entity.getEmail(),
				postService.toBoms(entity.getPostEntities())
				);
	}
	
	@Override
	public UserEntity save(UserEntity entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
}
