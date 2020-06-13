package Interfaces;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class SeleccionarPelicula extends JFrame implements ActionListener {

    private JButton btn_1, btn_2, btn_3, btn_cambiarDulcería, btn_corteBoleto;
    private JPanel panel1, panel2, panel3;
    public JButton btn_peli1_hora1, btn_peli1_hora2, btn_peli1_hora3, btn_peli2_hora1, btn_peli2_hora2, btn_peli2_hora3, btn_peli3_hora1, btn_peli3_hora2, btn_peli3_hora3;
    public JButton btn_peli4_hora1, btn_peli4_hora2, btn_peli4_hora3, btn_peli5_hora1, btn_peli5_hora2, btn_peli5_hora3, btn_peli6_hora1, btn_peli6_hora2, btn_peli6_hora3;
    public JButton btn_peli7_hora1, btn_peli7_hora2, btn_peli7_hora3,btn_peli8_hora1, btn_peli8_hora2, btn_peli8_hora3, btn_peli9_hora1, btn_peli9_hora2, btn_peli9_hora3;
    private static final long serialVersionUID = 1L;
    public JLayeredPane layeredPane;
    //	BASE DE DATOS
    Connection con = ConexionBD.conectar();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Statement stm = null;
    String query = "";
    //SALA SELECCIONADA
    public static int sala_sel;
    public static int funcion;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SeleccionarPelicula frame = new SeleccionarPelicula();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public SeleccionarPelicula() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(72,81,84));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(51, 71, 842, 476);
        layeredPane.setBackground(new Color(46, 48, 48));
        contentPane.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        panel1 = new JPanel();
        layeredPane.add(panel1, "name_16688486857900");
        panel1.setBackground(new Color(46, 48, 48));
        panel1.setLayout(null);

        panel2 = new JPanel();
        layeredPane.add(panel2, "name_19247193436600");
        panel2.setBackground(new Color(46, 48, 48));
        panel2.setLayout(null);

        panel3 = new JPanel();
        layeredPane.add(panel3, "name_16691971147000");
        panel3.setBackground(new Color(46, 48, 48));
        panel3.setLayout(null);

        JLabel lbl_titulo = new JLabel("Funciones disponibles:");
        lbl_titulo.setForeground(Color.WHITE);
        lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 40));
        lbl_titulo.setBounds(194, 11, 555, 57);
        contentPane.add(lbl_titulo);

        btn_cambiarDulcería = new JButton("Cambiar a Dulcer\u00EDa");
        btn_cambiarDulcería.setFont(new Font("Arial Black", Font.BOLD, 12));
        btn_cambiarDulcería.setBackground(new Color(171, 0 ,51));
        btn_cambiarDulcería.setBounds(10, 558, 175, 32);
        contentPane.add(btn_cambiarDulcería);

        btn_corteBoleto = new JButton("Corte de Boleto");
        btn_corteBoleto.setFont(new Font("Arial Black", Font.BOLD, 12));
        btn_corteBoleto.setBackground(new Color(171, 0, 51));
        btn_corteBoleto.setBounds(759, 558, 175, 32);
        contentPane.add(btn_corteBoleto);

        btn_1 = new JButton("Página 1");
        btn_1.setBounds(329, 560, 90, 20);
        btn_1.setBackground(new Color(255,255,255));
        btn_1.addActionListener(this);
        contentPane.add(btn_1);

        btn_2 = new JButton("P\u00E1gina 2");
        btn_2.setBackground(new Color(255,255,255));
        btn_2.setBounds(429, 560, 90, 20);
        btn_2.addActionListener(this);
        contentPane.add(btn_2);

        btn_3 = new JButton("P\u00E1gina 3");
        btn_3.setBackground(new Color(255, 255, 255));
        btn_3.setBounds(529, 560, 90, 20);
        btn_3.addActionListener(this);
        contentPane.add(btn_3);
        

        //Contenidos Panel1

        JLabel lbl_peli1_nombre = new JLabel("Nombre Pel\u00EDcula 1");
        lbl_peli1_nombre.setForeground(Color.WHITE);
        lbl_peli1_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli1_nombre.setBounds(120, 11, 212, 32);
        panel1.add(lbl_peli1_nombre);

        btn_peli1_hora1 = new JButton("Horario 1");
        btn_peli1_hora1.setBackground(new Color(171, 0,51));
        btn_peli1_hora1.setBounds(230, 45, 161, 66);
        panel1.add(btn_peli1_hora1);

        btn_peli1_hora2 = new JButton("Horario 2");
        btn_peli1_hora2.setBackground(new Color(171, 50, 51));
        btn_peli1_hora2.setBounds(390, 45, 161, 66);
        panel1.add(btn_peli1_hora2);

        btn_peli1_hora3 = new JButton("Horario 3");
        btn_peli1_hora3.setBackground(new Color(171, 0,51));
        btn_peli1_hora3.setBounds(550, 45, 152, 66);
        panel1.add(btn_peli1_hora3);

        JLabel lbl_peli1_horarios = new JLabel("Horarios:");
        lbl_peli1_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli1_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli1_horarios.setBounds(120, 64, 101, 23);
        panel1.add(lbl_peli1_horarios);


        JLabel lbl_peli2_nombre = new JLabel("Nombre Pel\u00EDcula 2");
        lbl_peli2_nombre.setForeground(Color.WHITE);
        lbl_peli2_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli2_nombre.setBounds(120, 137, 212, 32);
        panel1.add(lbl_peli2_nombre);

        btn_peli2_hora1 = new JButton("Horario 1");
        btn_peli2_hora1.setBackground(new Color(171, 0,51));
        btn_peli2_hora1.setBounds(230, 171, 161, 66);
        panel1.add(btn_peli2_hora1);

        btn_peli2_hora2 = new JButton("Horario 2");
        btn_peli2_hora2.setBackground(new Color(171, 50, 51));
        btn_peli2_hora2.setBounds(390, 171, 161, 66);
        panel1.add(btn_peli2_hora2);

        btn_peli2_hora3 = new JButton("Horario 3");
        btn_peli2_hora3.setBackground(new Color(171, 0,51));
        btn_peli2_hora3.setBounds(550, 171, 152, 66);
        panel1.add(btn_peli2_hora3);

        JLabel lbl_peli2_horarios = new JLabel("Horarios:");
        lbl_peli2_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli2_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli2_horarios.setBounds(120, 190, 101, 23);
        panel1.add(lbl_peli2_horarios);


        JLabel lbl_peli3_nombre = new JLabel("Nombre Pel\u00EDcula 3");
        lbl_peli3_nombre.setForeground(Color.WHITE);
        lbl_peli3_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli3_nombre.setBounds(120, 266, 212, 32);
        panel1.add(lbl_peli3_nombre);

        btn_peli3_hora1 = new JButton("Horario 1");
        btn_peli3_hora1.setBackground(new Color(171, 0,51));
        btn_peli3_hora1.setBounds(230, 300, 161, 66);
        panel1.add(btn_peli3_hora1);

        btn_peli3_hora2 = new JButton("Horario 2");
        btn_peli3_hora2.setBackground(new Color(171, 50, 51));
        btn_peli3_hora2.setBounds(390, 300, 161, 66);
        panel1.add(btn_peli3_hora2);

        btn_peli3_hora3 = new JButton("Horario 3");
        btn_peli3_hora3.setBackground(new Color(171, 0,51));
        btn_peli3_hora3.setBounds(550, 300, 152, 66);
        panel1.add(btn_peli3_hora3);

        JLabel lbl_peli3_horarios = new JLabel("Horarios:");
        lbl_peli3_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli3_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli3_horarios.setBounds(120, 319, 101, 23);
        panel1.add(lbl_peli3_horarios);

        //Contenidos Panel2


        JLabel lbl_peli4_nombre = new JLabel("Nombre Pel\u00EDcula 4");
        lbl_peli4_nombre.setForeground(Color.WHITE);
        lbl_peli4_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli4_nombre.setBounds(120, 11, 212, 32);
        panel2.add(lbl_peli4_nombre);

        btn_peli4_hora1 = new JButton("Horario 1");
        btn_peli4_hora1.setBackground(new Color(171, 0,51));
        btn_peli4_hora1.setBounds(230, 45, 161, 66);
        panel2.add(btn_peli4_hora1);

        btn_peli4_hora2 = new JButton("Horario 2");
        btn_peli4_hora2.setBackground(new Color(171, 50, 51));
        btn_peli4_hora2.setBounds(390, 45, 161, 66);
        panel2.add(btn_peli4_hora2);

        btn_peli4_hora3 = new JButton("Horario 3");
        btn_peli4_hora3.setBackground(new Color(171, 0,51));
        btn_peli4_hora3.setBounds(550, 45, 152, 66);
        panel2.add(btn_peli4_hora3);

        JLabel lbl_peli4_horarios = new JLabel("Horarios:");
        lbl_peli4_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli4_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli4_horarios.setBounds(120, 64, 101, 23);
        panel2.add(lbl_peli4_horarios);


        JLabel lbl_peli5_nombre = new JLabel("Nombre Pel\u00EDcula 5");
        lbl_peli5_nombre.setForeground(Color.WHITE);
        lbl_peli5_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli5_nombre.setBounds(120, 137, 212, 32);
        panel2.add(lbl_peli5_nombre);

        btn_peli5_hora1 = new JButton("Horario 1");
        btn_peli5_hora1.setBackground(new Color(171, 0,51));
        btn_peli5_hora1.setBounds(230, 171, 161, 66);
        panel2.add(btn_peli5_hora1);

        btn_peli5_hora2 = new JButton("Horario 2");
        btn_peli5_hora2.setBackground(new Color(171, 50, 51));
        btn_peli5_hora2.setBounds(390, 171, 161, 66);
        panel2.add(btn_peli5_hora2);

        btn_peli5_hora3 = new JButton("Horario 3");
        btn_peli5_hora3.setBackground(new Color(171, 0,51));
        btn_peli5_hora3.setBounds(550, 171, 152, 66);
        panel2.add(btn_peli5_hora3);

        JLabel lbl_peli5_horarios = new JLabel("Horarios:");
        lbl_peli5_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli5_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli5_horarios.setBounds(120, 190, 101, 23);
        panel2.add(lbl_peli5_horarios);

        JLabel lbl_peli6_nombre = new JLabel("Nombre Pel\u00EDcula 6");
        lbl_peli6_nombre.setForeground(Color.WHITE);
        lbl_peli6_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli6_nombre.setBounds(120, 266, 212, 32);
        panel2.add(lbl_peli6_nombre);

        btn_peli6_hora1 = new JButton("Horario 1");
        btn_peli6_hora1.setBackground(new Color(171, 0,51));
        btn_peli6_hora1.setBounds(230, 300, 161, 66);
        panel2.add(btn_peli6_hora1);

        btn_peli6_hora2 = new JButton("Horario 2");
        btn_peli6_hora2.setBackground(new Color(171, 50, 51));
        btn_peli6_hora2.setBounds(390, 300, 161, 66);
        panel2.add(btn_peli6_hora2);

        btn_peli6_hora3 = new JButton("Horario 3");
        btn_peli6_hora3.setBackground(new Color(171, 0,51));
        btn_peli6_hora3.setBounds(550, 300, 152, 66);
        panel2.add(btn_peli6_hora3);

        JLabel lbl_peli6_horarios = new JLabel("Horarios:");
        lbl_peli6_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli6_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli6_horarios.setBounds(120, 319, 101, 23);
        panel2.add(lbl_peli6_horarios);

        //Contenido Panel 3


        JLabel lbl_peli7_nombre = new JLabel("Nombre Pel\u00EDcula 7");
        lbl_peli7_nombre.setForeground(Color.WHITE);
        lbl_peli7_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli7_nombre.setBounds(120, 11, 212, 32);
        panel3.add(lbl_peli7_nombre);

        btn_peli7_hora1 = new JButton("Horario 1");
        btn_peli7_hora1.setBackground(new Color(171, 0,51));
        btn_peli7_hora1.setBounds(230, 45, 161, 66);
        panel3.add(btn_peli7_hora1);

        btn_peli7_hora2 = new JButton("Horario 2");
        btn_peli7_hora2.setBackground(new Color(171, 50, 51));
        btn_peli7_hora2.setBounds(390, 45, 161, 66);
        panel3.add(btn_peli7_hora2);

        btn_peli7_hora3 = new JButton("Horario 3");
        btn_peli7_hora3.setBackground(new Color(171, 0,51));
        btn_peli7_hora3.setBounds(550, 45, 152, 66);
        panel3.add(btn_peli7_hora3);

        JLabel lbl_peli7_horarios = new JLabel("Horarios:");
        lbl_peli7_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli7_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli7_horarios.setBounds(120, 64, 101, 23);
        panel3.add(lbl_peli7_horarios);

        JLabel lbl_peli8_img = new JLabel("Imagen Pel\u00EDcula 8");
        lbl_peli8_img.setForeground(Color.BLACK);
        lbl_peli8_img.setBackground(Color.YELLOW);
        lbl_peli8_img.setBounds(10, 137, 100, 100);
        panel3.add(lbl_peli8_img);

        JLabel lbl_peli8_nombre = new JLabel("Nombre Pel\u00EDcula 8");
        lbl_peli8_nombre.setForeground(Color.WHITE);
        lbl_peli8_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli8_nombre.setBounds(120, 137, 212, 32);
        panel3.add(lbl_peli8_nombre);

        btn_peli8_hora1= new JButton("Horario 1");
        btn_peli8_hora1.setBackground(new Color(171, 0,51));
        btn_peli8_hora1.setBounds(230, 171, 161, 66);
        panel3.add(btn_peli8_hora1);

        btn_peli8_hora2 = new JButton("Horario 2");
        btn_peli8_hora2.setBackground(new Color(171, 50, 51));
        btn_peli8_hora2.setBounds(390, 171, 161, 66);
        panel3.add(btn_peli8_hora2);

        btn_peli8_hora3 = new JButton("Horario 3");
        btn_peli8_hora3.setBackground(new Color(171, 0,51));
        btn_peli8_hora3.setBounds(550, 171, 152, 66);
        panel3.add(btn_peli8_hora3);

        JLabel lbl_peli8_horarios = new JLabel("Horarios:");
        lbl_peli8_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli8_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli8_horarios.setBounds(120, 190, 101, 23);
        panel3.add(lbl_peli8_horarios);

        JLabel lbl_peli9_nombre = new JLabel("Nombre Pel\u00EDcula 9");
        lbl_peli9_nombre.setForeground(Color.WHITE);
        lbl_peli9_nombre.setFont(new Font("Arial", Font.BOLD, 22));
        lbl_peli9_nombre.setBounds(120, 266, 212, 32);
        panel3.add(lbl_peli9_nombre);

        btn_peli9_hora1 = new JButton("Horario 1");
        btn_peli9_hora1.setBackground(new Color(171, 0,51));
        btn_peli9_hora1.setBounds(230, 300, 161, 66);
        panel3.add(btn_peli9_hora1);

        btn_peli9_hora2 = new JButton("Horario 2");
        btn_peli9_hora2.setBackground(new Color(171, 50, 51));
        btn_peli9_hora2.setBounds(390, 300, 161, 66);
        panel3.add(btn_peli9_hora2);

        btn_peli9_hora3 = new JButton("Horario 3");
        btn_peli9_hora3.setBackground(new Color(171, 0,51));
        btn_peli9_hora3.setBounds(550, 300, 152, 66);
        panel3.add(btn_peli9_hora3);

        JLabel lbl_peli9_horarios = new JLabel("Horarios:");
        lbl_peli9_horarios.setForeground(new Color(171, 50, 51));
        lbl_peli9_horarios.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_peli9_horarios.setBounds(120, 319, 101, 23);
        panel3.add(lbl_peli9_horarios);

        //Se me olvidaron los action listeners.
        btn_corteBoleto.addActionListener(this);
        btn_cambiarDulcería.addActionListener(this);
        btn_peli1_hora1.addActionListener(this);
        btn_peli1_hora2.addActionListener(this);
        btn_peli1_hora3.addActionListener(this);
        btn_peli2_hora1.addActionListener(this);
        btn_peli2_hora2.addActionListener(this);
        btn_peli2_hora3.addActionListener(this);
        btn_peli3_hora1.addActionListener(this);
        btn_peli3_hora2.addActionListener(this);
        btn_peli3_hora3.addActionListener(this);
        btn_peli4_hora1.addActionListener(this);
        btn_peli4_hora2.addActionListener(this);
        btn_peli4_hora3.addActionListener(this);
        btn_peli5_hora1.addActionListener(this);
        btn_peli5_hora2.addActionListener(this);
        btn_peli5_hora3.addActionListener(this);
        btn_peli6_hora1.addActionListener(this);
        btn_peli6_hora2.addActionListener(this);
        btn_peli6_hora3.addActionListener(this);
        btn_peli7_hora1.addActionListener(this);
        btn_peli7_hora2.addActionListener(this);
        btn_peli7_hora3.addActionListener(this);
        btn_peli8_hora1.addActionListener(this);
        btn_peli8_hora2.addActionListener(this);
        btn_peli8_hora3.addActionListener(this);
        btn_peli9_hora1.addActionListener(this);
        btn_peli9_hora2.addActionListener(this);
        btn_peli9_hora3.addActionListener(this);

        //CONTAR CUANTAS PELICULAS DISTINTAS HAY
        query = "SELECT COUNT(DISTINCT ID_Peli) FROM Funcion;";
        stm = con.createStatement();
        rs = stm.executeQuery(query);
        int cant_pelis = 0;
		//Empezamos a contar
		while(rs.next())
		{
			cant_pelis = rs.getInt(1); //devuelve el valor que tuvimos del result set
		}
        //SACAR LAS CLAVES DE LAS PELIS
        query = "SELECT DISTINCT ID_Peli FROM Funcion";
        stm = con.createStatement();
        rs = stm.executeQuery(query);
        int[] id_peliculas = new int[cant_pelis];
		//Empezamos a contar
        int i=0;
		while(rs.next())
		{
			 id_peliculas[i]=rs.getInt("ID_Peli"); //devuelve el valor que tuvimos del result set
			 i++;
		}
		//CONSIGUE EL NOMBRE DE LAS PELICULAS
		String[] nom_peli = new String[10];
		
		for(i=0; i<cant_pelis; i++)
		{
		query = "SELECT Nombre FROM Pelicula WHERE ID_Pelicula=?";
		pstm=con.prepareStatement(query);
    	pstm.setInt(1, id_peliculas[i]);
    	rs = pstm.executeQuery();
    		while(rs.next())
    		{
    			nom_peli[i]=rs.getString(1);
    		}
		}
		
		
		//DESACTIVACION DE FUNCIONES
    	switch(cant_pelis)
		{
		case 0: showMessageDialog(null, "NO HAY FUNCIONES, CONTACTE A SU ADMINISTRADOR"); break;
		case 1: desactivo1();
		lbl_peli1_nombre.setText(nom_peli[0]);
		
        lbl_peli2_nombre.setVisible(false);
        lbl_peli3_nombre.setVisible(false);
        lbl_peli2_horarios.setVisible(false);
        lbl_peli3_horarios.setVisible(false);
        break;
		case 2: desactivo2();
		lbl_peli1_nombre.setText(nom_peli[0]);
		lbl_peli2_nombre.setText(nom_peli[1]);
        lbl_peli3_nombre.setVisible(false);
        lbl_peli3_horarios.setVisible(false);
		break;
		case 3: 
			desactivo3();
			lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			break;
		case 4:
			desactivo4();
			lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setVisible(false);
			lbl_peli6_nombre.setVisible(false);
			lbl_peli5_horarios.setVisible(false);
			lbl_peli6_horarios.setVisible(false);
		break;
		case 5:
			desactivo5();
			lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setText(nom_peli[4]);
			lbl_peli6_nombre.setVisible(false);
			lbl_peli6_horarios.setVisible(false);
		break;
		case 6: 
			lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setText(nom_peli[4]);
			lbl_peli6_nombre.setText(nom_peli[5]);
			btn_3.setVisible(false); break;
		case 7:
			desactivo7();
			lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setText(nom_peli[4]);
			lbl_peli6_nombre.setText(nom_peli[5]);
			lbl_peli7_nombre.setText(nom_peli[6]);
			lbl_peli8_nombre.setVisible(false);
			lbl_peli9_nombre.setVisible(false);
			lbl_peli8_horarios.setVisible(false);
			lbl_peli9_horarios.setVisible(false);
		break;
    	case 8: 
    		desactivo8();
    		lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setText(nom_peli[4]);
			lbl_peli6_nombre.setText(nom_peli[5]);
			lbl_peli7_nombre.setText(nom_peli[6]);
			lbl_peli8_nombre.setText(nom_peli[7]);
    		lbl_peli9_nombre.setVisible(false);
    		lbl_peli9_horarios.setVisible(false);
    	break;
    	case 9:
    		desactivo8();
    		lbl_peli1_nombre.setText(nom_peli[0]);
			lbl_peli2_nombre.setText(nom_peli[1]);
			lbl_peli3_nombre.setText(nom_peli[2]);
			lbl_peli4_nombre.setText(nom_peli[3]);
			lbl_peli5_nombre.setText(nom_peli[4]);
			lbl_peli6_nombre.setText(nom_peli[5]);
			lbl_peli7_nombre.setText(nom_peli[6]);
			lbl_peli8_nombre.setText(nom_peli[7]);
    		lbl_peli9_nombre.setText(nom_peli[8]);
    		break;
		}
    	
    	//DESACTIVACION DE HORARIOS
    	//CONTAR CUANTOS HORARIOS TIENE CADA PELICULA
    	int cont_horarios=0;
    	int numero_peli=1;
    	String nom_hor[] = new String[3];
    	int j=0;
    	for(i=0; i<id_peliculas.length; i++) {
    	query = "SELECT Hora_Peli FROM Funcion WHERE ID_Peli=?";
    	pstm=con.prepareStatement(query);
    	pstm.setInt(1, id_peliculas[i]);
    	rs = pstm.executeQuery();
    	while(rs.next())
    	{
    		cont_horarios++;
    		nom_hor[j]= rs.getString("Hora_Peli"); 
    		j++;
    	}
    	System.out.println(cont_horarios);
    	rs.first(); //REGRESA A LA PRIMERA COLUMNA
    	//DEPENDE QUE PELI 
    	switch(numero_peli)
    	{ //DESACTIVA BOTONES DE HORARIO EN ESA PELI
    	case 1:
    		des_hor1(cont_horarios, nom_hor); 
    		break;
    	case 2:
    		des_hor2(cont_horarios, nom_hor); 
    		break;
    	case 3: des_hor3(cont_horarios, nom_hor); break;
    	case 4: des_hor4(cont_horarios, nom_hor); break;
    	case 5: des_hor5(cont_horarios, nom_hor); break;
    	case 6: des_hor6(cont_horarios, nom_hor); break;
    	case 7: des_hor7(cont_horarios, nom_hor); break;
    	case 8: des_hor8(cont_horarios, nom_hor); break;
    	case 9: des_hor9(cont_horarios, nom_hor); break;
    	}
    	
    	numero_peli++;
    	cont_horarios=0; //REINICIO
    	j=0;
    	
    	}
    	
    	
 
    }


	
	
	@Override
    //TODO: Realizar la conexion a SQL para mostrar de manera actualizada los asientos de la siguiente interfaz.
    public void actionPerformed(ActionEvent e) {
		String hor_sel = "";
        if(e.getSource()==btn_1){
            switchPane(panel1);
        }else if(e.getSource() == btn_2){
            switchPane(panel2);
        }else if(e.getSource() == btn_3){
            switchPane(panel3);
        }else if(e.getSource() == btn_corteBoleto){
        	CorteBoleto.opc_corte=false;
            CorteBoleto corteBoleto = new CorteBoleto();
            corteBoleto.setVisible(true);
            cerrar_conexion();
            dispose();
        }else if(e.getSource() == btn_cambiarDulcería){
        	hor_sel = btn_peli2_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            VentaDulceria ventaDulceria = new VentaDulceria();
            ventaDulceria.setVisible(true);
            cerrar_conexion();
            dispose();
        }else if(e.getSource() == btn_peli1_hora1){
        	hor_sel = btn_peli1_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();


        }else if(e.getSource() == btn_peli1_hora2){
        	hor_sel = btn_peli1_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli1_hora3){
        	hor_sel = btn_peli1_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli2_hora1){
        	hor_sel = btn_peli2_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli2_hora2){
        	hor_sel = btn_peli2_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli2_hora3){
        	hor_sel = btn_peli2_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli3_hora1){
        	hor_sel = btn_peli3_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli3_hora2){
        	hor_sel = btn_peli3_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli3_hora3){
        	hor_sel = btn_peli3_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli4_hora1){
        	hor_sel = btn_peli4_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli4_hora2){
        	hor_sel = btn_peli4_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli4_hora3){
        	hor_sel = btn_peli4_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli5_hora1){
        	hor_sel = btn_peli5_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli5_hora2){
        	hor_sel = btn_peli5_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli5_hora3){
        	hor_sel = btn_peli5_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            dispose();

        }else if(e.getSource() == btn_peli6_hora1){
        	hor_sel = btn_peli6_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli6_hora2){
        	hor_sel = btn_peli6_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli6_hora3){
        	hor_sel = btn_peli6_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli7_hora1){
        	hor_sel = btn_peli7_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli7_hora2){
        	hor_sel = btn_peli7_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli7_hora3){
        	hor_sel = btn_peli7_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli8_hora1){
        	hor_sel = btn_peli8_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli8_hora2){
        	hor_sel = btn_peli8_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli8_hora3){
        	hor_sel = btn_peli8_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli9_hora1){
        	hor_sel = btn_peli9_hora1.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli9_hora2){
        	hor_sel = btn_peli9_hora2.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();

        }else if(e.getSource() == btn_peli9_hora3){
        	hor_sel = btn_peli9_hora3.getText();
        	obtener_sala_y_funcion(hor_sel);
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            cerrar_conexion();
            dispose();
        }

    }

    private void cerrar_conexion() {
    	try {
            rs.close(); //SI UTILIZAS RS
pstm.close(); //SI UTILIZAS PREPARE STATEMENT
con.close(); //ESTE SI A HUEVO
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
	}
	private void obtener_sala_y_funcion(String hor_sel) {
		query = "SELECT Num_Sala, ID_Funcion FROM Funcion WHERE Hora_Peli=?";
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, hor_sel);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				SeleccionarPelicula.sala_sel = rs.getInt("Num_Sala");
				SeleccionarPelicula.funcion = rs.getInt("ID_Funcion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sala_sel);
		System.out.println(funcion);
	}
    
    
	public void switchPane(JPanel panel){
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    
    
    //DESACTIVAR TODO DE FUNCIONES
	private void desactivo8() {
		btn_peli9_hora1.setVisible(false);
        btn_peli9_hora2.setVisible(false);
        btn_peli9_hora3.setVisible(false);
	}
	private void desactivo7() {
		btn_peli8_hora1.setVisible(false);
        btn_peli8_hora2.setVisible(false);
        btn_peli8_hora3.setVisible(false);
        btn_peli9_hora1.setVisible(false);
        btn_peli9_hora2.setVisible(false);
        btn_peli9_hora3.setVisible(false);
		
	}
	private void desactivo5() {
		btn_peli6_hora1.setVisible(false);
        btn_peli6_hora2.setVisible(false);
        btn_peli6_hora3.setVisible(false);
        btn_3.setVisible(false);
	}
	private void desactivo4() {
		btn_peli5_hora1.setVisible(false);
        btn_peli5_hora2.setVisible(false);
        btn_peli5_hora3.setVisible(false);
        btn_peli6_hora1.setVisible(false);
        btn_peli6_hora2.setVisible(false);
        btn_peli6_hora3.setVisible(false);
        btn_3.setVisible(false);

	}
	private void desactivo3() {
		btn_1.setVisible(false);
		btn_2.setVisible(false);
		btn_3.setVisible(false);
	}
	private void desactivo2() {
		btn_peli3_hora1.setVisible(false);
        btn_peli3_hora2.setVisible(false);
        btn_peli3_hora3.setVisible(false);
        btn_1.setVisible(false);
		btn_2.setVisible(false);
		btn_3.setVisible(false);
	}
	private void desactivo1() {

		//DESHABILITA LO QUE NO
		btn_peli2_hora1.setVisible(false);
        btn_peli2_hora2.setVisible(false);
        btn_peli2_hora3.setVisible(false);
        btn_peli3_hora1.setVisible(false);
        btn_peli3_hora2.setVisible(false);
        btn_peli3_hora3.setVisible(false);
        btn_1.setVisible(false);
		btn_2.setVisible(false);
		btn_3.setVisible(false);
	}
	
	//DESACTIVACION DE BOTONES HORARIO
	private void des_hor1(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli1_hora1.setText(nom_hor[0]);
			btn_peli1_hora2.setVisible(false);
			btn_peli1_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli1_hora1.setText(nom_hor[0]);
			btn_peli1_hora2.setText(nom_hor[1]);
			btn_peli1_hora3.setVisible(false);
			break;
		case 3:
			btn_peli1_hora1.setText(nom_hor[0]);
			btn_peli1_hora2.setText(nom_hor[1]);
			btn_peli1_hora3.setText(nom_hor[2]);
			break;
		}
	}
	
	private void des_hor2(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli2_hora1.setText(nom_hor[0]);
			btn_peli2_hora2.setVisible(false);
			btn_peli2_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli2_hora1.setText(nom_hor[0]);
			btn_peli2_hora2.setText(nom_hor[1]);
			btn_peli2_hora3.setVisible(false);
			break;
		case 3:
			btn_peli2_hora1.setText(nom_hor[0]);
			btn_peli2_hora2.setText(nom_hor[1]);
			btn_peli2_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor3(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli3_hora1.setText(nom_hor[0]);
			btn_peli3_hora2.setVisible(false);
			btn_peli3_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli3_hora1.setText(nom_hor[0]);
			btn_peli3_hora2.setText(nom_hor[1]);
			btn_peli3_hora3.setVisible(false);
			break;
		case 3:
			btn_peli3_hora1.setText(nom_hor[0]);
			btn_peli3_hora2.setText(nom_hor[1]);
			btn_peli3_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
		
	private void des_hor4(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli4_hora1.setText(nom_hor[0]);
			btn_peli4_hora2.setVisible(false);
			btn_peli4_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli4_hora1.setText(nom_hor[0]);
			btn_peli4_hora2.setText(nom_hor[1]);
			btn_peli4_hora3.setVisible(false);
			break;
		case 3:
			btn_peli4_hora1.setText(nom_hor[0]);
			btn_peli4_hora2.setText(nom_hor[1]);
			btn_peli4_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor5(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli5_hora1.setText(nom_hor[0]);
			btn_peli5_hora2.setVisible(false);
			btn_peli5_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli5_hora1.setText(nom_hor[0]);
			btn_peli5_hora2.setText(nom_hor[1]);
			btn_peli5_hora3.setVisible(false);
			break;
		case 3:
			btn_peli5_hora1.setText(nom_hor[0]);
			btn_peli5_hora2.setText(nom_hor[1]);
			btn_peli5_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor6(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli6_hora1.setText(nom_hor[0]);
			btn_peli6_hora2.setVisible(false);
			btn_peli6_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli6_hora1.setText(nom_hor[0]);
			btn_peli6_hora2.setText(nom_hor[1]);
			btn_peli6_hora3.setVisible(false);
			break;
		case 3:
			btn_peli6_hora1.setText(nom_hor[0]);
			btn_peli6_hora2.setText(nom_hor[1]);
			btn_peli6_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor7(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli7_hora1.setText(nom_hor[0]);
			btn_peli7_hora2.setVisible(false);
			btn_peli7_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli7_hora1.setText(nom_hor[0]);
			btn_peli7_hora2.setText(nom_hor[1]);
			btn_peli7_hora3.setVisible(false);
			break;
		case 3:
			btn_peli7_hora1.setText(nom_hor[0]);
			btn_peli7_hora2.setText(nom_hor[1]);
			btn_peli7_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor8(int cont_horarios, String[] nom_hor) {
		switch (cont_horarios)
		{
		case 1: 
			btn_peli8_hora1.setText(nom_hor[0]);
			btn_peli8_hora2.setVisible(false);
			btn_peli8_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli8_hora1.setText(nom_hor[0]);
			btn_peli8_hora2.setText(nom_hor[1]);
			btn_peli8_hora3.setVisible(false);
			break;
		case 3:
			btn_peli8_hora1.setText(nom_hor[0]);
			btn_peli8_hora2.setText(nom_hor[1]);
			btn_peli8_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
	
	private void des_hor9(int cont_horarios, String[] nom_hor) {
		
		
		switch (cont_horarios)
		{
		case 1: 
			btn_peli9_hora1.setText(nom_hor[0]);
			btn_peli9_hora2.setVisible(false);
			btn_peli9_hora3.setVisible(false);
			break;
		case 2: 
			btn_peli9_hora1.setText(nom_hor[0]);
			btn_peli9_hora2.setText(nom_hor[1]);
			btn_peli9_hora3.setVisible(false);
			break;
		case 3:
			btn_peli9_hora1.setText(nom_hor[0]);
			btn_peli9_hora2.setText(nom_hor[1]);
			btn_peli9_hora3.setText(nom_hor[2]);
			break;
		}
		
	}
}