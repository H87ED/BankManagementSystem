package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Account {
	int id=31;
	String username="asd";

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
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
	public Account() {
		initialize();
	}
	public Account(int i,String u) {
		id=i;
		username=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Conn c1= new Conn();
		String query="select * from employee where eid = "+id;
		String namee = null,pas="",acid = null,add = null,bname = null,pas1;
		int bno=0;
		try {
			ResultSet rs =c1.s.executeQuery(query);
			rs.next();
			namee=rs.getString("ename");
			acid=rs.getString("account id");
			add=rs.getString("eaddress");
			pas1=rs.getString("password");
			bno=Integer.parseInt(rs.getString("ebranch"));
			for(int i=0;i<pas1.length();i++)
			{
				pas+="*";
			}
			rs=c1.s.executeQuery("select * from branch where bid = "+bno);
			rs.next();
			bname=rs.getString("bname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 1266, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBounds(420, 36, 378, 69);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(270, 231, 218, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Address :");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_2.setBounds(270, 296, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Branch :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_3.setBounds(270, 426, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Username :");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_4.setBounds(270, 490, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Password :");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_5.setBounds(270, 561, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Admin ID :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(270, 161, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(392, 626, 168, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new UpdAccount(id,username);
			}

			
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(641, 626, 168, 47);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String q= "delete from admin where aid = "+id+";";
				new Confirm(id,"delete",q);
			}

			
		});
		frame.getContentPane().add(btnDelete);
		
		JButton btnCloses = new JButton("Close");
		btnCloses.setForeground(Color.WHITE);
		btnCloses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCloses.setBorderPainted(false);
		btnCloses.setBackground(Color.BLACK);
		btnCloses.setBounds(1066, 626, 168, 47);
		btnCloses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}

			
		});
		frame.getContentPane().add(btnCloses);
		
		JLabel aid = new JLabel(id+"");
		aid.setFont(new Font("Tahoma", Font.PLAIN, 25));
		aid.setBounds(498, 161, 311, 41);
		frame.getContentPane().add(aid);
		
		JLabel name = new JLabel(namee);
		name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		name.setBounds(498, 231, 311, 41);
		frame.getContentPane().add(name);
		
		JLabel address = new JLabel(add);
		address.setFont(new Font("Tahoma", Font.PLAIN, 25));
		address.setBounds(498, 296, 311, 41);
		frame.getContentPane().add(address);
		
		JLabel branch = new JLabel(bname);
		branch.setFont(new Font("Tahoma", Font.PLAIN, 25));
		branch.setBounds(498, 426, 311, 41);
		frame.getContentPane().add(branch);
		
		JLabel uname = new JLabel(username);
		uname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		uname.setBounds(498, 490, 311, 41);
		frame.getContentPane().add(uname);
		
		JLabel pass = new JLabel(pas);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pass.setBounds(498, 561, 311, 41);
		frame.getContentPane().add(pass);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Account ID:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_2_1.setBounds(270, 357, 218, 41);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel accid = new JLabel(acid);
		accid.setFont(new Font("Tahoma", Font.PLAIN, 25));
		accid.setBounds(498, 362, 311, 41);
		frame.getContentPane().add(accid);
		frame.setVisible(true);
	}
}
