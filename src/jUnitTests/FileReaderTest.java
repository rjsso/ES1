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
	private int line = 0;
	
	/**
	 * Teste para verifica��o da cria��o correta de uma lista de Rules 
	 */
	@Test
	public void createRulesList() {
		List rulesList = reader.getRulesFromFile("src/jUnitTests/rules.cf");
		assertNotNull(rulesList);
	}
	
	/**
	 * Teste para verifica��o da cria��o correta de uma lista de Rules 
	 */
	@Test
	public void createRulesList2Param() {
		double vp[] = new double[335];
		List rulesList = reader.getRulesFromFile("src/jUnitTests/rules.cf",vp);
		assertNotNull(rulesList);
	}
	
	/**
	 * Teste para verifica��o da cria��o correta de uma lista de Emails 
	 */	
	@Test
	public void createMailList(){
		List mailList = reader.getEmailsFromFile("src/jUnitTests/ham.log");
		assertNotNull(mailList);
	}
	
	/**
	 * Teste para verificar qual das linhas representa uma maior aproxima��o a um email profissional
	 */
	
	@Test
	public void getLineTest() {
		line = reader.getLine("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");
		assertTrue(line!=0);
	}
	/**
	 * Teste para verifica��o da convers�o correta de um ficheiro dado uma localiza��o num vetor de doubles
	 */
	
	@Test
	public void getDoubleVectorTest() {
		double[] a  = reader.getDoubleVector("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf",line);
		assertNotNull(a);
	}


}
