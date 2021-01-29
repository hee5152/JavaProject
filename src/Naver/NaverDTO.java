package Naver;

public class NaverDTO {
	private String naver_id;
	private String naver_pass;
	private String naver_name;
	private String naver_birth;
	private String naver_gender;
	private String naver_email;
	private String naver_phone;
	
	//getter setter
	public String getNaver_id() {
		return naver_id;
	}
	public void setNaver_id(String naver_id) {
		this.naver_id = naver_id;
	}
	public String getNaver_pass() {
		return naver_pass;
	}
	public void setNaver_pass(String naver_pass) {
		this.naver_pass = naver_pass;
	}
	public String getNaver_name() {
		return naver_name;
	}
	public void setNaver_name(String naver_name) {
		this.naver_name = naver_name;
	}
	public String getNaver_birth() {
		return naver_birth;
	}
	public void setNaver_birth(String naver_birth) {
		this.naver_birth = naver_birth;
	}
	public String getNaver_gender() {
		return naver_gender;
	}
	public void setNaver_gender(String naver_gender) {
		this.naver_gender = naver_gender;
	}
	public String getNaver_email() {
		return naver_email;
	}
	public void setNaver_email(String naver_email) {
		this.naver_email = naver_email;
	}
	public String getNaver_phone() {
		return naver_phone;
	}
	public void setNaver_phone(String naver_phone) {
		this.naver_phone = naver_phone;
	}
	//toString
	@Override
	public String toString() {
		return "NaverDTO [naver_id=" + naver_id + ", naver_pass=" + naver_pass + ", naver_name=" + naver_name
				+ ", naver_birth=" + naver_birth + ", naver_gender=" + naver_gender + ", naver_email=" + naver_email
				+ ", naver_phone=" + naver_phone + "]";
	}
	
	
	//constructor used field 생성자
	public NaverDTO() {
		super();
	}
	
	
	//매개변수생성자
	public NaverDTO(String naver_id, String naver_pass, String naver_name, String naver_birth, String naver_gender,
			String naver_email, String naver_phone) {
		super();
		this.naver_id = naver_id;
		this.naver_pass = naver_pass;
		this.naver_name = naver_name;
		this.naver_birth = naver_birth;
		this.naver_gender = naver_gender;
		this.naver_email = naver_email;
		this.naver_phone = naver_phone;
	}
	
	
	
	public void delete(String nid) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
