package com.test.donation_app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the donation database table.
 * 
 */
@Entity
@NamedQuery(name="Donation.findAll", query="SELECT d FROM Donation d")
public class Donation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_donation")
	private int idDonation;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="donation_amount")
	private double donationAmount;

	private String month;

	//bi-directional many-to-one association to CreditCard
	@ManyToOne
	@JoinColumn(name="credit_card_id_credit_card")
	private CreditCard creditCard;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	private Institution institution;

	public Donation() {
	}

	public int getIdDonation() {
		return this.idDonation;
	}

	public void setIdDonation(int idDonation) {
		this.idDonation = idDonation;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDonationAmount() {
		return this.donationAmount;
	}

	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}