package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe tem como objetivo de representar um e-mail.
 * Um e-mail também pode ser considerado spam.
 *  
 * @author Kevin Corrales nº 73529
 */
public class Email {
	
	/**
	 * Atributos:
	 * 		email -> identifica o e-mail
	 * 		rules -> lista de regras atribuidas ao e-mail
	 */
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
	
	/**
	 * Adiciona uma regra à lista
	 * @param rule
	 */
	public void addRule(String rule) {
		rules.add(rule);
	}

	
}
