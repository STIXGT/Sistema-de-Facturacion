package ec.edu.puce;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.io.IOException;
import java.net.ServerSocket;




public class MenuPrincipal extends JFrame {
	
	private static ServerSocket SERVER_SOCKET;
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Sistema de facturación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 695);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 0));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistema");
		mnNewMenu.setBackground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmSalir);
		
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear clientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearCliente = new CrearCliente();
				try {
					SERVER_SOCKET = new ServerSocket(1334);
					crearCliente.setVisible(true);
					crearCliente.setBounds(1, 1, 500, 600);
					desktopPane.add(crearCliente);
				}
				catch(IOException x) {
					crearCliente.dispose();
				}
		
			}
			
			
		
	
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listas de clientes");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Productos");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Agregar producto");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProducto productonuevo = new AgregarProducto();
				
				try {
					SERVER_SOCKET = new ServerSocket(1334);
					productonuevo.setVisible(true);
					productonuevo.setBounds(1, 1, 500, 600);
					desktopPane.add(productonuevo);
				}
				catch(IOException x) {
					productonuevo.dispose();
				}
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Redes Sociales");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Facebook");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/ec/edu/puce/imagenes/facebook_social_network_network_communication_internet_icon_192273 (1).png")));
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Instagram");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_705412220562000");
	}
}
