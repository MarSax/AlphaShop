package com.xantrix.webapp.dao;

import java.util.List;

import com.xantrix.webapp.entities.Rilevazioni;

public interface RilevazioniDao 
{
	List<Rilevazioni> SelByIdTerminale(String IdTerminale);
	
	void Salva(Rilevazioni rilevazioni);
	
	void Elimina(String IdTerminale);
	
	
}
