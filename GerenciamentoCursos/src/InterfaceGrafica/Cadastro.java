package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.CPFException;
import Exception.CampoVazioException;
import Exception.DiasSemanaException;
import Exception.EmailInvalidoException;
import Exception.NomeNumeroException;
import Exception.SenhaPequenaException;
import Exception.horaIndisponivelException;
import Negocio.Entidades.Curso;
import Negocio.Entidades.Disciplina;
import Negocio.Entidades.Turma;
import Negocio.Entidades.Usuario;
import Negocio.Fachada.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField textField_5;
	private JLabel lblCadastro_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblCurso;
	private JTextField textField_6;
	private JComboBox <String> comboBox = new JComboBox <String>();
	private JComboBox <String> comboBox_1 = new JComboBox <String>();
	private JComboBox<String> cmbCursos = new JComboBox <String>();
	private JComboBox<String> cmbTurmas = new JComboBox <String>();
	private JComboBox<String> cmbCoordenadores = new JComboBox <String>();
	private JComboBox<String> cmbTurno = new JComboBox <String>();
	JRadioButton rdbtnM = new JRadioButton("M");
	JRadioButton rdbtnF = new JRadioButton("F");
	public static Cadastro instance;

	
	public static Cadastro getInstace()  {
		if (Cadastro.instance == null) {
			return Cadastro.instance = new Cadastro();
		}
		return Cadastro.instance;
	}
	
	public void preencherCMBDisciplina(){
		comboBox.removeAllItems();
		@SuppressWarnings("unused")
		Disciplina d;
		Fachada.getInstace().getDc().buscarDisciplina(d = new Disciplina("",TelaLogin.getCurso_aluno_coord(),'S'));
		
		for(Disciplina d2 : Fachada.getInstace().getDc().getDr().getDisciplinaLista()) {
			comboBox.addItem(d2.getNome());
		}
	}
	
	public void preencherCMBCursos() {
		@SuppressWarnings("unused")
		Curso c;
		Fachada.getInstace().getCcurso().buscarCurso(c = new Curso("","",""));

		for(Curso a : Fachada.getInstace().getCcurso().getCp().getCursosLista()) {
			cmbCursos.addItem(a.getNome());
		}
	}
	public void preencherCMBTurmas() {
		@SuppressWarnings("unused")
		Turma t;
		Fachada.getInstace().getTc().buscarTurma(t = new Turma("","","",""));

		for(Turma a : Fachada.getInstace().getTc().getTp().getTurmalista()){
			cmbTurmas.addItem(a.getNome());

		}
	}
	
	public void preencherCMBCoordenadores() {
		Fachada.getInstace().buscarPerfil("coordenador",'W',0);

		for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
			cmbCoordenadores.addItem(u.getNome());
		}
	}
	
	public void preencherCMBTurno() {
		cmbTurno.addItem("manha");
		cmbTurno.addItem("tarde");
		cmbTurno.addItem("noite");
	}
	
	public void preencherCMBProfessores() {
		comboBox_1.removeAllItems();
		Fachada.getInstace().buscarPerfil("professor",'S',0);
		
		for(Usuario u : Fachada.getInstace().getUc().getUsuarioRepositorio().getListaUsuario()) {
			comboBox_1.addItem(u.getNome());
		}
		
	}
	
	public char definirSexo() {
		char s= 'W';
		if(rdbtnM.isSelected()) {
			s = 'M';
		}else if(rdbtnF.isSelected()) {
			s =  'F';
		}
		return s;
	}
	static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}


	public Cadastro() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(12, 125, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCadastro_1 = new JLabel("Cadastro");
		lblCadastro_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCadastro_1.setBounds(147, 11, 135, 44);
		contentPane.add(lblCadastro_1);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setBounds(174, 219, 91, 23);
		contentPane.add(btnCadastrar);

		rdbtnF.setSelected(true);
		if(GerenciamentoDeCursos.getInstace().isVisible() == true) {		

			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Horario Funcionamento: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("CPF do Coordenador: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			cmbCoordenadores.setBounds(10, 190, 130, 20);
			contentPane.add(cmbCoordenadores);
			preencherCMBCoordenadores();

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Curso curso =  new Curso((String)textField.getText(),(String)textField_1.getText(),Fachada.getInstace().getUc().buscarCodigo((String)cmbCoordenadores.getSelectedItem()));


					try {
						Fachada.getInstace().getCcurso().inserirCurso(curso);
					} catch (CampoVazioException e1) {
						JOptionPane.showMessageDialog(null, e1.toString("Nome N�o Pode Ser "));

					}

				}
			});

		}else if (GerenciamentoDeDisciplinas.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Ementa: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("numero de Creditos: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Curso: ");
			lblNewLabel_2.setBounds(162, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Turma: ");
			lblNewLabel_3.setBounds(162, 126, 140, 14);
			contentPane.add(lblNewLabel_3);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			
			cmbCursos.setBounds(254, 83, 164, 22);
			contentPane.add(cmbCursos);
			
			
			cmbTurmas.setBounds(254, 122, 164, 22);
			contentPane.add(cmbTurmas);

			preencherCMBCursos();
			preencherCMBTurmas();
			
			if (TelaLogin.getInstace().getAdmCor() == 0) {
				lblNewLabel_2.setEnabled(false);
				cmbCursos.setEnabled(false);
				
			}				
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(TelaLogin.getInstace().getAdmCor() == 0) {
						@SuppressWarnings("unused")
						Disciplina d;
						Fachada.getInstace().getDc().inserirDisciplina(d = new Disciplina(0,textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),'S',TelaLogin.getCurso_aluno_coord(),Fachada.getInstace().getTc().buscarCodigo((String)cmbTurmas.getSelectedItem())));
					}else if (TelaLogin.getInstace().getAdmCor() == 1) {
						@SuppressWarnings("unused")
						Disciplina d;
						Fachada.getInstace().getDc().inserirDisciplina(d = new Disciplina(0,textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()),'S',Fachada.getInstace().getCcurso().buscarCodigo((String) cmbCursos.getSelectedItem()),Fachada.getInstace().getTc().buscarCodigo((String)cmbTurmas.getSelectedItem())));
					}				
				}
			});

		}else if (GerenciamentoDeTurmas.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("Nome: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Sigla: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Turno: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Semestre: ");
			lblNewLabel_2.setBounds(162, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			

			cmbTurno.setBounds(10, 196, 130, 22);
			contentPane.add(cmbTurno);
			preencherCMBTurno();
			
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Turma turma = new Turma((String)textField.getText(),(String)textField_1.getText(),(String)cmbTurno.getSelectedItem(), (String) textField_3.getText());;
					
					try {
						Fachada.getInstace().getTc().inserirTurma(turma);
					} catch (CampoVazioException e1) {
						JOptionPane.showMessageDialog(null, e1.toString("Nenhum Campo Pode Ser "));
					}
				}
			});

		}else if (GerenciamentoDeCoordenadores.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	

			
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);

			btnCadastrar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try {
						Fachada.getInstace().cadastrarCoordenador(textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), definirSexo());
					} catch (CPFException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (NomeNumeroException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (SenhaPequenaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (EmailInvalidoException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					}
					
				}
			});


		}else if (GerenciamentoDeProfessores.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	

			JRadioButton rdbtnM = new JRadioButton("M");
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);

			btnCadastrar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try {
						Fachada.getInstace().cadastrarProfessor(textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), definirSexo());
					} catch (CPFException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (NomeNumeroException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (SenhaPequenaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (EmailInvalidoException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					}

				}
			});


		}else if (GerenciamentoDeAlunos.getInstace().isVisible() == true) {
			JLabel lblLabel = new JLabel("CPF: ");
			lblLabel.setBounds(10, 62, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Nome: ");
			lblNewLabel.setBounds(10, 118, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Sexo: ");
			lblNewLabel_1.setBounds(10, 171, 164, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Telefone: ");
			lblNewLabel_2.setBounds(184, 87, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("e-mail: ");
			lblNewLabel_3.setBounds(184, 118, 140, 14);
			contentPane.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Senha:");
			lblNewLabel_4.setBounds(184, 160, 130, 14);
			contentPane.add(lblNewLabel_4);

			lblCurso = new JLabel("Curso");
			lblCurso.setBounds(184, 194, 140, 14);
			contentPane.add(lblCurso);

			textField = new JTextField();
			textField.setBounds(10, 87, 130, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 140, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(318, 87, 114, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);


			textField_4 = new JTextField();
			textField_4.setBounds(318, 123, 114, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);

			textField_5 = new JPasswordField();
			textField_5.setBounds(318, 157, 114, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);	


			JRadioButton rdbtnM = new JRadioButton("M");
			buttonGroup.add(rdbtnM);
			rdbtnM.setBounds(10, 192, 42, 23);
			contentPane.add(rdbtnM);

			JRadioButton rdbtnF = new JRadioButton("F");
			buttonGroup.add(rdbtnF);
			rdbtnF.setBounds(70, 192, 42, 23);
			contentPane.add(rdbtnF);
			
			cmbCursos.setBounds(268, 191, 164, 20);
			contentPane.add(cmbCursos);
			preencherCMBCursos();
			
			if (TelaLogin.getInstace().getAdmCor() == 0) {
				lblCurso.setEnabled(false);
				cmbCursos.setEnabled(false);
			}				
			btnCadastrar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					if(TelaLogin.getInstace().getAdmCor() == 0) {
						try {
							Fachada.getInstace().cadastrarAluno(textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), definirSexo(),TelaLogin.getCurso_aluno_coord());
						} catch (CampoVazioException e1) {
							JOptionPane.showMessageDialog(null, e1.toString("Nenhum Campo Pode Ser"));
						} catch (CPFException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (NomeNumeroException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (SenhaPequenaException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (EmailInvalidoException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						}
						Fachada.getInstace().matriculaPrimeiroPeriodo(TelaLogin.getCurso_aluno_coord(), textField.getText());
					}else if (TelaLogin.getInstace().getAdmCor() == 1) {
						try {
							Fachada.getInstace().cadastrarAluno(textField.getText(), textField_1.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), definirSexo(),Fachada.getInstace().getCcurso().buscarCodigo((String) cmbCursos.getSelectedItem()) );
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (CampoVazioException e1) {
							JOptionPane.showMessageDialog(null, e1.toString("Nenhum Campo Pode Ser"));
						} catch (CPFException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (NomeNumeroException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (SenhaPequenaException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						} catch (EmailInvalidoException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.toString());
						}
						Fachada.getInstace().matriculaPrimeiroPeriodo(Integer.parseInt(textField_6.getText()), textField.getText());
					}	
				}
			});


		}else if (GerenciamentoOfertas.getInstace().isVisible() == true) {
			comboBox.setBounds(44, 61, 339, 20);
			contentPane.add(comboBox);

			
			comboBox_1.setBounds(44, 105, 339, 20);
			contentPane.add(comboBox_1);

			preencherCMBDisciplina();
			preencherCMBProfessores();
			
			JLabel lblLabel = new JLabel("Dia 1");
			lblLabel.setBounds(10, 126, 164, 14);
			contentPane.add(lblLabel);

			JLabel lblNewLabel = new JLabel("Dia 2");
			lblNewLabel.setBounds(10, 165, 164, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_2 = new JLabel("Hora 1");
			lblNewLabel_2.setBounds(174, 126, 140, 14);
			contentPane.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Hora 2");
			lblNewLabel_3.setBounds(174, 165, 140, 14);
			contentPane.add(lblNewLabel_3);

			textField = new JTextField();
			textField.setBounds(174, 143, 126, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(10, 143, 130, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(10, 190, 130, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(174, 188, 126, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);

			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
	
					try {
						Fachada.getInstace().cadastrarOferta((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem(), textField_1.getText(), textField_2.getText(), textField.getText(), textField_3.getText(), TelaLogin.getCurso_aluno_coord());
					} catch (horaIndisponivelException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (DiasSemanaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					}
					
					
				}
			});
		}


	}
}

/*
JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setBounds(162, 87, 140, 14);
contentPane.add(lblNewLabel_2);

JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setBounds(162, 126, 140, 14);
contentPane.add(lblNewLabel_3);

JLabel lblNewLabel_4 = new JLabel("");
lblNewLabel_4.setBounds(172, 163, 130, 14);
contentPane.add(lblNewLabel_4);

textField = new JTextField();
textField.setBounds(10, 87, 130, 20);
contentPane.add(textField);
textField.setColumns(10);

textField_1 = new JTextField();
textField_1.setBounds(10, 140, 130, 20);
contentPane.add(textField_1);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setBounds(10, 190, 130, 20);
contentPane.add(textField_2);
textField_2.setColumns(10);

textField_3 = new JTextField();
textField_3.setBounds(318, 87, 114, 20);
contentPane.add(textField_3);
textField_3.setColumns(10);

textField_4 = new JTextField();
textField_4.setBounds(318, 123, 114, 20);
contentPane.add(textField_4);
textField_4.setColumns(10);

textField_5 = new JTextField();
textField_5.setBounds(318, 157, 114, 20);
contentPane.add(textField_5);
textField_5.setColumns(10);	
 */