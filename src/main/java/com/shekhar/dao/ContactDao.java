package com.shekhar.dao;

import java.util.List;

import com.shekhar.model.Contact;

public interface ContactDao {
	
	public String findNameById(Integer id);
	
	public List<String> findNames();
	
	public Contact findById(Integer id);

}
