package com.test.donation_app.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the credit_card_type database table.
 * 
 */
@Entity
@Table(name="credit_card_type")
@NamedQuery(name="CreditCardType.findAll", query="SELECT c FROM CreditCardType c")
public class CreditCardType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_credit_card_type")
	private int idCreditCardType;

	@Column(name="credit_card_type_name")
	private String creditCardTypeName;

	//bi-directional many-to-one association to CreditCard
	@OneToMany(mappedBy="creditCardType")
	private List<CreditCard> creditCards;

	public CreditCardType() {
	}
	
	public CreditCardType(String id) {
		idCreditCardType=Integer.valueOf(id);
	}

	public int getIdCreditCardType() {
		return this.idCreditCardType;
	}

	public void setIdCreditCardType(int idCreditCardType) {
		this.idCreditCardType = idCreditCardType;
	}

	public String getCreditCardTypeName() {
		return this.creditCardTypeName;
	}

	public void setCreditCardTypeName(String creditCardTypeName) {
		this.creditCardTypeName = creditCardTypeName;
	}

	public List<CreditCard> getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public CreditCard addCreditCard(CreditCard creditCard) {
		getCreditCards().add(creditCard);
		creditCard.setCreditCardType(this);

		return creditCard;
	}

	public CreditCard removeCreditCard(CreditCard creditCard) {
		getCreditCards().remove(creditCard);
		creditCard.setCreditCardType(null);

		return creditCard;
	}

}