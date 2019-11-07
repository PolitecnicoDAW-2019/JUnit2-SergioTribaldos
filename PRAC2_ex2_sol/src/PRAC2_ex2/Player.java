package PRAC2_ex2;

public class Player {

	private String name, surname;
	private int number, height, numInternational, injuredWeeks;
	private double weight;	
	private Position position;
	private Team team;
	
	
	public Player(String name, String surname, int number, int height, double weight, int numInternational, Position position, Team team) throws Exception{
		setName(name);
		setSurname(surname);
		setNumber(number);
		setHeight(height);
		setWeight(weight);	
		setNumInternational(numInternational);
		setPosition(position);
		setInjuriedWeeks(0);
		setTeam(team);
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
		
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) throws Exception{
		if(height<100) throw new Exception("[ERROR] Height must be equal or greater than 100 cm!!");
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) throws Exception{
		if(weight<30) throw new Exception("[ERROR] Weight must be equal or greater than 30 kg!!");
		this.weight = weight;
	}	
		
	public int getNumInternational() {		
		return numInternational;
	}
	
	public void setNumInternational(int numInternational) throws Exception{
		if(numInternational<0) throw new Exception("[ERROR] Num. international must be equal or greater than 0!!");
		this.numInternational = numInternational;
	}
		
	public int getInjuredWeeks() {
		return injuredWeeks;
	}
	
	public void setInjuriedWeeks(int injuredWeeks) throws Exception{
		if(injuredWeeks<0) throw new Exception("[ERROR] Weeks that a player is injured must be equal or greater than 0!!");
		this.injuredWeeks = injuredWeeks;
	}
	
	public boolean isInjured() {
		return (getInjuredWeeks()>0);
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(getNumber()+". "+getName()+" "+getSurname()+" | "+getTeam().getShortName()+" | ");
				
		str.append((getHeight()/(double)100)+" m. | "+getWeight()+" kg. | "+getNumInternational()+" | ");
		
		str.append(getPosition()+" | "+getInjuredWeeks());		
				
		return str.toString();
	}
}
