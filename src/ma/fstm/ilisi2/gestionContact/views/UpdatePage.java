package ma.fstm.ilisi2.gestionContact.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi2.gestionContact.controllers.*;
import ma.fstm.ilisi2.gestionContact.models.bo.*;


public class UpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phone;
	private JFrame context=this;
	ContactController ctrl=new ContactController();
	private JTable table;
	private DefaultTableModel model;
	
	public void addTypestoModel(JTable table,Collection<ma.fstm.ilisi2.gestionContact.models.bo.Type> types) {
		model=(DefaultTableModel)table.getModel();
		for(ma.fstm.ilisi2.gestionContact.models.bo.Type type:types) {
			model.addRow(new Object[] {type.getId(),
					type.getTitle()});
		}
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePage frame = new UpdatePage(new Contact());
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
	public UpdatePage(Contact contact) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(34, 32, 63, 14);
		contentPane.add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setBounds(122, 29, 86, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		firstName.setText(contact.getFirstName());
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(34, 68, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		lastName = new JTextField();
		lastName.setBounds(122, 65, 86, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);
		lastName.setText(contact.getLastName());
		
		JLabel lblNewLabel_2 = new JLabel("phone");
		lblNewLabel_2.setBounds(34, 100, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		phone = new JTextField();
		phone.setBounds(122, 97, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		phone.setText(contact.getPhone());
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				if(selectedRow>=0) {
					Long id=(Long) table.getValueAt(selectedRow, 0);
				ctrl.updateContact(contact.getId(),firstName.getText(), lastName.getText(), phone.getText(),id);
				context.dispose();
				}
				
			}
		});
		btnNewButton.setBounds(329, 253, 89, 23);
		contentPane.add(btnNewButton);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 147, 384, 95);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "title"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		scrollPane.setViewportView(table);
		Collection<ma.fstm.ilisi2.gestionContact.models.bo.Type> types=ctrl.getAllTypes();
		addTypestoModel(table, types);
	}

}
