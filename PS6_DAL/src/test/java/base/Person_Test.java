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

	private static PersonDomainModel personp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		personp = new PersonDomainModel();
		
		personp.setFirstName("Jack");
		personp.setLastName("Lee");
		personp.setCity("Newark");
		personp.setPostalCode(12345);
		personp.setStreet("1 Main street");
		
	}
	
	@Test
	public void AddPersonTest(){
		PersonDomainModel pdim = PersonDAL.getPerson(personp.getPersonID());		
		PersonDAL.addPerson(personp);
		pdim = PersonDAL.getPerson(personp.getPersonID());
		assertEquals(personp, pdim);
	}
	
	@Test
	public void GetPersonTest(){
		String LastName = personp.getLastName();
		assertEquals("Lee",LastName);
	}
	
	@Test
	public void UpdatePersonTest(){
		personp.setFirstName("Lee");
		PersonDAL.updatePerson(personp);
		assertTrue(PersonDAL.getPerson(personp.getPersonID()).getFirstName() == "Lee");
	}
	
	@Test
	public void deletePersontest(){
		PersonDAL.addPerson(personp);
		PersonDAL.deletePerson(personp.getPersonID());
		PersonDomainModel pdim = PersonDAL.getPerson(personp.getPersonID());
		pdim = PersonDAL.getPerson(personp.getPersonID());		
		assertEquals(null,pdim);	
	}



	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
