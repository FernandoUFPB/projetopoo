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

public class GuiRemover extends JFrame{
	private JButton botaoAluno, botaoProfessor,botaoExercicio;
	
	public GuiRemover(){
		super("Remover");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(3,1));
		
		botaoAluno = new JButton("Remover aluno");
		c2.add(botaoAluno);
		botaoProfessor = new JButton("Remover professor");
		c2.add(botaoProfessor);
		botaoExercicio = new JButton("Remover Exercicio");
		c2.add(botaoExercicio);
		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(300,300);
		this.setResizable(false);
		this.setLocation(350, 350);
		this.botaoAluno.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String matricula = JOptionPane.showInputDialog("Digite a matricula:"); 
				try {
					GuiCadastrar.fachada.removeAluno(matricula);
				} catch (AlunoInexistenteException e) {
					JOptionPane.showMessageDialog(null,"Aluno não encontrado");
				}
				
			}
			
		});
		this.botaoProfessor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String matricula = JOptionPane.showInputDialog("Digite a matricula: ");
				try {
					GuiCadastrar.fachada.removeProfessor(matricula);
				} catch (ProfessorInexistenteException e) {
					JOptionPane.showMessageDialog(null,"Professor não encontrado");
				}
				
			}
			
		});
		botaoExercicio.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog(null,"Digite o Nome do Exercicio: ");
				try {
					GuiCadastrar.fachada.removeExercico(nomeExercicio);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
	}
}
