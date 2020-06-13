package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informe extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn_actDia, btn_inventario, btn_usuarioEsp, btn_volver;
    public JFrame frame;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Informe window = new Informe();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Informe() {
    	frame = new JFrame();
		frame.setBounds(100, 100, 960, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(960,640);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(72,81,84));

        JLabel lbl_informe = new JLabel("Informe");
        lbl_informe.setForeground(Color.WHITE);
        lbl_informe.setFont(new Font("Arial", Font.BOLD, 40));
        lbl_informe.setBounds(410, 54, 350, 72);
        frame.getContentPane().add(lbl_informe);

        btn_actDia = new JButton("Actividades del dia");
        btn_actDia.setForeground(Color.WHITE);
		btn_actDia.setFont(new Font("Arial", Font.PLAIN, 24));
		btn_actDia.setFocusPainted(false);
		btn_actDia.setBorderPainted(false);
		btn_actDia.setBackground(new Color(171, 0, 51));
		btn_actDia.setBounds(307, 158, 339, 85);
		frame.getContentPane().add(btn_actDia);
		btn_actDia.addActionListener(this);

		btn_inventario = new JButton("Inventario");
		btn_inventario.setForeground(Color.WHITE);
		btn_inventario.setFont(new Font("Arial", Font.PLAIN, 24));
		btn_inventario.setFocusPainted(false);
		btn_inventario.setBorderPainted(false);
		btn_inventario.setBackground(new Color(171, 0, 51));
		btn_inventario.setBounds(307, 270, 339, 85);
		frame.getContentPane().add(btn_inventario);
		btn_inventario.addActionListener(this);

		btn_usuarioEsp = new JButton("Usuario en especifico");
		btn_usuarioEsp.setForeground(Color.WHITE);
		btn_usuarioEsp.setFont(new Font("Arial", Font.PLAIN, 24));
		btn_usuarioEsp.setFocusPainted(false);
		btn_usuarioEsp.setBorderPainted(false);
		btn_usuarioEsp.setBackground(new Color(171, 0, 51));
		btn_usuarioEsp.setBounds(307, 382, 339, 85);
		frame.getContentPane().add(btn_usuarioEsp);
		btn_usuarioEsp.addActionListener(this);

		btn_volver = new JButton("Volver");
		btn_volver.setForeground(Color.WHITE);
		btn_volver.setFont(new Font("Arial", Font.PLAIN, 20));
		btn_volver.setFocusPainted(false);
		btn_volver.setBorderPainted(false);
		btn_volver.setBackground(new Color(171, 0, 51));
		btn_volver.setBounds(10, 562, 139, 31);
		frame.getContentPane().add(btn_volver);
		btn_volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_actDia){
            actividadesDia actividadesDia = new actividadesDia();
            actividadesDia.frame.setVisible(true);
            frame.dispose();
        }else if(e.getSource() == btn_inventario){
            Inventario inventario = new Inventario();
            inventario.frame.setVisible(true);
            frame.dispose();
        }else if(e.getSource() == btn_usuarioEsp){
            usuarioEspecifico usuarioEspecifico = new usuarioEspecifico();
            usuarioEspecifico.frame.setVisible(true);
            frame.dispose();
        }else if(e.getSource() == btn_volver){
            menuAdmin menuAdmin = new menuAdmin();
            menuAdmin.frame.setVisible(true);
            frame.dispose();
        }
    }
}
