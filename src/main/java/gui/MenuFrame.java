package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(200, 100, 200, 50);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFrame game = new GameFrame();
				game.setVisible(true);
				MenuFrame.this.dispose();
			}
		});
		JButton btnNewGameFromXml = new JButton("New Game From Xml");
		btnNewGameFromXml.setBounds(200, 250, 200, 50);
		btnNewGameFromXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameFromXml frame = new GameFromXml();
				frame.setVisible(true);
				MenuFrame.this.dispose();
			}
		});
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(200, 400, 200, 50);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuFrame.this.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewGame);
		contentPane.add(btnNewGameFromXml);
		contentPane.add(btnExit);
	}
}
