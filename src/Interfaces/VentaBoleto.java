package Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentaBoleto extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton btn_Pagar, btn_Cancelar, btn_Volver;
    private JLabel lbl_numBoletos, lbl_detallesAsientos, lbl_detallesCategorias, lbl_Precio;
    
//	BASE DE DATOS
    Connection con = ConexionBD.conectar();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Statement stm = null;
    String query = "";
    
    //PARA LA FECHA
    Date date = new Date();
    //OTROS
    int niño=0, adulto=0, vip=0, opc=0, total=0, cont_total=0;
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentaBoleto frame = new VentaBoleto();
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
    public VentaBoleto() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72, 81, 84));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_tituloVenta = new JLabel("Detalles de la venta\r\n");
        lbl_tituloVenta.setForeground(Color.WHITE);
        lbl_tituloVenta.setFont(new Font("Arial Black", Font.BOLD, 40));
        lbl_tituloVenta.setBounds(234, 11, 476, 84);
        contentPane.add(lbl_tituloVenta);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(234, 106, 476, 229);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbl_cantidadBoletos = new JLabel("Cantidad de Boletos:");
        lbl_cantidadBoletos.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_cantidadBoletos.setBounds(10, 11, 203, 33);
        panel.add(lbl_cantidadBoletos);

        lbl_numBoletos = new JLabel("N\u00FAmero\r\n");
        lbl_numBoletos.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_numBoletos.setBounds(387, 11, 79, 33);
        panel.add(lbl_numBoletos);

        JLabel lbl_cantidadAsientos = new JLabel("Asientos comprados:\r\n");
        lbl_cantidadAsientos.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_cantidadAsientos.setBounds(10, 55, 203, 33);
        panel.add(lbl_cantidadAsientos);

        lbl_detallesAsientos = new JLabel("A1, A2, A3, A4, A5\r\n");
        lbl_detallesAsientos.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_detallesAsientos.setBounds(263, 38, 203, 70);
        panel.add(lbl_detallesAsientos);


        JLabel lbl_categorias = new JLabel("Categor\u00EDas:\r\n");
        lbl_categorias.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_categorias.setBounds(10, 123, 203, 33);
        panel.add(lbl_categorias);

        lbl_detallesCategorias = new JLabel("A1, A2, A3, A4, A5\r\n");
        lbl_detallesCategorias.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_detallesCategorias.setBounds(263, 107, 203, 70);
        panel.add(lbl_detallesCategorias);

        JLabel lbl_precioTotal = new JLabel("Precio Total:");
        lbl_precioTotal.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_precioTotal.setBounds(10, 167, 203, 33);
        panel.add(lbl_precioTotal);

        lbl_Precio = new JLabel("$1000\r\n");
        lbl_Precio.setFont(new Font("Arial", Font.BOLD, 20));
        lbl_Precio.setBounds(402, 167, 64, 33);
        panel.add(lbl_Precio);

        btn_Pagar = new JButton("Pagar");
        btn_Pagar.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_Pagar.setForeground(Color.WHITE);
        btn_Pagar.setBackground(new Color(171, 0, 51));
        btn_Pagar.setBounds(509, 346, 201, 40);
        btn_Pagar.addActionListener(this);
        contentPane.add(btn_Pagar);

        btn_Cancelar = new JButton("Cancelar Compra\r\n");
        btn_Cancelar.setFont(new Font("Arial", Font.PLAIN, 20));
        btn_Cancelar.setForeground(Color.WHITE);
        btn_Cancelar.setBackground(new Color(171, 0, 51));
        btn_Cancelar.setBounds(234, 346, 201, 40);
        btn_Cancelar.addActionListener(this);
        contentPane.add(btn_Cancelar);

        btn_Volver = new JButton("Volver");
        btn_Volver.setFont(new Font("Arial", Font.PLAIN, 30));
        btn_Volver.setForeground(Color.WHITE);
        btn_Volver.setBackground(new Color(171, 0, 51));
        btn_Volver.setBounds(10, 526, 149, 64);
        btn_Volver.addActionListener(this);
        contentPane.add(btn_Volver);
        
        
        lbl_numBoletos.setText(String.valueOf(SeleccionarAsiento.botonesSeleccionados.size()));
        String det_asiento="";
        for(int i = 0; i < SeleccionarAsiento.botonesSeleccionados.size(); i++) {   
           det_asiento=det_asiento+" "+SeleccionarAsiento.botonesSeleccionados.get(i); 
        }  
        lbl_detallesAsientos.setText(det_asiento);
        
        String categoria="";
        
        for(int i = 0; i < SeleccionarAsiento.precios.size(); i++) {   
            if(SeleccionarAsiento.precios.get(i) == 50)
            {
            	niño++;
            }else if(SeleccionarAsiento.precios.get(i) == 70)
            {
            	adulto++;
            }else if(SeleccionarAsiento.precios.get(i) == 120)
            {
            	vip++;
            }
            total+=SeleccionarAsiento.precios.get(i);
            cont_total++;
        } 
        
        if(niño != 0)
        {
        	categoria+=niño+" de Niño, ";
        }
        if(adulto!= 0)
        {
        	categoria+=adulto+" de Adulto, ";
        }
        if(vip != 0)
        {
        	categoria+=vip+" de VIP";
        }
        
        lbl_detallesCategorias.setText(categoria);
        
        lbl_Precio.setText("$"+String.valueOf(total));;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_Volver){
        	cancelarboletos();
            SeleccionarAsiento seleccionarAsiento = new SeleccionarAsiento();
            seleccionarAsiento.setVisible(true);
            dispose();
        }else if(e.getSource() == btn_Cancelar){
        	cancelarboletos();
            SeleccionarPelicula seleccionarPelicula = null;
			try {
				seleccionarPelicula = new SeleccionarPelicula();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            seleccionarPelicula.setVisible(true);
            dispose();
        }else if (e.getSource() == btn_Pagar){
            JOptionPane.showMessageDialog(null, "GRACIAS POR COMPRAR");
            pasarDB();
            SeleccionarPelicula seleccionarPelicula = null;
			try {
				seleccionarPelicula = new SeleccionarPelicula();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            seleccionarPelicula.setVisible(true);
            dispose();
        }

        
    }

	private void pasarDB() {
		try {
		//SACAMOS EL ULTIMO ID DE BOLETO
		int ultimo_id = 0;
    	
			ultimo_id = ultimoID_Boleto() + 1;
		
    	
    	String tipo_persona="";
    	int costo=0;
    	
    	//INSERTAR A BOLETO
		for(int i = 0; i < SeleccionarAsiento.precios.size(); i++)
		{   
			query = "INSERT INTO `Boleto`(`ID_Boleto`, `Tipo_Persona`, `Costo`, `ID_Funcion`, `ID_Asiento`) "
        	 		+ "VALUES (?,?,?,?,?)";
			pstm = con.prepareStatement(query);
			if(SeleccionarAsiento.precios.get(i) == 50)
            {
            	 tipo_persona="Niño";
            	 costo=50;
            	
            }else if(SeleccionarAsiento.precios.get(i) == 70)
            {
            	tipo_persona="Adulto";
           	 	costo=70;
            }else if(SeleccionarAsiento.precios.get(i) == 120)
            {
            	tipo_persona="VIP";
           	 	costo=120;
            }
			pstm.setInt(1, ultimo_id);
       	 	pstm.setString(2, tipo_persona);
       	 	pstm.setInt(3, costo);
       	 	pstm.setInt(4, SeleccionarPelicula.funcion);
       	 	pstm.setInt(5, conseguir_ID_Asiento(SeleccionarAsiento.botonesSeleccionados.get(i)));
       	 	pstm.executeUpdate();
			
        }
		
		int id_venta_boleto = conseguir_ID_VentaBoleto() + 1;
		System.out.println("ID VENTA BOLETO "+id_venta_boleto);
		//INSERTAR A VENTA DE BOLETO
		query ="INSERT INTO `Venta Boleto`(`ID_VentaBoleto`, `ID_Usuario`, `Fecha`, `Hora`, `Costo_Total`) "
				+ "VALUES (?,?,?,?,?)";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id_venta_boleto);
		pstm.setInt(2, Login.ID_USUARIO);
		pstm.setString(3, obtener_fecha());
		pstm.setString(4, obtener_hora());
		pstm.setInt(5, total);
		pstm.executeUpdate();
		
		//INSERTAR A DETALLES VENTA DE VOLETO
		query = "INSERT INTO `Detalles Venta Boleto`(`ID_VentaBoleto`, `ID_Boleto`, `Costo`, `Cantidad`, `Num_Sala`, `ID_Funcion`) "
				+ "VALUES (?,?,?,?,?,?)";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id_venta_boleto);
		pstm.setInt(2, ultimo_id);
		pstm.setInt(3, total);
		pstm.setInt(4, cont_total);
		pstm.setInt(5, SeleccionarPelicula.sala_sel);
		pstm.setInt(6, SeleccionarPelicula.funcion);
		pstm.executeUpdate();
		
    	}catch(SQLException e) {
    		e.printStackTrace();	
    	}
		try {
			con.close();
			pstm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String obtener_hora() {
		String hora;
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
		hora = hourdateFormat.format(date);
		return hora;
	}

	private int conseguir_ID_VentaBoleto() {
		int id_venta_boleto = 0;
		try {
		query="SELECT MAX(ID_VentaBoleto) AS ID_VentaBoleto FROM `Venta Boleto`";
		pstm = con.prepareStatement(query);
		rs = pstm.executeQuery();
		rs.next();
		if(rs.getInt(1)==0)
		{
			id_venta_boleto=1;
		}else {
			id_venta_boleto = rs.getInt(1);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();	

		}
		return id_venta_boleto;
	}

	private String obtener_fecha() {
		String fecha;
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fecha = hourdateFormat.format(date);
		return fecha;
	}

	private int conseguir_ID_Asiento(String Nombre_Asiento) {
		String Nom_Asiento = Nombre_Asiento;
		PreparedStatement pstm = null;
		  ResultSet rs = null;
		  Statement stm = null;
		  String query = "";
		  int id_asiento = 0;
		  query = "SELECT ID_Asiento FROM Asiento WHERE Asiento=? AND Num_Sala=?";
		  try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, Nom_Asiento);
			pstm.setInt(2, SeleccionarPelicula.sala_sel);
			rs = pstm.executeQuery();
			rs.next();
			id_asiento = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		return id_asiento;
	}

	private int ultimoID_Boleto() throws SQLException {
		int id_boleto = 0;
		query="SELECT MAX(ID_Boleto) AS ID_Boleto FROM Boleto";
		pstm = con.prepareStatement(query);
		rs = pstm.executeQuery();
		rs.next();
		if(rs.getInt(1)==0)
		{
			id_boleto=1;
		}else {
			id_boleto = rs.getInt(1);

		}
		return id_boleto;
	}

	private void cancelarboletos() {
		try {
		//cancelar asiento y eliminarlo de la base de datos
		for(int i = 0; i < SeleccionarAsiento.botonesSeleccionados.size(); i++) {   
            query="UPDATE Asiento SET Disponibilidad=1 WHERE Asiento=? AND Num_Sala=?";
            pstm=con.prepareStatement(query);
            pstm.setString(1, SeleccionarAsiento.botonesSeleccionados.get(i));
            pstm.setInt(2, SeleccionarPelicula.sala_sel);
            pstm.executeUpdate();
        }  
		}catch(SQLException e) {
			e.printStackTrace();	

		}
        //QUITAMOS LOS PRECIOS ACUMULADOS
		SeleccionarAsiento.precios.clear();
		//QUITAMOS LOS BOLETOS ACUMULADOS
		SeleccionarAsiento.botonesSeleccionados.clear();
	}
}
