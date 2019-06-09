package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dto.Post;
import services.PostService;
import ultilities.SessionUtils;

@javax.faces.bean.ManagedBean
@SessionScoped
public class PostView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PostService postService;

	private List<Post> posts;

	@PostConstruct
	public void init() {
		posts = postService.findAll();
	}

	public String move() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer postId = Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("postId"));
		return "PostDetail?faces-redirect=true&postId=" + postId;
	}

	public void upvotePost(Post post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			Post existingPost = posts.stream().filter(eachPost -> post.getId().equals(eachPost.getId())).findAny()
					.orElse(null);
			if (existingPost != null) {
				existingPost.setVote(existingPost.getVote() + 1);
				postService.update(postService.toEntity(existingPost));
				System.out.println("Upvoted post with id of " + post.getId());
			} else {
				System.out.println("Could not upvote post with id of " + post.getId());
			}
		} else {
			System.out.println("User not logged in");
		}
	}

	public void downvotePost(Post post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			Post existingPost = posts.stream().filter(eachPost -> post.getId().equals(eachPost.getId())).findAny()
					.orElse(null);
			if (existingPost != null) {
				existingPost.setVote(existingPost.getVote() - 1);
				postService.update(postService.toEntity(existingPost));
				System.out.println("Upvoted post with id of " + post.getId());
			} else {
				System.out.println("Could not upvote post with id of " + post.getId());
			}
		} else {
			System.out.println("User not logged in");
		}
	}

	public void refresh() {

	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
