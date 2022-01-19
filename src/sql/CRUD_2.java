package sql;

import getset.Agente_Vendedor;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CRUD_2 extends conexion {

    java.sql.Statement st;
    ResultSet rs;
    final Agente_Vendedor var = new Agente_Vendedor();

    //CRUD de la tabla Agente vendedor
    public void insertar(String id, String nombre, String fecha_contrato, String lugar_contrato, String documentos, String pago) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "insert into agente_vendedor values('" + id + "', "
                    + "'" + nombre + "', '" + fecha_contrato + "', '" + lugar_contrato + "',  "
                    + "'" + documentos + "',  '" + pago + "');";
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
            String sql = "select * from agente_vendedor where id_agent = '" + id + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setId(rs.getString("id_agent"));
                var.setNombre(rs.getString("nom_agent"));
                var.setFecha_contrato(rs.getString("fech_contr"));
                var.setLugar_contrato(rs.getString("lugar_contr"));
                var.setDocumento_contrato(rs.getString("document_contr"));
                var.setPago_agente(rs.getString("pago_agent"));
            } else {
                var.setId("");
                var.setNombre("");
                var.setFecha_contrato("");
                var.setLugar_contrato("");
                var.setDocumento_contrato("");
                var.setPago_agente("");
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registrar", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conec.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror en el sistema de busqueda" + e, "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(String id, String nombre, String fecha_contrato, String lugar_contrato, String documentos, String pago) {
        try {
            Connection conec = conectar();
            st = conec.createStatement();
            String sql = "update agente_vendedor set nom_agent = '" + nombre + "', "
                    + "fech_contr = '" + fecha_contrato + "', lugar_contr = '" + lugar_contrato + "', "
                    + "document_contr = '" + documentos + "', pago_agent = '" + pago + "' "
                    + "where id_agent = '" + id + "';";
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
            String sql = "delete from agente_vendedor where id_agent = '" + id + "';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se ha eliminado el registro", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conec.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror al eliminar" + e, "Error de actualizacion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
