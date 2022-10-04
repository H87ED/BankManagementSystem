package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Confirm {

	private JFrame frame;
	private JPasswordField passwordField;
	String type="";
	String query="";
	int id=-1;
	int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm window = new Confirm();
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
	public Confirm() {
		initialize();
	}
	public Confirm(int i,String s) {
		initialize();
		id=i;
		type=s;
	}
	public Confirm(int i,String s,String query) {
		initialize();
		id=i;
		type=s;
		this.query=query;
	}
	public Confirm(int i,String s,int amount) {
		initialize();
		id=i;
		type=s;
		a=amount;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(46, 139, 87));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFIRMATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBounds(384, 32, 586, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(303, 249, 277, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(303, 370, 277, 68);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 250, 205));
		textPane.setBounds(569, 249, 336, 68);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(569, 538, 277, 68);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{

				Conn c1=new Conn();
				String username=textPane.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText();
				String q="select * from admin where ausername = '"+username+"' and apass = '"+pass+"';";
				try {
					ResultSet rs=c1.s.executeQuery(q);
					
					if(rs.next()){
						Updation.update(type, a, id, query);
						
	                    
	                }else{
	                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
	                }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		
		});
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 250, 205));
		passwordField.setBounds(569, 370, 336, 68);
		frame.getContentPane().add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(235, 153, 917, 366);
		frame.getContentPane().add(panel);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(979, 605, 232, 53);
		frame.getContentPane().add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}

			
		});
		frame.setVisible(true);
	}
}
