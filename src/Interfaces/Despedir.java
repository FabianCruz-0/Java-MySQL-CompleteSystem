package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Despedir extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JButton btn_volver, btn_eliminar;
    private Connection con = ConexionBD.conectar();
    public PreparedStatement pstm = null;
	ResultSet rs = null;
	String query="";
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Despedir frame = new Despedir();
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
    public Despedir() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 608);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(72,81,84));
        setBounds(100, 100, 480, 460);
        setSize(480, 640);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_contratar = new JLabel("Despedir");
        lbl_contratar.setForeground(Color.WHITE);
        lbl_contratar.setFont(new Font("Arial", Font.PLAIN, 22));
        lbl_contratar.setBounds(184, 11, 95, 56);
        getContentPane().add(lbl_contratar);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setBounds(46, 80, 81, 25);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 12));
        textField.setBackground(new Color(72,81,84));
        textField.setForeground(Color.WHITE);
        textField.setBounds(137, 78, 317, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        btn_volver = new JButton("Volver");
        btn_volver.setFont(new Font("Arial", Font.BOLD, 20));
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 316, 123, 43);
        btn_volver.addActionListener(this);
        contentPane.add(btn_volver);

        btn_eliminar = new JButton("Eliminar");
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 20));
        btn_eliminar.setForeground(Color.WHITE);
        btn_eliminar.setBackground(new Color(171, 0, 51));
        btn_eliminar.setBounds(331, 316, 123, 43);
        btn_eliminar.addActionListener(this);
        contentPane.add(btn_eliminar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_volver){
            menuAdmin menuAdmin = new menuAdmin();
            menuAdmin.frame.setVisible(true);
            dispose();

        }else if(e.getSource() == btn_eliminar){
        	if(textField.getText().isEmpty())
        	{
        		showMessageDialog(null, "Introducir un nombre");
        	}else {
        		String nombre = textField.getText();
        		try {
            		query = "DELETE FROM Usuario WHERE Nombre = ? ";
            		pstm = con.prepareStatement(query);
            		pstm.setString(1, nombre);
            		pstm.executeUpdate();
            		showMessageDialog(null,"quitado con exito");
               	 pstm.close();
               	 con.close();
            	} catch (SQLException e1) {
            		
            	}
        	}

        }

    }
}
