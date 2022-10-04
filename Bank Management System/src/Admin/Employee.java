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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Employee {
	int id=0;
	String username="Hiei";

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
	}
	
	public Employee(int i,String u) {
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
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE");
		lblNewLabel.setBounds(182, 30, 960, 86);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HP Simplified Hans", Font.PLAIN, 60));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 189, 942, 424);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Conn c1=new Conn();
		try {
			ResultSet r=c1.s.executeQuery("select * from admin where aid = "+id);r.next();
			String bno=r.getString("abranch");
			ResultSet rs=c1.s.executeQuery("Select * from Employee where ebranch = " +bno+";");
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
				eid=rs.getString("eid");
				ename=rs.getString("ename");
				eaddress=rs.getString("eaddress");
				euname=rs.getString("euname");
				password=rs.getString("password");
				accountid=rs.getString("accountid");
				ebranch=rs.getString("ebranch");
				String row[]= {eid,ename,eaddress,euname,password,accountid,ebranch};
				model.addRow(row);
			}
			ListSelectionModel model1 = table.getSelectionModel();
			model1.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if(!model1.isSelectionEmpty())
					{
						
					}
				}
				
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("CLOSE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1041, 623, 162, 47);
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
