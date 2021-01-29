package Jdbc0120;

//DTO(Data Transfer Object)
// : 데이터 전송 객체
// : 클래스 필드 ,메소드, 생성자
public class StuDTO { //이름바꾸고 f2키 눌러주기

	private String stuName;
	private int stuAge;
	
	// getter, setter, toString, 생성자
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	@Override  //           --오른쪽마우스, sourse, toString
	public String toString() {
		return "StuDTO [stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}
	
	//기본생성자                           -- field 전부 해제하고
	public StuDTO() {
		super();
	}
	//매개변수 (파라미터) 생성자          -- fields 전부 체크하고
	public StuDTO(String stuName, int stuAge) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	
	// 정보 삭제 메소드 delete
	//delete(string sName) : 메소드 안에 String 타입의 sName정보를 가지고 있다.
	public void delete(String dName) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
