package project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu_principal {

	private JFrame frame;
	private JTextField txtnom;
	private JTextField txtprix;
	private JTextField txttotal;
	private JTextField txtrendu;
	private JTextField txtpayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principal window = new Menu_principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textField;
	private JTable table;
	
	public Menu_principal() {
		initialize();
		Table();
	} 
	

private void Table() {
	try {
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie", "root", "");
                PreparedStatement pst = con.prepareStatement("select * from tb_pharma" );
		String [] entet={"Code","Nom","Prix","Qtt","Total","Paiement","Rendu"};
		String [] ligne= new String[8];
		DefaultTableModel Model = new DefaultTableModel(null,entet);
		ResultSet rs = pst.executeQuery(); 
		while (rs.next()) {
			ligne [0] = rs.getString("Code");
			ligne [1] = rs.getString("Nom");
			ligne [2] = rs.getString("Prix");
			ligne [3] = rs.getString("Qtt");
			ligne [4] = rs.getString("Total");
			ligne [5] = rs.getString("Paiement");
			ligne [6] = rs.getString("Rendu");
			Model.addRow(ligne);

		}
			table.setModel(Model);
			

	}catch (Exception e) {
		e.printStackTrace();
	}
}
public JFrame getFrame() {
    return frame;
}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.setResizable(false);
		frame.setBounds(100, 100, 842, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 656, 46);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion du pharmacie");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(55, 11, 493, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 62, 656, 337);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(20, 85, 78, 17);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantité : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_2.setBounds(33, 134, 78, 17);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nom : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_3.setBounds(20, 42, 78, 17);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_4.setBounds(228, 42, 78, 17);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Paiement : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_5.setBounds(228, 85, 78, 17);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Rendu : ");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6.setBounds(228, 134, 78, 17);
		panel_1.add(lblNewLabel_1_6);
		
		txtnom = new JTextField();
		txtnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtnom.setColumns(10);
		txtnom.setBounds(111, 41, 86, 20);
		panel_1.add(txtnom);
		
		txtprix = new JTextField();
		txtprix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtprix.setColumns(10);
		txtprix.setBounds(111, 84, 86, 20);
		panel_1.add(txtprix);
		
		txttotal = new JTextField();
		txttotal.setForeground(new Color(255, 0, 0));
		txttotal.setBackground(new Color(255, 255, 255));
		txttotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttotal.setColumns(10);
		txttotal.setBounds(301, 40, 86, 20);
		panel_1.add(txttotal);
		
		txtrendu = new JTextField();
		txtrendu.setBackground(new Color(255, 255, 255));
		txtrendu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrendu.setColumns(10);
		txtrendu.setBounds(301, 133, 86, 20);
		panel_1.add(txtrendu);
		
		txtpayer = new JTextField();
		txtpayer.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				int total = Integer.parseInt(txttotal.getText());
				int payer = Integer.parseInt(txtpayer.getText());
			int rendu = payer-total;
			txtrendu.setText(String.valueOf(rendu));
			}
		});
		txtpayer.setForeground(new Color(0, 0, 0));
		txtpayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpayer.setColumns(10);
		txtpayer.setBackground(new Color(255, 255, 255));
		txtpayer.setBounds(301, 83, 86, 20);
		panel_1.add(txtpayer);
		
		JSpinner txtqtt = new JSpinner();
		txtqtt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prix = Integer.parseInt(txtprix.getText());
				int qte = Integer.parseInt(txtqtt.getValue().toString());
				int total = prix * qte ;
				txttotal.setText(String.valueOf(total));
			}
		});
		txtqtt.setForeground(new Color(255, 255, 255));
		txtqtt.setBackground(new Color(0, 128, 255));
		txtqtt.setBounds(149, 134, 30, 20);
		panel_1.add(txtqtt);
		
		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.jdbc.Driver"); 
		            // Connect to the database
		            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie", "root", "");
		                 PreparedStatement pst = con.prepareStatement("INSERT INTO `tb_pharma` (`Nom`, `Prix`, `Qtt`, `Total`, `Paiement`, `Rendu`) VALUES (?, ?, ?, ?, ?, ?)")) {
		                // Set values for the PreparedStatement
		                pst.setString(1, txtnom.getText());
		                pst.setString(2, txtprix.getText());
		                pst.setString(3, txtqtt.getValue().toString());
		                pst.setString(4, txttotal.getText());
		                pst.setString(5, txtpayer.getText());
		                pst.setString(6, txtrendu.getText());
		                // Execute the SQL query
		                pst.executeUpdate();
		                JOptionPane.showMessageDialog(null, txtnom.getText() + " ajouté");
		                txtnom.setText("");
		                txtprix.setText("");
		                txtqtt.setValue(0);
		                txttotal.setText("");
		                txtpayer.setText("");
		                txtrendu.setText("");
		                // Refresh the table
		                Table();
		                
		            }
		        } catch (SQLException | ClassNotFoundException e2) {
		            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'enregistrement des données.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            e2.printStackTrace(); // Log the exception
		        }
		    }
		});
		enregistrer.setFont(new Font("Tahoma", Font.ITALIC, 14));
		enregistrer.setForeground(new Color(255, 0, 0));
		enregistrer.setBackground(new Color(255, 255, 255));
		enregistrer.setBounds(21, 167, 120, 23);
		panel_1.add(enregistrer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie", "root", "");
		                 PreparedStatement pst = con.prepareStatement("DELETE FROM tb_pharma WHERE Nom = ?")) {
		            	
		                pst.setString(1, textField.getText());
		                pst.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Médicament supprimé : " + textField.getText());
		             // Refresh the table
		                Table();
		                
		            }
		        } catch (SQLException | ClassNotFoundException e2) {
		            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la suppression du médicament.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            e2.printStackTrace(); // Log the exception
		        }
		    }
		}); 
		btnSupprimer.setForeground(new Color(255, 0, 0));
		btnSupprimer.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnSupprimer.setBackground(new Color(255, 255, 255));
		btnSupprimer.setBounds(78, 272, 120, 23);
		panel_1.add(btnSupprimer); 
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Nom de médicament à supprimer : ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_3_1.setBounds(32, 244, 226, 17);
		panel_1.add(lblNewLabel_1_3_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(290, 243, 86, 20);
		panel_1.add(textField);
		
		JButton btnQuiter = new JButton("Quitter");
		btnQuiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuiter.setForeground(new Color(255, 0, 0));
		btnQuiter.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnQuiter.setBackground(new Color(255, 255, 255));
		btnQuiter.setBounds(267, 272, 120, 23);
		panel_1.add(btnQuiter);
		
		JButton btnmodifier = new JButton("MAJ");
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
		            Class.forName("com.mysql.jdbc.Driver"); 
		            // Connect to the database
		            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie", "root", "");
		                 PreparedStatement pst = con.prepareStatement("UPDATE `tb_pharma` SET `Prix` = ?, `Qtt` = ?, `Total` = ?, `Paiement` = ?, `Rendu` = ? WHERE `Nom` = ?")) {
		                // Set values for the PreparedStatement
		                pst.setString(1, txtprix.getText());
		                pst.setString(2, txtqtt.getValue().toString());
		                pst.setString(3, txttotal.getText());
		                pst.setString(4, txtpayer.getText());
		                pst.setString(5, txtrendu.getText());
		                pst.setString(6, txtnom.getText());
		                // Execute the SQL query
		                pst.executeUpdate();
		                JOptionPane.showMessageDialog(null, txtnom.getText() + " mis à jour");
		                txtnom.setText("");
		                txtprix.setText("");
		                txtqtt.setValue(0);
		                txttotal.setText("");
		                txtpayer.setText("");
		                txtrendu.setText("");
		                // Refresh the table
		                Table();
		            }
		        } catch (SQLException | ClassNotFoundException e2) {
		            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la mise à jour des données.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            e2.printStackTrace(); // Log the exception
		        }
				
			}
		});
		btnmodifier.setForeground(Color.RED);
		btnmodifier.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnmodifier.setBackground(Color.WHITE);
		btnmodifier.setBounds(267, 169, 120, 23);
		panel_1.add(btnmodifier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 410, 656, 116);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(255, 0, 0));
		table.setBackground(new Color(255, 255, 255));
	}
}
