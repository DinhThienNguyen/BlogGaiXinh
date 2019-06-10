package controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import dto.Post;
import dto.PostImage;
import entities.PostEntity;
import entities.PostImageEntity;
import entities.UserEntity;
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
	}

	public void isUserLoggedIn() {
		Integer userid = SessionUtils.getUserId();
		if (userid == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("SignUp.xhtml");
			} catch (IOException e) {

			}
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		imageContents = file.getContents();

		PostImageEntity latestImage = postImageService.getLatestEntityId();

		PostImageEntity newPostImage = new PostImageEntity();		
		newPostImage.setName(latestImage.getId() + file.getContentType().replaceAll("image/", "."));
		try (FileOutputStream fos = new FileOutputStream(
				System.getProperty("jboss.server.data.dir") + "\\images\\" + newPostImage.getName())) {
			fos.write(imageContents);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		newPostImage = postImageService.save(newPostImage);		

		PostEntity post = new PostEntity();
		post.setTitle(title);
		post.setCreateTimestamp(System.currentTimeMillis() / 1000L);
		post.setVote(0);

		UserEntity user = userService.findById(SessionUtils.getUserId());
		post.setUserEntity(user);

		post.setImageEntity(newPostImage);
		postService.save(post);

		System.out.println("uploaded " + file.getFileName());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("MainPage.xhtml");
		} catch (IOException e) {

		}
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
