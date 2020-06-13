package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CorteBoleto extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    protected JTextField txt_supervisor;
    protected JPasswordField pass_password;
    protected JButton btn_ingresar, btn_Volver;
    //PARA LA FECHA
    Date date = new Date();
//	BASE DE DATOS
    Connection con = ConexionBD.conectar();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Statement stm = null;
    String query = "";
    
    protected JFrame frameLog;
    protected JTextField txt_user;
    boolean permiso = false; //TIENE PERMISO O NO PARA ACCESAR
    public static boolean TYPE_USER = false; //0 user normal, 1 admin
	int cont_int=5; //CONTADOR DE INTENTOS
	int ID_ADMIN;
	String NOMBRE_ADMIN;
	public static boolean opc_corte; //1 dulce, 0 taquilla
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CorteBoleto frame = new CorteBoleto();
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
    public CorteBoleto() {
    	System.out.println(opc_corte);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 460);
        setSize(480, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().setBackground(new Color(72,81,84));
        getContentPane().setLayout(null);

        JLabel lbl_login = new JLabel("Corte del boleto");
        lbl_login.setForeground(Color.WHITE);
        lbl_login.setFont(new Font("Arial", Font.PLAIN, 22));
        lbl_login.setBounds(151, 11, 162, 56);
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

        JPanel panel_red = new JPanel();
        panel_red.setBackground(new Color(171, 0, 51));
        panel_red.setBounds(38, 75, 387, 61);
        getContentPane().add(panel_red);



        JPanel panel_gris = new JPanel();
        panel_gris.setBackground(new Color(46,48,48));
        panel_gris.setBounds(38, 75, 387, 430);
        getContentPane().add(panel_gris);

        btn_Volver = new JButton("Volver");
        btn_Volver.setFont(new Font("Arial", Font.BOLD, 20));
        btn_Volver.setForeground(Color.WHITE);
        btn_Volver.setBackground(new Color(171, 0, 51));
        btn_Volver.setBounds(10, 549, 99, 41);
        btn_Volver.addActionListener(this);
        getContentPane().add(btn_Volver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//VALIDACION SI ESTAN VACIOS
    	
    	
    	if(e.getSource() == btn_ingresar){
    		if(txt_supervisor.getText().isEmpty() || pass_password.getPassword().length == 0)
        	{
        		showMessageDialog(null, "Rellene todos los datos");
        	}else {
        	loginSQL();
    		if (permiso)
    		{
    			
    			if(TYPE_USER) //ADMIN O USER?
    			{
    				registrarCorte();
    				showMessageDialog(null, "GRACIAS "+NOMBRE_ADMIN+"SE HA HECHO EL CORTE");
    				
                    Login login = new Login();
    				login.frameLog.setVisible(true);
    				cerrar_conexion();
					dispose();
    			} else {
    				
    				showMessageDialog(null, "POR FAVOR, INGRESE A UN ADMINISTRADOR");
    			}
    				
    		}else {
    			if(cont_int!=1)
    			{
    				cont_int --;
        			showMessageDialog(null, "Intentos restantes: "+cont_int);
    			} else {
    				
    				showMessageDialog(null, "INTENTOS GASTADOS. BLOQUEANDO VENTANA");
    				txt_supervisor.setEnabled(false);
					pass_password.setEnabled(false);
					btn_ingresar.setEnabled(false);
					try {
					Thread.sleep(12000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txt_supervisor.setEnabled(true);
					pass_password.setEnabled(true);
					btn_ingresar.setEnabled(true);
					cont_int = 5;
					}}}
        }else if(e.getSource() == btn_Volver){
        	if(opc_corte)
        	{
        		VentaDulceria dulc = new VentaDulceria();
        		dulc.setVisible(true);
        	}
        	else
        	{
        		SeleccionarPelicula bol = null;
				try {
					bol = new SeleccionarPelicula();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		bol.setVisible(true);
        	}
            dispose();
        }

    }
    
private void cerrar_conexion() {
	try {
        rs.close(); //SI UTILIZAS RS
pstm.close(); //SI UTILIZAS PREPARE STATEMENT
con.close(); //ESTE SI A HUEVO
    } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
		
	}

private void registrarCorte() {
		try {
		if(opc_corte) { //dulceria
		query="INSERT INTO `Corte Dulceria`(`Fecha_Corte_Dulc`, `ID_User`, `ID_Admin`) "
				+ "VALUES (?,?,?)";
		}else { //taquellia
		query="INSERT INTO `Corte Taquilla`(`Fecha_Corte`, `ID_User`, `ID_Admin`)"
					+ " VALUES (?,?,?)";
		}
		pstm = con.prepareStatement(query);
		pstm.setString(1, obtener_fecha());
		pstm.setInt(2, Login.ID_USUARIO);
		pstm.setInt(3, this.ID_ADMIN);
		pstm.executeUpdate();
		con.close();
		pstm.close();
		}catch(SQLException e) {
			e.printStackTrace();	
		}
	}

private String obtener_fecha() {
    String fecha;
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
    fecha = hourdateFormat.format(date);
    return fecha;
}

private void loginSQL() {
		
		//EMPEZAMOS LA COMPROBACION
		boolean nivel = false;
		boolean pase = false;
		try {
			//CONSEGUIMOS LO QUE SE ESCRIBÃ�O	
			String valorPass = new String(pass_password.getPassword()); //se tiene que convertir a String, sino regresa char
			int valorUser = Integer.parseInt(txt_supervisor.getText());
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
					this.ID_ADMIN = valorUser;
					this.NOMBRE_ADMIN=rs.getString("Nombre");
					int nivelopc = Integer.parseInt(rs.getString("Admin"));
					if (nivelopc==1)
					{//admin
						nivel = true;
					}else { //user
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
		
		CorteBoleto.TYPE_USER = nivel;
		this.permiso=pase;
	}
}
