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

@WebServlet("/userEditPassController")
public class UserEditPassController extends HttpServlet {

	@EJB
	UserService userService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		Integer userIDLogin = (Integer) req.getSession().getAttribute("userid");
		String userID = req.getParameter("userID");

		if (userIDLogin == null) {
			response.sendRedirect("SignUp.xhtml");
			return;
		}

		if (userID == null) {
			userID = userIDLogin.toString();
		}

		if (!userIDLogin.toString().equals(userID)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("userDontPermission.jsp");
			dispatcher.forward(req, response);
			return;
		}

		String passOld = req.getParameter("pass-old");
		String passNew = req.getParameter("pass-new");
		String passRe = req.getParameter("pass-re");

		UserEntity userEntity = userService.find(Integer.parseInt(userID));

		if (!passOld.equals(userEntity.getPassword())) {
			req.setAttribute("userEntity", userEntity);
			req.setAttribute("status", "misspass");
			RequestDispatcher dispatcher = req.getRequestDispatcher("userEdit.jsp");
			dispatcher.forward(req, response);
			return;
		}

		if (!passRe.equals(passNew)) {
			req.setAttribute("userEntity", userEntity);
			req.setAttribute("status", "missre");
			RequestDispatcher dispatcher = req.getRequestDispatcher("userEdit.jsp");
			dispatcher.forward(req, response);
			return;
		}

		userEntity.setPassword(passNew);

		UserEntity userEntityResult = userService.update(userEntity);

		if (userEntityResult != null)
			req.setAttribute("status", "success");
		else
			req.setAttribute("status", "failure");

		UserEntity userEntity1 = userService.find(Integer.parseInt(userID));
		req.setAttribute("userEntity", userEntity1);

		RequestDispatcher dispatcher = req.getRequestDispatcher("userEdit.jsp");
		dispatcher.forward(req, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("userEditController");
		return;

	}

}
