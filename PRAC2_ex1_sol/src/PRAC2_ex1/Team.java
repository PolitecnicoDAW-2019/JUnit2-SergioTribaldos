package PRAC2_ex1;

/**
 * This class represents a Team of BalUOCesto game.
 * @author David García Solórzano
 * @version 1.0
 */
public class Team{
	/**
	 * Team's short name, e.g. Barça.	
	 */
	private String shortName;
	/**
	 * Team's long name, e.g. F.C. Barcelona.
	 */	
	private String longName;
	/**
	 * Image source.
	 */	
	private String imageSrc;
	/**
	 *  President's name.
	 */
	private String president;
	/**
	 *  Sponsor's name.
	 */
	private String sponsor;
	/**
	 * Team's members.
	 */	 
	private int members;
	/**
	 * Team's budget. It is "int" because data are from 1996, when Pesetas was the official coin in Spain.
	*/
	private int budget;
	/**
	 * Team's foundation year.
	*/
	private int founded;
		
	/**
	 * Default constructor. It assigns the default value to all the instance's fields/attributes.
	 * @throws TeamException When shortName is longer than 40 characters, members less than 0, budget less than 0 or founded less than 1900.
	 */
	public Team() throws TeamException{
		this("Default", "Team Default", "./", "Dummy", "UOC",1000,1000000,2019);
	}	
	/**
	 * Constructor with arguments.
	 * @param shortName Team's short name.
	 * @param longName Team's long name.
	 * @param imageSrc Source where the team's image is.
	 * @param president President's name.
	 * @param sponsor Sponsor's name.
	 * @param members Number of members.
	 * @param budget Team's budget.
	 * @param founded Foundation year.
	 * @throws TeamException When shortName is longer than 40 characters, members less than 0, budget less than 0 or founded less than 1900.
	 */
	public Team(String shortName, String longName, String imageSrc, String president, String sponsor, int members, int budget, int founded) throws TeamException{
		setShortName(shortName);
		setLongName(longName);
		setImageSrc(imageSrc);
		setPresident(president);
		setSponsor(sponsor);
		setMembers(members);
		setBudget(budget);
		setFounded(founded);
	}	
	/**
	 * It is shortname's getter.
	 * @return Team's short name.
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * It is shortname's setter.
	 * @param shortName Team's short name.
	 * @throws TeamException When param "shortName" is longer than 40 characters.
	 */
	public void setShortName(String shortName) throws TeamException{
		if(shortName.length()>40) {
			throw new TeamException("[ERROR] Short name cannot be longer than 40 characters!!");
		}
		
		this.shortName = shortName;
	}
	/**
	 * It is longname's getter.
	 * @return Team's long name.
	 */
	public String getLongName() {
		return longName;
	}
	/**
	 * It is shortname's setter.
	 * @param longName Team's long name.
	 */
	public void setLongName(String longName) {		
		this.longName = longName;
	}
	/**
	 * It is imageSrc's getter. 
	 * @return Source where the team's image is.
	 */
	public String getImageSrc() {
		return imageSrc;
	}
	/**
	 * It is imageSrc's setter.  
	 * @param imageSrc Source where the team's image is.
	 */
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	/**
	 * It is president's getter. 
	 * @return President's name.
	 */
	public String getPresident() {
		return president;
	}
	/**
	 * It is president's setter. 
	 * @param president President's name.
	 */
	public void setPresident(String president) {
		this.president = president;
	}
	/**
	 * It is sponsor's getter. 
	 * @return Sponsor's name.
	 */
	public String getSponsor() {
		return sponsor;
	}
	/**
	 * It is sponsor's setter. 
	 * @param sponsor Sponsor's name.
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	/**
	 * It is member's getter. 
	 * @return Number of members in the team.
	 */
	public int getMembers() {
		return members;
	}
	/**
	 * It is member's setter.
	 * @param members Number of members in the team.
	 * @throws TeamException When param "members" is less than 0.
	 */
	public void setMembers(int members) throws TeamException{
		if(members<0) {
			throw new TeamException("[ERROR] Members must be equal or greater than 0!!");
		}
		this.members = members;		
	}
	/**
	 * It is budget's getter. 
	 * @return Team's budget.
	 */
	public int getBudget() {
		return budget;
	}
	/**
	 * It is budget's setter. 
	 * @param budget Team's budget.
	 * @throws TeamException When param "budget" is less than 0.
	 */
	public void setBudget(int budget) throws TeamException{
		if(budget<0) {
			throw new TeamException("[ERROR] Budget must be equal or greater than 0!!");
		}
		this.budget = budget;		
	}
	/**
	 * It is foundation year (founded)'s getter.
	 * @return Team's foundation year.
	 */
	public int getFounded() {
		return founded;
	}
	/**
	 * It is foundation year (founded)'s setter.
	 * @param founded Team's foundation year.
	 * @throws TeamException When para "founded" is less than 0.
	 */
	public void setFounded(int founded) throws TeamException{
		if(founded<1900) {
			throw new TeamException("[ERROR] Year foundation must be equal or greater than 1900!!");
		}
		this.founded = founded;		
	}
	
	public static void main(String[] args){
		try{
			Team team1 = new Team();
			System.out.println("\n"+team1); //Aqui te saldra el nombre de la clase del objeto y la posicion de memoria que ocupa
			team1.setImageSrc("./baskonia.jpg");
			System.out.println("\nWe change the team's image source: "+team1.getImageSrc());
			team1.setLongName("Baskonia");
			System.out.println("We change the team's long name: "+team1.getLongName());
			team1.setBudget(1000);
			System.out.println("We change the team's budget: "+team1.getBudget());
			team1.setFounded(2016);
			System.out.println("We change the team's foundation year: "+team1.getFounded());
			
			/*
			* A partir de aqui genera diferentes excepciones para ver que el control de los casos anomalos funciona correctamente.
			* Genera solo una excepcion, puesto que el catch siempre te cogera la primera que se genere. Puedes hacer la prueba si tienes curiosidad.
			* A continuacion te damos varios casos en los que te deberia saltar la excepcion. Descomenta una línea y comenta el resto.
			*/
			//team1.setShortName("Baskonia Joventut F.C. Barcelona Real Madrid Estudiantes Xacobeo Ourense Unicaja Malaga Pamesa Valencia TDK Manresa Valvi Girona");
			team1.setBudget(-10);			
			//team1.setFounded(1899);			
			Team team2 = new Team("Pamesas", "Pamesa Valencia", "./pamesa.jpg", "Yo Mismo", "Pamesa", 20000, 50, 1800); //falla el ultimo valor founded=1800.
		}catch(Exception e){ //Cambia Exception por ResourceException, veras que el comportamiento es identico, 
			//pero con Exception coge cualquier tipo de Excepcion y con ResourceException se es especifico.
			/*
			* El metodo printStrackTrace:
			* 
			* 1) Dice el tipo de excepcion (i.e. la clase de Excepcion), 
			* 2) Imprime el mensaje (i.e. hace e.getMessage()) y ademas
			* 3) Proporciona donde se ha generado la excepcion dando la cadena de llamadas.
			*
			*/
			e.printStackTrace();
		}
	}
}
