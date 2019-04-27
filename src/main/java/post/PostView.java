package post;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@javax.faces.bean.ManagedBean
@RequestScoped
public class PostView {
	private StreamedContent chart;
	private List<PostComment> comments;

	@PostConstruct
	public void init() {
		try {
			comments = new ArrayList<PostComment>();
			PostComment postComment = new PostComment(1, "thien", "my dudes");
			PostComment postComment2 = new PostComment(2, "thien2", "my dudes2");
			PostComment postComment3 = new PostComment(3, "thien3", "my dudes3");
			comments.add(postComment);
			comments.add(postComment2);
			comments.add(postComment3);

			File chartFile = new File("C:/Users/pupper/Documents/BlogGaiXinh/src/main/java/mydudes.jpg");
			chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

	public StreamedContent getChart() {
		return chart;
	}
}
