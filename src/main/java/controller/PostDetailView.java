package controller;

import java.io.IOException;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.picketbox.util.StringUtil;

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

	private static final String UPVOTED_STYLE = "margin-right:20px; background-color: rgb(255, 69, 0);";
	private static final String DOWNVOTED_STYLE = "margin-right:20px; background-color: rgb(113, 147, 255);";
	private static final String DEFAULT_STYLE = "margin-right:20px;";

	@EJB
	PostService postService;

	@EJB
	UserService userService;

	@EJB
	PostCommentService postCommentService;

	private PostEntity post;

	private String comment;

	private String upvoteButtonStyle;
	private String downvoteButtonStyle;

	@PostConstruct
	public void init() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String test = request.getParameter("postId");
		System.out.println("Navigating to post with id of " + test);

		upvoteButtonStyle = DEFAULT_STYLE;
		downvoteButtonStyle = DEFAULT_STYLE;

		if (!StringUtil.isNullOrEmpty(test)) {
			post = postService.findById(Integer.valueOf(test));
			Integer userid = SessionUtils.getUserId();
			if (userid != null) {
				UserEntity userEntity = post.getUpvotedUser().stream().filter(user -> userid.equals(user.getId()))
						.findAny().orElse(null);
				if (userEntity != null) {
					upvoteButtonStyle = UPVOTED_STYLE;
				}
				userEntity = post.getDownvotedUser().stream().filter(user -> userid.equals(user.getId())).findAny()
						.orElse(null);
				if (userEntity != null) {
					downvoteButtonStyle = DOWNVOTED_STYLE;
				}
			}
		}
	}

	public void upvoteComment(PostComment comment) {
		PostCommentEntity existingComment = post.getComments().stream()
				.filter(eachComment -> comment.getId().equals(eachComment.getId())).findAny().orElse(null);
		if (existingComment != null) {
			existingComment.setVote(existingComment.getVote() + 1);
			postCommentService.update(existingComment);
			System.out.println("Upvoted comment with id of " + comment.getId());
		} else {
			System.out.println("Could not upvote comment with id of " + comment.getId());
		}
	}

	public void downvotevoteComment(PostComment comment) {
		PostCommentEntity existingComment = post.getComments().stream()
				.filter(eachComment -> comment.getId().equals(eachComment.getId())).findAny().orElse(null);
		if (existingComment != null) {
			existingComment.setVote(existingComment.getVote() + 1);
			postCommentService.update(existingComment);
			System.out.println("Upvoted comment with id of " + comment.getId());
		} else {
			System.out.println("Could not upvote comment with id of " + comment.getId());
		}
	}

	public void upvotePost() {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			UserEntity userEntity = post.getUpvotedUser().stream().filter(user -> userid.equals(user.getId())).findAny()
					.orElse(null);
			if (userEntity != null) {
				upvoteButtonStyle = DEFAULT_STYLE;
				post.setVote(post.getVote() - 1);
				post.getUpvotedUser().remove(userEntity);
			} else {
				userEntity = post.getDownvotedUser().stream().filter(user -> userid.equals(user.getId())).findAny()
						.orElse(null);
				if (userEntity != null) {
					post.getDownvotedUser().remove(userEntity);
					post.setVote(post.getVote() + 1);
					downvoteButtonStyle = DEFAULT_STYLE;
				}
				userEntity = userService.find(userid);
				post.getUpvotedUser().add(userEntity);
				post.setVote(post.getVote() + 1);
				upvoteButtonStyle = UPVOTED_STYLE;
			}
			postService.update(post);
			System.out.println("Upvoted post with id of " + post.getId());
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void downvotePost() {
		Integer userid = SessionUtils.getUserId();
		if (userid != null) {
			UserEntity userEntity = post.getDownvotedUser().stream().filter(user -> userid.equals(user.getId()))
					.findAny().orElse(null);
			if (userEntity != null) {
				downvoteButtonStyle = DEFAULT_STYLE;
				post.setVote(post.getVote() + 1);
				post.getDownvotedUser().remove(userEntity);
			} else {
				userEntity = post.getUpvotedUser().stream().filter(user -> userid.equals(user.getId())).findAny()
						.orElse(null);
				if (userEntity != null) {
					post.getUpvotedUser().remove(userEntity);
					post.setVote(post.getVote() - 1);
					upvoteButtonStyle = DEFAULT_STYLE;
				}
				userEntity = userService.find(userid);
				post.getDownvotedUser().add(userEntity);
				post.setVote(post.getVote() - 1);
				downvoteButtonStyle = DOWNVOTED_STYLE;
			}
			postService.update(post);
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
			postCommentEntity.setPostEntity(post);
			postCommentEntity.setCreateTimestamp(System.currentTimeMillis() / 1000L);
			postCommentEntity.setUserEntity(userService.findById(userid));
			postCommentEntity.setVote(0);
			postCommentEntity = postCommentService.save(postCommentEntity);
			post.getComments().add(0, postCommentEntity);
			comment = "";
		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void moveToUser() {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("userDetailController?userID=" + post.getUserEntity().getId());
		} catch (IOException e) {

		}
	}
	
	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
