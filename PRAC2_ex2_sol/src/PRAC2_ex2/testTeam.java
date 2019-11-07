package PRAC2_ex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PRAC2_ex2.Team;
import PRAC2_ex2.TeamException;

class testTeam {
	private Team team;
	String teamName = "El Madrí";
	String longName = "Real Madrid F.C";
	String imageSrc = "/img/default.jpg";
	String president = "Javier";
	String sponsor = "Nike";
	int members = 23;
	int budget=23000000;
	int founded = 2003;
	
	private Player player;
	private Player player2;
	private Player player3;
	private Player player4;
	String name = "Sergio";
	String surname = "Tribaldos Garcia";
	int number=23;
	int height=156;
	double weight=120;
	int numInternational=22;
	Position position= Position.PG;
	int injuredWeeks=0;
	
	// Antes de cada test, instanciamos una clase team con los valores asignados
	@BeforeEach
	void beforeEach() throws Exception {
		team=new Team(teamName,longName,imageSrc,president,sponsor,members,budget,founded);
		player=new Player(name,surname,number,height,weight,numInternational,position,team);
		player2=new Player("Javi",surname,12,height,weight,numInternational,position,team);
		player3=new Player("Manolo",surname,23,height,weight,numInternational,position,team);
		player4=new Player("Emilio",surname,44,height,weight,numInternational,position,team);
	}
	
	

	
	@Test
	final void testWhenSetLessThan8SquadSizeShouldThrowAnException() throws Exception {

		Player[] squad= {player};
		
		Exception exception=assertThrows(TeamException.class,()->{
			team.setSquad(squad);
		});
		
		assertEquals(exception.getMessage(),"[ERROR] Your team cannot have less than 8 players!!");
	}
	@Test
	final void testWhenSetMoreThan12SquadSizeShouldThrowAnException() throws Exception {

		Player[] squad= {player,player,player,player,player,player,player,player,player,player,player,player,player};
		
		Exception exception=assertThrows(TeamException.class,()->{
			team.setSquad(squad);
		});
		
		assertEquals(exception.getMessage(),"[ERROR] Your team cannot have more than 12 players!!");
	}

	@Test
	final void testGetLineup() throws TeamException {
		Player[] squad= {player,player,player,player,player,player,player,player,player};
		team.setSquad(squad);
		assertEquals(5,team.getLineup().length);
	}

	@Test
	final void testGetPlayerByNumberSucceed() throws TeamException {
		Player[] squad= {player,player2,player3,player4,player,player,player,player};
		Player play[]=team.getSquad();
		team.setSquad(squad);
		Player selectedPlayer=team.getPlayerByNumber(23);
		assertEquals(selectedPlayer.getNumber(),23);	
		
	}
	@Test
	final void testWhenATeamNumberMemberDoesntExistShouldThowAnException() throws TeamException {
		Player[] squad= {player,player2,player3,player4,player,player,player,player};
		Player play[]=team.getSquad();
		team.setSquad(squad);
		Exception exception=assertThrows(TeamException.class,()->{
			team.getPlayerByNumber(22);
		});
		assertEquals(exception.getMessage(),"[ERROR] The player you want to retrieve does not exist in your team!!");	
		
	}
	
	@Test
	final void testWhenATeamNumberIsLessThan0ShouldThowAnException() throws TeamException {
		Player[] squad= {player,player2,player3,player4,player,player,player,player};
		team.setSquad(squad);
		Exception exception=assertThrows(TeamException.class,()->{
			team.getPlayerByNumber(-1);
		});
		assertEquals(exception.getMessage(),"[ERROR] The number is incorrect. The number must be 0 or positive!!");	
		
	}

	@Test
	final void testAddPlayerSucceed() throws Exception {
		// Deberia añadir el jugador al squad sin que tenga que haber un hueco null
		Player[] squad= {player,player2,player3,player4,player,player,player,player,null};
		Player player5=new Player("Emilio",surname,44,height,weight,numInternational,position,team);
		team.setSquad(squad);
		team.addPlayer(player5);
		
	}

	@Test
	final void testIfAPlayerExistsShouldThrowAnException() throws Exception {
		Player[] squad= {player,player2,player3,player4,player,player,player,player,null};
		team.setSquad(squad);
		Exception exception=assertThrows(TeamException.class,()->{
			team.addPlayer(player);
		});
		assertEquals(exception.getMessage(),"[ERROR] The player who you want to add is already in the team!!");
		
	}
	
	@Test
	final void testRemovePlayerSucceed() throws Exception {
		Player[] squad= {player,player2,player3,player4,player,player,player,player,null};
		team.setSquad(squad);
		team.removePlayer(player2);
		boolean playerNotRemoved=false;
		
		for (Player actualPlayer : team.getSquad()) {
			if(player2==actualPlayer) {
				playerNotRemoved=true;
			}
		}
		assertEquals(playerNotRemoved,false);
		
	}
	@Test
	final void testWhenAPlayerIsNotInTheSquadRemovingFails() throws Exception {
		Player[] squad= {player,player3,player4,player,player,player,player,null};
		team.setSquad(squad);
		
		Exception exception=assertThrows(TeamException.class,()->{
			team.removePlayer(player2);
		});
		assertEquals(exception.getMessage(),"[ERROR] The player you want to remove does not exist in your team!!");
		
	}

}
