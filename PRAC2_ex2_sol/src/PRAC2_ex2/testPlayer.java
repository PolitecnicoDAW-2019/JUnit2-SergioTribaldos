package PRAC2_ex2;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import PRAC2_ex2.Team;
import PRAC2_ex2.TeamException;

class testPlayer {
	private Player player;
	
	String name = "Sergio";
	String surname = "Tribaldos Garcia";
	int number=23;
	int height=156;
	double weight=120;
	int numInternational=22;
	Position position= Position.PG;
	int injuredWeeks=0;
	Team team;
	
	
	@BeforeEach
	void beforeEach() throws Exception {
		team=new Team();
		
		player=new Player(name,surname,number,height,weight,numInternational,position,team);
	}
	
	@Test
	final void testPlayerConstructor() {
		assertEquals(name,player.getName());
		assertEquals(surname,player.getSurname());
		assertEquals(number,player.getNumber());
		assertEquals(height,player.getHeight());
		assertEquals(weight,player.getWeight(),1e-15);
		assertEquals(numInternational,player.getNumInternational());
		assertEquals(position,player.getPosition());
		assertEquals(injuredWeeks,player.getInjuredWeeks());
		assertEquals(team,player.getTeam());

	}
	@Test
	final void testSetHeight() {
		Exception exception=assertThrows(Exception.class,()->{
			player.setHeight(99);
		});
		
		assertEquals(exception.getMessage(),"[ERROR] Height must be equal or greater than 100 cm!!");
	}
	
	@Test
	final void testSetWeight() {
		Exception exception=assertThrows(Exception.class,()->{
			player.setWeight(29);
		});
		
		assertEquals(exception.getMessage(),"[ERROR] Weight must be equal or greater than 30 kg!!");
	}
	
	@Test
	final void testSetNumInternational() {
		Exception exception=assertThrows(Exception.class,()->{
			player.setNumInternational(-1);
		});
		assertEquals(exception.getMessage(),"[ERROR] Num. international must be equal or greater than 0!!");
	}
	

	
}
