import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ValidationStudent extends HttpServlet
{

    public ValidationStudent()
    {
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter printwriter = response.getWriter();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hms", "root", "1234");
            Statement statement = connection.createStatement();
            
			String username = request.getParameter("user");
            String password = request.getParameter("password");
            
			ResultSet resultset = statement.executeQuery("select * from userlevel where username='"+username+"';");
            if(resultset.next())
			{
				String dbusername = resultset.getString(1);
				String dbpassword = resultset.getString(2);
				if(username.equals(dbusername) && password.equals(dbpassword))
					response.sendRedirect("http://localhost:7001/hms/student_home.html");
	            else
					response.sendRedirect("http://localhost:7001/hms/error_student_login.html");
			}
            else
                response.sendRedirect("http://localhost:7001/hms/error_student_login.html");
        }
        catch(SQLException sqlexception)
        {
            printwriter.println(sqlexception);
        }
        catch(Exception exception)
        {
            printwriter.println(exception);
        }
    }
}