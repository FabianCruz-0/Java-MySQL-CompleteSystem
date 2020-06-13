package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CorteDulceria extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txt_supervisor;
    private JPasswordField pass_password;
    private JButton btn_ingresar, btn_volver;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CorteDulceria frame = new CorteDulceria();
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
    public CorteDulceria() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 460);
        setSize(480, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().setBackground(new Color(72,81,84));
        getContentPane().setLayout(null);

        JLabel lbl_login = new JLabel("Corte dulceria");
        lbl_login.setForeground(Color.WHITE);
        lbl_login.setFont(new Font("Arial", Font.PLAIN, 22));
        lbl_login.setBounds(162, 11, 139, 56);
        getContentPane().add(lbl_login);


        JLabel lbl_user = new JLabel("Supervisor: ");
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lbl_user.setBounds(167, 127, 130, 56);
        getContentPane().add(lbl_user);

        JLabel lbl_pass = new JLabel("Contrase\u00F1a:");
        lbl_pass.setForeground(Color.WHITE);
        lbl_pass.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lbl_pass.setBounds(166, 293, 131, 41);
        getContentPane().add(lbl_pass);

        txt_supervisor = new JTextField();
        txt_supervisor.setBounds(124, 181, 215, 28);
        getContentPane().add(txt_supervisor);
        txt_supervisor.setColumns(10);

        pass_password = new JPasswordField();
        pass_password.setBounds(124, 336, 215, 28);
        getContentPane().add(pass_password);

        btn_ingresar = new JButton("Ingresar");
        btn_ingresar.setForeground(new Color(255, 255, 255));
        btn_ingresar.setFont(new Font("Arial", Font.BOLD, 16));
        btn_ingresar.setBackground(new Color(171, 0, 51));
        btn_ingresar.setBounds(166, 433, 131, 56);
        btn_ingresar.addActionListener(this);
        getContentPane().add(btn_ingresar);

        Image img;
        img = new ImageIcon(Login.class.getResource("/IMGS/login.png")).getImage();

        JPanel panel_red = new JPanel();
        panel_red.setBackground(new Color(171, 0, 51));
        panel_red.setBounds(38, 75, 387, 61);
        getContentPane().add(panel_red);

        JLabel lbl_img_login = new JLabel("");
        panel_red.add(lbl_img_login);
        lbl_img_login.setIcon(new ImageIcon(img));

        JPanel panel_gris = new JPanel();
        panel_gris.setBackground(new Color(46,48,48));
        panel_gris.setBounds(38, 75, 387, 430);
        getContentPane().add(panel_gris);

        btn_volver = new JButton("Volver");
        btn_volver.setFont(new Font("Arial", Font.BOLD, 20));
        btn_volver.setForeground(Color.WHITE);
        btn_volver.setBackground(new Color(171, 0, 51));
        btn_volver.setBounds(10, 549, 99, 41);
        btn_volver.addActionListener(this);
        getContentPane().add(btn_volver);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_volver){
            VentaDulceria ventaDulceria = new VentaDulceria();
            ventaDulceria.setVisible(true);
            dispose();
        }else if(e.getSource() == btn_ingresar){
            JOptionPane.showMessageDialog(null, "credenciales requeridas");

            //todo query sql
        }

    }

}
