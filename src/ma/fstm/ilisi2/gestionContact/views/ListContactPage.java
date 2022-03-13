package ma.fstm.ilisi2.gestionContact.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi2.gestionContact.controllers.*;
import ma.fstm.ilisi2.gestionContact.models.bo.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Collection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ListContactPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ContactController ctrl=new ContactController();
	private JFrame context=this;
	private DefaultTableModel model;
	private JTextField keyWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListContactPage frame = new ListContactPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addContactstoModel(JTable table,Collection<Contact> contacts) {
		model=(DefaultTableModel)table.getModel();
		for(Contact contact:contacts) {
			model.addRow(new Object[] {
					contact.getType().getId(),
					contact.getType().getTitle(),
					contact.getId(),
					contact.getLastName(),
					contact.getFirstName(),
					contact.getPhone()});
		}
	}

	/**
	 * Create the frame.
	 */
	public ListContactPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 63, 336, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idType", "type", "", "Last name", "First name", "Phone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, Long.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		scrollPane.setViewportView(table);
		Collection<Contact> contacts=ctrl.getAllContacts();
		addContactstoModel(table, contacts);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				if(selectedRow>=0) {
					Long id=(Long) table.getValueAt(selectedRow, 2);
					ctrl.updatePage(id);
					context.dispose();
				}
				else JOptionPane.showMessageDialog(context, "please select a row");
			}
		});
		btnNewButton.setBounds(190, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow=table.getSelectedRow();
				if(selectedRow>=0) {
					Long id=(Long) table.getValueAt(selectedRow, 2);
					while(model.getRowCount()>0)	model.removeRow(0);
					ctrl.deleteContact(id);
					Collection<Contact> contacts=ctrl.getAllContacts();
					addContactstoModel(table, contacts);
				}
				else JOptionPane.showMessageDialog(context, "please select a row");
			}
		});
		btnNewButton_1.setBounds(289, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("List of Contacts");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(132, 0, 165, 29);
		contentPane.add(lblNewLabel);
		
		keyWord = new JTextField();
		keyWord.setBounds(121, 32, 165, 20);
		contentPane.add(keyWord);
		keyWord.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyWordText=keyWord.getText();
				Collection<Contact> contacts=ctrl.searchByKeyword(keyWordText);
				if(contacts!=null) {
					while(model.getRowCount()>0)	model.removeRow(0);
					addContactstoModel(table, contacts);
				}
			}
		});
		btnNewButton_3.setBounds(296, 31, 87, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.addContactPage();
				context.dispose();
			}
		});
		btnNewButton_2.setBounds(0, 6, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
