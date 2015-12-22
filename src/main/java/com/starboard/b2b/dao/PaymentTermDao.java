package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.PaymentTermDTO;

public interface PaymentTermDao {
	List<PaymentTermDTO> list();
}
