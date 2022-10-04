package Employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Admin.Conn;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Home {

	String username="asda";
	int id=31;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}
	public Home(int i,String s) {
		username=s;
		id=i;
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
		
		Image img=(new ImageIcon(ASignUp.class.getResource("/icon/Bank_icon.png"))).getImage();
		img=img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(0, 0, 1266, 188);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome "+username);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(799, 42, 444, 92);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(51, 42, 128, 100);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DEPOSIT");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(161, 230, 306, 73);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Deposit(id,username);
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnLoan = new JButton("LOAN");
		btnLoan.setForeground(new Color(255, 255, 255));
		btnLoan.setBorderPainted(false);
		btnLoan.setBackground(new Color(0, 0, 0));
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Loan();
			}
		});
		btnLoan.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLoan.setBounds(161, 350, 306, 73);
		frame.getContentPane().add(btnLoan);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.setBorderPainted(false);
		btnCustomer.setBackground(new Color(0, 0, 0));
		btnCustomer.setForeground(new Color(255, 255, 255));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Customer(id,username);
			}
			
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCustomer.setBounds(161, 463, 306, 73);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnAccount = new JButton("ACCOUNT");
		btnAccount.setForeground(new Color(255, 255, 255));
		btnAccount.setBackground(new Color(0, 0, 0));
		btnAccount.setBorderPainted(false);
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Account(id,username);
			}
		});
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAccount.setBounds(683, 463, 306, 73);
		frame.getContentPane().add(btnAccount);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setBorderPainted(false);
		btnWithdraw.setBackground(new Color(0, 0, 0));
		btnWithdraw.setForeground(new Color(255, 255, 255));
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnWithdraw.setBounds(683, 230, 306, 73);
		btnWithdraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Withdraw(id,username);
			}
			
		});
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnTransaction = new JButton("TRANSACTION");
		btnTransaction.setForeground(new Color(255, 255, 255));
		btnTransaction.setBackground(new Color(0, 0, 0));
		btnTransaction.setBorderPainted(false);
		btnTransaction.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTransaction.setBounds(683, 350, 306, 73);
		btnTransaction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Transaction(id,username);
			}
			
		});
		frame.getContentPane().add(btnTransaction);
		
		JButton btnBalance = new JButton("BALANCE");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c1= new Conn();
				try {
					ResultSet rs = c1.s.executeQuery("select * from employee where eid = "+id+";");
					rs.next();
					String a=rs.getString("account id");
					rs = c1.s.executeQuery("select * from account where aid = "+a+";");
					rs.next();
					String bal=rs.getString("balance");
					JOptionPane.showMessageDialog(null, "Balance ="+bal);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnBalance.setForeground(Color.WHITE);
		btnBalance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBalance.setBorderPainted(false);
		btnBalance.setBackground(Color.BLACK);
		btnBalance.setBounds(161, 567, 306, 73);
		frame.getContentPane().add(btnBalance);
		frame.setVisible(true);
	}
}
