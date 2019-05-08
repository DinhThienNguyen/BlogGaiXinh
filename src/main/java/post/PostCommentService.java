package post;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import technical.GenericService;
import user.UserService;

@Stateless
public class PostCommentService extends GenericService<PostCommentEntity, PostComment>{

	@EJB
	private UserService userService;
	
	public PostCommentService() {
		super(PostCommentEntity.class);
	}

	@Override
	public PostCommentEntity toEntity(PostComment bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new PostCommentEntity(bom.getId(), bom.getUpvote(), bom.getDownvote(), bom.getContent(), userService.toEntity(bom.getUser()));
	}

	@Override
	public PostComment toBom(PostCommentEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new PostComment(entity.getId(), entity.getUpvote(), entity.getDownvote(), entity.getContent(), userService.toBom(entity.getUserEntity()));
	}
	
	
}
