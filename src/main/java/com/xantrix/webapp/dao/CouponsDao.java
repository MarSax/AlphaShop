package com.xantrix.webapp.dao;

import java.util.List;

import com.xantrix.webapp.entities.Coupons;

public interface CouponsDao 
{
	List<Coupons> SelByCodFidelity(String CodFidelity);
	
	void Salva(Coupons coupon);
}
