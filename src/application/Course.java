package application;

public class Course {
	private String code;
	private String name;
	private String prereq ;
	private String faculty ;
	private String postcon;
	private String timing;
	public Course(String code, String name, String prereq, String faculty, String postcon, String timing) {
		super();
		this.code = code;
		this.name = name;
		this.prereq = prereq;
		this.faculty = faculty;
		this.postcon = postcon;
		this.timing = timing;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrereq() {
		return prereq;
	}
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getPostcon() {
		return postcon;
	}
	public void setPostcon(String postcon) {
		this.postcon = postcon;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
}
