package services;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import post.PostComment;
import post.PostCommentEntity;
import ultilities.GenericService;
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
	
	@Override
	public List<PostComment> toBoms(List<PostCommentEntity> entities) {
		// TODO Auto-generated method stub
		return super.toBoms(entities);
	}
	
	@Override
	public List<PostCommentEntity> toEntities(List<PostComment> boms) {
		// TODO Auto-generated method stub
		return super.toEntities(boms);
	}
}
