package br.com.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiPesquisar extends JFrame{
	private JButton botaoAluno, botaoProfessor, botaoExercicio, botaoQuestao, botaoCorrigirExercicio, botaoSortearExercicio;

	
	public GuiPesquisar(){
		super("Pesquisar");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(6,1));
		
		botaoAluno=new JButton("Pesquisar Aluno"); 
		c2.add(botaoAluno);
		botaoProfessor=new JButton("Pesquisar Professor");
		c2.add(botaoProfessor);
		botaoExercicio=new JButton("Pesquisar Exercicio");
		c2.add(botaoExercicio);
		botaoQuestao = new JButton("Pesquisar questão do exercicio");
		c2.add(botaoQuestao);
		botaoCorrigirExercicio = new JButton("Corrigir exercicio");
		c2.add(botaoCorrigirExercicio);
		botaoSortearExercicio = new JButton("Sortear exercicio");
		c2.add(botaoSortearExercicio);

		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(300,300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(350, 350);
		botaoAluno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String matri = JOptionPane.showInputDialog("Digite sua matricula");
				try {
					String nome = GuiCadastrar.fachada.pesquisaAlunoPelaMatricula(matri).getNome();
					JOptionPane.showMessageDialog(null, "O aluno é: "+nome);
				} catch (AlunoInexistenteException e) {
					JOptionPane.showMessageDialog(null,"Aluno não encontrado");
				}
					
					
			}
			
		});
		
		botaoProfessor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String matri = JOptionPane.showInputDialog("Digite sua matricula");
				try {
					String nome = GuiCadastrar.fachada.pesquisaProfessorPelaMatricula(matri).getNome();
					JOptionPane.showMessageDialog(null, "O professor é: "+nome);
				} catch (ProfessorInexistenteException e) {
					JOptionPane.showMessageDialog(null,"Professor não encontrado");
				}
				
			}
			
		});
		botaoExercicio.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				try {
					Exercicio e = GuiCadastrar.fachada.pesquisarExercicio(nomeExercicio);
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
		botaoQuestao.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String numQuestaoString = JOptionPane.showInputDialog(null,"Digite o Numero da Questão: ");
				int numQuestao = Integer.parseInt(numQuestaoString);
				try {
					Questao questao = GuiCadastrar.fachada.pesquisaQuestaoDeExercicio(nomeExercicio, numQuestao);
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
		botaoCorrigirExercicio.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				String matriculaAluno = JOptionPane.showInputDialog(null,"Digite a Matricula do Aluno: ");
				try {
					int quantAcertos = GuiCadastrar.fachada.corrigirExercicio(nomeExercicio, matriculaAluno);				
					JOptionPane.showMessageDialog(null,"Total de Acertos "+quantAcertos);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				} 				
			}			
		});
		botaoSortearExercicio.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				Exercicio exercicio = GuiCadastrar.fachada.sortearExercício();
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
		
	}
	//TODO FALTA IMPLEMENTAR MAIS FUNÇÕES

}
