package PRAC2_ex3;

import java.time.LocalDate;

public class Coach extends Person{
	
	private int maxNumPlayers2Train;
	
	public Coach(String name, String surname, String nick, LocalDate birthdate, 
			  Country country, int salary, Team team, int maxNumPlayers2Train) throws Exception{
		
		super(name,surname,nick,birthdate,country,salary,0,0,team);
		setMaxNumPlayers2Train(maxNumPlayers2Train);
	}
	
	public int getMaxNumPlayers2Train() {
		return maxNumPlayers2Train;
	}

	private void setMaxNumPlayers2Train(int maxNumPlayers2Train) throws Exception{
		if(maxNumPlayers2Train<=0) {
			throw new Exception("[ERROR] Number of players that a coach can train cannot be 0 or negative!!");
		}else {
			this.maxNumPlayers2Train = maxNumPlayers2Train;
		}
	}
	
	@Override
	public String toString() {
		return getSurname()+", "+getName()+" ("+getMaxNumPlayers2Train()+") | "+getContract().getSalary()+" mill.";
	}
}
