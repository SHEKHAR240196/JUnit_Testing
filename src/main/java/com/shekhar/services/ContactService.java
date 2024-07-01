package com.shekhar.services;

import java.util.List;

import com.shekhar.model.Contact;

public interface ContactService {
	
	public String getNamebyId(Integer id);
	
	public List<String> getAllContactName();
	
	public Contact getContactById(Integer id);

}
