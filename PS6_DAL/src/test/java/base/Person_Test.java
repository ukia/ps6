package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel person1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Date person1Birth = null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		person1 = new PersonDomainModel();
		
		try{
			person1Birth = dateFormat.parse("1990-10-10");
		}
		catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		person1.setFirstName("Wide");
		person1.setLastName("Stone");
		person1.setCity("Secret");
		person1.setPostalCode(43656);
		person1.setStreet("668 east street");
		
	}
	
	@Test
	public void AddPersonTest(){
		PersonDAL.addPerson(person1);
	}
	
	@Test
	public void GetPersonTest(){
		String LastName = person1.getLastName();
		assertEquals("Stone",LastName);
	}
	
	@Test
	public void UpdatePersonTest(){
		person1.setFirstName("Wide");
		
		PersonDAL.updatePerson(person1);
	}
	
	@Test
	public void deletePersontest(){
		PersonDAL.addPerson(person1);
	}



	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


}
