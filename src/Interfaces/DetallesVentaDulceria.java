package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetallesVentaDulceria extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel lbl_articulos, lbl_tamanos, lbl_sabores, lbl_precios, lbl_preciototal;
    private JButton btn_cancelar, btn_pagar, btn_volver;
    JList list = new JList();
    DefaultListModel lista;
    private Connection con = ConexionBD.conectar();
    public PreparedStatement pstm = null;
    ResultSet rs = null;
    
    String query="";
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DetallesVentaDulceria frame = new DetallesVentaDulceria();
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
    public DetallesVentaDulceria() {
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72, 81, 84));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_detalles = new JLabel("Detalles de la venta\r\n");
        lbl_detalles.setForeground(Color.WHITE);
        lbl_detalles.setFont(new Font("Arial Black", Font.BOLD, 40));
        lbl_detalles.setBounds(234, 11, 476, 84);
        contentPane.add(lbl_detalles);

        lista = new DefaultListModel();
		list.setModel(lista);
        list.setBounds(10, 250, 924, 290);
        getContentPane().add(list);
        list.setVisibleRowCount(4);
        lista.addElement("Nombre                                                                                           Tamanio                                Precio                                Sabor                                                         Cantidad");

        btn_cancelar = new JButton("Cancelar Compra\r\n");
        btn_cancelar.setBounds(234, 495, 201, 40);
        contentPane.add(btn_cancelar);
        btn_cancelar.setForeground(Color.WHITE);
        btn_cancelar.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_cancelar.setBackground(new Color(171, 0, 51));
        btn_cancelar.addActionListener(this);

        btn_pagar = new JButton("Pagar");
        btn_pagar.setBounds(509, 495, 201, 40);
        contentPane.add(btn_pagar);
        btn_pagar.setForeground(Color.WHITE);
        btn_pagar.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_pagar.setBackground(new Color(171, 0, 51));
        btn_pagar.addActionListener(this);

        btn_volver = new JButton("Volver");
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setFont(new Font("Arial", Font.PLAIN, 30));
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 526, 149, 64);
        btn_volver.addActionListener(this);

        contentPane.add(btn_volver);

        inicializacion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_cancelar){
            VentaDulceria ventaDulceria = new VentaDulceria();
            ventaDulceria.setVisible(true);
            dispose();

        }else if(e.getSource() == btn_pagar){
            JOptionPane.showMessageDialog(null, "pago aceptado");

        }else if(e.getSource() == btn_volver){
            SeleccionDetallesArt seleccionDetallesArt = new SeleccionDetallesArt();
            seleccionDetallesArt.setVisible(true);

        }

    }
    
    private void inicializacion() {
    	SeleccionDetallesArt articulo = new SeleccionDetallesArt();
    	if(articulo.cantR!=0) {
	    	try {
	    		query = "SELECT Nombre_Producto,Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, articulo.refresco.get(0));
	        	pstm.setString(2, articulo.refresco.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
	        	lista.addElement(rs.getString(1)+"                                                                                           "+articulo.refresco.get(0)+"                                "+rs.getInt(2)+"                                "+articulo.refresco.get(1)+"                                                         "+articulo.cantR);
	        	
	        	
	        } catch (SQLException e1) {
	        	
	        
	        	
	        		
	        }
    	}
    	if(articulo.cantP!=0) {
    		
    	
	    	try {
	    		query = "SELECT Nombre_Producto,Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, articulo.palomita.get(0));
	        	pstm.setString(2, articulo.palomita.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
	        	lista.addElement(rs.getString(1)+"                                                                                           "+articulo.palomita.get(0)+"                                "+rs.getInt(2)+"                                "+articulo.palomita.get(1)+"                                                         "+articulo.cantR);
	        	
	        	
	        } catch (SQLException e1) {
	        	
	        
	        	
	        		
	        }
    	}
    	if(articulo.cantH!=0) {
	    	try {
	    		query = "SELECT Nombre_Producto,Precio FROM `Producto Dulceria` WHERE Tamaño = ? AND Sabor=?";
	    		pstm = con.prepareStatement(query);
	        	pstm.setString(1, articulo.helado.get(0));
	        	pstm.setString(2, articulo.helado.get(1));
	        	rs = pstm.executeQuery();
	        	rs.next();
	        	lista.addElement(rs.getString(1)+"                                                                                           "+articulo.helado.get(0)+"                                "+rs.getInt(2)+"                                "+articulo.helado.get(1)+"                                                         "+articulo.cantR);
	        	
	        	
	        } catch (SQLException e1) {
	        	
	        
	        	
	        		
	        }
    	}
    	
    }
}
