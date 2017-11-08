package Classes;

import java.util.ArrayList;
import java.util.List;

public class Email {

	private String email ;
	private List<String> rules = new ArrayList<String>();
	
	public Email(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getRules() {
		return rules;
	}
	public void setRules(List<String> rules) {
		this.rules = rules;
	}
	public void addRule(String rule) {
		rules.add(rule);
	}

	
}
