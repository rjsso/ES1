package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Classes.Email;
import Classes.Rule;

/**
 * Esta classe tem como objetivo testar em JUnit os métodos que existem
 * nas classes Email e Rules
 *  
 * @author Diana Lopes nº 72898
 */

public class Email_and_Rules_Tests {
	/**
	 * Teste para verificação da atribuição correta de um email
	 */
	
	@Test
	public void setEmailValid() {
		Email email = new Email(null);
		email.setEmail("Example");
		assertTrue(email.getEmail().equals("Example"));
	}
	
	/**
	 * Teste para verificação da atribuição correta de uma lista de Rules no Email 
	 */
	
	@Test
	public void setRuleEmailValid() {
		Email email = new Email(null);
		List rulesList = new ArrayList<Rule>();
		Rule rule = new Rule(null,0);
		rulesList.add(rule);
		email.setRules(rulesList);
		assertNotNull(email.getRules());
	}
	
	/**
	 * Teste para verificação da atribuição correta de um nome para a Rule
	 */
	@Test
	public void setRuleValid() {
		Rule rule = new Rule(null,0);
		rule.setRule("Example");
		assertTrue(rule.getRule().equals("Example"));
	}
	/**
	 * Teste para verificação da atribuição correta de um peso para a Rule 
	 */
	@Test
	public void setWeightValid() {
		Rule rule = new Rule(null,0);
		rule.setWeight(5);
		assertTrue(rule.getWeight() == 5);
	}

}
