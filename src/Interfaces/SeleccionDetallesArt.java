package Interfaces;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SeleccionDetallesArt extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JComboBox combo_tam_refrescos, combo_tam_palomitas, combo_tam_helados, combo_sabor_refrescos, combo_sabor_palomitas, combo_sabor_helados;
    private JButton btnVolver, btnCancelarCompra, btnPagar;
    private JLabel lbl_precioR, lbl_precioP, lbl_precioH;
    private String tam[] = {"Chico", "Mediano", "Grande"};
    Date date = new Date();
    String saborP[];
    String saborH[];
    String saborR[];
    String fecha;
    String hora;
    int cantR = VentaDulceria.cantidadR;
    int cantP = VentaDulceria.cantidadP;
    int cantH = VentaDulceria.cantidadH;
    public int precioR,precioP,precioH;
    
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> a1 = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();
    ArrayList<String> b1 = new ArrayList<String>();
    ArrayList<String> c = new ArrayList<String>();
    ArrayList<String> c1 = new ArrayList<String>();
    public static ArrayList<String> refresco = new ArrayList<String>();
    public static ArrayList<String> palomita = new ArrayList<String>();
    public static ArrayList<String> helado = new ArrayList<String>();
    
    private JSpinner spinner_refrescos, spinner_palomitas, spinner_helados;
    
    
    // CONECTA A LA BASE DE DATOS Y CONSIGUE EL CON
 	private Connection con = ConexionBD.conectar();
 	public PreparedStatement pstm = null;
 	ResultSet rs = null;
 	String query="";
    
    
    //TODO: ARRAYS DE LOS DEMAS.

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SeleccionDetallesArt frame = new SeleccionDetallesArt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    
    public SeleccionDetallesArt() {
    	
    	try {
        	query="SELECT Sabor FROM `Producto Dulceria` WHERE Nombre_Producto = 'Refresco' ";
        	pstm = con.prepareStatement(query);
        	rs = pstm.executeQuery();
        	while(rs.next())
            {
                
                
                String palabra = rs.getString(1);
                a.add(palabra);
                a1.add(palabra);
                
                
            }
   
            for(int i=0;i<a.size();i++) {
            	int cont=0;
            	for(int j=0;j<a1.size();j++) {
            		
            		if(a1.get(j).equals(a.get(i))) {
            			
            			if(cont==0) {
            				cont++;
            			}
            			else {
            				
            				a1.remove(j);
            				j--;
            			}
            		}
            		
            	}
            }
            
            for(int i=0;i<a1.size();i++) {
            	System.out.println(a1.get(i) + "-----------------");
            }
        	saborR = a1.toArray(new String[a1.size()]);
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        try {
        	query="SELECT Sabor FROM `Producto Dulceria` WHERE Nombre_Producto = 'Palomitas' ";
        	pstm = con.prepareStatement(query);
        	rs = pstm.executeQuery();
        	while(rs.next())
            {
                
                
                String palabra = rs.getString(1);
                b.add(palabra);
                b1.add(palabra);
                
                
            }
   
            for(int i=0;i<b.size();i++) {
            	int cont=0;
            	for(int j=0;j<b1.size();j++) {
            		
            		if(b1.get(j).equals(b.get(i))) {
            			
            			if(cont==0) {
            				cont++;
            			}
            			else {
            				
            				b1.remove(j);
            				j--;
            			}
            		}
            		
            	}
            }
            
            for(int i=0;i<b1.size();i++) {
            	System.out.println(b1.get(i) + "-----------------");
            }
        	saborP = b1.toArray(new String[b1.size()]);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        try {
        	query="SELECT Sabor FROM `Producto Dulceria` WHERE Nombre_Producto = 'Helado' ";
        	pstm = con.prepareStatement(query);
        	rs = pstm.executeQuery();
        	while(rs.next())
            {
                
                
                String palabra = rs.getString(1);
                c.add(palabra);
                c1.add(palabra);
                
                
            }
   
            for(int i=0;i<c.size();i++) {
            	int cont=0;
            	for(int j=0;j<c1.size();j++) {
            		
            		if(c1.get(j).equals(c.get(i))) {
            			
            			if(cont==0) {
            				cont++;
            			}
            			else {
            				
            				c1.remove(j);
            				j--;
            			}
            		}
            		
            	}
            }
            
            for(int i=0;i<c1.size();i++) {
            	System.out.println(c1.get(i) + "-----------------");
            }
        	saborH = c1.toArray(new String[c1.size()]);
        
        }catch(Exception e) {
        	e.printStackTrace();
        }

    	
    	
    	
    	
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72, 81, 84));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_seleccion = new JLabel("Seleccion de detalles de los artículos");
        lbl_seleccion.setForeground(Color.WHITE);
        lbl_seleccion.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_seleccion.setBounds(122, 11, 699, 40);
        getContentPane().add(lbl_seleccion);

        JLabel lbl_refrescos = new JLabel("Refrescos:   >");
        lbl_refrescos.setForeground(Color.WHITE);
        lbl_refrescos.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_refrescos.setBackground(Color.DARK_GRAY);
        lbl_refrescos.setBounds(10, 90, 204, 48);
        contentPane.add(lbl_refrescos);

        JLabel lbl_palomitas = new JLabel("Palomitas:    >");
        lbl_palomitas.setForeground(Color.WHITE);
        lbl_palomitas.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_palomitas.setBackground(Color.DARK_GRAY);
        lbl_palomitas.setBounds(10, 156, 204, 61);
        contentPane.add(lbl_palomitas);

        JLabel lbl_helados = new JLabel("Helados:       >");
        lbl_helados.setForeground(Color.WHITE);
        lbl_helados.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_helados.setBackground(Color.DARK_GRAY);
        lbl_helados.setBounds(10, 228, 204, 61);
        contentPane.add(lbl_helados);

        JLabel lbl_tamano= new JLabel("Tama\u00F1o:");
        lbl_tamano.setForeground(Color.WHITE);
        lbl_tamano.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_tamano.setBackground(Color.DARK_GRAY);
        lbl_tamano.setBounds(224, 84, 124, 61);
        contentPane.add(lbl_tamano);

        combo_tam_refrescos = new JComboBox(tam);
        combo_tam_refrescos.setBounds(358, 101, 157, 26);
        combo_tam_refrescos.addActionListener(this);
        contentPane.add(combo_tam_refrescos);

        JLabel lbl_tamano2 = new JLabel("Tama\u00F1o:");
        lbl_tamano2.setForeground(Color.WHITE);
        lbl_tamano2.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_tamano2.setBackground(Color.DARK_GRAY);
        lbl_tamano2.setBounds(224, 156, 124, 61);
        contentPane.add(lbl_tamano2);

        combo_tam_palomitas = new JComboBox(tam);
        combo_tam_palomitas.setBounds(358, 173, 157, 26);
        combo_tam_palomitas.addActionListener(this);
        contentPane.add(combo_tam_palomitas);

        JLabel lbl_tamano3 = new JLabel("Tama\u00F1o:");
        lbl_tamano3.setForeground(Color.WHITE);
        lbl_tamano3.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_tamano3.setBackground(Color.DARK_GRAY);
        lbl_tamano3.setBounds(224, 228, 124, 61);
        contentPane.add(lbl_tamano3);

        combo_tam_helados = new JComboBox(tam);
        combo_tam_helados.setBounds(358, 245, 157, 26);
        combo_tam_helados.addActionListener(this);
        contentPane.add(combo_tam_helados);

        JLabel lbl_sabor = new JLabel("Sabor:");
        lbl_sabor.setForeground(Color.WHITE);
        lbl_sabor.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_sabor.setBackground(Color.DARK_GRAY);
        lbl_sabor.setBounds(525, 84, 95, 61);
        contentPane.add(lbl_sabor);

        
        combo_sabor_refrescos = new JComboBox<String>(saborR);
        combo_sabor_refrescos.setBounds(630, 101, 157, 26);
        combo_sabor_refrescos.addActionListener(this);
        contentPane.add(combo_sabor_refrescos);
        

        JLabel lbl_sabor2 = new JLabel("Sabor:");
        lbl_sabor2.setForeground(Color.WHITE);
        lbl_sabor2.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_sabor2.setBackground(Color.DARK_GRAY);
        lbl_sabor2.setBounds(525, 156, 95, 61);
        contentPane.add(lbl_sabor2);

        
        combo_sabor_palomitas = new JComboBox<String>(saborP);
        combo_sabor_palomitas.setBounds(630, 173, 157, 26);
        combo_sabor_palomitas.addActionListener(this);
        contentPane.add(combo_sabor_palomitas);
        
        
        
        
      
            
        /*spinner_palomitas = new JSpinner();
        SpinnerListModel sabP = new SpinnerListModel(saborP);
        spinner_palomitas.setModel(sabP);
        spinner_palomitas.setBounds(630, 173, 157, 26);
        spinner_palomitas.addChangeListener(this);
        getContentPane().add(spinner_palomitas);
		*/


        JLabel lbl_sabor3 = new JLabel("Sabor:");
        lbl_sabor3.setForeground(Color.WHITE);
        lbl_sabor3.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_sabor3.setBackground(Color.DARK_GRAY);
        lbl_sabor3.setBounds(525, 228, 95, 61);
        contentPane.add(lbl_sabor3);

        
        combo_sabor_helados = new JComboBox<String>(saborH);
        combo_sabor_helados.setBounds(630, 245, 157, 26);
        combo_sabor_helados.addActionListener(this);
        contentPane.add(combo_sabor_helados);
		

        lbl_precioR = new JLabel("$$$$");
        lbl_precioR.setForeground(Color.BLACK);
        lbl_precioR.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_precioR.setBounds(860, 98, 74, 32);
        contentPane.add(lbl_precioR);

        lbl_precioP = new JLabel("$$$$");
        lbl_precioP.setForeground(Color.WHITE);
        lbl_precioP.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_precioP.setBounds(860, 167, 74, 32);
        contentPane.add(lbl_precioP);

        lbl_precioH= new JLabel("$$$$");
        lbl_precioH.setForeground(Color.RED);
        lbl_precioH.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_precioH.setBounds(860, 239, 74, 32);
        contentPane.add(lbl_precioH);

        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 518, 199, 72);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);

        btnCancelarCompra = new JButton("Cancelar Compra");
        btnCancelarCompra.setForeground(Color.WHITE);
        btnCancelarCompra.setFont(new Font("Arial", Font.PLAIN, 25));
        btnCancelarCompra.setBackground(new Color(171, 0, 51));
        btnCancelarCompra.setBounds(213, 364, 238, 50);
        btnCancelarCompra.addActionListener(this);
        contentPane.add(btnCancelarCompra);

        btnPagar = new JButton("Pagar");
        btnPagar.setForeground(Color.WHITE);
        btnPagar.setFont(new Font("Arial", Font.PLAIN, 25));
        btnPagar.setBackground(new Color(171, 0, 51));
        btnPagar.setBounds(503, 364, 238, 50);
        btnPagar.addActionListener(this);
        contentPane.add(btnPagar);     
        
        if(cantR == 0) {
        	combo_tam_refrescos.setEnabled(false);
        	combo_sabor_refrescos.setEnabled(false);
        }
        if (cantP == 0) {
        	combo_tam_palomitas.setEnabled(false);
        	combo_sabor_palomitas.setEnabled(false);
        }
        if (cantH == 0) {
        	combo_tam_helados.setEnabled(false);
        	combo_sabor_helados.setEnabled(false);
        }
        if(cantR==0 && cantP==0 && cantH==0) {
        	btnPagar.setEnabled(false);
        }



    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelarCompra) {
            VentaDulceria ventaDulceria = new VentaDulceria();
            ventaDulceria.setVisible(true);
            dispose();

        } else if (e.getSource() == btnVolver) {
            VentaDulceria ventaDulceria = new VentaDulceria();
            ventaDulceria.setVisible(true);
            dispose();

        } else if (e.getSource() == btnPagar) {
        	
        	refresco.add((String) combo_tam_refrescos.getSelectedItem());
        	refresco.add((String) combo_sabor_refrescos.getSelectedItem());
        	
        	palomita.add((String) combo_tam_palomitas.getSelectedItem());
        	palomita.add((String) combo_sabor_palomitas.getSelectedItem());
        	
        	helado.add((String) combo_tam_helados.getSelectedItem());
        	helado.add((String) combo_sabor_helados.getSelectedItem());
             
            DetallesVentaDulceria detallesVentaDulceria = new DetallesVentaDulceria();
            detallesVentaDulceria.setVisible(true);
            dispose();
            int id = Integer.parseInt(JOptionPane.showInputDialog("Introducir ID de la venta"));
            obtener_fecha();
            
            try {
            	query = "SELECT Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, refresco.get(0));
	        	pstm.setString(2, refresco.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
            	
	        	precioR = rs.getInt(1);
	        	int totalR = precioR*cantR;
	        	
	        	query = "SELECT Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, palomita.get(0));
	        	pstm.setString(2, palomita.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
            	
	        	precioP = rs.getInt(1);
	        	int totalP = precioP*cantP;
	        	
	        	query = "SELECT Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, helado.get(0));
	        	pstm.setString(2, helado.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
            	
	        	precioH = rs.getInt(1);
	        	int totalH = precioH*cantH;
	        	
	        	int total = totalR+totalP+totalH;
            	query="INSERT INTO `Venta Dulceria` (`ID_VentaDulceria`, `ID_Usuario`, `Fecha_VentaDulc`, `Hora_VentaDulc`, `Costo_Total_Dulc`) VALUES (?,?,?,?,?)";
            	pstm=con.prepareStatement(query);
            	pstm.setInt(1, id);
            	pstm.setInt(2, Login.ID_USUARIO);
            	pstm.setString(3,fecha);
            	pstm.setString(4, hora);
            	pstm.setInt(5, total);
            	pstm.executeUpdate();
            	JOptionPane.showMessageDialog(null, "Venta agregada con exito.");
            	
            }catch(SQLException e1) {
            	
            }
        }
    }
    
    private String obtener_fecha() {
        
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha = hourdateFormat.format(date);
        return fecha;
    }

    private String obtener_hora() {
        String hora;
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
        hora = hourdateFormat.format(date);
        return hora;
    }
}