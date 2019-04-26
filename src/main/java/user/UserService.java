package user;

import java.util.Objects;

import javax.ejb.Stateless;

import technical.GenericService;

@Stateless
public class UserService extends GenericService<UserEntity, User> {
	
	public UserService() {
		super(UserEntity.class);
	}
	
	public UserEntity toEntity(User bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new UserEntity(bom.getId(), bom.getName(), bom.getGender(), bom.getEmail());
	}

	public User toBom(UserEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new User(entity.getId(), entity.getName(), entity.getGender(), entity.getEmail());
	}
	
	public void saveEmployee(User bom) {
		this.save(new UserEntity(bom.getId(), bom.getName(), bom.getGender(), bom.getEmail()));
	}
}
