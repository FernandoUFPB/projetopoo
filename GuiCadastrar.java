package br.com.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiCadastrar extends JFrame{
	private JButton botaoAluno, botaoProfessor, botaoExercicio, botaoRespostaExercicio, botaoAtualizarExercicio;
	static ExercicioFacade fachada;
	
	public GuiCadastrar(){
		super("Cadastrar");
		this.fachada = new ExercicioFacade();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(5,1));
		
		botaoAluno=new JButton("Cadastrar Aluno"); 
		c2.add(botaoAluno);
		botaoProfessor=new JButton("Cadastrar Professor");
		c2.add(botaoProfessor);
		botaoExercicio = new JButton("Cadastrar exercicio");
		c2.add(botaoExercicio);
		botaoRespostaExercicio = new JButton("Cadastrar resposta do exercicio");
		c2.add(botaoRespostaExercicio);
		botaoAtualizarExercicio = new JButton("Atualizar exercicio");
		c2.add(botaoAtualizarExercicio);
		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(250,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(200, 200);
		
		botaoAluno.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evento) {
				String nome = JOptionPane.showInputDialog("Digite seu nome");
				String matri = JOptionPane.showInputDialog("Digite sua matricula");
				try {
					fachada.cadastrarAluno(nome, matri);
				} catch (AlunoJaExisteException e) {
					JOptionPane.showMessageDialog(null, "ERROR "+e.getMessage());
				}
				
				
			}
		
		});
		
		botaoProfessor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("Digite seu nome");
				String matri = JOptionPane.showInputDialog("Digite sua matricula");
				try {
					fachada.cadastrarProfessor(nome, matri);
				} catch (ProfessorJaExisteException e) {
					JOptionPane.showMessageDialog(null, "ERROR "+e.getMessage());
				}
			}
			
		});
		botaoExercicio.addActionListener(new ActionListener (){
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
				fachada.cadastrarExercicio(e);				
			}			
		});
		this.botaoRespostaExercicio.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nomeExercicio = JOptionPane.showInputDialog("Digite o Nome do Exercicio que Deseja Cadastrar as Respostas: ");
					Exercicio exer = fachada.pesquisarExercicio(nomeExercicio);
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
					fachada.cadastrarRespostaDoExercicio(r);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				} 	
			}
		});
		botaoAtualizarExercicio.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio =JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String numQuestaoString = JOptionPane.showInputDialog(null,"Digite o Numero da Questão: ");
				int numQuestao = Integer.parseInt(numQuestaoString);
				String questao = JOptionPane.showInputDialog(null,"Digite a Nova Questão: ");
				try {
					GuiCadastrar.fachada.atualizarExercício(nomeExercicio, numQuestao, questao);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}	
			}
		});
	
	}
}
