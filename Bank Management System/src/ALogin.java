import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import Admin.ASignUp;

public class ALogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALogin window = new ALogin();
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
	public ALogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setForeground(Color.RED);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.RED);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(0, 0, 1280, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=(new ImageIcon(ALogin.class.getResource("/icon/Bank_icon.png"))).getImage();
		img=img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(45, 15, 128, 128);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\tWELCOME TO LE BANK\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(183, 15, 950, 128);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(46, 139, 87));
		panel_1_1.setBounds(0, 503, 1280, 180);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnAdmin = new JButton("USER");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserLogin();
			}
		});
		btnAdmin.setBounds(995, 28, 227, 45);
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Tahoma", Font.ITALIC, 30));
		btnAdmin.setBorderPainted(false);
		btnAdmin.setBackground(Color.BLACK);
		panel_1_1.add(btnAdmin);
		
		JButton btnSignUp_1_1 = new JButton("EMPLOYEE");
		btnSignUp_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmpLogin();
			}
			
		});
		btnSignUp_1_1.setForeground(Color.WHITE);
		btnSignUp_1_1.setFont(new Font("Tahoma", Font.ITALIC, 30));
		btnSignUp_1_1.setBorderPainted(false);
		btnSignUp_1_1.setBackground(Color.BLACK);
		btnSignUp_1_1.setBounds(995, 102, 227, 45);
		panel_1_1.add(btnSignUp_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(360, 230, 200, 56);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 204));
		textField.setBounds(627, 230, 350, 56);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(360, 316, 200, 56);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Conn c1=new Conn();
				int aid;
				String ausername=textField.getText();
				@SuppressWarnings("deprecation")
				String apass=passwordField.getText();
				String q="select * from admin where ausername = '"+ausername+"' and apass = '"+apass+"';";
				try {
					ResultSet rs=c1.s.executeQuery(q);
					
					if(rs.next()){
						aid= Integer.parseInt(rs.getString("aid"));
						new Admin.Home(aid,ausername);
						frame.setVisible(false);
	                    
	                }else{
	                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
	                }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 30));
		btnNewButton.setBounds(360, 418, 200, 56);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBorderPainted(false);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setFont(new Font("Tahoma", Font.ITALIC, 30));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin.ASignUp();
			}
		});
		btnSignUp.setBounds(627, 418, 200, 56);
		panel.add(btnSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 204));
		passwordField.setBounds(627, 316, 350, 56);
		panel.add(passwordField);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
}
