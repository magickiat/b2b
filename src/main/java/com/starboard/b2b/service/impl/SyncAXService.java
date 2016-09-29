package com.starboard.b2b.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.TmpAddrDao;
import com.starboard.b2b.dao.TmpContactDao;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.TmpAddr;
import com.starboard.b2b.model.TmpContact;
import com.starboard.b2b.web.form.contact.ContactForm;

@Service("SyncAXService")
@Transactional(rollbackFor = Exception.class)
public class SyncAXService {

	private AddrDao addrDao;
	private TmpAddrDao tmpAddrDao;
	private ContactDao contactDao;
	private TmpContactDao tmpContactDao;

	public void syncAddr(long custId) {
		// clear old address
		tmpAddrDao.deleteByCustId(custId);

		// insert new address
		List<Addr> listAddr = addrDao.findByCustId(custId);
		if (listAddr != null && !listAddr.isEmpty()) {
			for (Addr addr : listAddr) {
				TmpAddr tmpAddr = new TmpAddr();
				BeanUtils.copyProperties(addr, tmpAddr);
				tmpAddrDao.save(tmpAddr);
			}
		}
	}

	@Autowired
	public void setAddrDao(AddrDao addrDao) {
		this.addrDao = addrDao;
	}

	@Autowired
	public void setTmpAddrDao(TmpAddrDao tmpAddrDao) {
		this.tmpAddrDao = tmpAddrDao;
	}

	public void syncContact(ContactForm contact) {
		// clear tmp
		tmpContactDao.deleteByCustId(contact.getCustId());

		// copy original to tmp
		List<Contact> listContact = contactDao.findByCustId(contact.getCustId());
		if (listContact != null && !listContact.isEmpty()) {
			for (Contact source : listContact) {
				TmpContact target = new TmpContact();
				BeanUtils.copyProperties(source, target);
				tmpContactDao.save(target);
			}
		}
	}

	@Autowired
	public void setTmpContactDao(TmpContactDao tmpContactDao) {
		this.tmpContactDao = tmpContactDao;
	}

	@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
