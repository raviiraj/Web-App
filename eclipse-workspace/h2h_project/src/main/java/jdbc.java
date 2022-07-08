import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc {
	public static void main(String args[]) {
		try {
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			final String URL = "jdbc:mysql://localhost:3306/hrc";
			final String USER = "root";
			final String PASS = "Redrum@1";
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			Statement stm = con.createStatement();
			String query = "SELECT *FROM mytable";
			ResultSet rst = stm.executeQuery(query);
			
			
			
			while(rst.next()) {
				String business_code = rst.getString("business_code");
				String converted_usd = rst.getString("converted_usd");
				System.out.println(business_code+ "   "+converted_usd);
				
			}
			
			stm.close();
			con.close();
			
			

	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
		
		

}

