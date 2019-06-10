package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entities.UserEntity;
import services.UserService;

@ManagedBean
@RequestScoped
public class SignUpBean implements Serializable {
	private static final long serialVersionUID = 1094805385228386363L;

	private String username;
	private String password;
	private String fullname;
	private String email;
	private String gender;

	private List<String> genders;

	private boolean isUsernameTaken = false;
	private boolean isEmailFormatIncorrect = false;

	@EJB
	UserService userService;

	@PostConstruct
	public void init() {
		genders = new ArrayList<String>();
		genders.add("Nam");
		genders.add("Nữ");
		genders.add("Không xác định");
	}

	public boolean getIsUsernameTaken() {
		return isUsernameTaken;
	}

	public void setIsUsernameTaken(boolean isUsernameTaken) {
		this.isUsernameTaken = isUsernameTaken;
	}

	public boolean getIsEmailFormatIncorrect() {
		return isEmailFormatIncorrect;
	}

	public void setIsEmailFormatIncorrect(boolean isEmailFormatIncorrect) {
		this.isEmailFormatIncorrect = isEmailFormatIncorrect;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private boolean validate() {
		if (userService.find(username) != null) {
			isUsernameTaken = true;
			System.out.println("Username taken");
			return false;
		}

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (email.matches(regex)) {
			return true;
		} else {
			isEmailFormatIncorrect = true;
			System.out.println("Wrong email format");
			return false;
		}
	}

	public void signUp() {
		if (validate()) {
			UserEntity user = new UserEntity();
			user.setEmail(email);
			user.setFullname(fullname);
			user.setGender(gender);
			user.setPassword(password);
			user.setUsername(username);
			
			userService.save(user);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("MainPage.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
