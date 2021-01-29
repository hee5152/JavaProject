package dogShelter;

public class ShelterDTO2 {
	private String dPk;
	private String dDay;
	private String dBreed;
	private String dGender;
	private String dFigu;
	private String dAge;
	public String getdPk() {
		return dPk;
	}
	public void setdPk(String dPk) {
		this.dPk = dPk;
	}
	public String getdDay() {
		return dDay;
	}
	public void setdDay(String dDay) {
		this.dDay = dDay;
	}
	public String getdBreed() {
		return dBreed;
	}
	public void setdBreed(String dBreed) {
		this.dBreed = dBreed;
	}
	public String getdGender() {
		return dGender;
	}
	public void setdGender(String dGender) {
		this.dGender = dGender;
	}
	public String getdFigu() {
		return dFigu;
	}
	public void setdFigu(String dFigu) {
		this.dFigu = dFigu;
	}
	public String getdAge() {
		return dAge;
	}
	public void setdAge(String dAge) {
		this.dAge = dAge;
	}
	@Override
	public String toString() {
		return "ShelterDTO2 [dPk=" + dPk + ", dDay=" + dDay + ", dBreed=" + dBreed + ", dGender=" + dGender + ", dFigu="
				+ dFigu + ", dAge=" + dAge + "]";
	}
	public ShelterDTO2(String dPk, String dDay, String dBreed, String dGender, String dFigu, String dAge) {
		super();
		this.dPk = dPk;
		this.dDay = dDay;
		this.dBreed = dBreed;
		this.dGender = dGender;
		this.dFigu = dFigu;
		this.dAge = dAge;
	}
	public ShelterDTO2() {
		super();
	}
	
	
}
