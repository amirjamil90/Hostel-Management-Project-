import java.sql.*;
class MysqlConnect
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class loaded ");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","1234");
			System.out.println("connection obtained ");
			Statement st=cn.createStatement();
	ResultSet rs=st.executeQuery("Select * from login");

			System.out.println("records are as follows ");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.println("\t"+rs.getString(3));
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
			