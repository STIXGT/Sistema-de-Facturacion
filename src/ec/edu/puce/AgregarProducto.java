package ec.edu.puce;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AgregarProducto extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto();
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
	public AgregarProducto() {
		setBounds(100, 100, 535, 458);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(133, 28, 134, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("NUEVO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
			}
		});
		btnNewButton.setBounds(57, 209, 89, 23);
		getContentPane().add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("AGREGAR\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto producto = new Producto();
				producto.setCodigo(textField.getText());
				producto.setCantidad (Float.parseFloat(textField_1.getText()));
				producto.setDescripcion(textField_2.getText());
				producto.setPrecio (Float.parseFloat(textField_3.getText()));
				producto.setTotal(producto.getCantidad()*producto.getPrecio());
				
				Object[]fila = new Object[5];
				fila[0] = producto.getCodigo();
				fila[1] = producto.getCantidad();
				fila[2] = producto.getDescripcion();
				fila[3] = producto.getPrecio();
				fila[4] = producto.getTotal();
				model.addRow(fila);
				
			}
			

		});
		btnNewButton_1.setBounds(210, 209, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CANCELAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(361, 209, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setMaximumSize(new Dimension(40, 20));
		lblNewLabel.setMinimumSize(new Dimension(40, 20));
		lblNewLabel.setBounds(57, 31, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(57, 71, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripción ");
		lblNewLabel_2.setBounds(58, 116, 77, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(57, 157, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 68, 134, 17);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 114, 134, 17);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 155, 134, 17);
		getContentPane().add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 258, 413, 143);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cantidad", "Descripci\u00F3n", "Precio", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		model = (DefaultTableModel) table.getModel();

	}
}
