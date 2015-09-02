import java.util.*;

public class SetFactory{

	public SetFactory(){
		//
	}
	public Set getSet(String s){
		
		switch(s){
		
			case "1":	return new HashSet();
			case "2":	return new TreeSet();
			case "3":	return new LinkedHashSet();
			
		}
	return null;
	}
}