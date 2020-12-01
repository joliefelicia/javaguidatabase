import java.sql.SQLException;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        new Exercise();

        try{
            Database db = new Database();
            System.out.println("Database is connected: "+db.isConnected());

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
