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
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dto.Post;
import dto.PostComment;
import dto.PostImage;
import entities.PostEntity;
import entities.PostImageEntity;
import services.PostImageService;
import services.PostService;
import services.UserService;
import ultilities.SessionUtils;
import user.User;

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
		Integer userid = SessionUtils.getUserId();
		if (userid.equals(null)) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		imageContents = file.getContents();

		PostImage latestImage = postImageService.getLatestEntityId();

		PostImage postImage = new PostImage();		
		String test = getClass().getClassLoader().getResource("").getPath();
		postImage.setName(latestImage.getId() + file.getContentType().replaceAll("image/", "."));		
		try (FileOutputStream fos = new FileOutputStream(
				System.getProperty("jboss.server.data.dir") + "\\images\\" + postImage.getName())) {
			fos.write(imageContents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		PostImageEntity postImageEntity = postImageService.save(postImageService.toEntity(postImage));
		postImage.setId(postImageEntity.getId());

		Post post = new Post();
		post.setTitle(title);
		post.setCreateTimestamp(System.currentTimeMillis() / 1000L);
		post.setVote(0);

		User user = userService.findById(1);
		post.setUser(user);

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
