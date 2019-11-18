package com.xantrix.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xantrix.webapp.dao.CouponsDao;
import com.xantrix.webapp.entities.Coupons;

@Service("couponsService")
@Transactional
public class CouponsServiceImpl implements CouponsService
{
	@Autowired
	private CouponsDao couponsDao;
	
	
	@Override
	public List<Coupons> SelByCodFidelity(String CodFidelity) 
	{
		return couponsDao.SelByCodFidelity(CodFidelity);
	}

	@Override
	public void Salva(Coupons coupon) 
	{
		couponsDao.Salva(coupon);
	}

}
