package Customer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Loan {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan window = new Loan();
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
	public Loan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOAN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		lblNewLabel.setBounds(338, 24, 605, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount to apply for loan:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(58, 140, 1168, 105);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 205));
		textField.setBounds(211, 302, 895, 105);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(534, 520, 224, 53);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 1266, 136);
		frame.getContentPane().add(panel);
		
		JButton btnCloses = new JButton("Close");
		btnCloses.setForeground(Color.WHITE);
		btnCloses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCloses.setBorderPainted(false);
		btnCloses.setBackground(Color.BLACK);
		btnCloses.setBounds(1088, 612, 168, 47);
		btnCloses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}

			
		});
		frame.getContentPane().add(btnCloses);
		frame.setVisible(true);
	}
}
