package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class rellenoInventario implements ActionListener{

    public JButton btnVolver, btnActualizar;
    public JFrame frame;
    public JTextField textClave;
    public JTextField textCantidad;

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
                    rellenoInventario window = new rellenoInventario();
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
    public rellenoInventario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 960, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960,640);
        frame.getContentPane().setLayout(null);


        frame.getContentPane().setBackground(new Color(72,81,84));



        JLabel lblRellenoInventario = new JLabel("Relleno de inventario");
        lblRellenoInventario.setForeground(Color.WHITE);
        lblRellenoInventario.setFont(new Font("Arial", Font.BOLD, 40));
        lblRellenoInventario.setBounds(283, 53, 420, 72);
        frame.getContentPane().add(lblRellenoInventario);

        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);
        btnVolver.addActionListener(this);

        textClave = new JTextField();
        textClave.setColumns(10);
        textClave.setBounds(255, 135, 158, 19);
        frame.getContentPane().add(textClave);

        JLabel lblClave = new JLabel("ID del articulo:");
        lblClave.setForeground(Color.WHITE);
        lblClave.setFont(new Font("Arial", Font.PLAIN, 20));
        lblClave.setBounds(90, 135, 170, 16);
        frame.getContentPane().add(lblClave);

        textCantidad = new JTextField();
        textCantidad.setColumns(10);
        textCantidad.setBounds(647, 137, 208, 19);
        frame.getContentPane().add(textCantidad);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setForeground(Color.WHITE);
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCantidad.setBounds(554, 135, 149, 16);
        frame.getContentPane().add(lblCantidad);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setBackground(new Color(171, 0, 51));
        btnActualizar.setBounds(413, 224, 149, 39);
        frame.getContentPane().add(btnActualizar);
        btnActualizar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuInventario menuInventario = new menuInventario();

        if(e.getSource()==btnVolver) {
            menuInventario.frame.setVisible(true);
            frame.dispose();

        }
        else if(e.getSource()==btnActualizar) {
        	
        	if(textClave.getText().isEmpty() || textCantidad.getText().isEmpty())
        	{
        		JOptionPane.showMessageDialog(null, "Faltan datos.");
        	} else {
        	int id = Integer.parseInt(textClave.getText());	
        	int cantidad = Integer.parseInt(textCantidad.getText());
        	
        	try {
        		
        		query="UPDATE `Producto Dulceria` SET `Existencias`= ? WHERE `ID_Producto`=?";
        		pstm = con.prepareStatement(query);
        		pstm.setInt(1,cantidad);
        		pstm.setInt(2, id);
        		pstm.executeUpdate();
        		JOptionPane.showMessageDialog(null, "listo!");

           	 pstm.close();
           	 con.close();
        	} catch (SQLException e1) {
        		
        	}
        	
        	
        	}
        	
        	
        	
            int opcion = JOptionPane.showConfirmDialog(null, "Actualizado correctamente!, quiere rellenar otro producto?","Actualizado",JOptionPane.YES_NO_OPTION);

            if(opcion == JOptionPane.YES_OPTION) {
                textClave.setText("");
                textCantidad.setText("");
            }
            else {
                menuInventario.frame.setVisible(true);
                frame.dispose();
            }
        }
    }
}
