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

public class GuiFeedback extends JFrame{
	private JButton feedbackParaProf, feedbackParaAluno;
	
	public GuiFeedback() {
		super("Feedback");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(2,1));
		
		feedbackParaProf = new JButton("Enviar feedback para professor");
		c2.add(feedbackParaProf);
		feedbackParaAluno = new JButton("Enviar feedback para alunos");
		c2.add(feedbackParaAluno);
		
		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(300,300);
		this.setResizable(false);
		this.setLocation(350, 350);
		
		
		feedbackParaProf.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nomeExercicio = JOptionPane.showInputDialog("Digite o Nome do Exercicio: ");
				try {
					String feedback = GuiCadastrar.fachada.enviarFeedbackParaProfessor(nomeExercicio);
					JOptionPane.showMessageDialog(null,feedback);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
			});
		feedbackParaAluno.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("Digite o Nome do Exercicio: ");
				String matricula = JOptionPane.showInputDialog("Digite a Matricula do Aluno: ");
				try {
					String feedback = GuiCadastrar.fachada.enviarFeedbackParaAlunos(nome, matricula);
					JOptionPane.showMessageDialog(null,feedback);
				} catch (ExercicioInexistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}				
			}			
		});	
		
	}

}
