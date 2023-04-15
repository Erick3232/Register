package AppRegister.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DB {
    public static String URL = "jdbc:mysql://localhost:3306/app";
    public static String USER = "root";
    public static String PWD = "helrick34231";

    private static Connection conn = null;
    private static Statement st = null;
    private Resultset rs = null;

    public static Connection getConnection(){
        try{
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conection Sucess!");
            st = conn.createStatement();

        } catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        return conn;
    }
    public void closeConnection() throws SQLException{
        st.close();
        conn.close();
    }
    public int ExecutaQuery(String sql){
        try{
            return st.executeUpdate(sql);
        } catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }
    public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
    public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
