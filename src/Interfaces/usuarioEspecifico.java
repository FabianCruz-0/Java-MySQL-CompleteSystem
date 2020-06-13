package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class usuarioEspecifico implements ActionListener{
	int contDe30 = 1;
	int contDe31 = 1;
	int contA30 = 1;
	int contA31 = 1;
	private JComboBox comboBoxDeMm,comboBoxDeAaaa,comboBoxDeDd;
	private JButton btnVolver, btnBuscar;
	public JFrame frame;
	DefaultListModel lista;
	
	private JTextField textIdUsuario;
	
	Connection con = ConexionBD.conectar();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Statement stm = null;
    String query = "";
    String fecha;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarioEspecifico window = new usuarioEspecifico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public usuarioEspecifico() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960,640);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuarioEspecifico = new JLabel("Usuario en especifico");
		lblUsuarioEspecifico.setForeground(Color.WHITE);
		lblUsuarioEspecifico.setFont(new Font("Arial", Font.BOLD, 40));
		lblUsuarioEspecifico.setBounds(255, 50, 423, 72);
		
		JList list = new JList();
		list.setBounds(153, 445, 96, -77);
		frame.getContentPane().add(list);
		
		lista = new DefaultListModel();
		list.setModel(lista);
        list.setBounds(10, 280, 924, 270);
        frame.getContentPane().add(list);

		frame.getContentPane().add(lblUsuarioEspecifico);
		frame.getContentPane().setBackground(new Color(72,81,84));
		
		JLabel lblIdUsuario = new JLabel("ID Usuario:");
		lblIdUsuario.setForeground(Color.WHITE);
		lblIdUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIdUsuario.setBounds(58, 193, 149, 16);
		frame.getContentPane().add(lblIdUsuario);
		
		JLabel lblRango = new JLabel("dia a ver:");
		lblRango.setForeground(Color.WHITE);
		lblRango.setFont(new Font("Arial", Font.BOLD, 20));
		lblRango.setBounds(636, 132, 149, 31);
		frame.getContentPane().add(lblRango);
		

		
		textIdUsuario = new JTextField();
		textIdUsuario.setBounds(163, 195, 229, 19);
		frame.getContentPane().add(textIdUsuario);
		textIdUsuario.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBackground(new Color(171, 0, 51));
		btnVolver.setBounds(10, 562, 139, 31);
		frame.getContentPane().add(btnVolver);
		btnVolver.addActionListener(this);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(171, 0, 51));
		btnBuscar.setBounds(411, 237, 139, 31);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		JLabel lblDeAaaa = new JLabel("/ AAAA");
		lblDeAaaa.setForeground(Color.WHITE);
		lblDeAaaa.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDeAaaa.setBounds(758, 185, 68, 24);
		frame.getContentPane().add(lblDeAaaa);
		
		JLabel lblDeDd = new JLabel("/ DD");
		lblDeDd.setForeground(Color.WHITE);
		lblDeDd.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDeDd.setBounds(636, 185, 68, 24);
		frame.getContentPane().add(lblDeDd);
		
		JLabel lblDeMm = new JLabel("MM");
		lblDeMm.setForeground(Color.WHITE);
		lblDeMm.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDeMm.setBounds(531, 185, 68, 24);
		frame.getContentPane().add(lblDeMm);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setForeground(Color.WHITE);
		lblDe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDe.setBounds(496, 180, 42, 31);
		frame.getContentPane().add(lblDe);
		
		comboBoxDeMm = new JComboBox();
		comboBoxDeMm.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxDeMm.setForeground(Color.WHITE);
		comboBoxDeMm.setBackground(new Color(34, 31, 32));
		comboBoxDeMm.setBounds(566, 188, 60, 21);
		frame.getContentPane().add(comboBoxDeMm);
		comboBoxDeMm.addActionListener(this);
		
		comboBoxDeDd = new JComboBox();
		comboBoxDeDd.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDeDd.setForeground(Color.WHITE);
		comboBoxDeDd.setBackground(new Color(34, 31, 32));
		comboBoxDeDd.setBounds(688, 188, 60, 21);
		frame.getContentPane().add(comboBoxDeDd);

		
		comboBoxDeAaaa = new JComboBox();
		comboBoxDeAaaa.setModel(new DefaultComboBoxModel(new String[] {"2020"}));
		comboBoxDeAaaa.setForeground(Color.WHITE);
		comboBoxDeAaaa.setBackground(new Color(34, 31, 32));
		comboBoxDeAaaa.setBounds(829, 188, 60, 21);
		frame.getContentPane().add(comboBoxDeAaaa);
	
        lista.addElement("Fecha                                  Hora                            			ID_Usuario                  			              ID Venta Realizada                                Monto pagado en la venta");

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==comboBoxDeMm) {
			
			String deMm = (String) comboBoxDeMm.getSelectedItem();
			
			if(deMm == "02") {
				if(contDe31==1 && contDe30==1) {
					comboBoxDeDd.removeItem("30");
					comboBoxDeDd.removeItem("31");
					contDe30=0;
					contDe31=0;
				}
				else if(contDe31==0 && contDe30==1) {
					comboBoxDeDd.removeItem("30");
					contDe30=0;
				}	
			}	
			else if(deMm=="01" || deMm=="03" || deMm=="05" || deMm=="07" || deMm=="08" || deMm=="10" || deMm=="12") {
				
				if(contDe30==0 && contDe31==0) {
					comboBoxDeDd.addItem("30");
					comboBoxDeDd.addItem("31");
					contDe30=1;
					contDe31=1;
				}
				else if(contDe30==1 && contDe31==0) {
					comboBoxDeDd.addItem("31");
					contDe31=1;
				}
			}
			else if(deMm=="04" || deMm=="06" || deMm=="09" || deMm=="11") {
				
				if(contDe30==0 && contDe31==0) {
					comboBoxDeDd.addItem("30");
					contDe30=1;
				}
				else if(contDe30==1 && contDe31==1) {
					comboBoxDeDd.removeItem("31");
					contDe31=0;
				}
			}
		} else if(e.getSource()==btnVolver) {
			Informe informe = new Informe();
			informe.frame.setVisible(true);
			frame.dispose();
			
		}else if(e.getSource()==btnBuscar) {
			if(textIdUsuario.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Tienes que introducir un Id para ver.");
			}else {
				int Id = Integer.parseInt(textIdUsuario.getText());
				
				int dia= comboBoxDeDd.getSelectedIndex()+1;
				int mes= comboBoxDeMm.getSelectedIndex()+1;
				int anio= comboBoxDeAaaa.getSelectedIndex();
				String diaStr=null;
				String mesStr=null;
				if(dia<10)
				{
					diaStr="0"+dia;
				}else {
					
				}
				if(mes<10)
				{
					mesStr="0"+mes;
				}else {
					
				}
				if(diaStr!=null && mesStr!=null)
				{
					fecha="2020"+"-"+mesStr+"-"+diaStr;
				}else if(diaStr!=null && mesStr==null){
					fecha="2020"+"-"+mes+"-"+diaStr;	
				}else if(mesStr!=null && diaStr==null){
					fecha="2020"+"-"+mesStr+"-"+dia;
				}else if(mesStr==null && diaStr==null){
					fecha="2020"+"-"+mes+"-"+dia;
				}
				try {
	        		query = "SELECT * FROM `Venta Boleto` WHERE `Fecha` = ? AND `ID_Usuario`= ? ";
	            	pstm = con.prepareStatement(query);
	            	pstm.setString(1,fecha);
	            	pstm.setInt(2,Id);
	            	rs = pstm.executeQuery(); 
	            	while(rs.next()) {
	            		int venta = rs.getInt("ID_VentaBoleto"); 
	            		int dinero = rs.getInt("Costo_Total");
	            		String hora = rs.getString("Hora");
	            		
	            		lista.addElement(" ");
	                	lista.addElement(fecha+"	                  					"+hora+"		                         						"+Id+"                                      "+venta+"                                                                               "+dinero);
	                	lista.addElement("_________________________________________________________________________________________________________________________________");
	            	}
	            	query = "SELECT * FROM `Venta Dulceria` WHERE `Fecha_VentaDulc` = ? AND `ID_Usuario`= ? ";
	            	pstm = con.prepareStatement(query);
	            	pstm.setString(1,fecha);
	            	pstm.setInt(2,Id);
	            	rs = pstm.executeQuery(); 
	            	while(rs.next()) {
	            		int venta = rs.getInt("ID_VentaDulceria"); 
	            		int dinero = rs.getInt("Costo_Total_Dulc");
	            		String hora = rs.getString("Hora_VentaDulc");
	            		
	            		lista.addElement(" ");
	                	lista.addElement(fecha+"	                  					"+hora+"		                         						"+Id+"                                      "+venta+"                                                                               "+dinero);
	                	lista.addElement("_________________________________________________________________________________________________________________________________");
	            	}
	            } catch (SQLException e1) {	
	            }
				
				
			}
			
			
		}else {
		}
	}
}