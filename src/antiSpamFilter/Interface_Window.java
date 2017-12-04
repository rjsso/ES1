package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Classes.Email;
import Classes.FileReader;
import Classes.Rule;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JList;
import java.awt.Color;

public class Interface_Window {
	
	
	private JFrame frame;
	private List<Rule> rulesList;
	private List<Email> hamList;
	private List<Email> spamList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Window window = new Interface_Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 431, 149);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(26, 11, 243, 25);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(26, 113, 243, 25);
		panel.add(textPane_1);
		
		JLabel lblNewLabel = new JLabel("Rules Path");
		lblNewLabel.setBounds(345, 11, 46, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spam Path");
		lblNewLabel_1.setBounds(345, 62, 46, 25);
		panel.add(lblNewLabel_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(26, 62, 243, 25);
		panel.add(textPane_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ham Path");
		lblNewLabel_2.setBounds(345, 113, 46, 25);
		panel.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 136, 1, 2);
		panel.add(separator_1);
		
		JButton btnNewButton = new JButton("Set");
		btnNewButton.setBounds(270, 62, 65, 25);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Set");
		button.setBounds(270, 113, 65, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("Set");
		button_1.setBounds(270, 11, 65, 25);
		panel.add(button_1);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 160, 431, 143);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("avaliar configura\u00E7\u00E3o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(286, 40, 144, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(273, 39, 17, 75);
		panel_1.add(scrollBar);
		
		JButton btnNewButton_2 = new JButton("gravar configura\u00E7\u00E3o");
		btnNewButton_2.setBounds(289, 91, 141, 23);
		panel_1.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(147, 39, 132, 75);
		panel_1.add(textArea);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(126, 11, -105, 103);
		panel_1.add(textPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(125, 11, -104, 103);
		panel_1.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(123, 11, -102, 91);
		panel_1.add(textArea_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 141, 1, 2);
		panel_1.add(separator);
		
		JLabel lblManuelConfiguration = new JLabel("Manual Configuration");
		lblManuelConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManuelConfiguration.setBounds(109, 11, 181, 14);
		panel_1.add(lblManuelConfiguration);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		list.setBounds(31, 39, 112, 74);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 307, 431, 143);
		frame.getContentPane().add(panel_2);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(273, 39, 17, 75);
		panel_2.add(scrollBar_1);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setBounds(147, 39, 132, 75);
		panel_2.add(textArea_4);
		
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
		
		JButton btnGerarConfiguraoAutomatica = new JButton("gerar configura\u00E7\u00E3o automatica");
		btnGerarConfiguraoAutomatica.setBounds(289, 40, 142, 23);
		panel_2.add(btnGerarConfiguraoAutomatica);
		
		JButton btnGravarConfiguraao = new JButton("gravar configura\u00E7ao");
		btnGravarConfiguraao.setBounds(289, 91, 142, 23);
		panel_2.add(btnGravarConfiguraao);
		
		JLabel lblAutomaticConfiguration = new JLabel("Automatic Configuration");
		lblAutomaticConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutomaticConfiguration.setBounds(109, 11, 181, 14);
		panel_2.add(lblAutomaticConfiguration);
		
		JList list_1 = new JList();
		list_1.setBounds(31, 39, 112, 74);
		panel_2.add(list_1);
		
		//Kevin
		
		FileReader reader = new FileReader();
		
		btnNewButton.addActionListener( new ActionListener()
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
		        	textPane_2.setText(chooser.getSelectedFile().getPath());
		        	lblNewLabel_1.setText(chooser.getSelectedFile().getName());
		        	spamList = reader.getEmailsFromFile(chooser.getSelectedFile().getPath());
		        }
		    }
		});
		
		button.addActionListener( new ActionListener()
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
		        	textPane_1.setText(chooser.getSelectedFile().getPath());
		        	lblNewLabel_2.setText(chooser.getSelectedFile().getName());
		        	hamList = reader.getEmailsFromFile(chooser.getSelectedFile().getPath());
		        }
		    }
		});
		
		button_1.addActionListener( new ActionListener()
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
		        	textPane.setText(chooser.getSelectedFile().getPath());
		        	lblNewLabel.setText(chooser.getSelectedFile().getName());
		        	rulesList = reader.getRulesFromFile(chooser.getSelectedFile().getPath());
		        	
		        	for(Rule rule : rulesList) {
		        		model.addElement(rule.getRule());
		        	}
		        }
		    }
		});
		
		btnNewButton_2.addActionListener( new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				saveRuleValues(textArea,textPane.getText());
		    }
		});
	}
	
	public void saveRuleValues(JTextArea textarea,String file) {
		String s[] = textarea.getText().split("\\r?\\n");
	    ArrayList<String>ruleValues = new ArrayList<>(Arrays.asList(s));
	    
	    PrintWriter writer ;
		try {
			writer = new PrintWriter(file, "UTF-8");
				for(int i=0; i<rulesList.size();i++) {
					if(i<ruleValues.size()) {
						writer.println(rulesList.get(i).getRule() + " " + ruleValues.get(i));
					}else {
						writer.println(rulesList.get(i).getRule());
					}
				}
		    writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    
	    
	}
}
