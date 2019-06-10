package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dto.Post;
import entities.PostEntity;
import ultilities.GenericService;

@Stateless
//@ManagedBean(name = "postService")
//@SessionScoped
public class PostService extends GenericService<PostEntity, Post> {

	@EJB
	private UserService userService;

	@EJB
	private PostImageService postImageService;

	@EJB
	private PostCommentService postCommentService;

	public PostService() {
		super(PostEntity.class);
	}

//	@Override
//	public PostEntity toEntity(Post bom) {
//		if (Objects.isNull(bom)) {
//			return null;
//		}
//		return new PostEntity(bom.getId(), bom.getTitle(), bom.getCreateTimestamp(), bom.getVote(),
//				userService.toEntity(bom.getUser()), postImageService.toEntity(bom.getPostImage()),
//				postCommentService.toEntities(bom.getComments()));
//	}
//
//	@Override
//	public Post toBom(PostEntity entity) {
//		if (Objects.isNull(entity)) {
//			return null;
//		}
//		return new Post(entity.getId(), entity.getTitle(), entity.getCreateTimestamp(), entity.getVote(),
//				userService.toBom(entity.getUserEntity()), postImageService.toBom(entity.getImageEntity()),
//				postCommentService.toBoms(entity.getComments()));
//	}
//
//	@Override
//	public List<Post> toBoms(List<PostEntity> entities) {
//		// TODO Auto-generated method stub
//		return super.toBoms(entities);
//	}

//	@Override
//	public List<PostEntity> toEntities(List<Post> boms) {
//		// TODO Auto-generated method stub
//		return super.toEntities(boms);
//	}

	@Override
	public PostEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<PostEntity> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

}
