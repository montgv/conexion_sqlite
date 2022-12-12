import java.sql.*;

public class conexion_sqlite {
    public static void main(String[] args) {
        try {
            //Antes de comenzar debemos de añadir la depencecia de SQlite

            //Cargamos el driver
            Class.forName("org.sqlite.JDBC");

            //Declaramos la variable para guardar la direccion de la base de datos y como se llama
            String url = "jdbc:sqlite:C:/Users/MateBook/Desktop/DAM/2ºDAM/ACDAT/TEMA 2/baseSqlite/prac_embebida.db";

            //Establecemos la conexion con la base de datos
            Connection conexion = DriverManager.getConnection(url);

            //Preparamos la consulta que deseamos realizar
            Statement sentencia = conexion.createStatement();
            String consulta = "SELECT apellido, oficio, salario FROM empleados WHERE dept_no='10'";
            ResultSet resultado = sentencia.executeQuery(consulta);

            //Recorremos el resultado obtenido de la consulta mediante un bucle mientras que haya registros
            while (resultado.next()) {
                System.out.println("Apellido: " + resultado.getString(1));
                System.out.println("Oficio: " + resultado.getString(2));
                System.out.println("Salario: " + resultado.getInt(3));
            }

            //Cerramos los recursos utilizados
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
