package jUnitTests;


import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import Classes.Email;
import Classes.Rule;
import InterfaceAndMain.Main;
/**
 * Esta classe tem como objetivo testar em JUnit os m�todos que existem
 * na classe Interface_Window
 *  
 * @author Diana Lopes n� 72898
 */
public class Interface_WindowTest {
	
	InterfaceAndMain.Interface_Window i = new InterfaceAndMain.Interface_Window();
	
	
	/**
	 * Teste para verifica��o da avalia��o autom�tica correta
	 */
	
	@Test
	public void evaluateAutoValid(){
		i.evaluateAuto();
	}
	
	/**
	 * Teste para verifica��o da avalia��o manual correta
	 */
	
	@Test
	public void evaluateManualValid(){
		i.evaluateManual();
	}
	
	/**
	 * Teste para correr o main 
	 */
	
	@Test
	public void mainTest(){
		Main m = new Main();
		m.main(null);
	}
	
	/**
	 * Teste para verifica��o da avalia��o autom�tica incorreta
	 */
	
	@Test
	public void evaluateAutoFail(){
		List<Email> spamList = new ArrayList<Email>();
		List<Email> hamList = new ArrayList<Email>();
		List<Rule> rulesList = new ArrayList<Rule>();
		i.evaluateAuto();
	}
}
