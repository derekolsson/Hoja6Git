import java.util.*;

public class Hoja6{
	public static void main(String arg[]){
		String choice;
		Scanner in = new Scanner(System.in);
		SetFactory setFact = new SetFactory();
		

		//Get the set to use
		System.out.println("Please choose an implementation.\n1. HashSet \n2. TreeSet \n3. LinkedHashSet.");
		System.out.println("\nPlease choose an option: 1, 2, or 3\n");
		
		//loop while input is valid
		boolean loop = true;
		choice = "";
		while (loop){
			
			choice = in.nextLine();
			
			if (choice.equals("1") || choice.equals("2") || choice.equals("3")){
				loop = false;
			}
			
			else{
				System.out.println("\nPlease enter only 1, 2 or 3!\n");
			}
		}
		
		Set javaSet = setFact.getSet(choice);
		Set webSet = setFact.getSet(choice);
		Set cellSet =  setFact.getSet(choice);
		
		choice = "";
		while (!choice.equalsIgnoreCase("q")){
			String name = "";
			System.out.println("Please enter new user name: ");
			name = in.nextLine();
			
			String answer = "";
			System.out.println("Are the a java developer? y/n : ");
		}
	}
}	
	
		
		
		
		
		