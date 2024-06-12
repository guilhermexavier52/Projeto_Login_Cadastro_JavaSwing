package loginCadastro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Login extends JFrame implements ActionListener {
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "123";
    private static final String USER_USER = "usuario";
    private static final String USER_PASS = "456";

    private JLabel lblUsuario, lblSenha, lblMensagem;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin, btnCadastro, btnSair;

    public Login() {
        super("Tela de Login");
        initializeUI();
    }

    private void initializeUI() {
        lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField();
        
        lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        
        btnCadastro = new JButton("Cadastro");
        btnCadastro.addActionListener(this);
        
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        
        lblMensagem = new JLabel("");

        // Configuração do layout
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblUsuario)
        						.addComponent(lblSenha))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtUsuario, 320, 320, 320)
        						.addComponent(txtSenha, 320, 320, 320)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(92)
        					.addComponent(btnLogin)
        					.addGap(18)
        					.addComponent(btnCadastro)
        					.addGap(18)
        					.addComponent(btnSair))
        				.addComponent(lblMensagem))
        			.addGap(10))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblUsuario)
        				.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSenha)
        				.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSair)
        				.addComponent(btnCadastro)
        				.addComponent(btnLogin))
        			.addComponent(lblMensagem))
        );
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void verificaLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (usuario.equals(ADMIN_USER) && senha.equals(ADMIN_PASS)) {
            lblMensagem.setText("Seja bem-vindo, Administrador");
            lblMensagem.setForeground(Color.BLUE);
        } else if (usuario.equals(USER_USER) && senha.equals(USER_PASS)) {
            lblMensagem.setText("Seja bem-vindo, Usuário");
            lblMensagem.setForeground(Color.BLACK);
        } else {
            lblMensagem.setText("Usuário ou Senha estão incorretos");
            lblMensagem.setForeground(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            verificaLogin();
        } else if (e.getSource() == btnCadastro) {
            Cadastro cadastro = new Cadastro();
            cadastro.setVisible(true);
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame janela = new Login();
            janela.setVisible(true);
        });
    }
}

// Placeholder for Cadastro class
class Cadastro extends JFrame {
    private JLabel lblNome, lblEmail, lblSenha;
    private JTextField txtNome, txtEmail;
    private JPasswordField txtSenha;
    private JButton btnSalvar, btnCancelar;

    public Cadastro() {
        super("Tela de Cadastro");
        initializeUI();
    }

    private void initializeUI() {
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        
        lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cadastro salvo!"));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        // Configuração do layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblEmail)
                    .addComponent(lblSenha))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtEmail)
                    .addComponent(txtSenha)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSalvar)
                .addComponent(btnCancelar))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNome)
                .addComponent(txtNome))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmail)
                .addComponent(txtEmail))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblSenha)
                .addComponent(txtSenha))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnSalvar)
                .addComponent(btnCancelar))
        );

        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
