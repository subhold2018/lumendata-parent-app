package com.ld.app.clusterkeys;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lumendata.attribute.ScoreApp;
import com.lumendata.attribute.clusterkeys.service.ClusterKeysService;
import com.lumendata.common.model.Address;
import com.lumendata.common.model.ClusterKeys;
import com.lumendata.common.model.Customer;
import com.lumendata.common.model.Email;
import com.lumendata.common.model.Name;
import com.lumendata.common.model.Phone;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScoreApp.class)
public class ClusterKeysServiceTest {

	@Autowired
	private ClusterKeysService clusterKeysService;

	Customer customer = new Customer();
	
	@Test
	public void testNameScore(){

		ClusterKeys clusterKeys = clusterKeysService.getClusterKeys(customer);
		assertEquals("JN4567890", clusterKeys.getFirstNameMetaPhoneNumKey());
		assertEquals("567890", clusterKeys.getPhoneNumberKey());
		assertEquals("1234", clusterKeys.getNationalIdKey());
		assertEquals("XYZGMAILCOM", clusterKeys.getEmailKey());
		assertEquals("011992SMIJOH", clusterKeys.getDobGivenNameFirstNameKey());
		assertEquals("JOHN011992", clusterKeys.getFirstNameDOBKey());
		assertEquals("SMIT011992", clusterKeys.getLastNameDOBKey());
		
	}

	@Before
	public void setCustomerModel() {
		customer.setSource("SFDC");
		customer.setSRCId("00050000954131");
		customer.setCreated("1/1/2011");
		customer.setUpdated("1/12/2019");
		customer.setDob("1/1/1992");
		
		List<Name> names = new ArrayList<>();
		Name name = new Name();
		name.setFN("John");
		name.setLN("Smith");
		names.add(name);
		name = new Name();
		name.setFN("Johnathan");
		name.setLN("Smith");
		names.add(name);
		
		customer.setName(names);
		customer.setSSN("1234");
		
		List<Phone> phones = new ArrayList<>();
		Phone phone = new Phone();
		phone.setPhone(1234567890L);
		phone.setType("Home");
		phone.setPrimary("Y");
		phone.setCreated("1/1/2011");
		phone.setUpdated("1/12/2019");
		phone.setSource("SFDC");
		phone.setSRCId("123456");
		phones.add(phone);
	
		phone = new Phone();
		phone.setPhone(2234567890L);
		phone.setType("Cell");
		phone.setPrimary("N");
		phone.setCreated("1/1/2011");
		phone.setUpdated("1/12/2019");
		phone.setSource("SFDC");
		phone.setSRCId("123456");
		phones.add(phone);
		
		customer.setPhone(phones);
		
		List<Email> emails = new ArrayList<>();
		Email email = new Email();
		email.setEmail("xyz@gmail.com");
		email.setType("Work");
		email.setPrimary("Y");
		email.setCreated("1/1/2011");
		email.setUpdated("1/12/2019");
		email.setSource("SFDC");
		email.setSRCId("323456");
		emails.add(email);
		
		customer.setEmail(emails);
		
		List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setAddrLine1("123 Main St");
		address.setAddrLine2("Bldg 2");
		address.setCity("Denver");
		address.setState("CO");
		address.setZIP("45242");
		address.setType("Work");
		address.setPrimary("Y");
		address.setCreated("1/1/2011");
		address.setUpdated("1/12/2019");
		address.setSource("SFDC");
		address.setSRCId("423456");
		addresses.add(address);
		
		customer.setAddress(addresses);
		
	}

}
