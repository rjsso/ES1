package InterfaceAndMain;

import javax.swing.*;
import Classes.Analyzer;
import Classes.Email;
import Classes.FileReader;
import Classes.Rule;
import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

/**
 * Esta classe tem como objetivo de apresentar um interface simples e limpo para a realização de 
 * todas as acções desejadas.
 *  
 * @author Miguel Rodrigues nº 73541
 */

public class Interface_Window {

	JLabel lblFpMC = new JLabel("FP:");                 //Label FP Manual
	JLabel lblFnMc = new JLabel("FN:");				    //Label FN Manual
	JLabel lblfppercent = new JLabel("FP%:");			//Label Percentagem FP Manual
	JLabel lblfnpercent = new JLabel("FN%:");			//Label Percentagem FN Manual
	JLabel lblautofn = new JLabel("FN:");				//Label FN Automatico
	JLabel lblautofp = new JLabel("FP:");				//Label FP Automatico
	JLabel lblautofnpercent = new JLabel("FN%:");		//Label Percentagem FN automático
	JLabel lblautofppercent = new JLabel("FP%:");		//Label Percentagem FP automático
		
	private JButton btnRulesSetting;
	private JButton btnSpamSetting;
	private JButton btnHamSetting;

	private JButton btnAvaliacaoConf;
	private JButton btnGravarMConf;
	
	private JButton btnGerarAConf;
	private JButton btnAvalEvalAConf;
	private JButton btnGravarAConf;
	
	public static String RulePath;						//Path do ficheiro Rules
	public static String SpamPath;						//Path do ficheiro Spam
	public static String HamPath;						//Path do ficheiro Ham
	private JFrame frame;
	
	private AntiSpamFilterAutomaticConfiguration filterConfiguration = new AntiSpamFilterAutomaticConfiguration(); 
	private List<Rule> rulesList;
	private List<Email> hamList;
	private List<Email> spamList;
	boolean isGenerated;
	
	private FileReader reader = new FileReader();
	private Analyzer analyzer = new Analyzer();
	private Message error;
	private Message msg;
	

	/**
	 * Construtor da classe.
	 * Inicializa a interface.
	 */

	public Interface_Window() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Inicializar as Interface, construir o ui e correr o sistema. 
	 * 
	 * @author Miguel Rodrigues @73541
	 * @author (Parcial) Kevin Corrales nº 73529
	 */
	
	private void initialize() {
		
		DefaultListModel<String> model = new DefaultListModel<>();
		DefaultListModel<Double> doublemodel = new DefaultListModel<>();
	
		frame = new JFrame("Spam Filter");
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPaths = new JPanel();
		panelPaths.setBounds(10, 11, 800, 149);
		frame.getContentPane().add(panelPaths);
		panelPaths.setLayout(null);
				
		JTextPane pathRulesFinder = new JTextPane();
		pathRulesFinder.setEditable(false);
		pathRulesFinder.setBounds(26, 11, 500, 25);
		panelPaths.add(pathRulesFinder);
		
		JTextPane pathHamFinder = new JTextPane();
		pathHamFinder.setEditable(false);
		pathHamFinder.setBounds(26, 113, 500, 25);
		panelPaths.add(pathHamFinder);
		
		JTextPane pathSpamFinder = new JTextPane();
		pathSpamFinder.setEditable(false);
		pathSpamFinder.setBounds(26, 62, 500, 25);
		panelPaths.add(pathSpamFinder);
				
		btnRulesSetting = new JButton("Set Rules Path");
		btnRulesSetting.setBounds(550, 11, 170, 23);
		panelPaths.add(btnRulesSetting);
		
		btnSpamSetting = new JButton("Set Spam Path");
		btnSpamSetting.setBounds(550, 62, 170, 23);
		panelPaths.add(btnSpamSetting);
		
		btnHamSetting = new JButton("Set Ham Path");
		btnHamSetting.setBounds(550, 113, 170, 23);
		panelPaths.add(btnHamSetting);
		
		JPanel panelManualConf = new JPanel();
		panelManualConf.setBounds(10, 160, 800, 143);
		frame.getContentPane().add(panelManualConf);
		panelManualConf.setLayout(null);
	
	    //Labels de resultados de avaliação de FP e FN
    	
		lblFpMC.setBounds(30, 118, 80, 14);
		panelManualConf.add(lblFpMC);
		
		lblFnMc.setBounds(140, 118, 80, 14);
		panelManualConf.add(lblFnMc);
				
		//labels que dão valores em percentagem de FP e FN após avaliação
		
		lblfppercent.setBounds(280, 118, 54, 14);
		panelManualConf.add(lblfppercent);		

		lblfnpercent.setBounds(390, 118, 54, 14);
		panelManualConf.add(lblfnpercent);
		
		
		btnAvaliacaoConf = new JButton("Evaluate Configuration");
		btnAvaliacaoConf.setBounds(550, 39, 170, 23);
		panelManualConf.add(btnAvaliacaoConf);
		
		btnGravarMConf = new JButton("Save Configuration");
		btnGravarMConf.setBounds(550, 91, 170, 23);
		panelManualConf.add(btnGravarMConf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 39, 500, 80);
		panelManualConf.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{248, 248, 0};
		gbl_panel_1.rowHeights = new int[]{77, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JTextArea mCList = new JTextArea();
		mCList.setEditable(false);
		GridBagConstraints gbc_mCList = new GridBagConstraints();
		gbc_mCList.fill = GridBagConstraints.BOTH;
		panel_1.add(mCList, gbc_mCList);
		
		JTextArea mCediting = new JTextArea();
		GridBagConstraints gbc_mCediting = new GridBagConstraints();
		gbc_mCediting.fill = GridBagConstraints.BOTH;
		panel_1.add(mCediting, gbc_mCediting);

		JLabel lblManuelConfigurationTitle = new JLabel("Manual Configuration");
		lblManuelConfigurationTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManuelConfigurationTitle.setBounds(30, 11, 181, 14);
		panelManualConf.add(lblManuelConfigurationTitle);
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 307, 800, 143);
		frame.getContentPane().add(panel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 39, 500, 80);
		panel_2.add(scrollPane_2);
		
		JPanel panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{248, 248, 0};
		gbl_panel_2.rowHeights = new int[]{77, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel_2);
		
		JList autoList = new JList(model);
		GridBagConstraints gbc_AutoList = new GridBagConstraints();
		gbc_AutoList.fill = GridBagConstraints.BOTH;
		gbc_AutoList.insets = new Insets(0, 0, 0, 5);
		gbc_AutoList.gridx = 0;
		gbc_AutoList.gridy = 0;
		panel.add(autoList, gbc_AutoList);
		
		JList AutoGenerated = new JList(doublemodel);
		GridBagConstraints gbc_AutoGenerated = new GridBagConstraints();
		gbc_AutoGenerated.fill = GridBagConstraints.BOTH;
		gbc_AutoGenerated.gridx = 1;
		gbc_AutoGenerated.gridy = 0;
		panel.add(AutoGenerated, gbc_AutoGenerated);
		AutoGenerated.setFocusable(false);
		
		btnGerarAConf = new JButton("Generate Configuration");
		btnGerarAConf.setBounds(550, 39, 170, 23);
		panel_2.add(btnGerarAConf);
		
		btnAvalEvalAConf = new JButton("Update and Evaluate");
		btnAvalEvalAConf.setBounds(550, 65, 170, 23);
		panel_2.add(btnAvalEvalAConf);
		
		btnGravarAConf = new JButton("Save Configuration");
		btnGravarAConf.setBounds(550, 91, 170, 23);
		panel_2.add(btnGravarAConf);
		
		JLabel lblAutomaticConfiguration = new JLabel("Automatic Configuration");
		lblAutomaticConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutomaticConfiguration.setBounds(30, 11, 181, 14);
		panel_2.add(lblAutomaticConfiguration);
		
		//Labels de resultados de avaliação de FP e FN
		lblautofp.setBounds(30, 118, 46, 14);
		panel_2.add(lblautofp);
		
		lblautofn.setBounds(140, 118, 46, 14);
		panel_2.add(lblautofn);
				
		//labels que dão valores em percentagem de FP e FN após avaliação
		lblautofppercent.setBounds(280, 118, 54, 14);
		panel_2.add(lblautofppercent);
	
		lblautofnpercent.setBounds(390, 118, 54, 14);
		panel_2.add(lblautofnpercent);
		
		//Botão para selecionar localização do ficheiro Spam 
		btnSpamSetting.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFileChooser chooser = new JFileChooser();
		    	FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "Log Files",  "log");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	pathSpamFinder.setText(chooser.getSelectedFile().getPath());
		        	spamList = reader.getEmailsFromFile(chooser.getSelectedFile().getPath());
		        	SpamPath=chooser.getSelectedFile().getPath();
		        }
		    }
		});
		

		//Selecionador do ficheiro Ham
		btnHamSetting.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFileChooser chooser = new JFileChooser();
		    	FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    			 "Log Files",  "log");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	pathHamFinder.setText(chooser.getSelectedFile().getPath());
		        	hamList = reader.getEmailsFromFile(chooser.getSelectedFile().getPath());
		        	HamPath=chooser.getSelectedFile().getPath();
		        }
		    }
		});
		
		
		//Selecionador do ficheiro Rules
		btnRulesSetting.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFileChooser chooser = new JFileChooser();
		    	FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    			 "Configuration Files",  "cf");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	pathRulesFinder.setText(chooser.getSelectedFile().getPath());
		        	rulesList = reader.getRulesFromFile(chooser.getSelectedFile().getPath());
		        	
		        	mCediting.setText("");
		        	model.clear();
		        	mCList.setText("");
		        	
		        	RulePath=chooser.getSelectedFile().getPath();
		        	
		        	for(Rule rule : rulesList) {
		        		mCList.append(rule.getRule()+"\n");
		        		model.addElement(rule.getRule());
		        		mCediting.append(rule.getWeight()+"\n");
		        	}
		        }
		    }
		});
		
		//Botão de Gravação de Configuração manual
		btnGravarMConf.addActionListener( new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				String s[] = mCediting.getText().split("\\r?\\n");
			    ArrayList<String>rulesValues = new ArrayList<>(Arrays.asList(s));
			    reader.saveRuleValues(rulesValues,pathRulesFinder.getText(),rulesList);
		    }
		});
		
		
		//Botão de avaliação na configuração manual
		btnAvaliacaoConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evaluateManual();
			}
		});
	
		//Botão que inicia o Jmetal e gera os valores para a configuração automática
		btnGerarAConf.addActionListener( new ActionListener()
		   {@Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    	JOptionPane.showMessageDialog(null, "This operation may take a while");
		    	try {
					filterConfiguration.runJmetal();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    	JOptionPane.showMessageDialog(null, "Completed!");
		        }
		    }
		);
		
		//Botão de atualização e avaliação
		btnAvalEvalAConf.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	int aux  = reader.getLine("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");
		    	double[] geracao= reader.getDoubleVector("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs",aux);
		    	for(int i=0;i<geracao.length ||i< rulesList.size() ;i++) {
		    		doublemodel.addElement(geracao[i]);
		    		rulesList.get(i).setWeight(geracao[i]);
		    	}
		    	isGenerated=true;
		    	
		    	
		    	evaluateAuto();
		        }
		    }
		);
		
		//Gravar todos os valores gerados na configuração automática
		btnGravarAConf.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(isGenerated==true){
					DefaultListModel model = (DefaultListModel) AutoGenerated.getModel();
					
					 ArrayList<String> rulesValues = new ArrayList<String>();
					 
					for(int i = 0;i< model.getSize(); i++){
						rulesValues.add(model.getElementAt(i).toString());
					}
					reader.saveRuleValues(rulesValues,"AntiSpamConfigurationForProfessionalMailbox/rules.cf",rulesList);
				}
				else{
					 error= new Message("Not generated","Has not been generated yet");
					error.sendMessage();
				}
			}
		});
		
		
		
	}
			
	
	 /**
	  * Avaliar o FP e FN das listas guardadas e mostrar em labels (sistema manual)
	  * 
	  * @author Kevin Corrales nº 73529
	  */

	public void evaluateManual() {
		if(hamList==null || rulesList==null || spamList==null) {
			 error = new Message("Add all Files","Add all Files to their respective Path files first");
			error.sendMessage();
		}else {
			 msg= new Message("Manual configuration","Manual configuration FP and FN updated");
			msg.sendMessage();
			
			lblFnMc.setText("FN: " + String.valueOf(analyzer.getFNcount(hamList, rulesList))); 
			lblFpMC.setText("FP: " + String.valueOf(analyzer.getFPcount(spamList, rulesList)));
			
			lblfppercent.setText("FP%: " + String.valueOf(analyzer.getFPpercentage(spamList,rulesList) )) ;
			lblfnpercent.setText("FN%: " + String.valueOf(analyzer.getFNpercentage(hamList,rulesList) )) ;
			
		}
	}
	 /**
	  *  Avaliar o FP e FN das listas guardadas e mostrar em labels (sistema automático)
	  *  
	  * @author Kevin Corrales nº 73529
	  */

	public void evaluateAuto() {
		if(hamList==null || rulesList==null || spamList==null) {
			 error = new Message("Add all Files","Add all Files to their respective Path files first");
			error.sendMessage();
		}else {
			
			 msg= new Message("Auto configuration","Auto configuration FP and FN updated");
			msg.sendMessage();
			
			lblautofn.setText("FN: " + String.valueOf(analyzer.getFNcount(hamList, rulesList))); 
			lblautofp.setText("FP: " + String.valueOf(analyzer.getFPcount(spamList, rulesList)));
			lblautofppercent.setText("FP%: " + String.valueOf(analyzer.getFPpercentage(spamList,rulesList) )) ;
			lblautofnpercent.setText("FN%: " + String.valueOf(analyzer.getFNpercentage(hamList,rulesList) )) ;
		}
	}
	
	/**
	 * Métodos para testes JUnit
	 * 
	 * @author Diana Lopes
	 */
	
	public JButton getBtnRulesSetting() {
		return btnRulesSetting;
	}

	public JButton getBtnSpamSetting() {
		return btnSpamSetting;
	}
	
	public JButton getBtnHamSetting() {
		return btnHamSetting;
	}

	public JButton getBtnGravarMConf() {
		return btnGravarMConf;
	}
	
	public JButton getBtnAvaliacaoConf() {
		return btnAvaliacaoConf;
	}

	public JButton getBtnGerarAConf(){
		return btnGerarAConf;
	}
	
	public JButton getbtnAvalEvalAConf(){
		return btnAvalEvalAConf;
	}
	
	public JButton getBtnGravarAConf() {
		return btnGravarAConf;
	}
}
