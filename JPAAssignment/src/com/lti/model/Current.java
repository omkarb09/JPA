package com.lti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Currents")
@DiscriminatorValue(value="current")
public class Current extends Account
{
	private double overDraft;

	public Current() {
		super();
	}

	public Current(long accountNumber, String accountHolderName, double accountBalance,double overDraft) {
		super(accountNumber, accountHolderName, accountBalance);
		this.overDraft=overDraft;
	}

	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	@Override
	public String toString() {
		return "Current [overDraft=" + overDraft + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
}
