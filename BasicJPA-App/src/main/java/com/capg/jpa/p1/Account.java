package com.capg.jpa.p1;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.jpa.p3.Insurance;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity   
@Table(name = "MyAccounts")

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountNumber")
	private int accId;
	
	@Column(name=" AccountName")
	private String accountHolderName;
	
	private int balance;
	//@Temporal(TemporalType.TIMESTAMP) used only for java.util.Date (old date api)
	private LocalDate openningDate;
		
	@Embedded
	private Address address;
		
		@Embedded
		@AttributeOverrides({
			@AttributeOverride(name = "houseNumber",column = @Column(name="office_Address")),
			@AttributeOverride(name = "cityName",column = @Column(name="office_cityName")),
			@AttributeOverride(name = "state",column = @Column(name="office_state")),
		})
		private Address office_address;
		//--------  Collection Has-a Relation----
		
		@ElementCollection
		@CollectionTable(name="PolicyInfo",joinColumns = @JoinColumn(name="AccountNumber"))
		List<Policy> policies;
		
		// ------------- Adding Insurance Class with Accounts -----
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="Account_Number")
		private List<Insurance> insuranceList;
		
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(int accId, String accountHolderName, int balance, LocalDate openningDate, Address address,
			Address office_address, List<Policy> policies) {
		super();
		this.accId = accId;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.openningDate = openningDate;
		this.address = address;
		this.office_address = office_address;
		this.policies = policies;
	}
	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}



	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public List<Policy> getPolicies() {
		return policies;
	}



	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}



	public int getAccId() {
		return accId;
	}



	public void setAccId(int accId) {
		this.accId = accId;
	}



	public String getAccountHolderName() {
		return accountHolderName;
	}



	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public LocalDate getOpenningDate() {
		return openningDate;
	}



	public void setOpenningDate(LocalDate openningDate) {
		this.openningDate = openningDate;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Address getOffice_address() {
		return office_address;
	}



	public void setOffice_address(Address office_address) {
		this.office_address = office_address;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ ", openningDate=" + openningDate + ", address=" + address + ", office_address=" + office_address
				+ ", policies=" + policies + "]";
	}



}