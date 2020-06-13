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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class registrarNuevaFuncion implements ActionListener{
	
	public JFrame frame;
	private JTextField textIdPelicula, textDd, textMm, textAaaa, textHh, textHoraMm,textIdFuncion;
	 private JSpinner spinner_horas, spinner_dia, spinner_anio, spinner_minutos, spinner_mes, spinner_sala;
	Connection con = ConexionBD.conectar();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    Statement stm = null;
    String query = "";
    String query2 = "";
    String query3 = "";
    private JButton btnVolver,btnRegistrar;
    private String[] meses = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private String[] salas = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09"};
    
    
    private String[] dias = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    
    private String[] horas = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    
    private String[] anio = new String[] {"2020"};
    
    private String[] minutos = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34"
    , "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    
    
    menuFunciones menuFunciones = new menuFunciones();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarNuevaFuncion window = new registrarNuevaFuncion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registrarNuevaFuncion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
        frame.getContentPane().setFocusable(false);
        frame.setBounds(100, 100, 960, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960,640);
        frame.getContentPane().setLayout(null);


        frame.getContentPane().setBackground(new Color(72,81,84));



        JLabel lblEditar = new JLabel("Registrar funcion");
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Arial", Font.BOLD, 40));
        lblEditar.setBounds(370, 58, 350, 72);
        frame.getContentPane().add(lblEditar);


        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);
        btnVolver.addActionListener(this);

        btnRegistrar = new JButton("Actualizar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnRegistrar.setBackground(new Color(171, 0, 51));
        btnRegistrar.setBounds(424, 419, 149, 39);
        frame.getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        JLabel lblNumero = new JLabel("Numero de sala:");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNumero.setBounds(520, 191, 170, 24);
        frame.getContentPane().add(lblNumero);

        

        JLabel lblIdPelicula = new JLabel("ID Pelicula:");
        lblIdPelicula.setForeground(Color.WHITE);
        lblIdPelicula.setFont(new Font("Arial", Font.PLAIN, 20));
        lblIdPelicula.setBounds(36, 185, 109, 24);
        frame.getContentPane().add(lblIdPelicula);

        textIdPelicula = new JTextField();
        textIdPelicula.setColumns(10);
        textIdPelicula.setBounds(155, 191, 226, 19);
        frame.getContentPane().add(textIdPelicula);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFecha.setBounds(36, 268, 68, 24);
        frame.getContentPane().add(lblFecha);


        JLabel lblMm = new JLabel("MM");
        lblMm.setForeground(Color.WHITE);
        lblMm.setFont(new Font("Arial", Font.PLAIN, 20));
        lblMm.setBounds(102, 268, 47, 24);
        frame.getContentPane().add(lblMm);

        JLabel lblDd = new JLabel("/ DD");
        lblDd.setForeground(Color.WHITE);
        lblDd.setFont(new Font("Arial", Font.PLAIN, 20));
        lblDd.setBounds(216, 268, 68, 24);
        frame.getContentPane().add(lblDd);

        JLabel lblAaaa = new JLabel("/ AAAA");
        lblAaaa.setForeground(Color.WHITE);
        lblAaaa.setFont(new Font("Arial", Font.PLAIN, 20));
        lblAaaa.setBounds(338, 268, 68, 24);
        frame.getContentPane().add(lblAaaa);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setForeground(Color.WHITE);
        lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHora.setBounds(36, 350, 68, 24);
        frame.getContentPane().add(lblHora);

        JLabel lblHh = new JLabel("HH");
        lblHh.setForeground(Color.WHITE);
        lblHh.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHh.setBounds(89, 350, 68, 24);
        frame.getContentPane().add(lblHh);

        JLabel lblHoraMm = new JLabel(": MM");
        lblHoraMm.setForeground(Color.WHITE);
        lblHoraMm.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHoraMm.setBounds(185, 350, 68, 24);
        frame.getContentPane().add(lblHoraMm);

        spinner_minutos = new JSpinner();
        SpinnerListModel modeloMinuto = new SpinnerListModel(minutos);
        spinner_minutos.setModel(modeloMinuto);
        spinner_minutos.setBounds(238, 354, 51, 20);
        ((JSpinner.DefaultEditor) spinner_minutos.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_minutos);

        spinner_mes = new JSpinner();
        SpinnerModel model_mes = new SpinnerListModel(meses);
        spinner_mes.setModel(model_mes);
        spinner_mes.setBounds(155, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_mes.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_mes);

        spinner_dia = new JSpinner();
        SpinnerListModel modeloDia = new SpinnerListModel(dias);
        spinner_dia.setModel(modeloDia);
        spinner_dia.setBounds(277, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_dia.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_dia);

        spinner_anio = new JSpinner();
        SpinnerListModel modeloAnio = new SpinnerListModel(anio);
        spinner_anio.setModel(modeloAnio);
        spinner_anio.setBounds(424, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_anio.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_anio);

        spinner_sala = new JSpinner();
		SpinnerListModel modeloSala = new SpinnerListModel(salas);
        spinner_sala.setModel(modeloSala);
        spinner_sala.setBounds(680, 191, 226, 20);
        ((JSpinner.DefaultEditor) spinner_sala.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_sala);

        spinner_horas = new JSpinner();
        SpinnerListModel modeloHora = new SpinnerListModel(horas);
        spinner_horas.setModel(modeloHora);
        spinner_horas.setBounds(124, 354, 51, 20);
        ((JSpinner.DefaultEditor) spinner_minutos.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_horas);
        
        

      
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==btnRegistrar) {
			
			insert();
			
			
		}
		else {
			menuFunciones.frame.setVisible(true);
			frame.dispose();
		}
	}
	/**/
	private void insert() {
		
		
		try {
		
			query = "SELECT ID_Pelicula FROM Pelicula WHERE ID_Pelicula="+textIdPelicula.getText();
			pstm=con.prepareStatement(query);
			rs=pstm.executeQuery();
			
			if(rs.next()){
				query2="SELECT Nombre FROM Pelicula WHERE ID_Pelicula="+textIdPelicula.getText();
				pstm=con.prepareStatement(query2);
				rs2=pstm.executeQuery();
				rs2.next();
				
				query3="SELECT Tipo FROM Sala WHERE Num_Sala="+spinner_sala.getValue();
				pstm=con.prepareStatement(query3);
				rs3=pstm.executeQuery();
				rs3.next();
				
				pstm =con.prepareStatement( "INSERT INTO Funcion (Num_Sala,ID_Peli,Nombre_Peli,Fecha_Peli,Hora_Peli,Tipo) VALUES(?,?,?,?,?,?)");
				
				pstm.setString(1, (String) spinner_sala.getValue());
				pstm.setString(2, textIdPelicula.getText());
				pstm.setString(3, rs2.getString(1));
				pstm.setString(4, (String) spinner_anio.getValue()+"-"+(String) spinner_mes.getValue()+"-"+(String) spinner_dia.getValue());
				pstm.setString(5, (String) spinner_horas.getValue()+":"+(String) spinner_minutos.getValue()+":00");
				pstm.setString(6, rs3.getString(1));
				
				int sc = pstm.executeUpdate();
				
				if(sc>0) {
					JOptionPane.showMessageDialog(null, "Se agrego la funcion");
					int opcion = JOptionPane.showConfirmDialog(null, "Se ha registrado correctamente la funcion!. \n\n¿Quiere registrar otra funcion?\n","Registrado",JOptionPane.YES_NO_OPTION);
					
					if(opcion==JOptionPane.YES_OPTION) {
						textIdPelicula.setText("");
						
					}
					else {
						menuFunciones.frame.setVisible(true);
						frame.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No se agrego");
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"No se encuentra el ID introducido");
			}
			rs.close();
			rs2.close();
			rs3.close();
       	 pstm.close();
       	 con.close();
		}
		catch(SQLException e) {
			
		e.printStackTrace();
		}
	}
}
