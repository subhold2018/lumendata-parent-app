package com.lumendata.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lumendata.common.entities.AddressEntity;
import com.lumendata.common.entities.CustomerEntity;
import com.lumendata.common.entities.DOBEntity;
import com.lumendata.common.entities.EmailEntity;
import com.lumendata.common.entities.NameEntity;
import com.lumendata.common.entities.PhoneEntity;
import com.lumendata.common.entities.SSNEntity;
import com.lumendata.common.entities.SourceEntity;
import com.lumendata.common.model.Address;
import com.lumendata.common.model.Customer;
import com.lumendata.common.model.Email;
import com.lumendata.common.model.Name;
import com.lumendata.common.model.Phone;

public class CommonUtils {

	public static int calculateDistanceDP(String x, String y) {
		int[][] dp = new int[x.length() + 1][y.length() + 1];

		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				}
				else if (j == 0) {
					dp[i][j] = i;
				}
				else {
					dp[i][j] = min(dp[i - 1][j - 1] 
							+ costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
							dp[i - 1][j] + 1, 
							dp[i][j - 1] + 1);
				}
			}
		}

		return dp[x.length()][y.length()];
	}

	public static int costOfSubstitution(char a, char b) {
		return a == b ? 0 : 1;
	}

	public static int min(int... numbers) {
		return Arrays.stream(numbers)
				.min().orElse(Integer.MAX_VALUE);
	}

	public static Customer getCustomerFromEntity(CustomerEntity customerEntity, Customer customer) {

		customer.setSource(customerEntity.getDobEntity().getSource().getSource());
		customer.setCreated(customerEntity.getDobEntity().getSource().getCreatedDate());
		customer.setUpdated(customerEntity.getDobEntity().getSource().getUpdatedDate());
		customer.setSRCId(customerEntity.getDobEntity().getSource().getSourceId());

		List<Name> names = new ArrayList<>();
		Name name = null;
		for(NameEntity eachNameEntity: customerEntity.getNames()) {
			name = new Name();
			name.setFN(eachNameEntity.getFirstName());
			name.setLN(eachNameEntity.getLastName());
			names.add(name);
		}
		customer.setName(names);

		List<Phone> phones = new ArrayList<>();
		Phone  phone = null;
		for(PhoneEntity eachPhoneEntity: customerEntity.getPhones()) {
			phone = new Phone();
			phone.setPhone(eachPhoneEntity.getPhone());
			phone.setType(eachPhoneEntity.getType());
			phone.setPrimary(eachPhoneEntity.getPrimary());
			phone.setCreated(eachPhoneEntity.getSource().getCreatedDate());
			phone.setUpdated(eachPhoneEntity.getSource().getUpdatedDate());
			phone.setSource(eachPhoneEntity.getSource().getSource());
			phone.setSRCId(eachPhoneEntity.getSource().getSourceId());
			phones.add(phone);
		}
		customer.setPhone(phones);

		List<Email> emails = new ArrayList<>();
		Email  email = null;
		for(EmailEntity eachEmailEntity: customerEntity.getEmails()) {
			email = new Email();
			email.setEmail(eachEmailEntity.getEmail());
			email.setType(eachEmailEntity.getType());
			email.setPrimary(eachEmailEntity.getPrimary());
			email.setCreated(eachEmailEntity.getSource().getCreatedDate());
			email.setUpdated(eachEmailEntity.getSource().getUpdatedDate());
			email.setSource(eachEmailEntity.getSource().getSource());
			email.setSRCId(eachEmailEntity.getSource().getSourceId());
			emails.add(email);
		}
		customer.setEmail(emails);

		List<Address> addresses = new ArrayList<>();
		Address  address = null;
		for(AddressEntity eachAddressEntity: customerEntity.getAddresses()) {
			address = new Address();
			address.setAddrLine1(eachAddressEntity.getAddressLine1());
			address.setAddrLine2(eachAddressEntity.getAddressLine2());
			address.setPrimary(eachAddressEntity.getPrimary());
			address.setCreated(eachAddressEntity.getSource().getCreatedDate());
			address.setUpdated(eachAddressEntity.getSource().getUpdatedDate());
			address.setSource(eachAddressEntity.getSource().getSource());
			address.setSRCId(eachAddressEntity.getSource().getSourceId());
			addresses.add(address);
		}
		customer.setAddress(addresses);
		return customer;

	}

	public static CustomerEntity getCustomerEntityFromCustomer(Customer customer) {

		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setAddresses(new ArrayList<AddressEntity>());
		customerEntity.setDobEntity(new DOBEntity());
		customerEntity.setEmails(new ArrayList<EmailEntity>());
		customerEntity.setNames(new ArrayList<NameEntity>());
		customerEntity.setPhones(new ArrayList<PhoneEntity>());
		customerEntity.setSsnEntity(new SSNEntity());

		SourceEntity sourceEntity = new SourceEntity();
		sourceEntity.setCreatedDate(customer.getCreated());
		sourceEntity.setSource(customer.getSource());
		sourceEntity.setSourceId(customer.getSRCId());
		sourceEntity.setUpdatedDate(customer.getUpdated());

		customerEntity.getDobEntity().setSource(sourceEntity);
		customerEntity.getDobEntity().setDob(customer.getDob());
		
		customerEntity.getSsnEntity().setSource(sourceEntity);
		customerEntity.getSsnEntity().setSsn(customer.getSSN());


		List<NameEntity> names = new ArrayList<>();
		NameEntity nameEntity = null;
		for(Name eachName: customer.getName()) {
			nameEntity = new NameEntity();
			nameEntity.setFirstName(eachName.getFN());
			nameEntity.setLastName(eachName.getLN());
			
			sourceEntity = new SourceEntity();
			sourceEntity.setCreatedDate(customer.getCreated());
			sourceEntity.setSource(customer.getSource());
			sourceEntity.setSourceId(customer.getSRCId());
			sourceEntity.setUpdatedDate(customer.getUpdated());
			nameEntity.setSource(sourceEntity);
			
			names.add(nameEntity);
		}
		customerEntity.setNames(names);

		List<PhoneEntity> phones = new ArrayList<>();
		PhoneEntity  phoneEntity = null;
		for(Phone eachPhone: customer.getPhone()) {
			phoneEntity = new PhoneEntity();
			phoneEntity.setPhone(eachPhone.getPhone());
			phoneEntity.setType(eachPhone.getType());
			phoneEntity.setPrimary(eachPhone.getPrimary());
			
			sourceEntity = new SourceEntity();
			sourceEntity.setCreatedDate(eachPhone.getCreated());
			sourceEntity.setSource(eachPhone.getSource());
			sourceEntity.setSourceId(eachPhone.getSRCId());
			sourceEntity.setUpdatedDate(eachPhone.getUpdated());
			phoneEntity.setSource(sourceEntity);
			
			phones.add(phoneEntity);
		}
		customerEntity.setPhones(phones);

		List<EmailEntity> emails = new ArrayList<>();
		EmailEntity  emailEntity = null;
		for(Email eachEmail: customer.getEmail()) {
			emailEntity = new EmailEntity();
			emailEntity.setEmail(eachEmail.getEmail());
			emailEntity.setType(eachEmail.getType());
			emailEntity.setPrimary(eachEmail.getPrimary());
			
			sourceEntity = new SourceEntity();
			sourceEntity.setCreatedDate(eachEmail.getCreated());
			sourceEntity.setSource(eachEmail.getSource());
			sourceEntity.setSourceId(eachEmail.getSRCId());
			sourceEntity.setUpdatedDate(eachEmail.getUpdated());
			emailEntity.setSource(sourceEntity);
			
			emails.add(emailEntity);
		}
		customerEntity.setEmails(emails);

		List<AddressEntity> addresses = new ArrayList<>();
		AddressEntity addressEntity = null;
		for(Address eachAddress: customer.getAddress()) {
			addressEntity = new AddressEntity();
			addressEntity.setAddressLine1(eachAddress.getAddrLine1());
			addressEntity.setAddressLine2(eachAddress.getAddrLine2());
			addressEntity.setPrimary(eachAddress.getPrimary());
			
			sourceEntity = new SourceEntity();
			sourceEntity.setCreatedDate(eachAddress.getCreated());
			sourceEntity.setSource(eachAddress.getSource());
			sourceEntity.setSourceId(eachAddress.getSRCId());
			sourceEntity.setUpdatedDate(eachAddress.getUpdated());
			
			addressEntity.setSource(sourceEntity);
			addresses.add(addressEntity);
		}
		customerEntity.setAddresses(addresses);
		
		return customerEntity;
	}

}
