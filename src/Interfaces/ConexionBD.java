package Interfaces;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.*;

public class ConexionBD 
{
	//LO DEJO ASI EN DADO CASO QUE SI QUIERAN HACER UNA INTERFAZ PIDIENDO EL USUARIO Y CONTRASEÑA
	//DE LA BASE DE DATOS O INCLUSIVE QUE SEA CON OTRO SERVER 
	//NO SE SI SE TENGA QUE CREAR UNA INTERFAZ PARA ESTO, COMO QUIERA DEJO LA CONEXION AQUI
	//variables que se usaran en todos los javas.
	public static PreparedStatement pstm = null;
	ResultSet rs = null;
	String query="";
	public static String nom_BD="";
	public static String servidor= "jdbc:mysql://remotemysql.com:3306/zSuTM1gvH0";
	public static String usuario ="zSuTM1gvH0";
	public static String contrasena= "Q8XYDv9Lmv";
	public static Connection con = null;
	
	public static Connection conectar() {
		
		try
		{
		 con = DriverManager.getConnection(servidor, usuario, contrasena);
			nom_BD = con.getCatalog();
			System.out.println(con); 
		}
		catch(SQLException e1) //multicatch para classforname y con
		{
			e1.printStackTrace();	
		}
		return con;
	}
	
}
