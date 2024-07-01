package com.shekhar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import com.shekhar.dao.ContactDao;
import com.shekhar.model.Contact;

class ContactServiceImplTest {

	@Test
	public void getNamebyIdTest() {
		
		ContactDao daoproxy = EasyMock.createMock(ContactDao.class);
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		
		contactServiceImpl.setContactDao(daoproxy);
		
		Integer id=111;
		
		EasyMock.expect(daoproxy.findNameById(id)).andReturn("SHEKHAR");
		
		EasyMock.replay(daoproxy);
		
		String name = contactServiceImpl.getNamebyId(id);
		
		assertEquals("SHEKHAR", name);
		
	}
	
	@Test
	public void getAllContactNameTest() {
		
		// We are doing mock for dependent object DAO
		ContactDao daoproxy = EasyMock.createMock(ContactDao.class);
		
		//we create own list
		List<String> list= new ArrayList<>();
		list.add("shekhar");
		list.add("ravi");
		list.add("pramod");
		
		EasyMock.expect(daoproxy.findNames()).andReturn(list);
		
		EasyMock.replay(daoproxy);
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDao(daoproxy);
		
		List<String> actualList = contactServiceImpl.getAllContactName();
		
		Integer expectedList=3;
		
		assertEquals(expectedList, actualList.size());
		
		
	}
	
	@Test
	public void getContactByIdTest() {
		
		ContactDao daoproxy = EasyMock.createMock(ContactDao.class);
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDao(daoproxy);
		
		Contact contact = new Contact();
		contact.setContactId(777);
		contact.setContactName("shekhar");
		contact.setContactNumber(5353535);
		
		Integer id=777;
		EasyMock.expect(daoproxy.findById(id)).andReturn(contact);
		
		EasyMock.replay(daoproxy);
		
		Contact originalContact = contactServiceImpl.getContactById(id);
		
		String contactName="shekhar";
		
		assertEquals(contactName, originalContact.getContactName());
		assertEquals(id, originalContact.getContactId() );
		assertEquals(5353535, originalContact.getContactNumber());
	}
}
