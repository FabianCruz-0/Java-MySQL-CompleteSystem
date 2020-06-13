package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAdmin implements ActionListener{
    JButton btnContratar, btnSalir;
    public JFrame frame;
    private JButton btnInforme;
    private JButton btnFunciones;
    private JButton btnRelleno;
    private JButton btnDespedir;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menuAdmin window = new menuAdmin();
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
    public menuAdmin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame..
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



        JLabel lblRegistrar = new JLabel("Bienvenido!");
        lblRegistrar.setForeground(Color.WHITE);
        lblRegistrar.setFont(new Font("Arial", Font.BOLD, 40));
        lblRegistrar.setBounds(232, 32, 511, 72);
        frame.getContentPane().add(lblRegistrar);

        btnContratar = new JButton("Contratar");
        btnContratar.setBorderPainted(false);
        btnContratar.setFocusPainted(false);
        btnContratar.setForeground(Color.WHITE);
        btnContratar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnContratar.setBackground(new Color(171, 0, 51));
        btnContratar.setBounds(60, 155, 229, 89);
        frame.getContentPane().add(btnContratar);
        btnContratar.addActionListener(this);

        btnInforme = new JButton("Informe");
        btnInforme.setForeground(Color.WHITE);
        btnInforme.setFont(new Font("Arial", Font.PLAIN, 17));
        btnInforme.setFocusPainted(false);
        btnInforme.setBorderPainted(false);
        btnInforme.setBackground(new Color(171, 0, 51));
        btnInforme.setBounds(60, 363, 229, 89);
        frame.getContentPane().add(btnInforme);
        btnInforme.addActionListener(this);

        btnFunciones = new JButton("Funciones");
        btnFunciones.setForeground(Color.WHITE);
        btnFunciones.setFont(new Font("Arial", Font.PLAIN, 17));
        btnFunciones.setFocusPainted(false);
        btnFunciones.setBorderPainted(false);
        btnFunciones.setBackground(new Color(171, 0, 51));
        btnFunciones.setBounds(359, 263, 229, 89);
        frame.getContentPane().add(btnFunciones);
        btnFunciones.addActionListener(this);

        btnRelleno = new JButton("Relleno de Inventario");
        btnRelleno.setForeground(Color.WHITE);
        btnRelleno.setFont(new Font("Arial", Font.PLAIN, 17));
        btnRelleno.setFocusPainted(false);
        btnRelleno.setBorderPainted(false);
        btnRelleno.setBackground(new Color(171, 0, 51));
        btnRelleno.setBounds(657, 363, 229, 89);
        frame.getContentPane().add(btnRelleno);
        btnRelleno.addActionListener(this);

        btnDespedir = new JButton("Despedir");
        btnDespedir.setForeground(Color.WHITE);
        btnDespedir.setFont(new Font("Arial", Font.PLAIN, 17));
        btnDespedir.setFocusPainted(false);
        btnDespedir.setBorderPainted(false);
        btnDespedir.setBackground(new Color(171, 0, 51));
        btnDespedir.setBounds(657, 155, 229, 89);
        frame.getContentPane().add(btnDespedir);
        btnDespedir.addActionListener(this);


        btnSalir = new JButton("Salir");
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSalir.setFocusPainted(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setBackground(new Color(51, 51, 51));
        btnSalir.setBounds(410, 478, 139, 31);
        frame.getContentPane().add(btnSalir);
        btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnContratar) {
            Contratar contratar = new Contratar();
            contratar.setVisible(true);
            frame.dispose();

        }
        else if(e.getSource()==btnDespedir) {
            Despedir despedir = new Despedir();
            despedir.setVisible(true);
            frame.dispose();
        }
        else if(e.getSource()==btnInforme) {
        	Informe informe = new Informe();
            informe.frame.setVisible(true);
            frame.dispose();

        }
        else if(e.getSource()==btnFunciones) {
            menuPeliculas menuPeliculas = new menuPeliculas();
            menuPeliculas.frame.setVisible(true);
            frame.dispose();
        }
        else if(e.getSource()==btnRelleno) {
            menuInventario menu = new menuInventario();
            menu.frame.setVisible(true);
            frame.dispose();
        }
        else {
            Login login = new Login();
            login.frameLog.setVisible(true);
        }

        frame.dispose();

    }

}
