package com.xantrix.webapp.entities;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.persistence.AccessType;
import javax.persistence.Basic;

@Embeddable
@Access(AccessType.FIELD)
public class InfoPremi 
{
	@Basic
	String codice;
	
	@Basic
	String descrizione;
	
	@Basic(optional = true)
	String marca;
	
	@Basic(optional = true)
	String tipo;
	
	@Basic
	int punti;
	
	@Basic
	double contributo;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public double getContributo() {
		return contributo;
	}

	public void setContributo(double contributo) {
		this.contributo = contributo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
	
}
