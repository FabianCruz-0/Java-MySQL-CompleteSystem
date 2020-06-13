package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Prueba {
    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        prueba.createConnection();
    }
    void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/zSuTM1gvH0"
                    , "zSuTM1gvH0", "Q8XYDv9Lmv");
            System.out.println("Database connection Success");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
