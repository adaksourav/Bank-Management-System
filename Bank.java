package mainclass;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	@Column(name = "Bank_Name")
	private String bankName;
	@Column(name = "IFSC_CODE")
	private String ifscNo;
	@Column(name = "No_Of_Branches")
	private int noOfBranches;
	@Column(name = "Bank_Address")
	private String BankAddress;
	@OneToMany(mappedBy = "bank",fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List <AccountDetails> accounts;
    
	public List<AccountDetails> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDetails> accounts) {
		this.accounts = accounts;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public int getNoOfBranches() {
		return noOfBranches;
	}

	public void setNoOfBranches(int noOfBranches) {
		this.noOfBranches = noOfBranches;
	}

	public String getBankAddress() {
		return BankAddress;
	}

	public void setBankAddress(String bankAddress) {
		BankAddress = bankAddress;
	}

	public Bank() {
		super();
	}

	public Bank(String bankName, String ifscNo, int noOfBranches, String bankAddress) {
		super();
		this.bankName = bankName;
		this.ifscNo = ifscNo;
		this.noOfBranches = noOfBranches;
		BankAddress = bankAddress;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", ifscNo=" + ifscNo + ", noOfBranches=" + noOfBranches + ", BankAddress="
				+ BankAddress + "]";
	}

}
