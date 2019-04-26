package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
//@ManagedBean
//@SessionScoped
@WebServlet(name = "UserRegister", urlPatterns = "/register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		RequestDispatcher view = request.getRequestDispatcher("index.html");
//		view.forward(request, response);

//		 Set response content type
		response.setContentType("text/html");

		String message = "Hello World";
		
		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("enter");
		String name = request.getParameter("name");
		
		User user = new User();
//		user.setId(1);
		user.setName(name);
		user.setGender("a");
		user.setEmail("a");
		
		userService.saveEmployee(user);
		
		System.out.println(name);
	}

}
