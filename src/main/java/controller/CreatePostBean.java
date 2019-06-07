package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import post.Post;
import post.PostComment;
import post.PostImage;
import services.PostImageService;
import services.PostService;
import user.User;
import user.UserService;

@ManagedBean
@SessionScoped
public class CreatePostBean {
	private byte[] imageContents;
	private String title = "";

	@EJB
	private PostService postService;

	@EJB
	PostImageService postImageService;

	@EJB
	private UserService userService;

	@PostConstruct
	public void init() {
		imageContents = "Any String you want".getBytes();
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		imageContents = file.getContents();

		PostImage latestImage = postImageService.getLatestEntityId();

		try (FileOutputStream fos = new FileOutputStream(
				System.getProperty("jboss.server.data.dir") + "\\images\\" + (latestImage.getId() + 1) + ".png")) {
			fos.write(imageContents);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		Post post = new Post();
		post.setTitle(title);
		post.setCreateTimestamp(System.currentTimeMillis() / 1000L);
		post.setVote(0);

		User user = userService.findById(1);
		post.setUser(user);

		PostImage postImage = new PostImage();
		postImage.setPath("");
		postImageService.save(postImageService.toEntity(postImage));

		post.setPostImage(postImage);
		postService.save(postService.toEntity(post));

		System.out.println("uploaded " + file.getFileName());
	}

	public byte[] getImageContents() {
		return imageContents;
	}

	public void setImageContents(byte[] imageContents) {
		this.imageContents = imageContents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
