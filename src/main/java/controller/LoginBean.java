package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.UserEntity;
import services.UserService;
import ultilities.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String password;
	private String msg;
	private String username;

	private boolean isLoginInfoIncorrect = false;

	@PostConstruct
	public void init() {
		username = "";
		password = "";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getIsLoginInfoIncorrect() {
		return isLoginInfoIncorrect;
	}

	public void setLoginInfoIncorrect(boolean isLoginInfoIncorrect) {
		this.isLoginInfoIncorrect = isLoginInfoIncorrect;
	}

	@EJB
	UserService userService;

	// validate login
	public void validateUsernamePassword() {
		UserEntity userEntity = userService.find(username, password);
		if (userEntity != null) {
			isLoginInfoIncorrect = false;
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userid", userEntity.getId());
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("MainPage.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			isLoginInfoIncorrect = true;
			System.out.println("incorrect username");

		}
	}

	// logout event, invalidate session
	public void logout() {
		username = "";
		password = "";
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		System.out.println(SessionUtils.getUserId());
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("MainPage.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showInfo() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("MainPage.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String test() {
		System.out.println("test");
		return "MainPage?faces-redirect=true";
	}

	public boolean isUserLoggedOut() {
		if (username.equals("") || password.equals(""))
			return true;
		return false;
	}

	public boolean isUserLoggedIn() {
		if (!username.equals("") || !password.equals(""))
			return true;
		return false;
	}
}
