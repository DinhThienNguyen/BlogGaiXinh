package post;

public class PostComment {
	private Integer id;
	private String username;
	private String content;
	public PostComment() {
		super();
	}
	public PostComment(Integer id, String username, String content) {
		super();
		this.id = id;
		this.username = username;
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
