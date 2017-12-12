package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Classes.FileReader;
import Classes.Rule;
import antiSpamFilter.AntiSpamFilterProblem;
/**
 * Esta classe tem como objetivo testar em JUnit os m�todos que existem na classe FileReader
 *  
 * @author Diana Lopes n� 72898
 */
public class FileReaderTest {

	private FileReader reader = new FileReader();
	/**
	 * Teste para verifica��o da cria��o correta de uma lista de Rules 
	 */
	@Test
	public void createRulesList() {
		List rulesList = reader.getRulesFromFile("src/jUnitTests/rules.cf");
		assertTrue(rulesList!=null);
	}
	/**
	 * Teste para verifica��o da cria��o correta de uma lista de Emails 
	 */	
	@Test
	public void createMailList(){
		List mailList = reader.getEmailsFromFile("src/jUnitTests/ham.log");
		assertTrue(mailList!=null);
	}
	
	// FileReader ver exception
	

}
