package project;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {

    private JFrame frame;
    private JTextField login;
    private JTextField password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 498, 361);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        login = new JTextField();
        login.setBounds(105, 72, 71, 20);
        frame.getContentPane().add(login);
        login.setColumns(10);

        JLabel lblNewLabel_1_3 = new JLabel("Login : ");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNewLabel_1_3.setBounds(24, 72, 78, 17);
        frame.getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_3_1 = new JLabel("Password : ");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNewLabel_1_3_1.setBounds(24, 103, 78, 17);
        frame.getContentPane().add(lblNewLabel_1_3_1);

        password = new JTextField();
        password.setColumns(10);
        password.setBounds(105, 103, 71, 20);
        frame.getContentPane().add(password);

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacie", "root", "");
                    String loginText = login.getText();
                    String passwordText = password.getText();
                    String query = "SELECT * FROM log WHERE username = ? AND password = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, loginText);
                    pst.setString(2, passwordText);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        frame.dispose();
                        Menu_principal principale = new Menu_principal();
                        principale.getFrame().setVisible(true); // Make Menu_principal frame visible
                    } else {
                        JOptionPane.showMessageDialog(null, "Une erreur est survenue lors du login");
                    }
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        valider.setForeground(Color.RED);
        valider.setFont(new Font("Tahoma", Font.ITALIC, 14));
        valider.setBackground(Color.WHITE);
        valider.setBounds(179, 154, 120, 23);
        frame.getContentPane().add(valider);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 15, 465, 46);
        frame.getContentPane().add(panel);

        JLabel lblNewLabel = new JLabel("Gestion du pharmacie");
        lblNewLabel.setBounds(36, 11, 367, 29);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
    }
}
