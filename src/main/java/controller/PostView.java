package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dto.Post;
import entities.PostEntity;
import services.PostService;
import ultilities.SessionUtils;

@javax.faces.bean.ManagedBean
@ViewScoped
public class PostView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PostService postService;

	private List<PostEntity> posts;

	@PostConstruct
	public void init() {
		posts = postService.findAll();		
	}

	public String move() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer postId = Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("postId"));
		return "PostDetail?faces-redirect=true&postId=" + postId;
	}

	public void upvotePost(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			PostEntity existingPost = posts.stream().filter(eachPost -> post.getId().equals(eachPost.getId())).findAny()
					.orElse(null);
			if (existingPost != null) {
				existingPost.setVote(existingPost.getVote() + 1);
				postService.update(existingPost);
				System.out.println("Upvoted post with id of " + post.getId());
			} else {
				System.out.println("Could not upvote post with id of " + post.getId());
			}
		} else {
			System.out.println("User not logged in");
		}
	}

	public void downvotePost(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			PostEntity existingPost = posts.stream().filter(eachPost -> post.getId().equals(eachPost.getId())).findAny()
					.orElse(null);
			if (existingPost != null) {
				existingPost.setVote(existingPost.getVote() - 1);
				postService.update(existingPost);
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

	public PostService getPostService() {
		return postService;
	}

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
