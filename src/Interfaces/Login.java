package Interfaces;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends ConexionBD implements ActionListener {
	//CONECTA A LA BASE DE DATOS Y CONSIGUE EL CON
    Connection con = ConexionBD.conectar();
    protected JFrame frameLog;
    protected JTextField txt_user;
    protected JPasswordField pass_password;
    protected JButton btn_ingresar;
    boolean permiso = false; //TIENE PERMISO O NO PARA ACCESAR
    public static boolean TYPE_USER = false; //0 user normal, 1 admin
	int cont_int=5; //CONTADOR DE INTENTOS
	public static  int ID_USUARIO;
	public static String USUARIO;
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frameLog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }
        });
    }
	/**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * GRIS: 72,81,84
     * ROJO: 171, 0, 51
     */
    private void initialize() {
        frameLog = new JFrame();
        frameLog.getContentPane().setBackground(new Color(72,81,84));
        frameLog.setBounds(100, 100, 480, 460);
        frameLog.setSize(480, 640);
        frameLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLog.getContentPane().setLayout(null);

        JLabel lbl_login = new JLabel("Login");
        lbl_login.setForeground(Color.WHITE);
        lbl_login.setFont(new Font("Arial", Font.PLAIN, 22));
        lbl_login.setBounds(202, 11, 60, 56);
        frameLog.getContentPane().add(lbl_login);


        JLabel lbl_user = new JLabel("Usuario:");
        lbl_user.setForeground(Color.WHITE);
        lbl_user.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lbl_user.setBounds(186, 127, 91, 56);
        frameLog.getContentPane().add(lbl_user);

        JLabel lbl_pass = new JLabel("Contrase\u00F1a:");
        lbl_pass.setForeground(Color.WHITE);
        lbl_pass.setFont(new Font("Arial Black", Font.PLAIN, 18));
        lbl_pass.setBounds(166, 293, 131, 41);
        frameLog.getContentPane().add(lbl_pass);

        txt_user = new JTextField();
        txt_user.setBounds(124, 181, 215, 28);
        frameLog.getContentPane().add(txt_user);
        txt_user.setColumns(10);

        pass_password = new JPasswordField();
        pass_password.setBounds(124, 336, 215, 28);
        frameLog.getContentPane().add(pass_password);

        btn_ingresar = new JButton("Ingresar");
        btn_ingresar.setForeground(new Color(255, 255, 255));
        btn_ingresar.setFont(new Font("Arial", Font.BOLD, 16));
        btn_ingresar.setBackground(new Color(171, 0, 51));
        btn_ingresar.setBounds(166, 433, 131, 56);
        btn_ingresar.addActionListener(this);
        frameLog.getContentPane().add(btn_ingresar);

        JPanel panel_red = new JPanel();
        panel_red.setBackground(new Color(171, 0, 51));
        panel_red.setBounds(38, 75, 387, 61);
        frameLog.getContentPane().add(panel_red);

        Image img;
        img = new ImageIcon(Login.class.getResource("/images/logoRED.png")).getImage();
        JLabel lbl_img_login = new JLabel("");
        panel_red.add(lbl_img_login);
        lbl_img_login.setIcon(new ImageIcon(img));

        JPanel panel_gris = new JPanel();
        panel_gris.setBackground(new Color(46,48,48));
        panel_gris.setBounds(38, 75, 387, 430);
        frameLog.getContentPane().add(panel_gris);

    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	//VALIDACION SI ESTAN VACIOS
    	if(txt_user.getText().isEmpty() || pass_password.getPassword().length == 0)
    	{
    		showMessageDialog(null, "Rellene todos los datos");
    	}
    	else
    	{
    		loginSQL();
    		if (permiso)
    		{
    			frameLog.dispose(); //DUERME
    			if(TYPE_USER) //ADMIN O USER?
    			{
                    menuAdmin menuAdmin = new menuAdmin();
                    menuAdmin.frame.setVisible(true);
                    cerrarcon();
    			} else {
    				
                    PrincipalUser principalUser = new PrincipalUser();
                    principalUser.setVisible(true);
                    cerrarcon();
    			}
    				
    		}else {
    			if(cont_int!=1)
    			{
    				cont_int --;
        			showMessageDialog(null, "Intentos restantes: "+cont_int);
    			} else {
    				
    				showMessageDialog(null, "INTENTOS GASTADOS. BLOQUEANDO VENTANA");
    				txt_user.setEnabled(false);
					pass_password.setEnabled(false);
					btn_ingresar.setEnabled(false);
					try {
					Thread.sleep(12000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txt_user.setEnabled(true);
					pass_password.setEnabled(true);
					btn_ingresar.setEnabled(true);
					cont_int = 5;
					}
    			
    		}
    	}
    }
     


    
	private void cerrarcon() {
		try {
			con.close();
			pstm.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		
	}
	private void loginSQL() {
		
		//EMPEZAMOS LA COMPROBACION
		boolean nivel = false;
		boolean pase = false;
		try {
			//CONSEGUIMOS LO QUE SE ESCRIBÃ�O	
			String valorPass = new String(pass_password.getPassword()); //se tiene que convertir a String, sino regresa char
			int valorUser = Integer.parseInt(txt_user.getText());
			query = "SELECT * FROM Usuario WHERE ID_Usuario = ?";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, valorUser);
			rs = pstm.executeQuery();
			//VALIDACION DE USUARIO
			if(rs.next())
			{	
				query = "SELECT *  FROM Usuario WHERE ID_Usuario=? AND Contrasena = ?";
				pstm = con.prepareStatement(query);
				pstm.setInt(1, valorUser);
				pstm.setString(2, valorPass);
				rs = pstm.executeQuery();
				//VALIDACION DE CONTRASENA
				if(rs.next())
				{	
					//OBTENEMOS INFO NECESARIA
					this.ID_USUARIO = valorUser;
					this.USUARIO = rs.getString("Nombre");
					showMessageDialog(null, "BIENVENIDO "+USUARIO);
					int nivelopc = Integer.parseInt(rs.getString("Admin"));
					if (nivelopc==1)
					{
						nivel = true;
					}else {
						nivel = false;
					}
					pase = true;
				}else
				{
					showMessageDialog(null, "CONTRASENA INCORRECTA");
					 pase = false;
				}
				
			}else
			{
				showMessageDialog(null, "NO EXISTE TAL USUARIO");
				pase = false;
			}
		} catch (SQLException e1)
		{
			e1.printStackTrace();	
		}
		this.permiso = pase;
		this.TYPE_USER = nivel;
		}
	}
	

//.
