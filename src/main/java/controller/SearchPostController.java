package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Post;
import dto.PostImage;
import entities.PostEntity;
import entities.PostImageEntity;
import entities.UserEntity;
import services.PostImageService;
import services.PostService;
import services.UserService;
import ultilities.SessionUtils;

@WebServlet("/searchPostController")
public class SearchPostController extends HttpServlet {

	@EJB
	PostService postService;
	
	@EJB
	UserService userService;
	
	@EJB
	PostImageService postImageService;
	
	private static final String IMAGE_DIRECTORY = "/statics/images/";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("searchPost.jsp");
		dispatcher.forward(req, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");
		String searchType = req.getParameter("searchtype");

		if (keyword == null || searchType == null) {
			List<PostEntity> listPostEntity = postService.findAll();
	
			
			List<String> imagePaths = new LinkedList<>();
			
			if (listPostEntity != null && !listPostEntity.isEmpty()) {
				for (PostEntity post : listPostEntity) {
					PostImageEntity image = postImageService.findById(Integer.valueOf(post.getImageEntity().getId()));
					if (image != null) {
						String url = req.getContextPath() + IMAGE_DIRECTORY + image.getName();
						imagePaths.add(url);
					}
				}
			}
			
			
			req.setAttribute("imagePaths", imagePaths);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("searchPost.jsp");
			dispatcher.forward(req, response);
			return;
		}

		if (searchType != null) {
			if ("user".equals(searchType)) {
				
				UserEntity userEntity = userService.find(keyword);
				
//				List<UserEntity> listUserEntity = new LinkedList<>();
//				listUserEntity.add(userEntity);
				
				List<UserEntity> listUserEntity = userService.findList(keyword);
				
				req.setAttribute("listUserEntity", listUserEntity);
				RequestDispatcher dispatcher = req.getRequestDispatcher("searchUser.jsp");
				dispatcher.forward(req, response);
				return;
				
				// return user
			}
			
			if ("post".equals(searchType)) {
				List<PostEntity> listPostEntity = postService.findList(keyword);
				
				List<String> imagePaths = new LinkedList<>();
				
				if (listPostEntity != null && !listPostEntity.isEmpty()) {
					for (PostEntity post : listPostEntity) {
						PostImageEntity image = postImageService.findById(Integer.valueOf(post.getImageEntity().getId()));
						if (image != null) {
							String url = req.getContextPath() + IMAGE_DIRECTORY + image.getName();
							imagePaths.add(url);
						}
					}
				}
				
				req.setAttribute("imagePaths", imagePaths);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("searchPost.jsp");
				dispatcher.forward(req, response);
				
				return;
			}
		}

	}

}
