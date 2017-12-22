package jUnitTests;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

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
		i.evaluateAuto();
	}
	
	@Test
	public void btnAction() {
		JButton btnRules= i.getBtnRulesSetting();
		JButton btnSpam = i.getBtnSpamSetting();
		JButton btnHam = i.getBtnHamSetting();
		
		JButton btnGravarMconf = i.getBtnGravarMConf();
		JButton btnAvalMConf = i.getBtnAvaliacaoConf();
		
		JButton btnGerarAConf = i.getBtnGerarAConf();
		JButton btnAvalEvalAConf = i.getbtnAvalEvalAConf();
		JButton btnGravarAConf = i.getBtnGravarAConf();
		
		btnRules.doClick();
		btnSpam.doClick();
		btnHam.doClick();
		btnAvalMConf.doClick();
		btnGravarMconf.doClick();
		btnGerarAConf.doClick();
		btnAvalEvalAConf.doClick();
		btnGravarAConf.doClick();
	}

}
