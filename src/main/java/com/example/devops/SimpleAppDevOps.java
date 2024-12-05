package com.example.devops;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SimpleAppDevOps extends JFrame{

    private HashMap<String, String> users = new HashMap<>();

    public SimpleAppDevOps() {
        // Preload some users
        users.put("admin", "admin");
        users.put("jane", "securepassword");

        // Initialize GUI components
        setTitle("Login System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Create login panel
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        // Add Action Listener for Login Button
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (users.containsKey(username) && users.get(username).equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);

        add(panel);
        setLocationRelativeTo(null); // Center the window
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleAppDevOps app = new SimpleAppDevOps();
            app.setVisible(true);
        });
    }
}
