package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.PostEntity;
import services.PostService;
import ultilities.SessionUtils;

@ManagedBean
@ViewScoped
public class PostView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String UPVOTED_STYLE = "margin-right:20px; background-color: rgb(255, 69, 0);";
	private static final String DOWNVOTED_STYLE = "margin-right:20px; background-color: rgb(113, 147, 255);";
	private static final String DEFAULT_STYLE = "margin-right:20px;";

	@EJB
	PostService postService;

	private List<PostEntity> posts;
	private String upvoteButtonStyle;
	private String downvoteButtonStyle;

	@PostConstruct
	public void init() {
		posts = postService.findAll();
		upvoteButtonStyle = DEFAULT_STYLE;
		downvoteButtonStyle = DEFAULT_STYLE;
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

	public String getUpvoteButtonStyle() {
		return upvoteButtonStyle;
	}

	public void setUpvoteButtonStyle(String upvoteButtonStyle) {
		this.upvoteButtonStyle = upvoteButtonStyle;
	}

	public String getDownvoteButtonStyle() {
		return downvoteButtonStyle;
	}

	public void setDownvoteButtonStyle(String downvoteButtonStyle) {
		this.downvoteButtonStyle = downvoteButtonStyle;
	}

}
