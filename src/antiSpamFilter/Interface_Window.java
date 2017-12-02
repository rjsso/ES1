package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
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
import java.util.List;

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
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 149);
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
		
		JLabel lblNewLabel = new JLabel("Rules.cf");
		lblNewLabel.setBounds(345, 11, 46, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Spamlog");
		lblNewLabel_1.setBounds(345, 62, 46, 25);
		panel.add(lblNewLabel_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBounds(26, 62, 243, 25);
		panel.add(textPane_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ham.log");
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
		panel_1.setBounds(10, 160, 414, 143);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(273, 39, 17, 75);
		panel_1.add(scrollBar);
		
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
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setBounds(10, 39, 132, 75);
		panel_1.add(textArea_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 141, 1, 2);
		panel_1.add(separator);
		
		JButton btnNewButton_1 = new JButton("avaliar configura\u00E7\u00E3o");
		btnNewButton_1.setBounds(286, 40, 128, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("gravar configura\u00E7\u00E3o");
		btnNewButton_2.setBounds(289, 91, 125, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblManuelConfiguration = new JLabel("Manual Configuration");
		lblManuelConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManuelConfiguration.setBounds(109, 11, 181, 14);
		panel_1.add(lblManuelConfiguration);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 307, 414, 143);
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
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setEditable(false);
		textArea_7.setBounds(10, 39, 132, 75);
		panel_2.add(textArea_7);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(57, 141, 1, 2);
		panel_2.add(separator_2);
		
		JButton btnGerarConfiguraoAutomatica = new JButton("gerar configura\u00E7\u00E3o automatica");
		btnGerarConfiguraoAutomatica.setBounds(289, 40, 125, 23);
		panel_2.add(btnGerarConfiguraoAutomatica);
		
		JButton btnGravarConfiguraao = new JButton("gravar configura\u00E7ao");
		btnGravarConfiguraao.setBounds(289, 91, 125, 23);
		panel_2.add(btnGravarConfiguraao);
		
		JLabel lblAutomaticConfiguration = new JLabel("Automatic Configuration");
		lblAutomaticConfiguration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutomaticConfiguration.setBounds(109, 11, 181, 14);
		panel_2.add(lblAutomaticConfiguration);
		
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
		        	lblNewLabel.setText(chooser.getSelectedFile().getName());
		        	
		        	rulesList = reader.getRulesFromFile(chooser.getSelectedFile().getPath());
		        	for(Rule rule : rulesList) {
		        		textArea.append(rule.getRule() + "\n");
		        	}
		        }
		    }
		});
	}
}
