package InterfaceAndMain;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Window window = new Interface_Window();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
