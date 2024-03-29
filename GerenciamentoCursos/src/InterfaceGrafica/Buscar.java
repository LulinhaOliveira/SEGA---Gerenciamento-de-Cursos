package InterfaceGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Negocio.Entidades.Curso;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Turma;
import Negocio.Entidades.Usuario;
import Negocio.Fachada.Fachada;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	JComboBox <String> comboBox = new JComboBox <String>();
	public static Buscar instance;
	public static Buscar getInstace() {
		if (Buscar.instance == null) {
			return Buscar.instance = new Buscar();
		}
		return Buscar.instance;
	}


	public void preencheCMB() {
		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			@SuppressWarnings("unused")
			Curso c;
			Fachada.getInstace().getCcurso().buscarCurso(c = new Curso("","",""));

			for(Curso a : Fachada.getInstace().getCcurso().getCp().getCursosLista()) {
				comboBox.addItem(a.getNome());
			}
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				@SuppressWarnings("unused")
				Disciplina d;
				Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina(0,"","", 0,'S',TelaLogin.getCurso_aluno_coord(),0));
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				@SuppressWarnings("unused")
				Disciplina d;
				Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina(0,"","", 0,'S',0,0));
			}

			for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
				comboBox.addItem(d.getNome());
			}
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			@SuppressWarnings("unused")
			Turma t;
			Fachada.getInstace().getTc().buscarTurma(t = new Turma("","","",""));

			for(Turma a : Fachada.getInstace().getTc().getTp().getTurmalista()){
				comboBox.addItem(a.getNome());

			}

		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			Fachada.getInstace().buscarPerfil("coordenador",'W',0);


			for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
				comboBox.addItem(u.getNome());
			}

		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			Fachada.getInstace().buscarPerfil("professor",'W',0);


			for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
				comboBox.addItem(u.getNome());
			}
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			if(TelaLogin.getInstace().getAdmCor() == 0) {
				Fachada.getInstace().buscarPerfil("aluno",'W',TelaLogin.getCurso_aluno_coord());


				for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
					comboBox.addItem(u.getNome());
				}
			}else if (TelaLogin.getInstace().getAdmCor() == 1) {
				Fachada.getInstace().buscarPerfil("aluno",'W',0);


				for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
					comboBox.addItem(u.getNome());
				}			}
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			
			Fachada.getInstace().disciplinasOfertadas("", TelaLogin.getCurso_aluno_coord(),'N');

			for(Disciplina d : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
				comboBox.addItem(d.getNome());
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Buscar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox.setBounds(29, 48, 380, 22);
		contentPane.add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(173, 225, 91, 23);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 92, 380, 120);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JLabel lblInativar = new JLabel("Buscar");
		lblInativar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInativar.setBounds(156, 0, 169, 37);
		contentPane.add(lblInativar);

		preencheCMB();

		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Curso c = new Curso((String)comboBox.getSelectedItem(),"","");
					Fachada.getInstace().getCcurso().buscarCurso(c);
					for(Curso c2 : Fachada.getInstace().getCcurso().getCp().getCursosLista()) {
						textArea.setText(c2.toString());
					}
				}
			});
		}else if(GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {


			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Disciplina d = new Disciplina(0,(String)comboBox.getSelectedItem(),"", 0,'S',0,0);
					Fachada.getInstace().getDc().buscarDisciplina(d);

					for(Disciplina d2 : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
						textArea.setText(d2.toString());
					}

				}
			});
		}else if(GerenciamentoDeTurmas.getInstace().isVisible() == true) {


			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Turma t = new Turma((String)comboBox.getSelectedItem(),"","","");
					Fachada.getInstace().getTc().buscarTurma(t);
					for(Turma t2 : Fachada.getInstace().getTc().getTp().getTurmalista()) {
						textArea.setText(t2.toString());
					}
				}
			});
		}else if(GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {

			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario(Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem()));

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if(GerenciamentoDeProfessores.getInstace().isVisible() == true) {


			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario(Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem()));

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if(GerenciamentoDeAlunos.getInstace().isVisible() == true) {


			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Fachada.getInstace().getUc().getUsuarioRepositorio().encontrarUsuario(Fachada.getInstace().getUc().buscarCodigo((String) comboBox.getSelectedItem()));

					textArea.setText(Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario().get(0).toString());

				}
			});
		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {

			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod = Fachada.getInstace().buscarPosiçãoDisciplina((String) comboBox.getSelectedItem());

					textArea.setText("Disciplina: " + Fachada.getInstace().getDc().getDr().getDisciplinaLista().get(cod).getNome()
							+ "\n Dia 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_1()
							+ "\n Dia 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getDia_2()
							+ "\n Hora 1: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_1()
							+ "\n Hora 2: " + Fachada.getInstace().getOdc().getOd().getOferta_disciplinalista().get(cod).getHora_2()
							);



				}
			});

		}
	}

}
