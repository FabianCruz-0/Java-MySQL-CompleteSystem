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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class eliminarFuncion implements ActionListener{
	private JButton btnVolver,btnEliminar;
	public JFrame frame;
	private JTextField textNumero;

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
					eliminarFuncion window = new eliminarFuncion();
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
	public eliminarFuncion() {
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
		
		
		
		JLabel lblEliminar = new JLabel("Eliminar funcion");
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Arial", Font.BOLD, 40));
		lblEliminar.setBounds(299, 45, 342, 72);
		frame.getContentPane().add(lblEliminar);
		
		
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
		btnEliminar.setBounds(389, 278, 149, 39);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		JLabel lblNumero = new JLabel("Numero de sala:");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumero.setBounds(335, 184, 170, 24);
		frame.getContentPane().add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(491, 190, 96, 19);
		frame.getContentPane().add(textNumero);
		textNumero.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		menuFunciones menuFunciones = new menuFunciones();
		int opcion;
		
		if(e.getSource()==btnEliminar) {
			
			if(textNumero.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Intreoducir bien el dato");
			} else {
				int sala = Integer.parseInt(textNumero.getText());
				
				try {
					query= "SELECT * FROM Funcion WHERE Num_Sala = ?";
					pstm = con.prepareStatement(query);
	        		pstm.setInt(1,sala);
	        		rs = pstm.executeQuery();
	        		if(rs.next()) {
	        			query ="DELETE FROM Funcion WHERE Num_Sala = ?";
	        			pstm = con.prepareStatement(query);
		        		pstm.setInt(1,sala);
		        		pstm.execute();
		        		opcion = JOptionPane.showConfirmDialog(null, "Se ha eliminado exitosamente!. \n\n�Quiere eliminar otra funcion?\n","Eliminado",JOptionPane.YES_NO_OPTION);
	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null, "No se encuentra la Funcion");
	        		}
	        		rs.close();
	            	 pstm.close();
	            	 con.close();
					} catch (SQLException e1) {
					
				}
				
				
			}
			
			opcion = JOptionPane.NO_OPTION;
			
			
			if(opcion==JOptionPane.YES_OPTION) {
				textNumero.setText("");
			}
			else {
				menuFunciones.frame.setVisible(true);
				frame.dispose();
			}
		}
		else {
			menuFunciones.frame.setVisible(true);
			frame.dispose();
		}
	}
}
