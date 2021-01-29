package Jdbc0120;

//DTO(Data Transfer Object)
// : ������ ���� ��ü
// : Ŭ���� �ʵ� ,�޼ҵ�, ������
public class StuDTO { //�̸��ٲٰ� f2Ű �����ֱ�

	private String stuName;
	private int stuAge;
	
	// getter, setter, toString, ������
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
	
	@Override  //           --�����ʸ��콺, sourse, toString
	public String toString() {
		return "StuDTO [stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}
	
	//�⺻������                           -- field ���� �����ϰ�
	public StuDTO() {
		super();
	}
	//�Ű����� (�Ķ����) ������          -- fields ���� üũ�ϰ�
	public StuDTO(String stuName, int stuAge) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	
	// ���� ���� �޼ҵ� delete
	//delete(string sName) : �޼ҵ� �ȿ� String Ÿ���� sName������ ������ �ִ�.
	public void delete(String dName) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
