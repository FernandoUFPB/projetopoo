package br.com.ufpb.projetopoo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiListar extends JFrame{
	private JButton listaExercicios, listarAlunos, listarProfessores;
	
	public GuiListar(){
		super("Listar");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(3,1));
		
		listaExercicios = new JButton("Listar exercicio");
		c2.add(listaExercicios);
		listarAlunos = new JButton("Listar alunos");
		c2.add(listarAlunos);
		listarProfessores = new JButton("Listar professores");
		c2.add(listarProfessores);
		
		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(300,300);
		this.setResizable(false);
		this.setLocation(350, 350);
		
		listaExercicios.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				List<Exercicio> exercicios = GuiCadastrar.fachada.listarExercíciosCadastrados();
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
		
		listarAlunos.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				Collection<Aluno> alunos = GuiCadastrar.fachada.obterListaDeAlunos();
				for(Aluno a: alunos){
					System.out.println(a.getNome()+"\n");
				}
			}
		});
		listarProfessores.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				List<Professor> professores = GuiCadastrar.fachada.obterListaDeProfessores();
				for(Professor p: professores){
					System.out.println(p.getNome()+"\n");
				}
			}
		});
	}
}
