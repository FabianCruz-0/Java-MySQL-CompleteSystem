package Interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuInventario implements ActionListener{

    public JFrame frame;
    public JButton btnVolver, btnRegistrar, btnRellenar, btnEliminar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menuInventario window = new menuInventario();
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
    public menuInventario() {
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



        JLabel lblMenuInventario = new JLabel("Men\u00FA Inventario");
        lblMenuInventario.setForeground(Color.WHITE);
        lblMenuInventario.setFont(new Font("Arial", Font.BOLD, 40));
        lblMenuInventario.setBounds(337, 53, 309, 72);
        frame.getContentPane().add(lblMenuInventario);

        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);
        btnVolver.addActionListener(this);

        btnRegistrar = new JButton("Registrar nuevo producto");
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 24));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setBackground(new Color(171, 0, 51));
        btnRegistrar.setBounds(307, 158, 339, 85);
        frame.getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        btnRellenar = new JButton("Rellenar inventario");
        btnRellenar.setForeground(Color.WHITE);
        btnRellenar.setFont(new Font("Arial", Font.PLAIN, 24));
        btnRellenar.setFocusPainted(false);
        btnRellenar.setBorderPainted(false);
        btnRellenar.setBackground(new Color(171, 0, 51));
        btnRellenar.setBounds(307, 270, 339, 85);
        frame.getContentPane().add(btnRellenar);
        btnRellenar.addActionListener(this);

        btnEliminar = new JButton("Eliminar producto");
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Arial", Font.PLAIN, 24));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setBackground(new Color(171, 0, 51));
        btnEliminar.setBounds(307, 382, 339, 85);
        frame.getContentPane().add(btnEliminar);
        btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnRegistrar) {
            registrarNuevoProducto registrar = new registrarNuevoProducto();
            registrar.frame.setVisible(true);

        }
        else if(e.getSource()==btnRellenar) {
            rellenoInventario relleno = new rellenoInventario();
            relleno.frame.setVisible(true);

        }
        else if(e.getSource()==btnEliminar) {
            eliminarProducto eliminar = new eliminarProducto();
            eliminar.frame.setVisible(true);

        }
        else{
            menuAdmin menuAdmin = new menuAdmin();
            menuAdmin.frame.setVisible(true);
        }


        frame.dispose();


    }

}
