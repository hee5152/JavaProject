package dogShelter;

public class ShelterDTO {
	private String sId;
	private String sPw;
	private String sName;
	private String sAddr;
	private String sPhone;
	private String sEmail;
	private String charity;
	
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsPw() {
		return sPw;
	}
	public void setsPw(String sPw) {
		this.sPw = sPw;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getCharity() {
		return charity;
	}
	public void setCharity(String charity) {
		this.charity = charity;
	}
	
	@Override
	public String toString() {
		return "ShelterDTO [sId=" + sId + ", sPw=" + sPw + ", sName=" + sName + ", sAddr=" + sAddr + ", sPhone="
				+ sPhone + ", sEmail=" + sEmail + ", charity=" + charity + "]";
	}
	public ShelterDTO(String sId, String sPw, String sName, String sAddr, String sPhone, String sEmail,
			String charity) {
		this.sId = sId;
		this.sPw = sPw;
		this.sName = sName;
		this.sAddr = sAddr;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
		this.charity = charity;
	}
	public ShelterDTO() {
	
	}
	
	
}
