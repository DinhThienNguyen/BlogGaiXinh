package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.picketbox.util.StringUtil;

import dto.Post;
import dto.PostComment;
import services.PostCommentService;
import services.PostService;

@ManagedBean
@ViewScoped
public class PostDetailView {

	@EJB
	PostService postService;

	@EJB
	PostCommentService postCommentService;

	private Post post;

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
			existingComment.setUpvote(existingComment.getUpvote() + 1);
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
			existingComment.setUpvote(existingComment.getUpvote() + 1);
			postCommentService.update(postCommentService.toEntity(existingComment));
			System.out.println("Upvoted comment with id of " + comment.getId());
		} else {
			System.out.println("Could not upvote comment with id of " + comment.getId());
		}
	}

	public void upvotePost() {
		post.setVote(post.getVote() + 1);
		postService.update(postService.toEntity(post));
		System.out.println("Upvoted post with id of " + post.getId());
	}

	public void testMethod() {
		System.out.println("hello");
	}

	public void downvotePost() {
		post.setVote(post.getVote() - 1);
		postService.update(postService.toEntity(post));
		System.out.println("Downvoted post with id of " + post.getId());
	}
	
	public void saveComment() {
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
