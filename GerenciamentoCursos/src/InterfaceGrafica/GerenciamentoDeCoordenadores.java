package InterfaceGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GerenciamentoDeCoordenadores extends JFrame {

	private JPanel contentPane;
	public static GerenciamentoDeCoordenadores instance;
	public static GerenciamentoDeCoordenadores getInstace() {
		if (GerenciamentoDeCoordenadores.instance == null) {
			return GerenciamentoDeCoordenadores.instance = new GerenciamentoDeCoordenadores();
		}
		return GerenciamentoDeCoordenadores.instance;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoDeCoordenadores frame = new GerenciamentoDeCoordenadores();
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
	public GerenciamentoDeCoordenadores() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGerenciamentoDeCursos = new JLabel("Gerenciamento De");
		lblGerenciamentoDeCursos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGerenciamentoDeCursos.setBounds(72, 0, 432, 74);
		contentPane.add(lblGerenciamentoDeCursos);

		JLabel label = new JLabel("Sistema Educacional de Gerenciamento Acad\u00EAmico");
		label.setBounds(10, 259, 303, 14);
		contentPane.add(label);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Cadastro.getInstace().dispose();
					new Cadastro().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnCadastro.setBounds(40, 115, 117, 23);
		contentPane.add(btnCadastro);

		JButton btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Buscar.getInstace().dispose();
					new Buscar().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBusca.setBounds(282, 115, 117, 23);
		contentPane.add(btnBusca);

		JButton btnInativar = new JButton("Inativar");
		btnInativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Inativa.getInstace().dispose();
					new Inativa().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInativar.setBounds(40, 190, 117, 23);
		contentPane.add(btnInativar);

		JButton btnAtualizarDados = new JButton("Atualizar Dados");
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Atualizar.getInstace().dispose();
					new Atualizar().setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarDados.setBounds(282, 190, 117, 23);
		contentPane.add(btnAtualizarDados);

		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(TelaLogin.getInstace().getAdmCor() == 0) {
					PainelCoordenador.getInstace().setVisible(true);	
				}else if (TelaLogin.getInstace().getAdmCor() == 1) {
					PainelAdministrador.getInstace().setVisible(true);	
				}	
			}
		});
		button.setBounds(18, 11, 47, 23);
		contentPane.add(button);

		JLabel lblCoordenadores = new JLabel("Coordenadores");
		lblCoordenadores.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCoordenadores.setBounds(187, 54, 279, 33);
		contentPane.add(lblCoordenadores);
	}
}

