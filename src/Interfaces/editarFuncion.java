package Interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class editarFuncion implements ActionListener {
    private JButton btnVolver,btnActualizar;
    public JFrame frame;
    private JTextField textIdPelicula;
    private JTextField textIdFuncion;
    private JSpinner spinner_horas, spinner_dia, spinner_anio, spinner_minutos, spinner_mes, spinner_sala;
    private String[] meses = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    private String[] dias = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private String[] anio = new String[] {"2020"};
    private String[] minutos = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34"
    , "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};



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
                    editarFuncion window = new editarFuncion();
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
    public editarFuncion()
    {
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



        JLabel lblEditar = new JLabel("Editar funcion");
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Arial", Font.BOLD, 40));
        lblEditar.setBounds(370, 58, 269, 72);
        frame.getContentPane().add(lblEditar);


        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBackground(new Color(171, 0, 51));
        btnVolver.setBounds(10, 562, 139, 31);
        frame.getContentPane().add(btnVolver);
        btnVolver.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 17));
        btnActualizar.setBackground(new Color(171, 0, 51));
        btnActualizar.setBounds(424, 419, 149, 39);
        frame.getContentPane().add(btnActualizar);
        btnActualizar.addActionListener(this);

        JLabel lblFuncion = new JLabel("ID Funcion a editar:");
        lblFuncion.setForeground(Color.WHITE);
        lblFuncion.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFuncion.setBounds(36, 185, 200, 24);
        frame.getContentPane().add(lblFuncion);

        textIdFuncion = new JTextField();
        textIdFuncion.setColumns(10);
        textIdFuncion.setBounds(220, 189, 226, 19);
        frame.getContentPane().add(textIdFuncion);

        JLabel lblNumero = new JLabel("Numero de sala:");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNumero.setBounds(450, 335, 170, 24);
        frame.getContentPane().add(lblNumero);

        textIdPelicula = new JTextField();
        textIdPelicula.setColumns(10);
        textIdPelicula.setBounds(680, 191, 226, 19);
        frame.getContentPane().add(textIdPelicula);

        JLabel lblIdPelicula = new JLabel("ID Pelicula:");
        lblIdPelicula.setForeground(Color.WHITE);
        lblIdPelicula.setFont(new Font("Arial", Font.PLAIN, 20));
        lblIdPelicula.setBounds(573, 185, 109, 24);
        frame.getContentPane().add(lblIdPelicula);


        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFecha.setBounds(36, 268, 68, 24);
        frame.getContentPane().add(lblFecha);


        JLabel lblMm = new JLabel("MM");
        lblMm.setForeground(Color.WHITE);
        lblMm.setFont(new Font("Arial", Font.PLAIN, 20));
        lblMm.setBounds(102, 268, 47, 24);
        frame.getContentPane().add(lblMm);

        JLabel lblDd = new JLabel("/ DD");
        lblDd.setForeground(Color.WHITE);
        lblDd.setFont(new Font("Arial", Font.PLAIN, 20));
        lblDd.setBounds(216, 268, 68, 24);
        frame.getContentPane().add(lblDd);

        JLabel lblAaaa = new JLabel("/ AAAA");
        lblAaaa.setForeground(Color.WHITE);
        lblAaaa.setFont(new Font("Arial", Font.PLAIN, 20));
        lblAaaa.setBounds(338, 268, 68, 24);
        frame.getContentPane().add(lblAaaa);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setForeground(Color.WHITE);
        lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHora.setBounds(36, 350, 68, 24);
        frame.getContentPane().add(lblHora);

        JLabel lblHh = new JLabel("HH");
        lblHh.setForeground(Color.WHITE);
        lblHh.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHh.setBounds(89, 350, 68, 24);
        frame.getContentPane().add(lblHh);

        JLabel lblHoraMm = new JLabel(": MM");
        lblHoraMm.setForeground(Color.WHITE);
        lblHoraMm.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHoraMm.setBounds(185, 350, 68, 24);
        frame.getContentPane().add(lblHoraMm);

        spinner_minutos = new JSpinner();
        SpinnerModel model_min = new SpinnerListModel(minutos);
        spinner_minutos.setModel(model_min);
        spinner_minutos.setBounds(238, 354, 51, 20);
        ((JSpinner.DefaultEditor) spinner_minutos.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_minutos);

        spinner_mes = new JSpinner();
        SpinnerModel model_mes = new SpinnerListModel(meses);
        spinner_mes.setModel(model_mes);
        spinner_mes.setBounds(155, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_mes.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_mes);

        spinner_dia = new JSpinner();
        SpinnerModel model_dia = new SpinnerListModel(dias);
        spinner_dia.setModel(model_dia);
        spinner_dia.setBounds(277, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_dia.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_dia);

        spinner_anio = new JSpinner();
        SpinnerModel model_anio = new SpinnerListModel(anio);
        spinner_anio.setModel(model_anio);
        spinner_anio.setBounds(424, 268, 51, 20);
        ((JSpinner.DefaultEditor) spinner_anio.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_anio);

        spinner_sala = new JSpinner();
        spinner_sala.setModel(new SpinnerNumberModel(1, 1, 9, 1));
        spinner_sala.setBounds(680, 340, 226, 20);
        ((JSpinner.DefaultEditor) spinner_sala.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_sala);

        spinner_horas = new JSpinner();
        spinner_horas.setModel(new SpinnerNumberModel(1, 1, 23, 1));
        spinner_horas.setBounds(124, 354, 51, 20);
        ((JSpinner.DefaultEditor) spinner_minutos.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(spinner_horas);

        spinner_minutos = new JSpinner();
        spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        spinner_minutos.setBounds(238, 354, 51, 20);
        frame.getContentPane().add(spinner_minutos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuFunciones menuFunciones = new menuFunciones();
        int opcion;
        opcion = JOptionPane.NO_OPTION;


        if(e.getSource()==btnVolver) {
            menuFunciones.frame.setVisible(true);
            frame.dispose();
        }
        else if(e.getSource()==btnActualizar) {


            if(textIdFuncion.getText().isEmpty() || textIdPelicula.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Introducir los datos.");
            } else {
                int funcion = Integer.parseInt(textIdFuncion.getText());
                int pelicula =Integer.parseInt(textIdPelicula.getText());
                int sala = (int) spinner_sala.getValue();
                String mes = (String) spinner_mes.getValue();
                String dia = (String) spinner_dia.getValue();
                String anio = (String) spinner_anio.getValue();
                int horas = (int) spinner_horas.getValue();
                int minutos = (int) spinner_minutos.getValue();

                String horaString = ""+horas+":"+minutos+":00";
                String diaString = ""+anio+"-"+""+mes+"-"+dia;

                try {
                    query="UPDATE Funcion SET Num_Sala=?,ID_Peli=?,Fecha_Peli=?,Hora_Peli=? WHERE ID_Funcion=?";
                    pstm = con.prepareStatement(query);
                    pstm.setInt(1,sala);
                    pstm.setInt(2,pelicula);
                    pstm.setString(3,diaString);
                    pstm.setString(4,horaString);
                    pstm.setInt(5,funcion);
                    pstm.executeUpdate();
                    opcion = JOptionPane.showConfirmDialog(null, "Se ha actualizado exitosamente!. \n\n¿Quiere actualizar otra funcion?\n", "Actualizado",JOptionPane.YES_NO_OPTION);

               	 pstm.close();
               	 con.close();
                } catch (SQLException e1) {

                }



            }



            if(opcion==JOptionPane.YES_OPTION) {
                textIdPelicula.setText("");

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

