package Admin;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ASignUp {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Admin Sign Up");
	private JTextField name;
	private JTextField address;
	private JTextField branch;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASignUp window = new ASignUp();
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
	public ASignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 1266, 130);
		panel.setBackground(new Color(46, 139, 87));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=(new ImageIcon(ASignUp.class.getResource("/icon/Bank_icon.png"))).getImage();
		img=img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(45, 15, 128, 100);
		panel.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(281, 15, 850, 100);
		
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 133, 1266, 550);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(415, 25, 218, 41);
		panel_1.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(new Color(255, 250, 205));
		name.setBounds(701, 28, 258, 38);
		panel_1.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBackground(new Color(255, 250, 205));
		address.setBounds(701, 114, 258, 73);
		panel_1.add(address);
		
		branch = new JTextField();
		branch.setColumns(10);
		branch.setBackground(new Color(255, 250, 205));
		branch.setBounds(701, 210, 258, 38);
		panel_1.add(branch);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBackground(new Color(255, 250, 205));
		username.setBounds(701, 284, 258, 38);
		panel_1.add(username);
		
		password = new JPasswordField();
		password.setBackground(new Color(255, 250, 205));
		password.setBounds(701, 355, 258, 38);
		panel_1.add(password);
		
		JLabel lblNewLabel_2_5 = new JLabel("Password :");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_5.setBounds(415, 355, 218, 41);
		panel_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_4 = new JLabel("Username :");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_4.setBounds(415, 284, 218, 41);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_3 = new JLabel("Branch :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_3.setBounds(415, 207, 218, 41);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Address :");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_2.setBounds(415, 114, 218, 41);
		panel_1.add(lblNewLabel_2_2);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(578, 446, 218, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int d=(int)(Math.random()*1000);
				int aid=(int)(Math.random()*1000);
				Conn c1=new Conn();
				String b=branch.getText();
				int bn=-1;
				try {
					ResultSet rs=c1.s.executeQuery("Select * from branch where bname ='"+b+"';");
					if(rs.next()) {
					bn=Integer.parseInt(rs.getString("bid"));
					System.out.println(rs.getString("bid"));
					}else
						JOptionPane.showMessageDialog(null, "Incorrect Branch");
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String q="insert into account values("+aid+",'salary',0);";
				try {
					c1.s.executeUpdate(q);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String q1="insert into admin values("+d+",'"+name.getText()+"',"+bn+",'"+username.getText()+"','"+password.getText()+"',"+aid+","+address.getText()+");";				
				try {
					c1.s.executeUpdate(q1);
					JOptionPane.showMessageDialog(null, "Your ID is: "+d+"\nYour account id is: "+aid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		panel_1.add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.BLACK);
		btnClose.setBounds(1038, 446, 186, 41);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}

			
		});
		panel_1.add(btnClose);frame.setVisible(true);
	}
}
