package com.xantrix.webapp.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.xantrix.webapp.entities.Utenti;

@Repository
public class UtentiDaoImpl  extends AbstractDao<Utenti, Integer> 
	implements UtentiDao
{
	@Override
	public Utenti SelByIdFidelity(String idFidelity)
	{
		Utenti retVal = new Utenti();
		
		try
		{
			CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Utenti> queryDefinition = queryBuilder.createQuery(Utenti.class);
			
			Root<Utenti> recordset = queryDefinition.from(Utenti.class);
			
			queryDefinition.select(recordset).
							where(queryBuilder.equal(recordset.get("codFidelity"), idFidelity));
			
			retVal =  entityManager.createQuery(queryDefinition).getSingleResult();
			
			return retVal;
		}
		catch(Exception ex)
		{
			return retVal;
		}
	}
	
	@Override
	public Utenti SelByUserId(String UserId) 
	{
		Utenti utente = null;
		
		try
		{
			String JPQL = "SELECT a FROM Utenti a WHERE a.userId = :UserId";
			
			utente = (Utenti) entityManager.createQuery(JPQL)
					.setParameter("UserId", UserId)
					.getSingleResult();
		}
		catch (Exception ex)
		{ }
		
		return utente;
	}
	
	@Override
	public void Salva(Utenti utente)
	{
		super.Inserisci(utente);
	}
	
	@Override
	public void Aggiorna(Utenti utente)
	{
		super.Aggiorna(utente);
	}
	
	@Override
	public void Elimina(Utenti utente)
	{
		super.Elimina(utente);
	}

	

	

}
