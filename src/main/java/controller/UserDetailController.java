package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.PostEntity;
import entities.PostImageEntity;
import entities.UserEntity;
import services.PostImageService;
import services.PostService;
import services.UserService;

@WebServlet("/userDetailController")

public class UserDetailController extends HttpServlet {

	@EJB
	PostService postService;

	@EJB
	UserService userService;

	@EJB
	PostImageService postImageService;

	private static final String IMAGE_DIRECTORY = "/statics/images/";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String userID = req.getParameter("userID");
		Integer userIDLogin = (Integer) req.getSession().getAttribute("userid");

		if (userIDLogin == null && userID == null) {
			response.sendRedirect("SignUp.xhtml");
			return;
		}

		if (userIDLogin != null && userID == null) {
			userID = userIDLogin.toString();
		}
		
		List<String> imagePaths = new LinkedList<>();
		UserEntity userEntity = userService.find(Integer.parseInt(userID));

		if (userEntity == null) {
			response.sendRedirect("SignUp.xhtml");
			return;
		}

		List<PostEntity> postEntities = userEntity.getPostEntities();

		if (postEntities != null && !postEntities.isEmpty()) {
			for (PostEntity post : postEntities) {
				PostImageEntity image = postImageService.findById(Integer.valueOf(post.getImageEntity().getId()));
				if (image != null) {
					String url = req.getContextPath() + IMAGE_DIRECTORY + image.getName();
					imagePaths.add(url);
				}
			}
		}

		req.setAttribute("userIDLogin", userIDLogin);
		req.setAttribute("userID", userID);
		req.setAttribute("imagePaths", imagePaths);
		
		req.setAttribute("userEntity", userEntity);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("userDetail.jsp");
		dispatcher.forward(req, response);

	}

}
