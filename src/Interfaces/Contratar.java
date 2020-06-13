package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contratar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	// CONECTA A LA BASE DE DATOS Y CONSIGUE EL CON
    private Connection con = ConexionBD.conectar();
    public PreparedStatement pstm = null;
	ResultSet rs = null;
	String query="";
    
    private JPanel contentPane;
    private JTextField txt_nombre;
    private JTextField txt_telefono;
    private JTextField txt_direccion;
    private String[] tipos = {"Admin", "Usuario"};
    private JComboBox comboBox;
    private JButton btn_volver, btn_enviar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Contratar frame = new Contratar();
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
    public Contratar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 608);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(72,81,84));
        setBounds(100, 100, 480, 460);
        setSize(480, 640);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_contratar = new JLabel("Contratar");
        lbl_contratar.setForeground(Color.WHITE);
        lbl_contratar.setFont(new Font("Arial", Font.PLAIN, 22));
        lbl_contratar.setBounds(184, 11, 95, 56);
        getContentPane().add(lbl_contratar);

        JLabel lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setForeground(Color.WHITE);
        lbl_nombre.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_nombre.setBounds(46, 80, 81, 25);
        contentPane.add(lbl_nombre);

        JLabel lbl_telefono = new JLabel("Tel\u00E9fono:");
        lbl_telefono.setForeground(Color.WHITE);
        lbl_telefono.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_telefono.setBounds(46, 140, 95, 25);
        contentPane.add(lbl_telefono);

        JLabel lbl_direccion = new JLabel("Direcci\u00F3n:");
        lbl_direccion.setForeground(Color.WHITE);
        lbl_direccion.setFont(new Font("Arial", Font.PLAIN, 20));
        lbl_direccion.setBounds(46, 200, 95, 25);
        contentPane.add(lbl_direccion);

        txt_nombre = new JTextField();
        txt_nombre.setFont(new Font("Arial", Font.PLAIN, 12));
        txt_nombre.setBackground(new Color(72,81,84));
        txt_nombre.setForeground(Color.WHITE);
        txt_nombre.setBounds(137, 78, 317, 20);
        contentPane.add(txt_nombre);
        txt_nombre.setColumns(10);

        txt_telefono = new JTextField();
        txt_telefono.setFont(new Font("Arial", Font.PLAIN, 12));
        txt_telefono.setForeground(Color.WHITE);
        txt_telefono.setBackground(new Color(72,81,84));
        txt_telefono.setBounds(137, 140, 317, 20);
        contentPane.add(txt_telefono);
        txt_telefono.setColumns(10);

        txt_direccion = new JTextField();
        txt_direccion.setFont(new Font("Arial", Font.PLAIN, 12));
        txt_direccion.setForeground(Color.WHITE);
        txt_direccion.setBackground(new Color(72,81,84));
        txt_direccion.setBounds(137, 200, 317, 20);
        contentPane.add(txt_direccion);
        txt_direccion.setColumns(10);

        JLabel lblNivel = new JLabel("Nivel:");
        lblNivel.setForeground(Color.WHITE);
        lblNivel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNivel.setBounds(46, 260, 95, 25);
        contentPane.add(lblNivel);

        comboBox = new JComboBox(tipos);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(46, 48, 48));
        comboBox.setBounds(137, 260, 142, 20);
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(this);
        contentPane.add(comboBox);

        btn_volver = new JButton("Volver");
        btn_volver.setFont(new Font("Arial", Font.BOLD, 20));
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 316, 123, 43);
        btn_volver.addActionListener(this);
        contentPane.add(btn_volver);

        btn_enviar = new JButton("Enviar");
        btn_enviar.setFont(new Font("Arial", Font.BOLD, 20));
        btn_enviar.setForeground(Color.WHITE);
        btn_enviar.setBackground(new Color(171, 0, 51));
        btn_enviar.setBounds(331, 316, 123, 43);
        btn_enviar.addActionListener(this);
        contentPane.add(btn_enviar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_volver){
            menuAdmin menuAdmin = new menuAdmin();
            menuAdmin.frame.setVisible(true);
            dispose(); //Elimina este JFrame por completo, dejando el del MenuAdmin
            
            
            
            
        }else if(e.getSource() == btn_enviar){
        	
        	if (txt_nombre.getText().isEmpty() || txt_telefono.getText().isEmpty() || txt_direccion.getText().isEmpty() ) {
        		
                showMessageDialog(null, "Rellene todos los datos.");
                
            } else {
            		int id = Integer.parseInt(JOptionPane.showInputDialog("id"));
            		String contrasena = JOptionPane.showInputDialog("contraseña");
            		
            		if(id == 0 || contrasena == null)
            		{
            			showMessageDialog(null,"Introducir valores");
            		}else {
            			String nombre = txt_nombre.getText();
                		int telefono = Integer.parseInt(txt_telefono.getText());
                		String direccion = txt_direccion.getText();
                		String nivel = (String)comboBox.getSelectedItem();
                		int nivelBool;
                		if(nivel=="Admin")
                		{
                			nivelBool = 1;
                		} else {
                			nivelBool = 0;
                		}
                		try {
                		query = "INSERT INTO Usuario (ID_Usuario, Admin, Contrasena, Nombre, Telefono, Direccion) VALUES (?, ?, ?, ?, ?, ?)";
                		pstm = con.prepareStatement(query);
                		pstm.setInt(1, id);
                		pstm.setInt(2,nivelBool);
                		pstm.setString(3,contrasena);
                		pstm.setString(4,nombre);
                		pstm.setInt(5,telefono);
                		pstm.setString(6,direccion);
                		pstm.executeUpdate();
                		showMessageDialog(null,"Empujado con exito");
                		
                   	 pstm.close();
                   	 con.close();
                	} catch (SQLException e1) {
                		
                	}
                		
            	}
            }

            
            
            
            
        }else if(e.getSource() == comboBox){

        }

    }
}
