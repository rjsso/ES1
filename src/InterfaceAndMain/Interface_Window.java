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

import java.awt.Color;
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
		
	public static String RulePath;						//Path do ficheiro Rules
	public static String SpamPath;						//Path do ficheiro Spam
	public static String HamPath;						//Path do ficheiro Ham
	private JFrame frame;
	
	private AntiSpamFilterAutomaticConfiguration filterConfiguration = new AntiSpamFilterAutomaticConfiguration(); 
	private List<Rule> rulesList;
	private List<Email> hamList;
	private List<Email> spamList;
	boolean isGenerated;

	

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
	
	
	
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPaths = new JPanel();
		panelPaths.setBounds(10, 11, 449, 149);
		frame.getContentPane().add(panelPaths);
		panelPaths.setLayout(null);
		
		
		JTextPane pathRulesFinder = new JTextPane();
		pathRulesFinder.setEditable(false);
		pathRulesFinder.setBounds(26, 11, 243, 25);
		panelPaths.add(pathRulesFinder);
		
		JTextPane pathHamFinder = new JTextPane();
		pathHamFinder.setEditable(false);
		pathHamFinder.setBounds(26, 113, 243, 25);
		panelPaths.add(pathHamFinder);
		
		JLabel lblNewLabel = new JLabel("Rules Path");
		lblNewLabel.setBounds(345, 11, 94, 25);
		panelPaths.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spam Path");
		lblNewLabel_1.setBounds(345, 62, 94, 25);
		panelPaths.add(lblNewLabel_1);
		
		JTextPane pathSpamFinder = new JTextPane();
		pathSpamFinder.setEditable(false);
		pathSpamFinder.setBounds(26, 62, 243, 25);
		panelPaths.add(pathSpamFinder);
		
		JLabel lblNewLabel_2 = new JLabel("Ham Path");
		lblNewLabel_2.setBounds(345, 113, 94, 25);
		panelPaths.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 136, 1, 2);
		panelPaths.add(separator_1);
		
		JButton btnSpamSetting = new JButton("Set");
		btnSpamSetting.setBounds(270, 62, 65, 25);
		panelPaths.add(btnSpamSetting);
		
		JButton btnHamSetting = new JButton("Set");
		btnHamSetting.setBounds(270, 113, 65, 25);
		panelPaths.add(btnHamSetting);
		
		JButton btnRulesSetting = new JButton("Set");
		btnRulesSetting.setBounds(270, 11, 65, 25);
		panelPaths.add(btnRulesSetting);
			
		JPanel panelManualConf = new JPanel();
		panelManualConf.setBounds(10, 160, 449, 143);
		frame.getContentPane().add(panelManualConf);
		panelManualConf.setLayout(null);
		lblFpMC.setForeground(Color.RED);
		

		lblFpMC.setBounds(100, 118, 80, 14);
		panelManualConf.add(lblFpMC);
		lblFnMc.setForeground(Color.GREEN);
		lblFnMc.setBackground(Color.WHITE);
		
		lblFnMc.setBounds(10, 118, 80, 14);
		panelManualConf.add(lblFnMc);
		
		JButton btnAvaliacaoConf = new JButton("evaluate configuration\u00E7\u00E3o");
		btnAvaliacaoConf.setBounds(295, 39, 144, 23);
		panelManualConf.add(btnAvaliacaoConf);
		
		JButton btnGravarMconf = new JButton("save configuration\u00E7\u00E3o");
		btnGravarMconf.setBounds(298, 91, 141, 23);
		panelManualConf.add(btnGravarMconf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 39, 248, 75);
		panelManualConf.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{123, 123, 0};
		gbl_panel_1.rowHeights = new int[]{73, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		JList<String> mCList = new JList<>(model);
		GridBagConstraints gbc_mCList = new GridBagConstraints();
		gbc_mCList.fill = GridBagConstraints.BOTH;
		gbc_mCList.insets = new Insets(0, 0, 0, 5);
		gbc_mCList.gridx = 0;
		gbc_mCList.gridy = 0;
		panel_1.add(mCList, gbc_mCList);
		
		JTextArea mCediting = new JTextArea();
		GridBagConstraints gbc_mCediting = new GridBagConstraints();
		gbc_mCediting.fill = GridBagConstraints.BOTH;
		gbc_mCediting.gridx = 1;
		gbc_mCediting.gridy = 0;
		panel_1.add(mCediting, gbc_mCediting);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(126, 11, -105, 103);
		panelManualConf.add(textPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(125, 11, -104, 103);
		panelManualConf.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(123, 11, -102, 91);
		panelManualConf.add(textArea_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 141, 1, 2);
		panelManualConf.add(separator);
		
		JLabel lblManuelConfigurationTitle = new JLabel("Manual Configuration");
		lblManuelConfigurationTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManuelConfigurationTitle.setBounds(109, 11, 181, 14);
		panelManualConf.add(lblManuelConfigurationTitle);
		
		lblfppercent.setForeground(Color.RED);
		lblfppercent.setBounds(188, 118, 54, 14);
		panelManualConf.add(lblfppercent);

		

		lblfnpercent.setForeground(Color.GREEN);
		lblfnpercent.setBounds(245, 118, 54, 14);
		panelManualConf.add(lblfnpercent);
		

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 307, 449, 143);
		frame.getContentPane().add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 39, 248, 75);
		panel_2.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{123, 123, 0};
		gbl_panel.rowHeights = new int[]{73, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JList AutoList = new JList(model);
		GridBagConstraints gbc_AutoList = new GridBagConstraints();
		gbc_AutoList.fill = GridBagConstraints.BOTH;
		gbc_AutoList.insets = new Insets(0, 0, 0, 5);
		gbc_AutoList.gridx = 0;
		gbc_AutoList.gridy = 0;
		panel.add(AutoList, gbc_AutoList);
		
		JList AutoGenerated = new JList(doublemodel);
		GridBagConstraints gbc_AutoGenerated = new GridBagConstraints();
		gbc_AutoGenerated.fill = GridBagConstraints.BOTH;
		gbc_AutoGenerated.gridx = 1;
		gbc_AutoGenerated.gridy = 0;
		panel.add(AutoGenerated, gbc_AutoGenerated);
		AutoGenerated.setFocusable(false);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(126, 11, -105, 103);
		panel_2.add(textPane_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(125, 11, -104, 103);
		panel_2.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(123, 11, -102, 91);
		panel_2.add(textArea_6);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(57, 141, 1, 2);
		panel_2.add(separator_2);
		
		JButton btnGerarConfiguraoAutomatica = new JButton("generate configuration\u00E7\u00E3o automatica");
		btnGerarConfiguraoAutomatica.setBounds(297, 39, 142, 23);
		panel_2.add(btnGerarConfiguraoAutomatica);
		
		JButton btnGravarAutConf = new JButton("save configuration\u00E7ao");
		btnGravarAutConf.setBounds(297, 91, 142, 23);
		panel_2.add(btnGravarAutConf);
		
		JLabel lblAutomaticConfiguration = new JLabel("Automatic Configuration");
		lblAutomaticConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutomaticConfiguration.setBounds(109, 11, 181, 14);
		panel_2.add(lblAutomaticConfiguration);
		

		lblautofp.setForeground(Color.RED);
		lblautofp.setBounds(77, 118, 46, 14);
		panel_2.add(lblautofp);
		
		lblautofn.setForeground(Color.GREEN);
		lblautofn.setBounds(10, 118, 46, 14);
		panel_2.add(lblautofn);
		

		lblautofnpercent.setForeground(Color.GREEN);
		lblautofnpercent.setBounds(237, 118, 54, 14);
		panel_2.add(lblautofnpercent);
		

		lblautofppercent.setForeground(Color.RED);
		lblautofppercent.setBounds(142, 118, 54, 14);
		panel_2.add(lblautofppercent);
			
		
		FileReader reader = new FileReader();
		
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
		        	RulePath=chooser.getSelectedFile().getPath();
		        	
		        	
		        	for(Rule rule : rulesList) {
		        		model.addElement(rule.getRule());
		        		mCediting.append(rule.getWeight()+"\n");
		        	}
		        }
		    }
		});
		
		btnGravarMconf.addActionListener( new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				String s[] = mCediting.getText().split("\\r?\\n");
			    ArrayList<String>rulesValues = new ArrayList<>(Arrays.asList(s));
				saveRuleValues(rulesValues,pathRulesFinder.getText());
		    }
		});
		
		btnAvaliacaoConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evaluateManual();
			}
		});
	
		
		btnGerarConfiguraoAutomatica.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    	JOptionPane.showMessageDialog(null, "This operation may take a while so, grab a cup of coffee my dear");
		    	try {
					filterConfiguration.runJmetal();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	double[] geracao= reader.getDoubleVector("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");
		    	for(int i=0;i<geracao.length ||i< rulesList.size() ;i++) {
		    		doublemodel.addElement(geracao[i]);
		    		rulesList.get(i).setWeight(geracao[i]);
		    	}
		    	isGenerated=true;
		    	
		    	
		    	evaluateAuto();
		        }
		    }
		);
		
		
		btnGravarAutConf.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(isGenerated==true){
					DefaultListModel model = (DefaultListModel) AutoGenerated.getModel();
					
					 ArrayList<String> rulesValues = new ArrayList<String>();
					 
					for(int i = 0;i< model.getSize(); i++){
						rulesValues.add(model.getElementAt(i).toString());
					}
					saveRuleValues(rulesValues,pathRulesFinder.getText());
				}
				else{
					ErrorMessage error= new ErrorMessage("Has not been generated yet");
					error.errorMessage("Has not been generated yet");
				}
			}
		});
		
		
		
	}
	
	 public boolean isDouble(String str) {
	        try {
	            Double.parseDouble(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	
	public void saveRuleValues(List<String> rulesValues,String file) {
		
	    if(!file.isEmpty()) {
	    	PrintWriter writer ;
			try {
				writer = new PrintWriter(file, "UTF-8");
					for(int i=0; i<rulesList.size();i++) {
						if(i<rulesValues.size() && rulesValues.size()>0) {
							if(isDouble(rulesValues.get(i))) {
								writer.println(rulesList.get(i).getRule() + " " + rulesValues.get(i));
								rulesList.get(i).setWeight(Double.parseDouble(rulesValues.get(i)));
							}else {
								writer.println(rulesList.get(i).getRule() + " " + 0);
								rulesList.get(i).setWeight(0);
					    	
							}
						}else {
							writer.println(rulesList.get(i).getRule() + " " + 0);
						}
					}
			    writer.close();
			} catch (FileNotFoundException e) {
				ErrorMessage error = new ErrorMessage("Files not Found");
		    	error.errorMessage("Files not Found");
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	    }else {
	    	ErrorMessage error = new ErrorMessage("Add all Files to their respective Path files first");
			error.errorMessage("Add all Files to their respective Path files first");
	    }
	}
	
		
	
	
	
	public void evaluateManual() {
		Analyzer analyzer = new Analyzer() ;
		if(hamList==null || rulesList==null || spamList==null) {
			ErrorMessage error = new ErrorMessage("Add all Files to their respective Path files first");
			error.errorMessage("Add all Files to their respective Path files first");
		}else {
			lblFnMc.setText("FN: " + String.valueOf(analyzer.getFNcount(hamList, rulesList))); 
			lblFpMC.setText("FP: " + String.valueOf(analyzer.getFPcount(spamList, rulesList)));
			
			lblfppercent.setText("FP%: " + String.valueOf(analyzer.getFPpercentage(spamList,rulesList) )) ;
			lblfnpercent.setText("FP%: " + String.valueOf(analyzer.getFNpercentage(hamList,rulesList) )) ;
			
		}
	}
	
	public void evaluateAuto() {
		Analyzer analyzer = new Analyzer() ;
		if(hamList==null || rulesList==null || spamList==null) {
			ErrorMessage error = new ErrorMessage("Add all Files to their respective Path files first");
			error.errorMessage("Add all Files to their respective Path files first");
		}else {
			
			lblautofn.setText("FN: " + String.valueOf(analyzer.getFNcount(hamList, rulesList))); 
			lblautofp.setText("FP: " + String.valueOf(analyzer.getFPcount(spamList, rulesList)));
			lblautofppercent.setText("FP%: " + String.valueOf(analyzer.getFPpercentage(spamList,rulesList) )) ;
			lblautofnpercent.setText("FP%: " + String.valueOf(analyzer.getFNpercentage(hamList,rulesList) )) ;
		}
	}
	

}
