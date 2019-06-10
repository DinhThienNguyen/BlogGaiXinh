package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.picketbox.util.StringUtil;

import dto.Post;
import dto.PostComment;
import entities.PostCommentEntity;
import entities.PostEntity;
import entities.UserEntity;
import services.PostCommentService;
import services.PostService;
import services.UserService;
import ultilities.SessionUtils;

@ManagedBean
@ViewScoped
public class PostDetailView {

	@EJB
	PostService postService;

	@EJB
	UserService userService;

	@EJB
	PostCommentService postCommentService;

	private Post post;

	private String comment;

	@PostConstruct
	public void init() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String test = request.getParameter("postId");
		System.out.println("Navigating to post with id of " + test);

		if (!StringUtil.isNullOrEmpty(test)) {
			post = postService.findById(Integer.valueOf(test));

		}
	}

	public void upvoteComment(PostComment comment) {
		PostComment existingComment = post.getComments().stream()
				.filter(eachComment -> comment.getId().equals(eachComment.getId())).findAny().orElse(null);
		if (existingComment != null) {
			existingComment.setVote(existingComment.getVote() + 1);
			postCommentService.update(postCommentService.toEntity(existingComment));
			System.out.println("Upvoted comment with id of " + comment.getId());
		} else {
			System.out.println("Could not upvote comment with id of " + comment.getId());
		}
	}

	public void downvotevoteComment(PostComment comment) {
		PostComment existingComment = post.getComments().stream()
				.filter(eachComment -> comment.getId().equals(eachComment.getId())).findAny().orElse(null);
		if (existingComment != null) {
			existingComment.setVote(existingComment.getVote() + 1);
			postCommentService.update(postCommentService.toEntity(existingComment));
			System.out.println("Upvoted comment with id of " + comment.getId());
		} else {
			System.out.println("Could not upvote comment with id of " + comment.getId());
		}
	}

	public void upvotePost() {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			post.setVote(post.getVote() + 1);
			postService.update(postService.toEntity(post));
			System.out.println("Upvoted post with id of " + post.getId());
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void testMethod() {
		System.out.println("hello");
	}

	public void downvotePost() {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			post.setVote(post.getVote() - 1);
			postService.update(postService.toEntity(post));
			System.out.println("Downvoted post with id of " + post.getId());
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void saveComment() {
		if (post != null)
			System.out.println("post not null");
		else {
			System.out.println("post null");
		}
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			PostCommentEntity postCommentEntity = new PostCommentEntity();
			postCommentEntity.setContent(comment);
			UserEntity userEntity = userService.find(userid);
			postCommentEntity.setUserEntity(userEntity);
//			postCommentEntity.setPostEntity(postEntity);
			
			List<PostEntity> postEntities = userEntity.getPostEntities();
			
			postCommentEntity.setVote(0);
			postCommentEntity = postCommentService.save(postCommentEntity);
//			post.getComments().add(0, postCommentService.toBom(commentEntity));
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
