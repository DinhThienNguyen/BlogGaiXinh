package post;

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

@ManagedBean
@ViewScoped
public class PostDetailView {

	@EJB
	PostService postService;

	private Post post;

	private List<PostComment> comments;

	@PostConstruct
	public void init() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String test = request.getParameter("postId");
		System.out.println("Navigating to post with id of " + test);
		comments = new ArrayList<PostComment>();

		if (!StringUtil.isNullOrEmpty(test)) {
			post = postService.findById(Integer.valueOf(test));

		}		
	}

	public void upvotePost() {		
		post.setUpvote(post.getUpvote() + 1);
		postService.update(postService.toEntity(post));
		System.out.println("Upvoted post with id of " + post.getId());
	}
	
	public void testMethod() {
		System.out.println("hello");
	}
	
	public void downvotePost() {
		post.setDownvote(post.getDownvote() + 1);
		postService.update(postService.toEntity(post));
		System.out.println("Downvoted post with id of " + post.getId());
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}
}
