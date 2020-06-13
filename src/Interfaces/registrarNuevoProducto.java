package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registrarNuevoProducto implements ActionListener{
    JButton btnVolver,btnRegistrar;
    public JFrame frame;
    private JTextField textPrecio,textTamano,textSabor,textNombre;

    /**
     * Launch the application.
     */
    
 // CONECTA A LA BASE DE DATOS Y CONSIGUE EL CON
    private Connection con = ConexionBD.conectar();
    public PreparedStatement pstm = null;
	ResultSet rs = null;
	String query="";
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    registrarNuevoProducto window = new registrarNuevoProducto();
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
    public registrarNuevoProducto() {
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



        JLabel lblRegistrar = new JLabel("Registrar nuevo producto");
        lblRegistrar.setForeground(Color.WHITE);
        lblRegistrar.setFont(new Font("Arial", Font.BOLD, 40));
        lblRegistrar.setBounds(231, 53, 511, 72);
        frame.getContentPane().add(lblRegistrar);
        
        JLabel lblNombre = new JLabel("Nombre del producto: ");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNombre.setBounds(250, 270, 511, 72);
        frame.getContentPane().add(lblNombre);
        
        textNombre = new JTextField();
        textNombre.setBounds(450, 300, 237, 19);
        frame.getContentPane().add(textNombre);
        textNombre.setColumns(10);

        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);

        btnVolver.addActionListener(this);


        JLabel lblTipo = new JLabel("Tipo de producto:");
        lblTipo.setForeground(Color.WHITE);
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTipo.setBounds(90, 135, 170, 24);
        frame.getContentPane().add(lblTipo);



        JLabel lblTamano = new JLabel("Tamano:");
        lblTamano.setForeground(Color.WHITE);
        lblTamano.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTamano.setBounds(585, 137, 149, 16);
        frame.getContentPane().add(lblTamano);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnRegistrar.setBackground(new Color(171, 0, 51));
        btnRegistrar.setBounds(409, 359, 149, 39);
        frame.getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setForeground(Color.WHITE);
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Palomitas", "Refresco", "Helado"}));
        comboBoxTipo.setBounds(252, 140, 149, 21);
        comboBoxTipo.setBackground(new Color(34,31,32));
        frame.getContentPane().add(comboBoxTipo);

        textTamano = new JTextField();
        textTamano.setBounds(666, 138, 189, 21);
        frame.getContentPane().add(textTamano);
        textTamano.setColumns(10);

        textSabor = new JTextField();
        textSabor.setBounds(652, 240, 203, 21);
        frame.getContentPane().add(textSabor);
        textSabor.setColumns(10);

        JLabel lblSabor = new JLabel("Sabor:");
        lblSabor.setForeground(Color.WHITE);
        lblSabor.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSabor.setBounds(585, 239, 149, 16);
        frame.getContentPane().add(lblSabor);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setForeground(Color.WHITE);
        lblPrecio.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPrecio.setBounds(90, 237, 170, 24);
        frame.getContentPane().add(lblPrecio);

        textPrecio = new JTextField();
        textPrecio.setBounds(164, 241, 237, 19);
        frame.getContentPane().add(textPrecio);
        textPrecio.setColumns(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuInventario menuInventario = new menuInventario();
        if(e.getSource()==btnVolver) {

            menuInventario.frame.setVisible(true);

            frame.dispose();
        }
        else if(e.getSource()==btnRegistrar) {

        	if(textPrecio.getText().isEmpty() || textTamano.getText().isEmpty() || textSabor.getText().isEmpty() || textNombre.getText().isEmpty())
        	{
        		JOptionPane.showMessageDialog(null,"Faltan datos");
        	} else {
        		
        		float precio = Float.parseFloat(textPrecio.getText());
        		String tamano = textTamano.getText();
        		String sabor = textSabor.getText();
        		String nombre = textNombre.getText();
        		int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresar un id para el producto: "+nombre));
        		
        		try {
        			query="INSERT INTO `Producto Dulceria` (`ID_Producto`, `Nombre_Producto`, `Tamaño`, `Precio`, `Sabor`, `Existencias`) VALUES (?, ?, ?, ?, ?, ?)";
        			pstm = con.prepareStatement(query);
        			pstm.setInt(1,id);
        			pstm.setString(2,nombre);
        			pstm.setString(3, tamano);
        			pstm.setFloat(4, precio);
        			pstm.setString(5, sabor);
        			pstm.setInt(6, 1);
        			pstm.executeUpdate();
        			JOptionPane.showMessageDialog(null, "listo, producto agregado");
               	 pstm.close();
               	 con.close();
        		} catch(SQLException e1) {
        			
        		}
        		
        		
        		
        	}

            int opcion = JOptionPane.showConfirmDialog(null, "Se ha registrado exitosamente el producto!, desdea agregar otro producto?","Registrado",JOptionPane.YES_NO_OPTION);

            if(opcion==JOptionPane.YES_OPTION) {
                textPrecio.setText("");
            }
            else {
                menuInventario.frame.setVisible(true);
                frame.dispose();
            }

        }

    }


}