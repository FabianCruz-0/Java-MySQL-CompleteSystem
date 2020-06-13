package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class eliminarProducto implements ActionListener{
    JButton btnVolver,btnEliminar;
    public JFrame frame;
    private JTextField textClave;

    /**
     * Launch the application..
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
                    eliminarProducto window = new eliminarProducto();
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
    public eliminarProducto() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    @SuppressWarnings({ })
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


        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);
        btnVolver.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnEliminar.setBackground(new Color(171, 0, 51));
        btnEliminar.setBounds(389, 298, 149, 39);
        frame.getContentPane().add(btnEliminar);
        btnEliminar.addActionListener(this);

        JLabel lblClave = new JLabel("Clave del articulo:");
        lblClave.setForeground(Color.WHITE);
        lblClave.setFont(new Font("Arial", Font.PLAIN, 20));
        lblClave.setBounds(250, 185, 170, 24);
        frame.getContentPane().add(lblClave);

        textClave = new JTextField();
        textClave.setBounds(414, 191, 237, 19);
        frame.getContentPane().add(textClave);
        textClave.setColumns(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuInventario menuInventario = new menuInventario();

        if(e.getSource()==btnVolver) {
            menuInventario.frame.setVisible(true);
            frame.dispose();
        }
        else {
        	
        	if(textClave.getText().isEmpty())
        	{
        		JOptionPane.showMessageDialog(null, "Falta dato");
        	} else {
        		int id = Integer.parseInt(textClave.getText());
        		
        		try {
        			
        			query="DELETE FROM `Producto Dulceria` WHERE `ID_Producto`= ?";
        			pstm = con.prepareStatement(query);
        			pstm.setInt(1, id);
        			pstm.executeUpdate();
            		JOptionPane.showMessageDialog(null, "listo");
            		rs.close();
               	 pstm.close();
               	 con.close();
        		} catch (SQLException e1) {
        			
        		}
        		
        	}     	
            int opcion=JOptionPane.showConfirmDialog(null, "El producto se ha eliminado exitosamente!, quiere eliminar otro producto?","Eliminado",JOptionPane.YES_NO_OPTION);

            if(opcion == JOptionPane.YES_OPTION) {
                textClave.setText("");

            }
            else {
                menuInventario.frame.setVisible(true);
                frame.dispose();
            }
        }


    }

}
