package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Transaction {
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
					Transaction window = new Transaction();
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
	public Transaction() {
		initialize();
	}

	public Transaction(int i,String u) {
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
		
		JLabel lblNewLabel = new JLabel("Transaction");
		lblNewLabel.setBounds(503, 35, 306, 69);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 183, 886, 466);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		Conn c1=new Conn();
		try {
			ResultSet r=c1.s.executeQuery("Select * from admin where aid = "+id);
			r.next();
			String a =r.getString("accid");
			ResultSet rs=c1.s.executeQuery("Select * from Transaction where aid ="+a+";");
			ResultSetMetaData rsmd=rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName=new String[cols];
			for(int i=0;i<cols;i++)
			{
				colName[i]=rsmd.getColumnName(i+1);
			}
		
			model.setColumnIdentifiers(colName);
			String tid,aid,amount,type;
			while(rs.next())
			{
				aid=rs.getString("aid");
				tid=rs.getString("tid");
				amount=rs.getString("amount");
				type=rs.getString("type");
				String row[]= {tid,aid,amount,type};
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1124, 612, 117, 47);
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
