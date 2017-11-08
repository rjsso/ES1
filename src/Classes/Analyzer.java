package Classes;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
	
	public int getFPcount(List<Email> spamList, List<Rule> rulesList ) {
		int fp_counter = 0;
		
		for(int x=0; x<spamList.size(); x++) {
			for(int y=0; y<spamList.get(x).getRules().size();y++) {
				String spamRule = spamList.get(x).getRules().get(y);
					
					for(int k=0; k<rulesList.size();k++) {
						Rule ruleItem = rulesList.get(k);
						if(ruleItem.getWeight()<5 && spamRule.equals(ruleItem.getRule())) {
							fp_counter++;
						}
							
					}
			}
		}
		return fp_counter;
	}
	
	public int getFNcount(List<Email> emailList, List<Rule> rulesList) {
		int fn_counter = 0;
		
		for(int x=0; x<emailList.size(); x++) {
			for(int y=0; y<emailList.get(x).getRules().size();y++) {
				String spamRule = emailList.get(x).getRules().get(y);
					
					for(int k=0; k<rulesList.size();k++) {
						Rule ruleItem = rulesList.get(k);
						if(ruleItem.getWeight()>=5 && spamRule.equals(ruleItem.getRule())) {
							fn_counter++;
						}
							
					}
			}
		}
		return fn_counter;
	}
	
	public double getFPpercentage(List<Email> spamList, List<Rule> rulesList) {
		return (getFPcount(spamList,rulesList)*100)/spamList.size();
	}
	
	public double getFNpercentage(List<Email> emailList, List<Rule> rulesList) {
		return (getFPcount(emailList,rulesList)*100)/emailList.size();
	}
	
}
