package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Post;
import dto.PostImage;
import entities.UserEntity;
import services.PostImageService;
import services.PostService;
import services.UserService;
import user.User;

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

		// String employeeName = req.getParameter("name");
		// String employeeSurname = req.getParameter("surname");
		// int employeeSalary = Integer.parseInt(req.getParameter("salary"));
		//
		// Employee employee = new Employee(employeeName, employeeSurname,
		// employeeSalary);
		// employeeService.insertEmployee(employee);
		//
		// List<Employee> allEmployees = employeeService.findAllEmployees();
		// req.setAttribute("allEmployees", allEmployees);
		// RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		// dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

//		List<Post> posts = postService.findAll();
//		User user = userService.findById(7);
//		List<String> imagePaths = new ArrayList();
//	
//		List<Post> posts = user.getPosts();
//		if(posts == null)
//			System.out.println("empty");
//		
//		else {
//			for(Post post : posts) {
//				PostImage image = postImageService.findById(Integer.valueOf(post.getId()));
//				
//				if(image == null) {
//					System.out.println("nuled");
//					continue;
//				}
//					
//				String url = req.getContextPath() +  IMAGE_DIRECTORY + image.getName();
//				imagePaths.add(url);
//			}
//
//			req.setAttribute("imagePaths", imagePaths);
//
//		}
		
		
		//
		// if (req.getParameter("employeeId") != null)
		// {
		// int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		// employeeService.removeEmployee(employeeId);
		// }
		//
		// List<Employee> allEmployees = employeeService.findAllEmployees();
		// req.setAttribute("allEmployees", allEmployees);

		RequestDispatcher dispatcher = req.getRequestDispatcher("userDetail.jsp");
		dispatcher.forward(req, response);

		// return "Hello World";

		// set response headers
		// response.setContentType("text/html");
		// response.setCharacterEncoding("UTF-8");
		//
		// PrintWriter writer = response.getWriter();
		//
		// writer.append("<p>Hello World</p>");
		//
		// writer.append("<a href='/gaix/employeeController'>Click here</a> go to Demo
		// page");

	}

}
