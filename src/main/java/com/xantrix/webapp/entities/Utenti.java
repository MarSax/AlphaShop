package com.xantrix.webapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.xantrix.webapp.validator.UserId;

@Entity
@Table(name = "UTENTI")
public class Utenti  extends AbstractEntityClienti implements Serializable
{
	private static final long serialVersionUID = 8473057964112587082L;

	@Column(name = "USERID")
	@UserId
	private String userId;

	@Column(name = "PASSWORD")
	private String pwd;

	@Column(name = "ABILITATO")
	private String abilitato;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Clienti clienti;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,  mappedBy = "utente", orphanRemoval = true)
	private Set<Profili> profili = new HashSet<>();

	public Utenti()
	{
	}
	
	public Utenti(String CodFidelity)
	{
		super.codFidelity = CodFidelity;
	}
	
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getAbilitato()
	{
		return abilitato;
	}

	public void setAbilitato(String abilitato)
	{
		this.abilitato = abilitato;
	}
	
	public Clienti getClienti() {
		return clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Set<Profili> getProfili() {
		return profili;
	}

	public void setProfili(Set<Profili> profili) {
		this.profili = profili;
	}
	
	
}

