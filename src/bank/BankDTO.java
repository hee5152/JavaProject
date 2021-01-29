package bank;

public class BankDTO {

	private int clientNumber;		//����ȣ
	private String cName;			//���̸�
	private String accountNumber;	//���¹�ȣ
	private int balance;			//�ܾ�
	
	//getter setter
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	//	toString
	@Override
	public String toString() {
		return "BankDTO [clientNumber=" + clientNumber + ", cName=" + cName + ", accountNumber=" + accountNumber
				+ ", balance=" + balance + "]";
	}
	
	//�⺻ ������
	public BankDTO() {
		super();
	}
	
	//�Ű����� ������  ���� ������ �ֵ��� �Ѳ����� ó���Ҽ����� 
	public BankDTO(int clientNumber, String cName, String accountNumber, int balance) {
		super();
		this.clientNumber = clientNumber;
		this.cName = cName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	

	
}
