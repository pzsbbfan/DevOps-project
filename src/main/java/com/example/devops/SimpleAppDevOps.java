package com.example.devops;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SimpleAppDevOps extends JFrame {
    public HashMap<String, String> users = new HashMap<>();
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel;

    public SimpleAppDevOps() {
        // Preload some users
        users.put("john", "password123");
        users.put("jane", "securepassword");

        // Initialize GUI components
        setTitle("Login and Registration System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        mainPanel = new JPanel(cardLayout);

        // Add login and registration screens
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createRegistrationPanel(), "Register");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");

        setLocationRelativeTo(null); // Center the window
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Go to Register");

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

        // Switch to Registration Panel
        btnRegister.addActionListener(e -> cardLayout.show(mainPanel, "Register"));

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnRegister);

        return panel;
    }

    private JPanel createRegistrationPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel lblUsername = new JLabel("Choose a Username:");
        JLabel lblPassword = new JLabel("Choose a Password:");
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JButton btnRegister = new JButton("Register");
        JButton btnBack = new JButton("Back to Login");

        // Add Action Listener for Register Button
        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                users.put(username, password);
                JOptionPane.showMessageDialog(this, "Registration Successful!");
                cardLayout.show(mainPanel, "Login");
            }
        });

        // Switch back to Login Panel
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnRegister);
        panel.add(btnBack);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleAppDevOps app = new SimpleAppDevOps();
            app.setVisible(true);
        });
    }
}
