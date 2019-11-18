package com.xantrix.webapp.service;

import java.util.List;

import com.xantrix.webapp.entities.Coupons;

public interface CouponsService 
{
	List<Coupons> SelByCodFidelity(String CodFidelity);
	
	void Salva(Coupons coupon);
}
