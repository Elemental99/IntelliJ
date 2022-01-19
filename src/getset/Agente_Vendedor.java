package getset;

public class Agente_Vendedor {
    private static String id;
    private static String nombre;
    private static String fecha_contrato;
    private static String lugar_contrato;
    private static String documento_contrato;
    private static String pago_agente;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Agente_Vendedor.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Agente_Vendedor.nombre = nombre;
    }

    public static String getFecha_contrato() {
        return fecha_contrato;
    }

    public static void setFecha_contrato(String fecha_contrato) {
        Agente_Vendedor.fecha_contrato = fecha_contrato;
    }

    public static String getLugar_contrato() {
        return lugar_contrato;
    }

    public static void setLugar_contrato(String lugar_contrato) {
        Agente_Vendedor.lugar_contrato = lugar_contrato;
    }

    public static String getDocumento_contrato() {
        return documento_contrato;
    }

    public static void setDocumento_contrato(String documento_contrato) {
        Agente_Vendedor.documento_contrato = documento_contrato;
    }

    public static String getPago_agente() {
        return pago_agente;
    }

    public static void setPago_agente(String pago_agente) {
        Agente_Vendedor.pago_agente = pago_agente;
    }
}
