package Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Updation {
	

	public static void update(String type,int amount,int id,String query)
	{
		Conn c1=new Conn();
		if(type.equalsIgnoreCase("deposit"))
		{
			try {
				ResultSet rs=c1.s.executeQuery("select * from admin where aid ="+id+";");
				rs.next();
				System.out.println( Integer.parseInt(rs.getString("accid")));
				int accid = Integer.parseInt(rs.getString("accid"));
				rs=c1.s.executeQuery("select * from account where aid = "+accid);
				rs.next();
				int bal= Integer.parseInt(rs.getString("balance"));
				bal+=amount;
				c1.s.executeUpdate("update account set balance = "+bal+" where aid = "+accid+" ;");
				int tid=(int)(Math.random()*10000000); 
				c1.s.executeUpdate("insert into transaction values("+tid+","+accid+","+amount+",'"+"deposit'"+");");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(type.equalsIgnoreCase("withdraw"))
		{

			try {
				ResultSet rs=c1.s.executeQuery("select * from admin where aid ="+id+";");
				rs.next();
				System.out.println( Integer.parseInt(rs.getString("accid")));
				int accid = Integer.parseInt(rs.getString("accid"));
				rs=c1.s.executeQuery("select * from account where aid = "+accid);
				rs.next();
				int bal= Integer.parseInt(rs.getString("balance"));
				bal-=amount;
				c1.s.executeUpdate("update account set balance = "+bal+" where aid = "+accid+" ;");
				int tid=(int)(Math.random()*10000000); 
				amount=-amount;
				c1.s.executeUpdate("insert into transaction values("+tid+","+accid+","+amount+",'"+"withdraw'"+");");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equalsIgnoreCase("loan")) {

			try {
				ResultSet rs=c1.s.executeQuery("select * from admin where aid ="+id+";");
				rs.next();
				System.out.println( Integer.parseInt(rs.getString("accid")));
				int accid = Integer.parseInt(rs.getString("accid"));
				rs=c1.s.executeQuery("select * from account where aid = "+accid);
				rs.next();
				int bal= Integer.parseInt(rs.getString("balance"));
				bal+=amount;
				c1.s.executeUpdate("update account set balance = "+bal+" where aid = "+accid+" ;");
				int tid=(int)(Math.random()*10000000); 
				c1.s.executeUpdate("insert into transaction values("+tid+","+accid+","+amount+",'"+"loan'"+");");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equalsIgnoreCase("update"))
		{
			try {
				c1.s.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else if(type.equalsIgnoreCase("delete"))
		{
			String q="delete from customer where id ="+id;
			try {
				c1.s.executeUpdate(q);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
