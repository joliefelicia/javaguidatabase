import java.sql.*;
public class Database {


    public Connection db;
    public Database() throws SQLException, ClassNotFoundException {

        Class.forName("oracle.jdbc.driver.OracleDriver");


        db = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "javagui", "javagui");
    }
        public boolean isConnected(){
            return( db != null);
        }

}


