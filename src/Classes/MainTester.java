package Classes;

import java.util.List;

public class MainTester {

	public static void main(String[] args) {
		FileReader reader = new FileReader();
		
		List<Rule> rulesList = reader.getRulesFromFile("src/rules.cf");
		
		List<Email> hamList = reader.getEmailsFromFile("src/ham.log");
		List<Email> spamList = reader.getEmailsFromFile("src/spam.log");
		
	/*	
	  //Para testes
	   * 
	  	for(int x=0; x<rulesList.size();x++) {
			System.out.println(rulesList.get(x).getRule());
		}
	
		
		for(int x=0; x<hamList.size();x++) {
			System.out.println(hamList.get(x).getEmail());
		}
		
		for(int x=0; x<hamList.get(0).getRules().size();x++) {
			System.out.println(hamList.get(0).getRules().get(x));
		}
	*/
	}
	
	

}
