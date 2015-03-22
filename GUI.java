package br.com.ufpb.projetopoo;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GUI extends JFrame{
	private ExercicioFacade sistema;
	JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7, 
	        botao8, botao9, botao10, botao11, botao12, botao13, botao14, 
	        botao15, botao16, botao17, botao18, botao19;
	public static void main(String[] args) {
		GUI janela = new GUI();
		janela.setVisible(true);
	}
	public GUI(){
		super("Sistema Criação de Exercicio");	
		this.sistema=new ExercicioFacade();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(18,6));
		botao1=new JButton("Cadastrar Professor"); 
		c2.add(botao1);
		botao2=new JButton("Cadastrar Aluno");
		c2.add(botao2);
		botao3=new JButton("Cadastrar Resposta do Exercicio");
		c2.add(botao3);
		botao4=new JButton("Pesquisar Professor");
		c2.add(botao4);
		botao5 = new JButton("Pesquisar Aluno");
		c2.add(botao5);
		botao6 = new JButton("Pesquisar Exercicio");
		c2.add(botao6);
		botao7 = new JButton("Listar Exercicios");
		c2.add(botao7);
		botao8 = new JButton("Sortear Exercício");
		c2.add(botao8);
		botao9 = new JButton("Atualizar Exercicio");
		c2.add(botao9);
		botao10 = new JButton("Corrigir Exercicio");
		c2.add(botao10);
		botao11 = new JButton("Pesquisa Questao De Exercicio");
		c2.add(botao11);
		botao12 = new JButton("Enviar feedback para alunos");
		c2.add(botao12);
		botao13 = new JButton("Enviar feedback para professor");
		c2.add(botao13);
		botao15 =  new JButton("Remover Professor");
		c2.add(botao15);
		botao16 = new JButton("Remover Aluno");
		c2.add(botao16);
		botao17 = new JButton("Remover Exercico");
		c2.add(botao17);
		botao18 = new JButton("Obter Lista De Professores");
		c2.add(botao18);
		botao19 = new JButton("Obter Lista De Alunos");
		c2.add(botao19);
		
		c.setLayout(new BorderLayout(5,5));
		botao14 = new JButton("Cadastrar Exercicio");
		c.add(botao14);
		c.add(BorderLayout.BEFORE_LINE_BEGINS, c2);//EAST
		this.setSize(450,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(150, 150);
		botao1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o Nome: ");
				String matricula = JOptionPane.showInputDialog("Digite a Matricula: ");
				try {
					sistema.cadastrarProfessor(nome, matricula);
					sistema.sairDoSistema();
				} catch (ProfessorJaExisteException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}			
			}
			});
		botao2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite o Nome: ");
				String matricula = JOptionPane.showInputDialog("Digite a Matricula: ");
				try {
					sistema.cadastrarAluno(nome, matricula);
					sistema.sairDoSistema();
				} catch (AlunoJaExisteException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}			
			}
			});
		botao3.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nomeExercicio = JOptionPane.showInputDialog("Digite o Nome do Exercicio que Deseja Cadastrar as Respostas: ");
					Exercicio exer = sistema.pesquisarExercicio(nomeExercicio);
					String nome = JOptionPane.showInputDialog("Digite Seu Nome: ");
					String matricula = JOptionPane.showInputDialog("Digite Sua Matricula: ");
					Aluno a = new Aluno(nome, matricula);
					RespostaDoExercicio r = new RespostaDoExercicio();
					r.setAluno(a);
					r.setExercicio(exer);
					String quantString = JOptionPane.showInputDialog("Digite a Quantidade de Resposta: ");
					int quantResposta = Integer.parseInt(quantString);
					for(int k=0; k<quantResposta; k++){
						int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um Tipo de Questão Associando um Numero: \n1 Questão V ou F\n2 Questão Dissertativa\n3 Questão Multipla Escolha"));
						if(num == 1){
							String numString = JOptionPane.showInputDialog(null,"Digite o Numero da Questão: ");
							int numero = Integer.parseInt(numString);
							String resposta = JOptionPane.showInputDialog(null,"Forneça a Resposta: ");
							r.cadastrarRespostaQuestao(numero, resposta, TipoQuestao.QUESTAO_V_OU_F);
						}else if(num == 2){
							int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Questão: "));
							String resposta = JOptionPane.showInputDialog(null,"Forneça a Resposta: ");
							r.cadastrarRespostaQuestao(numero, resposta, TipoQuestao.QUESTAO_DISSERTATIVA);
						}else if(num == 3){
							int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Questao: "));
							String resposta = JOptionPane.showInputDialog(null,"Forneça a Resposta: ");
							r.cadastrarRespostaQuestao(numero, resposta, TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA);
						}else{
							JOptionPane.showMessageDialog(null,"Tipo Questão Invalido!");
						}
					}		
					sistema.cadastrarRespostaDoExercicio(r);
					sistema.sairDoSistema();
				} catch (ExercicioInexistenteException e) {
					System.out.println(e.getMessage());
				} 	
			}
		});
		botao4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricula = JOptionPane.showInputDialog("Digite Sua Matricula: ");
				try {
					Professor p = sistema.pesquisaProfessorPelaMatricula(matricula);
					JOptionPane.showMessageDialog(botao4,"O Professor Pesquisado é: "+p.getNome());
				} catch (ProfessorInexistenteException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}	
			}
		});
		botao5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricula = JOptionPane.showInputDialog("Digite Sua Matricula: ");
				try {
					Aluno p = sistema.pesquisaAlunoPelaMatricula(matricula);
					JOptionPane.showMessageDialog(botao5, "O Aluno Pesquisado é: "+p.getNome());
				} catch (AlunoInexistenteException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}	
			}
		});
		botao6.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				try {
					Exercicio e = sistema.pesquisarExercicio(nomeExercicio);
					System.out.println("\n"+e.getNomeExercicio());
					for(Questao q : e.getQuestoes()){
						if(q.getTipo().equals(TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA)){
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
							for(String i: q.getAltenativas()){
								System.out.println(i);
							}
						}else if(q.getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
						}else{
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());		
						}
				    }
				} catch (ExercicioInexistenteException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		botao7.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				List<Exercicio> exercicios = sistema.listarExercíciosCadastrados();
				for(Exercicio e: exercicios){
					System.out.println("\n"+e.getNomeExercicio());
					for(Questao q : e.getQuestoes()){
						if(q.getTipo().equals(TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA)){
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
							for(String i: q.getAltenativas()){
								System.out.println(i);
							}
						}else if(q.getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
						}else{
							System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());		
						}
				    }
				}
			}
		});
		botao8.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				Exercicio exercicio = sistema.sortearExercício();
				System.out.println("\n"+exercicio.getNomeExercicio());
				for(Questao q: exercicio.getQuestoes()){
					if(q.getTipo().equals(TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA)){
						System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
						for(String i: q.getAltenativas()){
							System.out.println(i);
						}
					}else if(q.getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
						System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());
					}else{
						System.out.println("\n"+q.getNumQuestao()+" "+q.getQuestao());		
					}
				}
			}
		});
		botao9.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio =JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String numQuestaoString = JOptionPane.showInputDialog(null,"Digite o Numero da Questão: ");
				int numQuestao = Integer.parseInt(numQuestaoString);
				String questao = JOptionPane.showInputDialog(null,"Digite a Nova Questão: ");
				try {
					sistema.atualizarExercício(nomeExercicio, numQuestao, questao);
					sistema.sairDoSistema();
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}	
			}
		});
		botao10.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String matriculaAluno = JOptionPane.showInputDialog(null,"Digite a Matricula do Aluno: ");
				try {
					int quantAcertos = sistema.corrigirExercicio(nomeExercicio, matriculaAluno);				
					JOptionPane.showMessageDialog(null,"Total de Acertos "+quantAcertos);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				} 				
			}			
		});
		botao11.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String numQuestaoString = JOptionPane.showInputDialog(null,"Digite o Numero da Questão: ");
				int numQuestao = Integer.parseInt(numQuestaoString);
				try {
					Questao questao = sistema.pesquisaQuestaoDeExercicio(nomeExercicio, numQuestao);
					if(questao.getTipo().equals(TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA)){
						System.out.println("\n"+questao.getQuestao());
						List<String> alternativas = questao.getAltenativas();
						for(String a: alternativas){
							System.out.println(a);
						}
					}else{
						System.out.println("\n"+questao.getNumQuestao()+" "+questao.getQuestao());
					}
				} catch (QuestaoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}	
			}
		});
		botao12.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("Digite o Nome do Exercicio: ");
				String matricula = JOptionPane.showInputDialog("Digite a Matricula do Aluno: ");
				try {
					String feedback = sistema.enviarFeedbackParaAlunos(nome, matricula);
					JOptionPane.showMessageDialog(null,feedback);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}				
			}			
		});	
		botao13.addActionListener(new ActionListener (){
		public void actionPerformed(ActionEvent arg0) {
			String nomeExercicio = JOptionPane.showInputDialog("Digite o Nome do Exercicio: ");
			try {
				String feedback = sistema.enviarFeedbackParaProfessor(nomeExercicio);
				JOptionPane.showMessageDialog(null,feedback);
			} catch (ExercicioInexistenteException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
		});
		botao14.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Informe o Nome do Exercicio: ");
				Exercicio e = new Exercicio(nomeExercicio);				
				String quantQuestaoString = JOptionPane.showInputDialog(null,"Digite a Quantidade de Questão: ");
				int quantQuestao = Integer.parseInt(quantQuestaoString);			
				for(int i=0; i<quantQuestao; i++){
					String numString = JOptionPane.showInputDialog(null, "Escolha um Tipo de Questão Associando um Numero: \n1 Questão V ou F\n2 Questão Dissertativa\n3 Questão Multipla Escolha");
					int num = Integer.parseInt(numString);
					if(num == 1){
						int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Questão: "));
						String questao = JOptionPane.showInputDialog(null,"Digite a Questão: ");
						String resposta = JOptionPane.showInputDialog(null,"Forneça a Resposta Correta: ");
						e.cadastrarQuestao(numero, questao, resposta, TipoQuestao.QUESTAO_V_OU_F);
					}else if(num == 2){
						int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Questão: "));
						String questao = JOptionPane.showInputDialog(null,"Digite a Questão: ");
						String resposta2 = JOptionPane.showInputDialog(null,"Forneça a Resposta Correta: ");
						e.cadastrarQuestao(numero, questao, resposta2, TipoQuestao.QUESTAO_DISSERTATIVA);
					}else if(num == 3){
						int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Questão: "));
						String questao = JOptionPane.showInputDialog(null,"Digite a Questão: ");
						List<String> alternativas = new ArrayList<String>();
						int quantAlternativas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a Quantidade de Alternativas: "));
						for(int k=0; k<quantAlternativas; k++){
							String r = JOptionPane.showInputDialog(null,"Digite a Alternativa: ");
							alternativas.add(r);
						}
						String resposta3 = JOptionPane.showInputDialog(null,"Forneça a Resposta Correta: ");
						e.cadastrarQuestaoMultiplaEscolha(numero, questao, alternativas, resposta3, TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA);
					}else{
						JOptionPane.showMessageDialog(null,"Tipo Questão Invalido!");
					}
				}
				sistema.cadastrarExercicio(e);
				sistema.sairDoSistema();
			}			
		});
		botao15.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String matriculaProf = JOptionPane.showInputDialog(null,"Digite a Matricula do Professor: "); 
				try {
					sistema.removeProfessor(matriculaProf);
					sistema.sairDoSistema();
				} catch (ProfessorInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		botao16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String matricula = JOptionPane.showInputDialog(null,"Digite a Matricula do Aluno: ");
				try {
					sistema.removeAluno(matricula);
					sistema.sairDoSistema();
				} catch (AlunoInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}				
			}
		});
		botao17.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				try {
					sistema.removeExercico(nomeExercicio);
					sistema.sairDoSistema();
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		botao18.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				List<Professor> professores = sistema.obterListaDeProfessores();
				for(Professor p: professores){
					JOptionPane.showMessageDialog(null,p.getNome()+"\n");
				}
			}
		});
		botao19.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				Collection<Aluno> alunos = sistema.obterListaDeAlunos();
				for(Aluno a: alunos){
					JOptionPane.showMessageDialog(null,a.getNome()+"\n");
				}
			}
		});
	}
}
