package vista;

import controlador.LoginController;

import javax.swing.*;

public class Login extends JFrame {
    private JPasswordField passwordTexbox;
    private JTextField userTexbox;
    private JButton btnLogin;
    private JPanel panel;

    public Login() {
        setTitle("Login");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 250);

        btnLogin.addActionListener(v -> {
            String user = userTexbox.getText();
            String password = new String(passwordTexbox.getPassword());

            if ((new LoginController()).isExist(user, password)) {
                VerClientes clientes = new VerClientes();
                clientes.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrecta.");
            }


            userTexbox.setText("");
            passwordTexbox.setText("");
        });
    }
}