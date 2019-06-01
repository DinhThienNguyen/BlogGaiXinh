package post;

public class PostImage {
	private Integer id;
	private String path;

	public PostImage() {
		super();
	}

	public PostImage(Integer id, String path) {
		super();
		this.id = id;
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
