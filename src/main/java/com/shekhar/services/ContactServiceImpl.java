package com.shekhar.services;

import java.util.List;

import com.shekhar.dao.ContactDao;
import com.shekhar.exception.NoDataFoundException;
import com.shekhar.model.Contact;

public class ContactServiceImpl implements ContactService {
	
	private ContactDao contactDao;

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public String getNamebyId(Integer id) {
		String name = contactDao.findNameById(id);
		String formatedName = name.toUpperCase();
		return formatedName;
	}

	@Override
	public List<String> getAllContactName() {
		List<String> names = contactDao.findNames();
		
		if(names == null) {
			throw new NoDataFoundException();
		}
		return names;
	}

	@Override
	public Contact getContactById(Integer id) {
       Contact contact = contactDao.findById(id);
       
       if(contact == null) {
    	   throw new NoDataFoundException();
       }
		return contact;
	}

}
