package com.xantrix.webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
 
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTI")
public class Clienti extends AbstractEntityClienti  implements Serializable
{
	private static final long serialVersionUID = -6994272792307526864L;
	
	@Column(name = "NOME")
	@Size(min=2, max=50, message = "{Size.Clienti.nome.validation}")
	private String nome;
	
	@Column(name = "COGNOME")
	@Size(min=2, max=60, message = "{Size.Clienti.cognome.validation}")
	private String cognome;
	
	@Transient
	private String nominativo;
	
	@Column(name = "INDIRIZZO")
	@Size(min=10, max=80, message = "{Size.Clienti.indirizzo.validation}")
	private String indirizzo;
	
	@Column(name = "COMUNE")
	@Size(min=2, max=50, message = "{Size.Clienti.comune.validation}")
	private String comune;
	
	@Column(name = "CAP")
	private String cap;
	
	@Column(name = "PROV")
	private String prov;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "STATO")
	@Enumerated(EnumType.ORDINAL)
	private Stato stato;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATACREAZ")
	private Date dataCreaz;
	
	@Transient
	private Double valCoupons;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Cards card;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Premi premi;
	
	@OneToOne(mappedBy = "clienti", cascade = CascadeType.ALL, orphanRemoval = true)
	private Utenti utenti;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private Set<Coupons> coupons = new HashSet<>();

	
	public Clienti() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}
	
	
	public String getCap() 
	{
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) 
	{
		this.prov = prov;
	}

	public String getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Premi getPremi() {
		return premi;
	}

	public void setPremi(Premi premi) {
		this.premi = premi;
	}

	public Date getDataCreaz() {
		return dataCreaz;
	}

	public void setDataCreaz(Date dataCreaz) {
		this.dataCreaz = dataCreaz;
	}
	
	
	public Cards getCard() {
		return card;
	}

	public void setCard(Cards card) {
		this.card = card;
	}

	public Utenti getUtenti() {
		return utenti;
	}

	public void setUtenti(Utenti utenti) {
		this.utenti = utenti;
	}

	public String getNominativo() 
	{
		return this.nome + " " + this.cognome;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Double getValCoupons() {
		return valCoupons;
	}

	public void setValCoupons(Double valCoupons) {
		this.valCoupons = valCoupons;
	}

	public Set<Coupons> getCoupons() {
		return coupons;
	}

	public void setCoupons(Set<Coupons> coupons) {
		this.coupons = coupons;
	}
	
	
	

}
