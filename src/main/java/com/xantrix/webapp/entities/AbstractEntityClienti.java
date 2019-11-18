package com.xantrix.webapp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractEntityClienti implements Serializable
{
	private static final long serialVersionUID = -3715123128236261120L;
	
	@Id
	@Column(name = "CODFIDELITY")
	@NotNull(message = "{NotNull.Clienti.codFidelity.validation}")
	@Size(min=8, max=20, message = "{Size.Clienti.codFidelity.validation}")
	protected String codFidelity;

	public String getCodFidelity() {
		return codFidelity;
	}

	public void setCodFidelity(String codFidelity) {
		this.codFidelity = codFidelity;
	}
	
	
}
