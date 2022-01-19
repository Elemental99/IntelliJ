package getset;

public class lugar_de_nacimiento {
    private static String id;
    private static String pais;
    private static String ciudad;
    private static String canton;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        lugar_de_nacimiento.id = id;
    }

    public static String getPais() {
        return pais;
    }

    public static void setPais(String pais) {
        lugar_de_nacimiento.pais = pais;
    }

    public static String getCiudad() {
        return ciudad;
    }

    public static void setCiudad(String ciudad) {
        lugar_de_nacimiento.ciudad = ciudad;
    }

    public static String getCanton() {
        return canton;
    }

    public static void setCanton(String canton) {
        lugar_de_nacimiento.canton = canton;
    }
}
