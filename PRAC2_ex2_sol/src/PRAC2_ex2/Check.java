package PRAC2_ex2;

/**
 * This class is used to test the Exercise 2 of the PRAC 2.
 * 
 * @author David García Solórzano
 * @version 1.0
 * 
 */

public class Check {

	public Check() {
		
	}

	public static void main(String[] args) {		
		Team team1 = null, team2 = null;
		Player rafaJofresa = null;
		
		try{
			team1 = new Team("Barça","F.C. Barcelona","./images/barcelona.jpg","Josep Lluís Nuñez Clemente","Banca Catalan",5000,1555000000,1928);
			team2 = new Team("Madrid","Real Madrid","./images/madrid.jpg","Lorenzo Sanz Mancebo","Teka",6000,1100000000,1932);		
		}catch(TeamException te){
			te.printStackTrace();
		}
		
		//Equipo sin jugadores
		System.out.println(team1);
		
		try {
			rafaJofresa = new Player("Rafael","Jofresa Prats",5,183,82,75,Position.PG,team1);
			team1.addPlayer(rafaJofresa);			
			team1.addPlayer(new Player("Roberto","Dueñas Hernández",12,219,127,84,Position.C,team1));
			
			System.out.println(System.lineSeparator());
			System.out.println(team1);
			System.out.println(System.lineSeparator());  //Hasta aqui es el ejemplo del enunciado
			
			
			//team1.removePlayer(new Player("Rafael","Jofresa Prats",5,183,82,75,Position.PG,team1)); //Si descomentas esta linea deberia saltarte una Excepcion
			//team1.removePlayer(rafaJofresa); //Elimina al jugador "Rafael Jofresa Prats"
			//System.out.println(team1); //Descomenta si descomentas la linea 42, ya no esta "Rafael Jofresa Prats"			
			//System.out.println(team1.getPlayerByNumber(12)); //Debe devolverte "Roberto Dueñas Hernandez"
			//System.out.println(team1.getPlayerByNumber(5)); //Debe saltar excepcion de que no existe el jugador si has descomentado la linea 42, en caso contrario, "Rafael Jofresa Prats"
			//System.out.println(team1.getPlayerByNumber(-5)); //Debe devolverte error de "number format".
			System.out.println(System.lineSeparator());
			System.out.println(team2); //Real Madrid sin jugadores
			System.out.println(System.lineSeparator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}