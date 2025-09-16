package mainclass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AccountDetails {
	@Id
	private long accountNumber;
	@Column(name = "Account_Holder_Name")
	private String name;
	@Column(name = "D.O.B")
	private String dateOfbirth;
	private String email;
	private long aadharNo;
	private double blance;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Bank bank;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public double getBlance() {
		return blance;
	}

	public void setBlance(double blance) {
		this.blance = blance;
	}

	public AccountDetails() {
		super();
	}

	public AccountDetails(long accountNumber, String name, String dateOfbirth, String email, long aadharNo,
			double blance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.dateOfbirth = dateOfbirth;
		this.email = email;
		this.aadharNo = aadharNo;
		this.blance = blance;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", name=" + name + ", dateOfbirth=" + dateOfbirth
				+ ", email=" + email + ", aadharNo=" + aadharNo + ", blance=" + blance + "]";
	}

}
