package Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class Deposit {
	int id=0;
	String username="Hiei";

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
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
	public Deposit() {
		initialize();
	}
	public Deposit(int i,String user) {
		id =i;
		user=username;
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
		
		JLabel lblNewLabel = new JLabel("DEPOSIT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		lblNewLabel.setBounds(338, 24, 605, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount to be deposited:");
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
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Confirm(id,"deposit",Integer.parseInt(textField.getText()));
			}
			
		});
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
		btnCloses.setBounds(1088, 626, 168, 47);
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
