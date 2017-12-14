package jUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JTextArea;

import org.junit.Test;

import Classes.Analyzer;
import Classes.Email;
/**
 * Esta classe tem como objetivo testar em JUnit os métodos que existem
 * na classe Interface_Window
 *  
 * @author Diana Lopes nº 72898
 */
public class Interface_WindowTest {
	private List<Email> hamList = null;
	InterfaceAndMain.Interface_Window i = new InterfaceAndMain.Interface_Window();
	
	/**
	 * Teste para verificação da verificação correta de um número double
	 */
	
	@Test
	public void isDoubleValid() {
		assertTrue(i.isDouble("0.1"));
	}
	
}
