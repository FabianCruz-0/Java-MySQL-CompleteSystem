package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDulceria extends JFrame implements ActionListener, ChangeListener {

    private JPanel contentPane;
    private JButton btn_confirmar, btn_cambiar, btn_corteDulceria;
    private JSpinner spinner_refrescos, spinner_palomitas, spinner_helados;
    public static int cantidadP, cantidadR, cantidadH;
    

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentaDulceria frame = new VentaDulceria();
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
    public VentaDulceria() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 460);
        setSize(960, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().setBackground(new Color(72, 81, 84));
        getContentPane().setLayout(null);

        JLabel lbl_dulceria = new JLabel("Dulcer\u00EDa");
        lbl_dulceria.setForeground(Color.WHITE);
        lbl_dulceria.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_dulceria.setBounds(391, 11, 161, 40);
        getContentPane().add(lbl_dulceria);

        JLabel lbl_articulos = new JLabel("Art\u00EDculos");
        lbl_articulos.setForeground(Color.WHITE);
        lbl_articulos.setFont(new Font("Arial", Font.PLAIN, 30));
        lbl_articulos.setBounds(414, 62, 116, 50);
        getContentPane().add(lbl_articulos);

        JLabel lbl_refrescos = new JLabel("Refrescos:            >");
        lbl_refrescos.setForeground(Color.WHITE);
        lbl_refrescos.setBackground(Color.DARK_GRAY);
        lbl_refrescos.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_refrescos.setBounds(10, 112, 300, 61);
        getContentPane().add(lbl_refrescos);

        JLabel lbl_palomitas = new JLabel("Palomitas:             >");
        lbl_palomitas.setForeground(Color.WHITE);
        lbl_palomitas.setBackground(Color.DARK_GRAY);
        lbl_palomitas.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_palomitas.setBounds(10, 184, 300, 61);
        getContentPane().add(lbl_palomitas);

        JLabel lbl_helados = new JLabel("Helados:                >");
        lbl_helados.setForeground(Color.WHITE);
        lbl_helados.setBackground(Color.DARK_GRAY);
        lbl_helados.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_helados.setBounds(10, 256, 300, 61);
        getContentPane().add(lbl_helados);

        spinner_refrescos = new JSpinner();
        spinner_refrescos.setModel(new SpinnerNumberModel(0, null, 10, 1));
        spinner_refrescos.setBounds(764, 119, 170, 40);
        spinner_refrescos.addChangeListener(this);
        getContentPane().add(spinner_refrescos);
        JTextField ftf = getTextField(spinner_refrescos);
        if (ftf != null) {
            ftf.setColumns(8);
            ftf.setHorizontalAlignment(JTextField.RIGHT);
            ftf.setEditable(false);
            ftf.setBackground(new Color(171, 0, 51));
            ftf.setForeground(new Color(255, 255, 255));
        }

        JLabel lbl_cant1 = new JLabel("Cantidad:");
        lbl_cant1.setForeground(Color.WHITE);
        lbl_cant1.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_cant1.setBackground(Color.DARK_GRAY);
        lbl_cant1.setBounds(592, 112, 276, 61);
        getContentPane().add(lbl_cant1);

        spinner_palomitas = new JSpinner();
        spinner_palomitas.setModel(new SpinnerNumberModel(0, null, 10, 1));
        spinner_palomitas.setBounds(764, 191, 170, 40);
        spinner_palomitas.addChangeListener(this);
        getContentPane().add(spinner_palomitas);
        JTextField ftf1 = getTextField(spinner_palomitas);
        if (ftf1 != null) {
            ftf1.setColumns(8);
            ftf1.setHorizontalAlignment(JTextField.RIGHT);
            ftf1.setEditable(false);
            ftf1.setBackground(new Color(171, 0, 51));
            ftf1.setForeground(new Color(255, 255, 255));
        }

        JLabel lbl_cant2 = new JLabel("Cantidad:");
        lbl_cant2.setForeground(Color.WHITE);
        lbl_cant2.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_cant2.setBackground(Color.DARK_GRAY);
        lbl_cant2.setBounds(592, 184, 276, 61);
        getContentPane().add(lbl_cant2);

        spinner_helados = new JSpinner();
        spinner_helados.setModel(new SpinnerNumberModel(0, null, 10, 1));
        spinner_helados.setBounds(764, 263, 170, 40);
        spinner_helados.addChangeListener(this);
        getContentPane().add(spinner_helados);
        JTextField ftf2 = getTextField(spinner_helados);
        if (ftf2 != null) {
            ftf2.setColumns(8);
            ftf2.setHorizontalAlignment(JTextField.RIGHT);
            ftf2.setEditable(false);
            ftf2.setBackground(new Color(171, 0, 51));
            ftf2.setForeground(new Color(255, 255, 255));
        }


        JLabel lbl_cant3 = new JLabel("Cantidad:");
        lbl_cant3.setForeground(Color.WHITE);
        lbl_cant3.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_cant3.setBackground(Color.DARK_GRAY);
        lbl_cant3.setBounds(592, 256, 276, 61);
        getContentPane().add(lbl_cant3);

        btn_confirmar = new JButton("Confirmar");
        btn_confirmar.setBackground(new Color(171, 0, 51));
        btn_confirmar.setForeground(Color.WHITE);
        btn_confirmar.setFont(new Font("Arial", Font.PLAIN, 25));
        btn_confirmar.setBounds(379, 361, 186, 50);
        btn_confirmar.addActionListener(this);
        getContentPane().add(btn_confirmar);

        btn_cambiar = new JButton("Cambiar a \r\ntaquilla");
        btn_cambiar.setForeground(Color.WHITE);
        btn_cambiar.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_cambiar.setBackground(new Color(171, 0, 51));
        btn_cambiar.setBounds(10, 518, 199, 72);
        btn_cambiar.addActionListener(this);
        getContentPane().add(btn_cambiar);

        btn_corteDulceria = new JButton("Corte de dulcer\u00EDa");
        btn_corteDulceria.setForeground(Color.WHITE);
        btn_corteDulceria.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_corteDulceria.setBackground(new Color(171, 0, 51));
        btn_corteDulceria.setBounds(735, 516, 199, 72);
        btn_corteDulceria.addActionListener(this);
        getContentPane().add(btn_corteDulceria);
    }

    public JFormattedTextField getTextField(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor) editor).getTextField();
        } else {
            System.err.println("Unexpected editor type: "
                    + spinner.getEditor().getClass()
                    + " isn't a descendant of DefaultEditor");
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_confirmar) {
        	if(cantidadH == 0 && cantidadP == 0 && cantidadR == 0) {
        		JOptionPane.showMessageDialog(null, "No se pueden comprar 0 artículos");
        	}else {
        		SeleccionDetallesArt seleccionDetallesArt = new SeleccionDetallesArt();
                seleccionDetallesArt.setVisible(true);
                dispose();
        	}
            

        } else if (e.getSource() == btn_cambiar) {
            SeleccionarPelicula seleccionarPelicula = null;
			try {
				seleccionarPelicula = new SeleccionarPelicula();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            seleccionarPelicula.setVisible(true);
            dispose();
        } else if (e.getSource() == btn_corteDulceria) {
            CorteDulceria corteDulceria = new CorteDulceria();
            corteDulceria.setVisible(true);
            dispose();

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == spinner_helados) {
            cantidadH = (Integer) spinner_helados.getValue();
            System.out.println(cantidadH);
            mostrarWarning(cantidadH);

        } else if (e.getSource() == spinner_palomitas) {
            cantidadP = (Integer) spinner_palomitas.getValue();
            System.out.println(cantidadP);
            mostrarWarning(cantidadP);

        } else if (e.getSource() == spinner_refrescos) {
            cantidadR = (Integer) spinner_refrescos.getValue();
            System.out.println(cantidadR);
            mostrarWarning(cantidadR);

        }
        
    }
    public void mostrarWarning (int cantidad){
        if(cantidad == 10){
            JOptionPane.showMessageDialog(null, "Limite alcanzado");
        }
    }
}

