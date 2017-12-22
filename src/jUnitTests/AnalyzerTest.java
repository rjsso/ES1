package jUnitTests;

import java.util.List;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Classes.Analyzer;
import Classes.Email;
import Classes.FileReader;
import Classes.Rule;

/**
 * Esta classe tem como objetivo testar em JUnit os m�todos que existem na classe Analyzer
 *  
 * @author Diana Lopes n� 72898
 */
public class AnalyzerTest {
	private Analyzer anal = new Analyzer();
	
	/**
	 * Teste para verifica��o de execu��o correta do m�todo de contagem do FP
	 */
	@Test
	public void getFPcountExist() {
		
		List spamList = new ArrayList<Email>();
		List rulesList = new ArrayList<Rule>();
		
		Rule rule = new Rule("SpamExample",4.0);
		rulesList.add(rule);
		
		Email ham = new Email("EmailExample");
		ham.addRule("SpamExample");
		spamList.add(ham);
		
		int total = anal.getFPcount(spamList, rulesList);
		assertTrue(total >= 0);
	}
	/**
	 * Teste para verifica��o de execu��o incorreta do m�todo de contagem do FP
	 */
	@Test
	public void getFPcountFail() {
		
		List spamList = new ArrayList<Email>();
		List rulesList = new ArrayList<Rule>();
		
		Rule rule = new Rule("SpamExample",6.0);
		rulesList.add(rule);
		
		Email ham = new Email("EmailExample");
		ham.addRule("SpamExample");
		spamList.add(ham);
		
		int total = anal.getFPcount(spamList, rulesList);
		assertFalse(total > 0);
	}
	
	/**
	 * Teste para verifica��o de execu��o correta do m�todo de contagem do FN
	 */
	@Test
	public void getFNcountExist() {
		
		List hamList = new ArrayList<Email>();
		List rulesList = new ArrayList<Rule>();
		
		Rule rule = new Rule("SpamExample",6.0);
		rulesList.add(rule);
		
		Email spam = new Email("EmailExample");
		spam.addRule("SpamExample");
		hamList.add(spam);
		
		int total = anal.getFNcount(hamList, rulesList);
		assertTrue(total > 0);
	}
	
	/**
	 * Teste para verifica��o de execu��o incorreta do m�todo de contagem do FN
	 */
	@Test
	public void getFNcountFail() {
		
		List hamList = new ArrayList<Email>();
		List rulesList = new ArrayList<Rule>();
		
		Rule rule = new Rule("SpamExample",4.0);
		rulesList.add(rule);
		
		Email spam = new Email("EmailExample");
		spam.addRule("SpamExample");
		hamList.add(spam);
		
		int total = anal.getFNcount(hamList, rulesList);
		assertFalse(total > 0);
	}
	//falta invalid FP
	
	/**
	 * Teste para verifica��o de execu��o correta do m�todo de percentagem do FP
	 */
	@Test 
	public void getPercentageFPValid(){
		List spamList ;
		List rulesList ;
		FileReader reader = new FileReader();
		
		spamList = reader.getEmailsFromFile("src/jUnitTests/spam.log");
		rulesList = reader.getRulesFromFile("src/jUnitTests/rules.cf");
				
		double percentage = anal.getFPpercentage(spamList, rulesList);
		
		
		assertTrue(percentage<=100 && percentage>=0);
		
	}
	/**
	 * Teste para verifica��o de execu��o correta do m�todo de percentagem do FN
	 */
	@Test 
	public void getPercentageFNValid(){
		List hamList ;
		List rulesList ;
		FileReader reader = new FileReader();
		
		hamList = reader.getEmailsFromFile("src/jUnitTests/ham.log");
		rulesList = reader.getRulesFromFile("src/jUnitTests/rules.cf");
				
		double percentage = anal.getFNpercentage(hamList, rulesList);
		
		
		assertTrue(percentage<=100 && percentage>=0);
		
	}
	

}
