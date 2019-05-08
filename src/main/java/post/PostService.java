package post;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import technical.GenericService;
import user.UserService;

@Stateless
public class PostService extends GenericService<PostEntity, Post>{

	@EJB
	private UserService userService;
	
	@EJB
	private PostImageService postImageService;
	
	public PostService() {
		super(PostEntity.class);
	}

	@Override
	public PostEntity toEntity(Post bom) {
		if (Objects.isNull(bom)) {
			return null;
		}
		return new PostEntity(bom.getId(), 
				bom.getTitle(), 
				bom.getTimestamp(), 
				bom.getUpvote(), 
				bom.getDownvote(), 
				userService.toEntity(bom.getUser()),
				postImageService.toEntity(bom.getPostImage())
				);
	}

	@Override
	public Post toBom(PostEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new Post(entity.getId(), 
				entity.getTitle(), 
				entity.getTimestamp(), 
				entity.getUpvote(), 
				entity.getDownvote(), 
				userService.toBom(entity.getUserEntity()),
				postImageService.toBom(entity.getImageEntity())
				);
	}
	
	@Override
	public Post findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

}
