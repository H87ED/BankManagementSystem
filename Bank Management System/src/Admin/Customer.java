package Admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Customer {
	int id=0;
	String username="Hiei";

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}
	public Customer(int i,String u) {
		id=i;
		username=u;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 1266, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER");
		lblNewLabel.setBounds(123, 28, 960, 86);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 209, 1001, 407);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Conn c1=new Conn();
		try {
			ResultSet r=c1.s.executeQuery("select * from admin where aid = "+id);
			r.next();
			String bno=r.getString("abranch");
			ResultSet rs=c1.s.executeQuery("Select * from Customer where cbranch = "+bno+";");
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
			{
				colName[i]=rsmd.getColumnName(i+1);
			}
		
			model.setColumnIdentifiers(colName);
			String eid,ename,eaddress,euname,password,accountid,ebranch;
			while(rs.next())
			{
				eid=rs.getString("custid");
				ename=rs.getString("cname");
				eaddress=rs.getString("caddress");
				euname=rs.getString("auname");
				password=rs.getString("password");
				accountid=rs.getString("accid");
				ebranch=rs.getString("cbranch");
				String row[]= {eid,ename,eaddress,accountid,euname,password,ebranch};
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1051, 626, 162, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
			}

			
		});
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

}
