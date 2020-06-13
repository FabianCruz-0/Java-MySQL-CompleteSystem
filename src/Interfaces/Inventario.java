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

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Inventario extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList list = new JList();
    private JButton btn_volver, btnBuscar;
    public JFrame frame;
    private JTextField textIdProducto;
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
                	Inventario window = new Inventario();
                    window.frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Inventario() {
    	frame = new JFrame();
		frame.setBounds(100, 100, 960, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960,640);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(72,81,84));

        JLabel lbl_inventario = new JLabel("Inventario");
        lbl_inventario.setForeground(Color.WHITE);
        lbl_inventario.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_inventario.setBounds(400, 11, 191, 88);
        frame.getContentPane().add(lbl_inventario);
        
        JLabel lblIdProducto = new JLabel("ID Producto:");
        lblIdProducto.setForeground(Color.WHITE);
        lblIdProducto.setFont(new Font("Arial", Font.PLAIN, 20));
        lblIdProducto.setBounds(280, 120, 149, 16);
        frame.getContentPane().add(lblIdProducto);
        
        textIdProducto = new JTextField();
        textIdProducto.setColumns(10);
        textIdProducto.setBounds(400, 120, 208, 19);
        frame.getContentPane().add(textIdProducto);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setBackground(new Color(171, 0, 51));
        btnBuscar.setBounds(413, 170, 149, 39);
        frame.getContentPane().add(btnBuscar);
        btnBuscar.addActionListener(this);

        btn_volver = new JButton("Volver");
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_volver.setFocusPainted(false);
        btn_volver.setBorderPainted(false);
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 562, 139, 31);
		frame.getContentPane().add(btn_volver);
		btn_volver.addActionListener(this);
		
	
        
		lista = new DefaultListModel();
		list.setModel(lista);
        list.setBounds(10, 250, 924, 290);
        frame.getContentPane().add(list);
        list.setVisibleRowCount(4);
        lista.addElement("Nombre                                Tamanio                                Precio                                Sabor                               ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_volver){
            Informe informe = new Informe();
            informe.frame.setVisible(true);
            frame.dispose();
        }
        else if(e.getSource()==btnBuscar){
        	try {
        		query = "SELECT * FROM `Producto Dulceria` WHERE `ID_Producto` = ?";
            	pstm = con.prepareStatement(query);
            	pstm.setInt(1, Integer.parseInt(textIdProducto.getText()));
            	
            	rs = pstm.executeQuery(); 
            	
            	if(rs.next()) {
            		String nom = rs.getString("Nombre_Producto");
            		String tam = rs.getString("Tamaño"); //SI NO DICE TAMAÑO, CORREGIRLO, TIENE QUE SER CON Ñ.
            		String prec = rs.getString("Precio");
            		String sabor = rs.getString("Sabor");
            		String exis = rs.getString("Existencias");
            		
            		lista.addElement(" ");
                	lista.addElement(nom+"                                "+tam+"                                "+prec+"                                "+sabor+"                                "+exis);
                	lista.addElement("_______________________________________________________________________________________________________________________");
            	}
            	
            	
            	
            	rs.close();
           	 pstm.close();
           	 con.close();
            } catch (SQLException e1) {	
            }
        }
    }
}

