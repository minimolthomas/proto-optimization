package com.protobuf.test;
import java.util.List;
import java.util.Random;

import com.example.tutorial.protos.*;
public class ProtoBufTest {

	public static void generateTestProto(int total) {
		AddressBook.Builder book = AddressBook.newBuilder();
		//List<Person.Builder> peopleList =  book.add
		for(int i = 0 ; i < total ; ++i) {
			Person.Builder person = Person.newBuilder();
			Random rand = new Random(i);
	
			person.setId(rand.nextInt());
	
			person.setName("Test Name " + i);

			person.setEmail("test.name"+i + "@gmail.com");
	
			Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber(String.valueOf(  121345667+rand.nextInt()));
			Integer type = i%3;
			if (type.equals(0)) {
				phoneNumber.setType(Person.PhoneType.MOBILE);
			} else if (type.equals(1)) {
				phoneNumber.setType(Person.PhoneType.HOME);
			} else if (type.equals(2)) {
				phoneNumber.setType(Person.PhoneType.WORK);
			}
			person.addPhones(phoneNumber);
			person.setCountry("Unites States");
	
			//System.out.println("Size " +person.build().toByteArray().length);
			book.addPeople(person); 
		}
		System.out.println("Final Size " +book.build().toByteArray().length);
	}
	public static void generateTestProtoWithMap(int total) {
		AddressBook.Builder book = AddressBook.newBuilder();
		CountryMapping.Builder cBuilder = CountryMapping.newBuilder();
		cBuilder.setKey(1);
		cBuilder.setValue("Unites States");
		book.addCmap(cBuilder);
		for(int i = 0 ; i < total ; ++i) {
			Person.Builder person = Person.newBuilder();
			Random rand = new Random(i);
	
			person.setId(rand.nextInt());
	
			person.setName("Test Name " + i);

			person.setEmail("test.name"+i + "@gmail.com");
	
			Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber(String.valueOf(  121345667+rand.nextInt()));
			Integer type = i%3;
			if (type.equals(0)) {
				phoneNumber.setType(Person.PhoneType.MOBILE);
			} else if (type.equals(1)) {
				phoneNumber.setType(Person.PhoneType.HOME);
			} else if (type.equals(2)) {
				phoneNumber.setType(Person.PhoneType.WORK);
			}
			person.addPhones(phoneNumber);
			person.setCountry("1");
	
			//System.out.println("Size " +person.build().toByteArray().length);
			book.addPeople(person); 
		}
		System.out.println("Final Size with Map " +book.build().toByteArray().length);
	}
	public static void main(String[] args) {
		System.out.println("ProtoBuf Size Test");
		generateTestProto(1000);
		generateTestProtoWithMap(1000);
	}
}
