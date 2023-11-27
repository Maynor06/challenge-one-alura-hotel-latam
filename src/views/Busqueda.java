package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.BusquedaDAO;
import DTO.BusquedaDTO;
import Modelos.Huespedes;
import Modelos.Reserva;
import Modelos.TipoBusqueda;
import Utils.Conexion;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	
	private Conexion con = new Conexion(); 
	private BusquedaDTO busquedaDto = new BusquedaDTO(con); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarHuespedes();

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Este código se ejecutará cuando el usuario haga clic en el botón (JPanel).
		        // Puedes poner aquí la lógica que deseas ejecutar cuando se presiona el botón.
		        System.out.println("Botón Editar presionado");
		        editarRegistro();
		    }
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Este código se ejecutará cuando el usuario haga clic en el botón (JPanel).
		        // Puedes poner aquí la lógica que deseas ejecutar cuando se presiona el botón.
		    	eliminarRegitro();
		        System.out.println("Botón Eliminar presionado");
		    }
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
	private void mostrarHuespedes() {
		
		boolean sePuede = esNumero(txtBuscar.getText()); 
		TipoBusqueda tipoBusqueda = busquedaDto.filtrarRegistros(txtBuscar.getText(), sePuede );
		List<Huespedes> hues =  tipoBusqueda.getHuespedes(); 
		List<Reserva> res = tipoBusqueda.getReservas(); 
		
		modelo.setRowCount(0);
		modeloHuesped.setRowCount(0);
		
		if(!hues.isEmpty() && !res.isEmpty()) {
			for(Reserva reserva: res) {
				Object[] rowDataReserva = {reserva.getId(), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getValor()
						, reserva.getFormaDePago() }; 
				
				modelo.addRow(rowDataReserva);
			}
			
			for(Huespedes huesped: hues) {
				
				Object[] rowDataHuespedes = {huesped.getId(), huesped.getNombre(), huesped.getApellido(), huesped.getFechaNacimiento(), huesped.getNacionalidad(),
						huesped.getTelefono(), huesped.getNumeroReserva() };
				
				modeloHuesped.addRow(rowDataHuespedes);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "No se encontraron resultados a su petición", "Sin resultados", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	private boolean esNumero(String cadena) {
	    return cadena.matches("\\d+"); // La expresión regular "\\d+" verifica si la cadena contiene solo dígitos.
	}
	

	private void editarRegistro() {
		int filaSeleccionada = tbHuespedes.getSelectedRow(); 
		int filaSeleccionada2 = tbReservas.getSelectedRow();
		
		Huespedes huesped = new Huespedes(); 
		if(filaSeleccionada != -1) {
			
			Object[] datosFila = new Object[modeloHuesped.getColumnCount() ];
			for(int i = 0; i< modeloHuesped.getColumnCount(); i++) {
				datosFila[i] = modeloHuesped.getValueAt(filaSeleccionada, i);
			}
			
			huesped.setId(Integer.valueOf( datosFila[0].toString()));
			huesped.setNombre(datosFila[1].toString());
			huesped.setApellido(datosFila[2].toString());
			huesped.setFechaNacimiento(Date.valueOf(( datosFila[3].toString())));
			huesped.setNacionalidad(datosFila[4].toString());
			huesped.setTelefono(Integer.valueOf(datosFila[5].toString()));
			huesped.setNumeroReserva(Integer.parseInt(datosFila[6].toString()) );
			
			busquedaDto.editarHuesped(huesped);
			JOptionPane.showMessageDialog(null, "Se edito con exito el huesped");
			
			System.out.println("Datos de la fila: " + Arrays.toString(datosFila));
			
		}else if(filaSeleccionada2 != -1) {
			editarReserva();
		}else {
			System.out.println("no hay nada");
			JOptionPane.showMessageDialog(null, "No a seleccionado un registro para editar", "Error", JOptionPane.ERROR_MESSAGE);
			
			
		}
			
	}
	private void editarReserva(){
		int filaSeleccionada = tbReservas.getSelectedRow(); 
		Reserva reserva = new Reserva(); 
		
		if(filaSeleccionada != -1) {
			
			Object[] datosFila = new Object[modelo.getColumnCount()]; 
			for(int i = 0; i < modelo.getColumnCount(); i++) {
				datosFila[i] = modelo.getValueAt(filaSeleccionada, i); 
				
			}
			reserva.setId(Integer.valueOf(datosFila[0].toString()));
			reserva.setFechaEntrada(Date.valueOf(datosFila[1].toString() ) );
			reserva.setFechaSalida(Date.valueOf(datosFila[2].toString()));
			reserva.setValor(Integer.valueOf(datosFila[3].toString()) );
			reserva.setFormaDePago(datosFila[4].toString());

			busquedaDto.editarReserva(reserva);
			JOptionPane.showMessageDialog(null, "Se edito con exito la Reserva");
			
		}else {
			System.out.println("no hay reserva");
		}
		
	}
	private void eliminarRegitro() {
		int filaSeleccionada = tbHuespedes.getSelectedRow(); 
		int filaSeleccionada2 = tbReservas.getSelectedRow(); 
		
		if(filaSeleccionada != -1) {
			busquedaDto.eliminarHuesped(Integer.valueOf( modeloHuesped.getValueAt(filaSeleccionada,0).toString()));
			JOptionPane.showMessageDialog(null, "Se elimino con exito el Huesped");
		}else if(filaSeleccionada2 != -1) {
			busquedaDto.eliminarReserva(Integer.valueOf(modelo.getValueAt(filaSeleccionada2,0).toString() ) );
			JOptionPane.showMessageDialog(null, "Se elimino con exito la Reserva");	
		}else {
			JOptionPane.showMessageDialog(null, "No a seleccionado un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
