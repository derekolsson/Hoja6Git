import java.util.*;

public class Hoja6{
	public static void main(String arg[]){
		String choice;
		Scanner in = new Scanner(System.in);
		SetFactory setFact = new SetFactory();
		

		//Get the set to use
		System.out.println("Please choose an implementation.\n1. HashSet \n2. TreeSet \n3. LinkedHashSet.");
		System.out.println("\nPlease choose an option: 1, 2, or 3\n");
		
		//loop while input is invalid
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
		
		//create the three sets using the choice made
		Set javaSet = setFact.getSet(choice);
		Set webSet = setFact.getSet(choice);
		Set cellSet =  setFact.getSet(choice);
		
		//choice cleared and ready for new use
		choice = "";
		
		//variables for "answer" and "name"
		//name:		name of new user
		//answer:	yes or no to developer types
		String answer;
		String name;
		
		//loop until final choice is "q"
		while (!choice.equalsIgnoreCase("q")){
			//get name....clear it just to avoid issues
			name = "";
			System.out.println("Please enter new user name: ");
			name = in.nextLine();
			
			//get what they develop in
			//only take y or n for answer
			//clear answer each time just to avoid problems
			
			//java
			answer = "";	
			while (!answer.equalsIgnoreCase("y")&&!answer.equalsIgnoreCase("n")){
				System.out.println("Are they a java developer?\nPlease enter either y or n : ");
				answer = in.nextLine();
			}
			if (answer.equalsIgnoreCase("y")){
				javaSet.add(name);
			}
			
			//web
			answer = "";
			while (!answer.equalsIgnoreCase("y")&&!answer.equalsIgnoreCase("n")){
				System.out.println("Are they a web developer?\nPlease enter either y or n : ");
				answer = in.nextLine();
			}
			if (answer.equalsIgnoreCase("y")){
				webSet.add(name);
			}
			
			//cellular
			answer = "";
			while (!answer.equalsIgnoreCase("y")&&!answer.equalsIgnoreCase("n")){
				System.out.println("Are they a cellular developer?\nPlease enter either y or n : ");
				answer = in.nextLine();
			}
			if (answer.equalsIgnoreCase("y")){
				cellSet.add(name);
			}
			
			//anything to continue
			//q or Q to quit
			System.out.println("\nHit enter to continue.\nTo quit, enter q");
			choice = in.nextLine();
		}
		
		//Print out all those desired results
		//Gonna need iterators
		Iterator javaIt = javaSet.iterator();
		Iterator webIt = webSet.iterator();
		Iterator cellIt = cellSet.iterator();
		
		//1. Union de los tres
		// iterate javaSet, then look for contains() in the other sets
		System.out.println("\nUsers with experience in Java, Web and Cell: ");
		while (javaIt.hasNext()){
			Object a = javaIt.next();
			if (webSet.contains(a) && cellSet.contains(a)){
				System.out.println(a);
			}
		}
		
		//2. Java, but not web
		// iterate java, !webSet.contains()
		System.out.println("\nUsers with experience in Java, but not Web: ");
		while (javaIt.hasNext()){
			Object a = javaIt.next();
			if (!webSet.contains(a)){
				System.out.println(a);
			}
		}
		
		//3. Web and cell, but not Java
		// iterate web, cellSet.contains&&!javaSet.contains() 
		
		System.out.println("\nUsers with experience in Web and Cell, but not Java: ");
		while (webIt.hasNext()){
			Object a = webIt.next();
			if (cellSet.contains(a) && !javaSet.contains(a)){
				System.out.println(a);
			}
		}
		
		//4. Web OR cell, but not Java
		// iterate web, !javaSet.contains() 
		// iterate cell, !javaSet &&!webSet     avoids repetition
		
		System.out.println("\nUsers with experience in Web OR Cell, but not Java: ");
		
		while (webIt.hasNext()){
			Object a = webIt.next();
			if (!javaSet.contains(a)){
				System.out.println(a);
			}
		}
		while (cellIt.hasNext()){
			Object a = cellIt.next();
			if (!webSet.contains(a) && !javaSet.contains(a)){
				System.out.println(a);
			}
		}
		
		
		//5.Java is a subset of web?
		//iterate Java, if something is not in Web, flag false
		
		boolean subset = true;
		while (javaIt.hasNext()){
			Object a = javaIt.next();
			if (!webSet.contains(a)){
				subset=false;
			}
		}
		if (subset){
			System.out.println("\n The Java developers ARE a subset of the Web developers");
		}
		else {
			System.out.println("\n The Java developers ARE NOT a subset of the Web developers");
		}

		//6. Biggest set with the people involved
		// compare sizes
		
		Set biggest;
		String big;
		//compare web vs java
		//save name and set
		if (webSet.size() > javaSet.size()){
			biggest=webSet;
			big = " Web.";
		}		
		else{
			biggest = javaSet;
			big = " Java.";
		}
		//compare biggest to cells
		//overwrite if cell is bigger
		if (biggest.size() < cellSet.size()){
			biggest = cellSet;
			big = " Cellulars.";
		}
		System.out.println("The biggest set of developers is"+big);
		System.out.println("The developers involved are: \n");
		System.out.println(biggest);
		
		//7. In order
		// Save as tree (ordered by default), then print
		
		TreeSet sorted = new TreeSet(biggest);
		System.out.println("\nIn order, the developers are : ");
		System.out.println(sorted);
	}
}	
	
		
		
		
		
		