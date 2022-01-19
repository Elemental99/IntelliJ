package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    Connection con = null;
    String url = "jdbc:postgresql://localhost:5432/Aseguradora_de_vida";
    String user = "postgres";
    String pass = "openpgpwd";

    public Connection conectar(){
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
