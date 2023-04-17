package kr.ac.kopo.lib.vo;

public class MemberVO {
	
	private String Id; 
	private String Password; 
	private	String name; 
	private String birth; 
	private String email; 
	private String phone;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id) {
		super();
		this.Id = id;
	}
	
	
	public MemberVO(String id, String password, String name, String birth, String email, String phone) {
		super();
		this.Id = id;
		this.Password = password;
		this.name = name;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
	}

	
	
	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "MemberVO [Id=" + Id + ", Password=" + Password + ", name=" + name + ", birth=" + birth + ", email="
				+ email + ", phone=" + phone + "]";
	}



	
	
}
