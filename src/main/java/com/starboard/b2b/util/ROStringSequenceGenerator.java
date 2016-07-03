package com.starboard.b2b.util;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGeneratorHelper.BigDecimalHolder;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.SequenceGenerator;

public class ROStringSequenceGenerator extends SequenceGenerator {
	
	private final String prefix = "RO";
	
	@Override
	public Serializable generate(SessionImplementor session, Object obj) {
		String.format("%s-%s-%s", prefix);
		return super.generate(session, obj).toString();
	}

	@Override
	protected IntegralDataTypeHolder buildHolder() {
		return new BigDecimalHolder();
	}
}
