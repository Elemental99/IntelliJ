package sql;
import getset.lugar_de_nacimiento;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class CRUD extends conexion{
    java.sql.Statement st;
    ResultSet rs;
    lugar_de_nacimiento var = new lugar_de_nacimiento();

    //CRUD de la tabla Lugar de Nacimiento
    public void insertar(String id, String pais, String ciudad, String canton) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "insert into lugar_de_nacimiento values('" + id + "', '" + pais + "', '" + ciudad + "', '" + canton + "');";
            st.execute(sql);
            st.close();
            conec.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultar(String id) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "select * from lugar_de_nacimiento where id_lug = '" + id + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setId(rs.getString("id_lug"));
                var.setPais(rs.getString("pais_lug"));
                var.setCiudad(rs.getString("ciudad_lug"));
                var.setCanton(rs.getString("canton_lug"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registrar", JOptionPane.INFORMATION_MESSAGE);
                var.setId("");
                var.setPais("");
                var.setCiudad("");
                var.setCanton("");
            }
            st.close();
            conec.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror en el sistema de busqueda" + e, "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(String id, String pais, String ciudad, String canton) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "update lugar_de_nacimiento set pais_lug = '" + pais + "', "
                    + "ciudad_lug = '" + ciudad + "', canton_lug = '" + canton + "' "
                    + "where id_lug = '" + id + "';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conec.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror al actualizzar" + e, "Error de actualizacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String id) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "delete from lugar_de_nacimiento where id_lug = '" + id + "';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se ha eliminado el registro", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conec.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror al eliminar" + e, "Error de actualizacion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
