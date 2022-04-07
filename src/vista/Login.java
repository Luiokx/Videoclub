package vista;

import controlador.LoginController;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Login {
    private JPasswordField passwordTexbox;
    private JTextField userTexbox;
    private JButton btnLogin;
    private JPanel panel;

    public Login() {
        btnLogin.addActionListener(v -> {
            String user = userTexbox.getText();
            String password = new String(passwordTexbox.getPassword());

            (new LoginController()).login(user, password);

            userTexbox.setText("");
            passwordTexbox.setText("");
        });
    }

    public void init() {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 250, 250);
        frame.setVisible(true);
    }
}