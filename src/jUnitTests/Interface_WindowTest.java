package jUnitTests;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.Test;

import Classes.Analyzer;
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
	 * Teste para verifica��o a correta de um n�mero double
	 */
	
	@Test
	public void isDoubleValid() {
		assertTrue(i.isDouble("0.1"));
	}
	
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
