package br.com.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GUI extends JFrame{
	private ExercicioFacade sistema;
	JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7, 
	        botao8, botao9, botao10, botao11, botao12, botao13, botao14;
	public static void main(String[] args) {
		GUI janela = new GUI();
		janela.setVisible(true);
	}
	public GUI(){
		super("Sistema");	
		this.sistema=new ExercicioFacade();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(13,6));
		
		botao1=new JButton("Cadastrar Aluno"); 
		c2.add(botao1);
		botao2=new JButton("Cadastrar Professor");
		c2.add(botao2);
		botao3=new JButton("Cadastrar Resposta de Aluno");
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
		
		c.setLayout(new BorderLayout(5,5));
		botao14 = new JButton("Cadastrar Exercicio");
		c.add(botao14);
		c.add(BorderLayout.BEFORE_LINE_BEGINS, c2);//EAST
		
		this.setSize(450,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(150, 150);
	
		botao4.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricula = JOptionPane.showInputDialog("Digite sua matricula: ");
				try {
					Professor p = sistema.pesquisaProfessorPelaMatricula(matricula);
					JOptionPane.showMessageDialog(botao4, "O professor pesquisado(a) é: "+p.getNome());
				} catch (ProfessorInexistenteException e1) {
					JOptionPane.showMessageDialog(null,"Professor não encontrado com a matricula: \n> "+matricula);
				}	
			}
			});
		botao2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite seu nome: ");
				String matricula = JOptionPane.showInputDialog("Digite sua matricula: ");
				try {
					sistema.cadastrarProfessor(nome, matricula);
				} catch (ProfessorJaExisteException e1) {
					JOptionPane.showMessageDialog(null,"Já existe um professor com esta matricula: \n> "+matricula);
				}			
			}
			});
		botao14.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String temaExercicio = JOptionPane.showInputDialog(null,"Forneça um nome para o exercicio que deseja cadastrar:");
				int quantQuestao = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneça a quantidade de questão que deseja cadastrar:"));
				Exercicio e = new Exercicio();
				e.setNomeExercicio(temaExercicio);
				for(int i=0; i<quantQuestao; i++){
					int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um tipo de questão associando um numero: \n1 QuestãoVouF\n2 Questão Dissertativa\n3 Questão Multipla Escolha"));
					int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneça o numero da pergunda:"));
					String questao = JOptionPane.showInputDialog(null,"Forneça a pergunda:");
					String resposta = JOptionPane.showInputDialog(null,"Forneça a resposta:");
					if(num == 1){
						e.cadastrarQuestao(numero, questao, resposta, TipoQuestao.QUESTAO_V_OU_F);
					}else if(num == 2){
						e.cadastrarQuestao(numero, questao, resposta, TipoQuestao.QUESTAO_DISSERTATIVA);
					}else{
						e.cadastrarQuestao(numero, questao, resposta, TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA);
					}
				}
				sistema.cadastrarExercicio(e);				
			}	
		});
		botao6.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Forneça o nome do exercicio para realizar a pesquisa:");
				Exercicio e;
				try {
					e = sistema.pesquisarExercicio(nomeExercicio);
					for(Questao y : e.getQuestoes()){
						JOptionPane.showMessageDialog(null,y.toString());
					}
				} catch (ExercicioInexistenteException e1) {
					System.err.println("não deve lança essa exceção");
				}
			}
		});	
	}
}

//
//botao3.addActionListener(new ActionListener (){
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		Exercicio exercicio;
//		try {
//			exercicio = sistema.pesquisarExercicio(JOptionPane.showInputDialog("Digite seu nome do exercicio: "));
//			CadastroDeRespostaDoAluno r = new CadastroDeRespostaDoAluno();
//			Aluno a = new Aluno();
//			a.setNome(JOptionPane.showInputDialog("Digite seu nome: "));
//			a.setMatricula(JOptionPane.showInputDialog("Digite sua matricula: "));
//			r.setAluno(a);
//			
//			int quantQuestao = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneça a quantidade de questão que deseja cadastrar:"));
//			for(int i=0; i<quantQuestao; i++){
//				int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha um tipo de questão associando um numero: \n1 QuestãoVouF\n2 Questão Dissertativa\n3 Questão Multipla Escolha"));
//				int numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneça o numero da pergunda:"));
//				String resposta = JOptionPane.showInputDialog(null,"Forneça a resposta:");
//				if(num == 1){
//				    r.cadastrarRespostaDeQuestao(numero, resposta, TipoQuestao.QUESTAO_V_OU_F);
//				}else if(num == 2){
//					r.cadastrarRespostaDeQuestao(numero, resposta, TipoQuestao.QUESTAO_V_OU_F);
//				}else{
//					r.cadastrarRespostaDeQuestao(numero, resposta, TipoQuestao.QUESTAO_V_OU_F);
//				}
//			}
//			exercicio.adicionaCadastroDeRespostaDoAluno(r);
//			 sistema.cadastrarExercicio(exercicio);
//		} catch (HeadlessException e) {
//			e.printStackTrace();
//		} catch (ExercicioInexistenteException e) {
//			e.printStackTrace();
//		}
//
//	}
//});
//botao10.addActionListener(new ActionListener (){
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		String nomeExercicio = JOptionPane.showInputDialog(null, "digite o nome do exercicio");
//		String matriculaAluno = JOptionPane.showInputDialog(null, "digite sua matricula");
//		boolean b;
//		try {
//			b = sistema.corrigirExercicio(nomeExercicio, matriculaAluno);
//			JOptionPane.showMessageDialog(null, b);
//		} catch (ExercicioInexistenteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//});