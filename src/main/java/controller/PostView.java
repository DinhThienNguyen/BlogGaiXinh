package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.PostEntity;
import entities.UserEntity;
import services.PostService;
import services.UserService;
import ultilities.SessionUtils;

@ManagedBean
@ViewScoped
public class PostView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PostService postService;

	@EJB
	UserService userService;

	private List<PostEntity> posts;

	@PostConstruct
	public void init() {
		posts = postService.findAll();
		posts.stream().forEach(post -> post.getUpvotedUser());
		posts.stream().forEach(post -> post.getDownvotedUser());
	}

	public String move() {
		FacesContext context = FacesContext.getCurrentInstance();
		Integer postId = Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("postId"));
		return "PostDetail?faces-redirect=true&postId=" + postId;
	}

	public void upvotePost(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			PostEntity upvotedPost = postService.findById(post.getId());
			UserEntity userEntity = upvotedPost.getUpvotedUser().stream().filter(user -> userid.equals(user.getId()))
					.findAny().orElse(null);
			if (userEntity != null) {
				upvotedPost.setVote(upvotedPost.getVote() - 1);
				upvotedPost.getUpvotedUser().remove(userEntity);
			} else {
				userEntity = upvotedPost.getDownvotedUser().stream().filter(user -> userid.equals(user.getId()))
						.findAny().orElse(null);
				if (userEntity != null) {
					upvotedPost.getDownvotedUser().remove(userEntity);
					upvotedPost.setVote(upvotedPost.getVote() + 1);
				}
				userEntity = userService.find(userid);
				upvotedPost.getUpvotedUser().add(userEntity);
				upvotedPost.setVote(upvotedPost.getVote() + 1);
			}
			upvotedPost = postService.update(upvotedPost);
			for (int index = 0; index < posts.size(); index++) {
			    if(posts.get(index).getId() == upvotedPost.getId()){
			        posts.set(index, upvotedPost);
			        break;
			    }
			}
			System.out.println("Upvoted post with id of " + post.getId());
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void downvotePost(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			PostEntity downvotedPost = postService.findById(post.getId());
			UserEntity userEntity = downvotedPost.getDownvotedUser().stream().filter(user -> userid.equals(user.getId()))
					.findAny().orElse(null);
			if (userEntity != null) {
				downvotedPost.setVote(downvotedPost.getVote() + 1);
				downvotedPost.getDownvotedUser().remove(userEntity);
			} else {
				userEntity = downvotedPost.getUpvotedUser().stream().filter(user -> userid.equals(user.getId()))
						.findAny().orElse(null);
				if (userEntity != null) {
					downvotedPost.getUpvotedUser().remove(userEntity);
					downvotedPost.setVote(downvotedPost.getVote() - 1);
				}
				userEntity = userService.find(userid);
				downvotedPost.getDownvotedUser().add(userEntity);
				downvotedPost.setVote(downvotedPost.getVote() - 1);
			}
			downvotedPost = postService.update(downvotedPost);
			for (int index = 0; index < posts.size(); index++) {
			    if(posts.get(index).getId() == downvotedPost.getId()){
			        posts.set(index, downvotedPost);
			        break;
			    }
			}
			System.out.println("Downvoted post with id of " + post.getId());
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public boolean isPostUpvoted(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {

			UserEntity userEntity = userService.find(userid);
			PostEntity upvotedPostEntity = userEntity.getUpvotedPost().stream()
					.filter(upvotedPost -> upvotedPost.getId().equals(post.getId())).findAny().orElse(null);
			if (upvotedPostEntity != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isPostDownvoted(PostEntity post) {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			UserEntity userEntity = userService.find(userid);
			PostEntity downvotedPostEntity = userEntity.getDownvotedPost().stream()
					.filter(downvotedPost -> downvotedPost.getId().equals(post.getId())).findAny().orElse(null);
			if (downvotedPostEntity != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
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
