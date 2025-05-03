package Utilities;

import java.lang.foreign.AddressLayout;
import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public static String getFirstFakeName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String firstName=address.firstName();
		return firstName;
	}
	
	public static String getLastFakeName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String lastName=address.lastName();
		return lastName;
	}
	
	public static String getCityFakeName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String citytName=address.city();
		return citytName;
	}
	
	public static int randomnumberGenerator() {
		Random rand =new Random();
		int randomNumber = rand.nextInt(100000);
		return randomNumber;
	}

}


