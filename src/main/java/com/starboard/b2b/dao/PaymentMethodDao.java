package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.PaymentMethodDTO;

public interface PaymentMethodDao {

	List<PaymentMethodDTO> list();

}