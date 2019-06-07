package services;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import post.Post;
import post.PostEntity;
import ultilities.GenericService;
import user.UserService;

@Stateless
//@ManagedBean(name = "postService")
//@SessionScoped
public class PostService extends GenericService<PostEntity, Post>{

	@EJB
	private UserService userService;
	
	@EJB
	private PostImageService postImageService;
	
	@EJB
	private PostCommentService postCommentService;
	
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
				bom.getCreateTimestamp(), 
				bom.getVote(),
				userService.toEntity(bom.getUser()),
				postImageService.toEntity(bom.getPostImage()),
				postCommentService.toEntities(bom.getComments())
				);
	}

	@Override
	public Post toBom(PostEntity entity) {
		if (Objects.isNull(entity)) {
			return null;
		}
		return new Post(entity.getId(), 
				entity.getTitle(), 
				entity.getCreateTimestamp(), 
				entity.getVote(), 
				userService.toBom(entity.getUserEntity()),
				postImageService.toBom(entity.getImageEntity()),
				postCommentService.toBoms(entity.getComments())
				);
	}
	
	@Override
	public Post findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

}
