package PRAC2_ex1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import PRAC2_ex1.Team;

class test {
	private Team team;
	
	String name = "El Madrí";
	String longName = "Real Madrid F.C";
	String imageSrc = "/img/default.jpg";
	String president = "Javier";
	String sponsor = "Nike";
	int members = 23;
	int budget=23000000;
	int founded = 2003;
	
	// Antes de cada test, instanciamos una clase team con los valores asignados
	@BeforeEach
	void beforeEach() throws TeamException {
		team=new Team(name,longName,imageSrc,president,sponsor,members,budget,founded);
	}
	
	// Combrobamos que al instanciar una clase Team sin valores, los asigna por defecto
	@Test
	final void testEmptyConstructor() throws TeamException {
		Team team1 =new Team();
		
		assertEquals("Default", team1.getShortName());
		assertEquals("Team Default", team1.getLongName());
		assertEquals("./", team1.getImageSrc());
		assertEquals("Dummy", team1.getPresident());
		assertEquals("UOC", team1.getSponsor());
	}

	
	// Cada linea del archivo constructorParams.csv es una iteracion cuyos parametros se pasan a 
	// testConstructorWithValues() por orden
	@ParameterizedTest
	@CsvFileSource(resources = "/constructorParams.csv")
	final void testConstructorWithValues(String shortName, String longName, String imgSrc,
			 String president, String sponsor, int members,
			 int budget, int founded) throws TeamException {
		
		Team team = new Team(shortName, longName, imgSrc, president, sponsor, members, budget, founded);
		System.out.println(founded);
		assertEquals(shortName, team.getShortName());
		assertEquals(longName, team.getLongName());
		assertEquals(imgSrc, team.getImageSrc());
		assertEquals(sponsor, team.getSponsor());
		assertEquals(president, team.getPresident());
		assertEquals(members, team.getMembers());
		assertEquals(budget, team.getBudget());
		assertEquals(founded, team.getFounded());
		
	}


	 @Test
	final void testSetShortNameFails() throws TeamException {
		 Exception exception = assertThrows(TeamException.class, () -> {
				team.setShortName("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
			});
			assertEquals("[ERROR] Short name cannot be longer than 40 characters!!",
					exception.getMessage());
	}
	 
	 @Test
	 final void testSetShortNameSucced() throws TeamException {
		 String shortName="Bârça";
		 team.setShortName(shortName);
		 assertEquals(shortName,team.getShortName());
		 
	 }
	 
	 @ParameterizedTest
	 @ValueSource(ints= {-1,-111,-123123120})
	 final void testSetMembersFail(int members) {
		 Exception exception=assertThrows(TeamException.class, ()->{
			 team.setMembers(members);
		 });
		 
		 assertEquals("[ERROR] Members must be equal or greater than 0!!",exception.getMessage());
	 }
	 

}
