package PRAC2_ex3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Check {

	public Check() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Team barcelona = null;
		Person[] people = new Person[3];
		
		try{
			barcelona = new Team("Barça","F.C. Barcelona","./images/barcelona.jpg","Josep Lluís Nuñez Clemente","Banca Catalan",5000,1555000000,1928);
					
			people[0] = new Person("David","García Solórzano","Deivid",LocalDate.parse("12/09/1983",DateTimeFormatter.ofPattern("dd/MM/yyyy")),Country.ES,10,100,3,barcelona);			
			people[1] = new Player("Rafael","Jofresa Prats","Rafa Jofresa",LocalDate.parse("02/09/1966",DateTimeFormatter.ofPattern("dd/MM/yyyy")),
									Country.ES,60,125,1,barcelona,5,183,82,75,Position.PG);
			people[2] = new Coach("Alejandro","García Reneses","Aíto",LocalDate.parse("20/12/1946",DateTimeFormatter.ofPattern("dd/MM/yyyy")),Country.ES,20,barcelona,12);
			
			for(Person person : people)
				System.out.println(person+"\n\n");
		
		}catch(Exception re){
			re.printStackTrace();
		}		
	}
}