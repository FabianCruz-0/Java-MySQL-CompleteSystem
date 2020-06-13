package Interfaces;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeleccionarAsiento extends JFrame implements ActionListener, ChangeListener {
	String nomAsiento;
	InputStream stream2;
	ImageIcon icon2, icon;
	int precio,preciosCont;
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String[] categorias = new String[] {"Categoria","Adulto", "Niño", "VIP"};
    JButton btn_agregarAsiento, btn_volver, btn_continuar;
    private JLabel lbl_numAsiento, lbl_precio_dinero;
    private JSpinner spinner;
    private SpinnerListModel lista = new SpinnerListModel(categorias);
    private BotonPersonalizado btn_A1, btn_A2, btn_A3, btn_A4, btn_A5, btn_A6, btn_A7, btn_A8, btn_A9, btn_A10;
    private BotonPersonalizado btn_B1, btn_B2, btn_B3, btn_B4, btn_B5, btn_B6, btn_B7, btn_B8, btn_B9, btn_B10;
    private BotonPersonalizado btn_C1, btn_C2, btn_C3, btn_C4, btn_C5, btn_C6, btn_C7, btn_C8, btn_C9, btn_C10;
    private BotonPersonalizado btn_D1, btn_D2, btn_D3, btn_D4, btn_D5, btn_D6, btn_D7, btn_D8, btn_D9, btn_D10;
    private BotonPersonalizado btn_E1, btn_E2, btn_E3, btn_E4, btn_E5, btn_E6, btn_E7, btn_E8, btn_E9, btn_E10;
    private BotonPersonalizado btn_F1, btn_F2, btn_F3, btn_F4, btn_F5, btn_F6, btn_F7, btn_F8, btn_F9, btn_F10;
    private BotonPersonalizado btn_G1, btn_G2, btn_G3, btn_G4, btn_G5, btn_G6, btn_G7, btn_G8, btn_G9, btn_G10;
    private BotonPersonalizado btn_H1, btn_H2, btn_H3, btn_H4, btn_H5, btn_H6, btn_H7, btn_H8, btn_H9, btn_H10;
    private BotonPersonalizado btn_I1, btn_I2, btn_I3, btn_I4, btn_I5, btn_I6, btn_I7, btn_I8, btn_I9, btn_I10;
    private BotonPersonalizado btn_J1, btn_J2, btn_J3, btn_J4, btn_J5, btn_J6, btn_J7, btn_J8, btn_J9, btn_J10;
    
    ArrayList<BotonPersonalizado> botones = new ArrayList<BotonPersonalizado>();
    static ArrayList<String> botonesSeleccionados = new ArrayList<String>();
    ArrayList<String> asientosPreSeleccionados = new ArrayList<String>();
    ArrayList<String> asientosName = new ArrayList<String>();
    static ArrayList<Integer> precios = new ArrayList<Integer>();

    /**
     * Launch the application.
     */
    private Connection con = ConexionBD.conectar();
    public PreparedStatement pstm = null;
    ResultSet rs = null;
    String query="";
    //GUARDA LA SALA ESCOGIDA EN SELECCION DE PELICULA
    int sala = SeleccionarPelicula.sala_sel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        	SeleccionarAsiento f = new SeleccionarAsiento();
            public void run() {
                try {
                    SeleccionarAsiento frame = new SeleccionarAsiento();
                    frame.setVisible(true);
                    
                } catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
    
    private void selectAsiento() {
    	
       
    	try {
    		query = "SELECT Asiento FROM Asiento WHERE Disponibilidad = 0 AND Num_Sala=?";
        	pstm = con.prepareStatement(query);
        	pstm.setInt(1, sala);
        	rs = pstm.executeQuery();
        	
        	
        	while(rs.next()) {
        		String nom =rs.getString("Asiento");
        		
        		asientosPreSeleccionados.add(nom);

        	}
        } catch (SQLException e1) {
        	
        
        	
        		
        }
    	
    	for(BotonPersonalizado i: botones) {
    		i.setIcon(icon);
    	}
    	
    	for(String i: asientosPreSeleccionados) {
    		
    		for(BotonPersonalizado j: botones) {
    			
    			if(i.equals(j.getName())) {
    				j.setIcon(icon2);
    			}
    			
    		}
    		
    	}
    	
    
       
	}
    

    /**
     * Create the frame.
     */
    public SeleccionarAsiento() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72,81,84));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tipo de asiento:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
        lblNewLabel.setBounds(246, 11, 223, 43);
        contentPane.add(lblNewLabel);

        spinner = new JSpinner();
        spinner.setForeground(Color.WHITE);
        spinner.setBackground(new Color(171, 0, 51));
        spinner.setModel(lista);
        spinner.setBounds(439, 15, 223, 43);
        spinner.addChangeListener(this);
        JTextField ftf = getTextField(spinner);
        if (ftf != null ) {
            ftf.setColumns(8);
            ftf.setHorizontalAlignment(JTextField.RIGHT);
            ftf.setEditable(false);
            ftf.setBackground(new Color(171, 0, 51));
            ftf.setForeground(new Color(255, 255, 255));
        }
        
        spinner.addChangeListener(this);

        contentPane.add(spinner);

        JLabel lbl_asiento = new JLabel("Asiento:");
        lbl_asiento.setForeground(new Color(46, 48, 48));
        lbl_asiento.setBackground(new Color(46, 48, 48));
        lbl_asiento.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_asiento.setBounds(10, 60, 76, 43);
        contentPane.add(lbl_asiento);

        lbl_numAsiento = new JLabel("");
        lbl_numAsiento.setForeground(new Color(46, 48, 48));
        lbl_numAsiento.setBackground(new Color(46, 48, 48));
        lbl_numAsiento.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_numAsiento.setBounds(96, 60, 76, 43);
        contentPane.add(lbl_numAsiento);

        JLabel lbl_precio_txt = new JLabel("Precio:");
        lbl_precio_txt.setForeground(new Color(46, 48, 48));
        lbl_precio_txt.setBackground(new Color(46, 48, 48));
        lbl_precio_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_precio_txt.setBounds(814, 60, 76, 43);
        contentPane.add(lbl_precio_txt);

        lbl_precio_dinero = new JLabel("$");
        lbl_precio_dinero.setForeground(new Color(46, 48, 48));
        lbl_precio_dinero.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_precio_dinero.setBounds(886, 60, 50, 43);
        contentPane.add(lbl_precio_dinero);

        btn_agregarAsiento = new JButton("Agregar Asiento");
        btn_agregarAsiento.setForeground(Color.WHITE);
        btn_agregarAsiento.setFont(new Font("Arial Black", Font.BOLD, 18));
        btn_agregarAsiento.setBackground(new Color(171, 0, 51));
        btn_agregarAsiento.setBounds(368, 73, 207, 35);
        btn_agregarAsiento.addActionListener(this);
        btn_agregarAsiento.setEnabled(false);
        contentPane.add(btn_agregarAsiento);

        btn_volver = new JButton("Volver");
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setFont(new Font("Arial", Font.BOLD, 14));
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 567, 120, 23);
        btn_volver.addActionListener(this);
        contentPane.add(btn_volver);

        btn_continuar = new JButton("Continuar");
        btn_continuar.setForeground(Color.WHITE);
        btn_continuar.setFont(new Font("Arial", Font.BOLD, 14));
        btn_continuar.setBackground(new Color(171, 0, 51));
        btn_continuar.setBounds(814, 567, 120, 23);
        btn_continuar.addActionListener(this);
        contentPane.add(btn_continuar);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(SystemColor.inactiveCaption);
        panel.setBounds(75, 121, 794, 431);
        contentPane.add(panel);
        panel.setLayout(null);


        JLabel lbl_filaA = new JLabel("A");
        lbl_filaA.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaA.setBounds(10, 378, 22, 30);
        panel.add(lbl_filaA);

        JLabel lbl_filaB = new JLabel("B");
        lbl_filaB.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaB.setBounds(10, 337, 22, 30);
        panel.add(lbl_filaB);

        JLabel lbl_filaC = new JLabel("C");
        lbl_filaC.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaC.setBounds(10, 296, 22, 30);
        panel.add(lbl_filaC);

        JLabel lbl_filaD = new JLabel("D");
        lbl_filaD.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaD.setBounds(10, 255, 22, 30);
        panel.add(lbl_filaD);

        JLabel lbl_filaE = new JLabel("E");
        lbl_filaE.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaE.setBounds(10, 214, 22, 30);
        panel.add(lbl_filaE);

        JLabel lbl_filaF = new JLabel("F");
        lbl_filaF.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaF.setBounds(10, 173, 22, 30);
        panel.add(lbl_filaF);

        JLabel lbl_filaG = new JLabel("G");
        lbl_filaG.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaG.setBounds(10, 132, 22, 30);
        panel.add(lbl_filaG);

        JLabel lbl_filaH = new JLabel("H");
        lbl_filaH.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaH.setBounds(10, 91, 22, 30);
        panel.add(lbl_filaH);

        JLabel lbl_filaI = new JLabel("I");
        lbl_filaI.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaI.setBounds(10, 50, 22, 30);
        panel.add(lbl_filaI);

        JLabel lbl_filaJ = new JLabel("J");
        lbl_filaJ.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_filaJ.setBounds(10, 11, 22, 30);
        panel.add(lbl_filaJ);

        JButton pantalla = new JButton();
        pantalla.setEnabled(false);
        pantalla.setForeground(Color.BLACK);
        pantalla.setBackground(Color.BLACK);
        pantalla.setBounds(137, 421, 500, 9);
        panel.add(pantalla);

        JLabel lbl_col5 = new JLabel("5");
        lbl_col5.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col5.setBounds(347, 400, 10, 30);
        panel.add(lbl_col5);

        JLabel lbl_col6 = new JLabel("6");
        lbl_col6.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col6.setBounds(397, 400, 10, 30);
        panel.add(lbl_col6);

        JLabel lbl_col7 = new JLabel("7");
        lbl_col7.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col7.setBounds(447, 400, 10, 30);
        panel.add(lbl_col7);

        JLabel lbl_col8 = new JLabel("8");
        lbl_col8.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col8.setBounds(497, 400, 10, 30);
        panel.add(lbl_col8);

        JLabel lbl_col9 = new JLabel("9");
        lbl_col9.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col9.setBounds(547, 400, 10, 30);
        panel.add(lbl_col9);

        JLabel lbl_col10 = new JLabel("10");
        lbl_col10.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col10.setBounds(600, 400, 20, 30);
        panel.add(lbl_col10);

        JLabel lbl_col4 = new JLabel("4");
        lbl_col4.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col4.setBounds(297, 400, 10, 30);
        panel.add(lbl_col4);

        JLabel lbl_col3 = new JLabel("3");
        lbl_col3.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col3.setBounds(247, 400, 10, 30);
        panel.add(lbl_col3);

        JLabel lbl_col2 = new JLabel("2");
        lbl_col2.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col2.setBounds(197, 400, 10, 30);
        panel.add(lbl_col2);

        JLabel lbl_col1 = new JLabel("1");
        lbl_col1.setFont(new Font("Arial", Font.PLAIN, 15));
        lbl_col1.setBounds(147, 400, 10, 30);
        panel.add(lbl_col1);

        //FILA A

        InputStream stream = getClass().getResourceAsStream("/images/fondo1.png");
        icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(stream));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		stream2 = getClass().getResourceAsStream("/images/fondo2.png");
        icon2 = null;
		try {
			icon2 = new ImageIcon(ImageIO.read(stream2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        btn_A1 = new BotonPersonalizado();
        
        btn_A1.setBounds(137, 385, 20, 23);
        btn_A1.setBorder(BorderFactory.createEmptyBorder());
        btn_A1.setName("A1");
        panel.add(btn_A1);

        btn_A2 = new BotonPersonalizado();
      
        btn_A2.setBorder(BorderFactory.createEmptyBorder());
        btn_A2.setBounds(187, 383, 20, 23);
        btn_A2.setName("A2");
        panel.add(btn_A2);

        btn_A3 = new BotonPersonalizado();
    
        btn_A3.setBorder(BorderFactory.createEmptyBorder());
        btn_A3.setBounds(237, 383, 20, 23);
        btn_A3.setName("A3");
        panel.add(btn_A3);

        btn_A4 = new BotonPersonalizado();
     
        btn_A4.setBorder(BorderFactory.createEmptyBorder());
        btn_A4.setBounds(287, 383, 20, 23);
        btn_A4.setName("A4");
        panel.add(btn_A4);

        btn_A5 = new BotonPersonalizado();
  
        btn_A5.setBorder(BorderFactory.createEmptyBorder());
        btn_A5.setBounds(337, 383, 20, 23);
        btn_A5.setName("A5");
        panel.add(btn_A5);

        btn_A6 = new BotonPersonalizado();
      
        btn_A6.setBorder(BorderFactory.createEmptyBorder());
        btn_A6.setBounds(387, 383, 20, 23);
        btn_A6.setName("A6");
        panel.add(btn_A6);

        btn_A7 = new BotonPersonalizado();
  
        btn_A7.setBorder(BorderFactory.createEmptyBorder());
        btn_A7.setBounds(437, 383, 20, 23);
        btn_A7.setName("A7");
        panel.add(btn_A7);

        btn_A8 = new BotonPersonalizado();
    
        btn_A8.setBorder(BorderFactory.createEmptyBorder());
        btn_A8.setBounds(487, 383, 20, 23);
        btn_A8.setName("A8");
        panel.add(btn_A8);

        btn_A9 = new BotonPersonalizado();

        btn_A9.setBorder(BorderFactory.createEmptyBorder());
        btn_A9.setBounds(537, 383, 20, 23);
        btn_A9.setName("A9");
        panel.add(btn_A9);

        btn_A10 = new BotonPersonalizado();
 
        btn_A10.setBorder(BorderFactory.createEmptyBorder());
        btn_A10.setBounds(600, 383, 20, 23);
        btn_A10.setName("A10");
        panel.add(btn_A10);

        //FILA B

        btn_B1 = new BotonPersonalizado();
 
        btn_B1.setBorder(BorderFactory.createEmptyBorder());
        btn_B1.setBounds(137, 342, 20, 23);
        btn_B1.setName("B1");
        panel.add(btn_B1);

        btn_B2 = new BotonPersonalizado();
     
        btn_B2.setBorder(BorderFactory.createEmptyBorder());
        btn_B2.setBounds(187, 342, 20, 23);
        btn_B2.setName("B2");
        panel.add(btn_B2);

        btn_B3 = new BotonPersonalizado();
      
        btn_B3.setBorder(BorderFactory.createEmptyBorder());
        btn_B3.setBounds(237, 342, 20, 23);
        btn_B3.setName("B3");
        panel.add(btn_B3);

        btn_B4 = new BotonPersonalizado();
       
        btn_B4.setBorder(BorderFactory.createEmptyBorder());
        btn_B4.setBounds(287, 342, 20, 23);
        btn_B4.setName("B4");
        panel.add(btn_B4);

        btn_B5 = new BotonPersonalizado();
      
        btn_B5.setBorder(BorderFactory.createEmptyBorder());
        btn_B5.setBounds(337, 342, 20, 23);
        btn_B5.setName("B5");
        panel.add(btn_B5);

        btn_B6 = new BotonPersonalizado();
      
        btn_B6.setBorder(BorderFactory.createEmptyBorder());
        btn_B6.setBounds(387, 342, 20, 23);
        btn_B6.setName("B6");
        panel.add(btn_B6);

        btn_B7 = new BotonPersonalizado();
      
        btn_B7.setBorder(BorderFactory.createEmptyBorder());
        btn_B7.setBounds(437, 342, 20, 23);
        btn_B7.setName("B7");
        panel.add(btn_B7);

        btn_B8 = new BotonPersonalizado();

        btn_B8.setBorder(BorderFactory.createEmptyBorder());
        btn_B8.setBounds(487, 342, 20, 23);
        btn_B8.setName("B8");
        panel.add(btn_B8);

        btn_B9 = new BotonPersonalizado();
  
        btn_B9.setBorder(BorderFactory.createEmptyBorder());
        btn_B9.setBounds(537, 342, 20, 23);
        btn_B9.setName("B9");
        panel.add(btn_B9);

        btn_B10 = new BotonPersonalizado();

        btn_B10.setBorder(BorderFactory.createEmptyBorder());
        btn_B10.setBounds(600, 342, 20, 23);
        btn_B10.setName("B10");
        panel.add(btn_B10);

        //FILA C

        btn_C1 = new BotonPersonalizado();
     
        btn_C1.setBorder(BorderFactory.createEmptyBorder());
        btn_C1.setBounds(137, 301, 20, 23);
        btn_C1.setName("C1");
        panel.add(btn_C1);

        btn_C2 = new BotonPersonalizado();
      
        btn_C2.setBorder(BorderFactory.createEmptyBorder());
        btn_C2.setBounds(187, 301, 20, 23);
        btn_C2.setName("C2");
        panel.add(btn_C2);

        btn_C3 = new BotonPersonalizado();
   
        btn_C3.setBorder(BorderFactory.createEmptyBorder());
        btn_C3.setBounds(237, 301, 20, 23);
        btn_C3.setName("C3");
        panel.add(btn_C3);

        btn_C4 = new BotonPersonalizado();
    
        btn_C4.setBorder(BorderFactory.createEmptyBorder());
        btn_C4.setBounds(287, 301, 20, 23);
        btn_C4.setName("C4");
        panel.add(btn_C4);

        btn_C5 = new BotonPersonalizado();
   
        btn_C5.setBorder(BorderFactory.createEmptyBorder());
        btn_C5.setBounds(337, 301, 20, 23);
        btn_C5.setName("C5");
        panel.add(btn_C5);

        btn_C6 = new BotonPersonalizado();
     
        btn_C6.setBorder(BorderFactory.createEmptyBorder());
        btn_C6.setBounds(387, 301, 20, 23);
        btn_C6.setName("C6");
        panel.add(btn_C6);

        btn_C7 = new BotonPersonalizado();
     
        btn_C7.setBorder(BorderFactory.createEmptyBorder());
        btn_C7.setBounds(437, 301, 20, 23);
        btn_C7.setName("C7");
        panel.add(btn_C7);

        btn_C8 = new BotonPersonalizado();
 
        btn_C8.setBorder(BorderFactory.createEmptyBorder());
        btn_C8.setBounds(487, 301, 20, 23);
        btn_C8.setName("C8");
        panel.add(btn_C8);

        btn_C9 = new BotonPersonalizado();
       
        btn_C9.setBorder(BorderFactory.createEmptyBorder());
        btn_C9.setBounds(537, 301, 20, 23);
        btn_C9.setName("C9");
        panel.add(btn_C9);

        btn_C10 = new BotonPersonalizado();
 
        btn_C10.setBorder(BorderFactory.createEmptyBorder());
        btn_C10.setBounds(600, 301, 20, 23);
        btn_C10.setName("C10");
        panel.add(btn_C10);

        //FILA D

        btn_D1 = new BotonPersonalizado();
      
        btn_D1.setBorder(BorderFactory.createEmptyBorder());
        btn_D1.setBounds(137, 260, 20, 23);
        btn_D1.setName("D1");
        panel.add(btn_D1);

        btn_D2 = new BotonPersonalizado();
     
        btn_D2.setBorder(BorderFactory.createEmptyBorder());
        btn_D2.setBounds(187, 260, 20, 23);
        btn_D2.setName("D2");
        panel.add(btn_D2);

        btn_D3 = new BotonPersonalizado();
   
        btn_D3.setBorder(BorderFactory.createEmptyBorder());
        btn_D3.setBounds(237, 260, 20, 23);
        btn_D3.setName("D3");
        panel.add(btn_D3);

        btn_D4 = new BotonPersonalizado();
      
        btn_D4.setBorder(BorderFactory.createEmptyBorder());
        btn_D4.setBounds(287, 260, 20, 23);
        btn_D4.setName("D4");
        panel.add(btn_D4);

        btn_D5 = new BotonPersonalizado();
     
        btn_D5.setBorder(BorderFactory.createEmptyBorder());
        btn_D5.setBounds(337, 260, 20, 23);
        btn_D5.setName("D5");
        panel.add(btn_D5);

        btn_D6 = new BotonPersonalizado();
    
        btn_D6.setBorder(BorderFactory.createEmptyBorder());
        btn_D6.setBounds(387, 260, 20, 23);
        btn_D6.setName("D6");
        panel.add(btn_D6);

        btn_D7 = new BotonPersonalizado();
   
        btn_D7.setBorder(BorderFactory.createEmptyBorder());
        btn_D7.setBounds(437, 260, 20, 23);
        btn_D7.setName("D7");
        panel.add(btn_D7);

        btn_D8 = new BotonPersonalizado();
   
        btn_D8.setBorder(BorderFactory.createEmptyBorder());
        btn_D8.setBounds(487, 260, 20, 23);
        btn_D8.setName("D8");
        panel.add(btn_D8);

        btn_D9 = new BotonPersonalizado();

        btn_D9.setBorder(BorderFactory.createEmptyBorder());
        btn_D9.setBounds(537, 260, 20, 23);
        btn_D9.setName("D9");
        panel.add(btn_D9);

        btn_D10 = new BotonPersonalizado();
    
        btn_D10.setBorder(BorderFactory.createEmptyBorder());
        btn_D10.setBounds(600, 260, 20, 23);
        btn_D10.setName("D10");
        panel.add(btn_D10);

        //FILA E

        btn_E1 = new BotonPersonalizado();

        btn_E1.setBorder(BorderFactory.createEmptyBorder());
        btn_E1.setBounds(137, 219, 20, 23);
        btn_E1.setName("E1");
        panel.add(btn_E1);

        btn_E2 = new BotonPersonalizado();
  
        btn_E2.setBorder(BorderFactory.createEmptyBorder());
        btn_E2.setBounds(187, 219, 20, 23);
        btn_E2.setName("E2");
        panel.add(btn_E2);

        btn_E3 = new BotonPersonalizado();
   
        btn_E3.setBorder(BorderFactory.createEmptyBorder());
        btn_E3.setBounds(237, 219, 20, 23);
        btn_E3.setName("E3");
        panel.add(btn_E3);

        btn_E4 = new BotonPersonalizado();

        btn_E4.setBorder(BorderFactory.createEmptyBorder());
        btn_E4.setBounds(287, 219, 20, 23);
        btn_E4.setName("E4");
        panel.add(btn_E4);

        btn_E5 = new BotonPersonalizado();
 
        btn_E5.setBorder(BorderFactory.createEmptyBorder());
        btn_E5.setBounds(337, 219, 20, 23);
        btn_E5.setName("E5");
        panel.add(btn_E5);

        btn_E6 = new BotonPersonalizado();
   
        btn_E6.setBorder(BorderFactory.createEmptyBorder());
        btn_E6.setBounds(387, 219, 20, 23);
        btn_E6.setName("E6");
        panel.add(btn_E6);

        btn_E7 = new BotonPersonalizado();
  
        btn_E7.setBorder(BorderFactory.createEmptyBorder());
        btn_E7.setBounds(437, 219, 20, 23);
        btn_E7.setName("E7");
        panel.add(btn_E7);

        btn_E8 = new BotonPersonalizado();
  
        btn_E8.setBorder(BorderFactory.createEmptyBorder());
        btn_E8.setBounds(487, 219, 20, 23);
        btn_E8.setName("E8");
        panel.add(btn_E8);

        btn_E9 = new BotonPersonalizado();

        btn_E9.setBorder(BorderFactory.createEmptyBorder());
        btn_E9.setBounds(537, 219, 20, 23);
        btn_E9.setName("E9");
        panel.add(btn_E9);

        btn_E10 = new BotonPersonalizado();
  
        btn_E10.setBorder(BorderFactory.createEmptyBorder());
        btn_E10.setBounds(600, 219, 20, 23);
        btn_E10.setName("E10");
        panel.add(btn_E10);

        //FILA F

        btn_F1 = new BotonPersonalizado();

        btn_F1.setBorder(BorderFactory.createEmptyBorder());
        btn_F1.setBounds(137, 178, 20, 23);
        btn_F1.setName("F1");
        panel.add(btn_F1);

        btn_F2 = new BotonPersonalizado();

        btn_F2.setBorder(BorderFactory.createEmptyBorder());
        btn_F2.setBounds(187, 178, 20, 23);
        btn_F2.setName("F2");
        panel.add(btn_F2);

        btn_F3 = new BotonPersonalizado();

        btn_F3.setBorder(BorderFactory.createEmptyBorder());
        btn_F3.setBounds(237, 178, 20, 23);
        btn_F3.setName("F3");
        panel.add(btn_F3);

        btn_F4 = new BotonPersonalizado();

        btn_F4.setBorder(BorderFactory.createEmptyBorder());
        btn_F4.setBounds(287, 178, 20, 23);
        btn_F4.setName("F4");
        panel.add(btn_F4);

        btn_F5 = new BotonPersonalizado();
  
        btn_F5.setBorder(BorderFactory.createEmptyBorder());
        btn_F5.setBounds(337, 178, 20, 23);
        btn_F5.setName("F5");
        panel.add(btn_F5);

        btn_F6 = new BotonPersonalizado();

        btn_F6.setBorder(BorderFactory.createEmptyBorder());
        btn_F6.setBounds(387, 178, 20, 23);
        btn_F6.setName("F6");
        panel.add(btn_F6);

        btn_F7 = new BotonPersonalizado();
    
        btn_F7.setBorder(BorderFactory.createEmptyBorder());
        btn_F7.setBounds(437, 178, 20, 23);
        btn_F7.setName("F7");
        panel.add(btn_F7);

        btn_F8 = new BotonPersonalizado();

        btn_F8.setBorder(BorderFactory.createEmptyBorder());
        btn_F8.setBounds(487, 178, 20, 23);
        btn_F8.setName("F8");
        panel.add(btn_F8);

        btn_F9 = new BotonPersonalizado();
 
        btn_F9.setBorder(BorderFactory.createEmptyBorder());
        btn_F9.setBounds(537, 178, 20, 23);
        btn_F9.setName("F9");
        panel.add(btn_F9);

        btn_F10 = new BotonPersonalizado();
   
        btn_F10.setBorder(BorderFactory.createEmptyBorder());
        btn_F10.setBounds(600, 178, 20, 23);
        btn_F10.setName("F10");
        panel.add(btn_F10);

        //FILA G

        btn_G1 = new BotonPersonalizado();

        btn_G1.setBorder(BorderFactory.createEmptyBorder());
        btn_G1.setBounds(137, 137, 20, 23);
        btn_G1.setName("G1");
        panel.add(btn_G1);

        btn_G2 = new BotonPersonalizado();
  
        btn_G2.setBorder(BorderFactory.createEmptyBorder());
        btn_G2.setBounds(187, 137, 20, 23);
        btn_G2.setName("G2");
        panel.add(btn_G2);

        btn_G3 = new BotonPersonalizado();
  
        btn_G3.setBorder(BorderFactory.createEmptyBorder());
        btn_G3.setBounds(237, 137, 20, 23);
        btn_G3.setName("G3");
        panel.add(btn_G3);

        btn_G4 = new BotonPersonalizado();

        btn_G4.setBorder(BorderFactory.createEmptyBorder());
        btn_G4.setBounds(287, 137, 20, 23);
        btn_G4.setName("G4");
        panel.add(btn_G4);

        btn_G5 = new BotonPersonalizado();
 
        btn_G5.setBorder(BorderFactory.createEmptyBorder());
        btn_G5.setBounds(337, 137, 20, 23);
        btn_G5.setName("G5");
        panel.add(btn_G5);

        btn_G6 = new BotonPersonalizado();
 
        btn_G6.setBorder(BorderFactory.createEmptyBorder());
        btn_G6.setBounds(387, 137, 20, 23);
        btn_G6.setName("G6");
        panel.add(btn_G6);

        btn_G7 = new BotonPersonalizado();
   
        btn_G7.setBorder(BorderFactory.createEmptyBorder());
        btn_G7.setBounds(437, 137, 20, 23);
        btn_G7.setName("G7");
        panel.add(btn_G7);

        btn_G8 = new BotonPersonalizado();
      
        btn_G8.setBorder(BorderFactory.createEmptyBorder());
        btn_G8.setBounds(487, 137, 20, 23);
        btn_G8.setName("G8");
        panel.add(btn_G8);

        btn_G9 = new BotonPersonalizado();
    
        btn_G9.setBorder(BorderFactory.createEmptyBorder());
        btn_G9.setBounds(537, 137, 20, 23);
        btn_G9.setName("G9");
        panel.add(btn_G9);

        btn_G10 = new BotonPersonalizado();
  
        btn_G10.setBorder(BorderFactory.createEmptyBorder());
        btn_G10.setBounds(600, 137, 20, 23);
        btn_G10.setName("G10");
        panel.add(btn_G10);

        //FILA H

        btn_H1 = new BotonPersonalizado();

        btn_H1.setBorder(BorderFactory.createEmptyBorder());
        btn_H1.setBounds(137, 96, 20, 23);
        btn_H1.setName("H1");
        panel.add(btn_H1);

        btn_H2 = new BotonPersonalizado();
  
        btn_H2.setBorder(BorderFactory.createEmptyBorder());
        btn_H2.setBounds(187, 96, 20, 23);
        btn_H2.setName("H2");
        panel.add(btn_H2);

        btn_H3 = new BotonPersonalizado();

        btn_H3.setBorder(BorderFactory.createEmptyBorder());
        btn_H3.setBounds(237, 96, 20, 23);
        btn_H3.setName("H3");
        panel.add(btn_H3);

        btn_H4 = new BotonPersonalizado();
       
        btn_H4.setBorder(BorderFactory.createEmptyBorder());
        btn_H4.setBounds(287, 96, 20, 23);
        btn_H4.setName("H4");
        panel.add(btn_H4);

        btn_H5 = new BotonPersonalizado();

        btn_H5.setBorder(BorderFactory.createEmptyBorder());
        btn_H5.setBounds(337, 96, 20, 23);
        btn_H5.setName("H5");
        panel.add(btn_H5);

        btn_H6 = new BotonPersonalizado();

        btn_H6.setBorder(BorderFactory.createEmptyBorder());
        btn_H6.setBounds(387, 96, 20, 23);
        btn_H6.setName("H6");
        panel.add(btn_H6);

        btn_H7 = new BotonPersonalizado();

        btn_H7.setBorder(BorderFactory.createEmptyBorder());
        btn_H7.setBounds(437, 96, 20, 23);
        btn_H7.setName("H7");
        panel.add(btn_H7);

        btn_H8 = new BotonPersonalizado();
     
        btn_H8.setBorder(BorderFactory.createEmptyBorder());
        btn_H8.setBounds(487, 96, 20, 23);
        btn_H8.setName("H8");
        panel.add(btn_H8);

        btn_H9 = new BotonPersonalizado();
       
        btn_H9.setBorder(BorderFactory.createEmptyBorder());
        btn_H9.setBounds(537, 96, 20, 23);
        btn_H9.setName("H9");
        panel.add(btn_H9);

        btn_H10 = new BotonPersonalizado();

        btn_H10.setBorder(BorderFactory.createEmptyBorder());
        btn_H10.setBounds(600, 96, 20, 23);
        btn_H10.setName("H10");
        panel.add(btn_H10);

        //FILA I

        btn_I1 = new BotonPersonalizado();

        btn_I1.setBorder(BorderFactory.createEmptyBorder());
        btn_I1.setBounds(137, 55, 20, 23);
        btn_I1.setName("I1");
        panel.add(btn_I1);

        btn_I2 = new BotonPersonalizado();
    
        btn_I2.setBorder(BorderFactory.createEmptyBorder());
        btn_I2.setBounds(187, 55, 20, 23);
        btn_I2.setName("I2");
        panel.add(btn_I2);

        btn_I3 = new BotonPersonalizado();
    
        btn_I3.setBorder(BorderFactory.createEmptyBorder());
        btn_I3.setBounds(237, 55, 20, 23);
        btn_I3.setName("I3");
        panel.add(btn_I3);

        btn_I4 = new BotonPersonalizado();
       
        btn_I4.setBorder(BorderFactory.createEmptyBorder());
        btn_I4.setBounds(287, 55, 20, 23);
        btn_I4.setName("I4");
        panel.add(btn_I4);

        btn_I5 = new BotonPersonalizado();
       
        btn_I5.setBorder(BorderFactory.createEmptyBorder());
        btn_I5.setBounds(337, 55, 20, 23);
        btn_I5.setName("I5");
        panel.add(btn_I5);

        btn_I6 = new BotonPersonalizado();
      
        btn_I6.setBorder(BorderFactory.createEmptyBorder());
        btn_I6.setBounds(387, 55, 20, 23);
        btn_I6.setName("I6");
        panel.add(btn_I6);

        btn_I7 = new BotonPersonalizado();
      
        btn_I7.setBorder(BorderFactory.createEmptyBorder());
        btn_I7.setBounds(437, 55, 20, 23);
        btn_I7.setName("I7");
        panel.add(btn_I7);

        btn_I8 = new BotonPersonalizado();

        btn_I8.setBorder(BorderFactory.createEmptyBorder());
        btn_I8.setBounds(487, 55, 20, 23);
        btn_I8.setName("I8");
        panel.add(btn_I8);

        btn_I9 = new BotonPersonalizado();
    
        btn_I9.setBorder(BorderFactory.createEmptyBorder());
        btn_I9.setBounds(537, 55, 20, 23);
        btn_I9.setName("I9");
        panel.add(btn_I9);

        btn_I10 = new BotonPersonalizado();

        btn_I10.setBorder(BorderFactory.createEmptyBorder());
        btn_I10.setBounds(600, 55, 20, 23);
        btn_I10.setName("I10");
        panel.add(btn_I10);

        //FILA K

        btn_J1 = new BotonPersonalizado();

        btn_J1.setBorder(BorderFactory.createEmptyBorder());
        btn_J1.setBounds(137, 16, 20, 23);
        btn_J1.setName("J1");
        panel.add(btn_J1);

        btn_J2 = new BotonPersonalizado();
 
        btn_J2.setBorder(BorderFactory.createEmptyBorder());
        btn_J2.setBounds(187, 16, 20, 23);
        btn_J2.setName("J2");
        panel.add(btn_J2);

        btn_J3 = new BotonPersonalizado();
  
        btn_J3.setBorder(BorderFactory.createEmptyBorder());
        btn_J3.setBounds(237, 16, 20, 23);
        btn_J3.setName("J3");
        panel.add(btn_J3);

        btn_J4 = new BotonPersonalizado();
     
        btn_J4.setBorder(BorderFactory.createEmptyBorder());
        btn_J4.setBounds(287, 16, 20, 23);
        btn_J4.setName("J4");
        panel.add(btn_J4);

        btn_J5 = new BotonPersonalizado();
    
        btn_J5.setBorder(BorderFactory.createEmptyBorder());
        btn_J5.setBounds(337, 16, 20, 23);
        btn_J5.setName("J5");
        panel.add(btn_J5);

        btn_J6 = new BotonPersonalizado();
      
        btn_J6.setBorder(BorderFactory.createEmptyBorder());
        btn_J6.setBounds(387, 16, 20, 23);
        btn_J6.setName("J6");
        panel.add(btn_J6);

        btn_J7 = new BotonPersonalizado();

        btn_J7.setBorder(BorderFactory.createEmptyBorder());
        btn_J7.setBounds(437, 16, 20, 23);
        btn_J7.setName("J7");
        panel.add(btn_J7);

        btn_J8 = new BotonPersonalizado();
 
        btn_J8.setBorder(BorderFactory.createEmptyBorder());
        btn_J8.setBounds(487, 16, 20, 23);
        btn_J8.setName("J8");
        panel.add(btn_J8);

        btn_J9 = new BotonPersonalizado();

        btn_J9.setBorder(BorderFactory.createEmptyBorder());
        btn_J9.setBounds(537, 16, 20, 23);
        btn_J9.setName("J9");
        panel.add(btn_J9);

        btn_J10 = new BotonPersonalizado();
  
        btn_J10.setBorder(BorderFactory.createEmptyBorder());
        btn_J10.setBounds(600, 16, 20, 23);
        btn_J10.setName("J10");
        panel.add(btn_J10);

        //Se me olvidaron los action listeners, probablemente debería meter los botones en un array y luego hacer foreach pero  ¯\_(ツ)_/¯
        //al final lo tuve que hacer
        botones.add(btn_A1);
        botones.add(btn_A2);
        botones.add(btn_A3);
        botones.add(btn_A4);
        botones.add(btn_A5);
        botones.add(btn_A6);
        botones.add(btn_A7);
        botones.add(btn_A8);
        botones.add(btn_A9);
        botones.add(btn_A10);
        botones.add(btn_B1);
        botones.add(btn_B2);
        botones.add(btn_B3);
        botones.add(btn_B4);
        botones.add(btn_B5);
        botones.add(btn_B6);
        botones.add(btn_B7);
        botones.add(btn_B8);
        botones.add(btn_B9);
        botones.add(btn_B10);
        botones.add(btn_C1);
        botones.add(btn_C2);
        botones.add(btn_C3);
        botones.add(btn_C4);
        botones.add(btn_C5);
        botones.add(btn_C6);
        botones.add(btn_C7);
        botones.add(btn_C8);
        botones.add(btn_C9);
        botones.add(btn_C10);
        botones.add(btn_D1);
        botones.add(btn_D2);
        botones.add(btn_D3);
        botones.add(btn_D4);
        botones.add(btn_D5);
        botones.add(btn_D6);
        botones.add(btn_D7);
        botones.add(btn_D8);
        botones.add(btn_D9);
        botones.add(btn_D10);
        botones.add(btn_E1);
        botones.add(btn_E2);
        botones.add(btn_E3);
        botones.add(btn_E4);
        botones.add(btn_E5);
        botones.add(btn_E6);
        botones.add(btn_E7);
        botones.add(btn_E8);
        botones.add(btn_E9);
        botones.add(btn_E10);
        botones.add(btn_F1);
        botones.add(btn_F2);
        botones.add(btn_F3);
        botones.add(btn_F4);
        botones.add(btn_F5);
        botones.add(btn_F6);
        botones.add(btn_F7);
        botones.add(btn_F8);
        botones.add(btn_F9);
        botones.add(btn_F10);
        botones.add(btn_G1);
        botones.add(btn_G2);
        botones.add(btn_G3);
        botones.add(btn_G4);
        botones.add(btn_G5);
        botones.add(btn_G6);
        botones.add(btn_G7);
        botones.add(btn_G8);
        botones.add(btn_G9);
        botones.add(btn_G10);
        botones.add(btn_H1);
        botones.add(btn_H2);
        botones.add(btn_H3);
        botones.add(btn_H4);
        botones.add(btn_H5);
        botones.add(btn_H6);
        botones.add(btn_H7);
        botones.add(btn_H8);
        botones.add(btn_H9);
        botones.add(btn_H10);
        botones.add(btn_I1);
        botones.add(btn_I2);
        botones.add(btn_I3);
        botones.add(btn_I4);
        botones.add(btn_I5);
        botones.add(btn_I6);
        botones.add(btn_I7);
        botones.add(btn_I8);
        botones.add(btn_I9);
        botones.add(btn_I10);
        botones.add(btn_J1);
        botones.add(btn_J2);
        botones.add(btn_J3);
        botones.add(btn_J4);
        botones.add(btn_J5);
        botones.add(btn_J6);
        botones.add(btn_J7);
        botones.add(btn_J8);
        botones.add(btn_J9);
        botones.add(btn_J10);

        System.out.println("Sala:"+SeleccionarPelicula.sala_sel);
		System.out.println("Funcion"+SeleccionarPelicula.funcion);
		
        for(BotonPersonalizado boton: botones){
            boton.addActionListener(this);
        }
        selectAsiento();
        desactivarTodosAsientos();
    }
    public JFormattedTextField getTextField(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor)editor).getTextField();
        } else {
            System.err.println("Unexpected editor type: "
                    + spinner.getEditor().getClass()
                    + " isn't a descendant of DefaultEditor");
            return null;
        }
    }

    //TODO: EL CÓDIGO QUE SIGUE NO SIRVE, HAY QUE MODIFICARLO, sobre todo la parte de checar si un botón ya fue incluido
    //TODO: En la clase de boton personalizado hay una variable booleana para saber si fue presionado o no y su tipod
    //TODO: LOS BOTONES SE TIENEN QUE DESACTIVAR CONFORME ESTÉ SU ESTADO EN SQL.
    //TODO: Reflejar el precio con el JSpinner
    //TODO : NO PUDE HACERLO

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	int cont = 0;
    	
    	if(e.getSource()==btn_agregarAsiento) {
    		habilitarAsiento();
    		lbl_numAsiento.setText("");
    		btn_agregarAsiento.setEnabled(false);
    		switch(preciosCont) {
			case 1: precios.add(50);
					break;
			case 2: precios.add(70);
					break;
			case 3: precios.add(120);
			}
		
			for(Integer j: precios) {
			System.out.println(j);
			}
			
    	}
    	else if(e.getSource()==btn_continuar){
            VentaBoleto ventaboleto = new VentaBoleto();
            ventaboleto.setVisible(true);
            dispose();

        }
        else if(e.getSource()==btn_volver) {
            try {
                SeleccionarPelicula seleccionarPelicula = new SeleccionarPelicula();
                seleccionarPelicula.setVisible(true);
                dispose();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


        }
    	else {
    		
    		boolean boton = false;
    		int contPre = 0,contSelec=0;
    		
    		for(BotonPersonalizado i: botones) {
        		
    			
        		if(e.getSource()==i) {
        			
        			for(String j: asientosPreSeleccionados) {
            			if(j.equals(i.getName())) {
            				boton=true;
            				contPre=1;
            			}
            		}
        			
        			for(String j: botonesSeleccionados) {
        				if(j.equals(i.getName())) {
        					boton=true;
        					contSelec=1;
        				}
        			}
        			if(boton==false) {

        				nomAsiento = i.getName();
        				btn_agregarAsiento.setEnabled(true);
            			try {
            				String SQL_UPDATE = "UPDATE Asiento SET Disponibilidad=0 WHERE Asiento='"+nomAsiento+"' AND Num_Sala="+sala;
            				System.out.println("Query de agregando: "+SQL_UPDATE);
                    		pstm = con.prepareStatement(SQL_UPDATE);
                    		pstm.executeUpdate();
                    	
                    		JOptionPane.showMessageDialog(null,"Agregado con exito.");
                    		
                    	} catch (SQLException e1) {
                    		
                    	}
            			botonesSeleccionados.add(nomAsiento);
            			lbl_numAsiento.setText(nomAsiento);
            			i.setIcon(icon2);
            			
            			
            			desabilitarAsiento();
            		
            			break;
        			}
        			else {
        				if(contPre==1) {
        					JOptionPane.showMessageDialog(null, "No puede seleccionar un asiento ocupado.");
        				}
        				else if(contSelec==1) {
        					
        					if(e.getSource()==i) {
        						int opcion = JOptionPane.showConfirmDialog(null, "Quiere eliminar este boleto de su compra?","Eliminar",JOptionPane.YES_NO_OPTION);
            					
            					if(opcion==JOptionPane.YES_OPTION) {
            						i.setIcon(icon);
            						botonesSeleccionados.remove(i.getName());
            						try {
            								String SQL_UPDATE = "UPDATE Asiento SET Disponibilidad=1 WHERE Asiento='"+nomAsiento+"' AND Num_Sala="+sala;
            								System.out.println("Query de eliminando: "+SQL_UPDATE);
            								pstm = con.prepareStatement(SQL_UPDATE);
            				       		pstm.executeUpdate();
            				       	
            				       		JOptionPane.showMessageDialog(null,"Eliminado con exito.");
            				       	} catch (SQLException e1) {
            				       		
            				       	}
        					}
        					else {
        						
        						
            					}   
            					try {
            						con.close();
            					} catch (SQLException e1) {
            						// TODO Auto-generated catch block
            						e1.printStackTrace();
            					}
        					}		
        				}
        			}
        		}
        	}
    	}
    }
    
    
    private void desactivarTodosAsientos() {
    	for(BotonPersonalizado i: botones) {
    		i.setEnabled(false);
    	}
    }

    private void activarTodosAsientos() {
    	for(BotonPersonalizado i: botones) {
    		i.setEnabled(true);
    	}
    	
    }
    private void desabilitarAsiento() {
    	
    	for(BotonPersonalizado i: botones) {
    		
    		if(i.getName()!=nomAsiento) {
    			i.setEnabled(false);
    		}
    		
    	}
    	
    }
    
    private void habilitarAsiento() {
    	
    	for(BotonPersonalizado i: botones) {
    		i.setEnabled(true);
    	}
    	
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		
		
		String tipo = (String) spinner.getValue();
		if (tipo.equals("Niño")) {
			lbl_precio_dinero.setText("$50");
			getTipo(tipo);
			preciosCont=1;
			activarTodosAsientos();
		} else if (tipo.equals("Adulto")) {
			lbl_precio_dinero.setText("$70");
			preciosCont=2;
			activarTodosAsientos();
		} else if (tipo.equals("VIP")) {
			lbl_precio_dinero.setText("$120");
			preciosCont=3;
			activarTodosAsientos();
		}
		else if(tipo.equals("Categoria")) {
			desabilitarAsiento();
			btn_agregarAsiento.setEnabled(false);
		}
		
		
		
		
	}
	
	public String getTipo (String tipo){
        return tipo;
    }

            
}
