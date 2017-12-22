package InterfaceAndMain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Esta classe tem como objetivo indicar um erro no correr do programa
 * 
 * @author Miguel Rodrigues	 nº 73541
 *
 */

public class Message extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String message;
	private String title;
	

	/**
	 * Lançar a aplicação
	 */
	public void sendMessage() {
		try {
			Message dialog = new Message(title,message);
			dialog.setTitle(title);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Criar o Dialog
	 */
	
	public Message(String title,String message) {
		this.message = message;
		this.title = title;
		setBounds(100, 100, 294, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			//"Add all Files to their respective Path files first"
			JLabel lblAddAllFiles = new JLabel(message);
			lblAddAllFiles.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblAddAllFiles);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
					
				});
			}
		}
	}

}
