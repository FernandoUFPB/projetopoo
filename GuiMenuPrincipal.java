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
public class GuiMenuPrincipal extends JFrame{
	private JButton botaoCadastrar, botaoPesquisar, botaoRemover, obterListas, botaoFeedback, botaoSair;
	
	public GuiMenuPrincipal(){
		super("Sistema");	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(6,1));
		
		botaoCadastrar=new JButton("Cadastrar"); 
		c2.add(botaoCadastrar);
		botaoPesquisar=new JButton("Pesquisar");
		c2.add(botaoPesquisar);
		botaoRemover = new JButton("Remover");
		c2.add(botaoRemover);
		obterListas = new JButton("Obter listas");
		c2.add(obterListas);
		botaoFeedback = new JButton("Feedback");
		c2.add(botaoFeedback);
		botaoSair = new JButton("Sair");
		c2.add(botaoSair);
		
		
		c.add(BorderLayout.CENTER, c2);
		
		this.setSize(250,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(350, 150);
	
		botaoCadastrar.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiCadastrar cadastramento = new GuiCadastrar();
				cadastramento.setVisible(true);
				
			}
		});
		botaoPesquisar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiPesquisar pesquisar = new GuiPesquisar();
				pesquisar.setVisible(true);
			}
		});
		botaoRemover.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiRemover remover = new GuiRemover();
				remover.setVisible(true);
				
			}
		});
		this.obterListas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiListar listar = new GuiListar();
				listar.setVisible(true);
				
			}
			
		});
		this.botaoFeedback.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiFeedback feedback = new GuiFeedback();
				feedback.setVisible(true);
				
			}
			
		});
		
		this.botaoSair.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoSair.setVisible(true);
				System.exit(0);
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		GuiMenuPrincipal gui = new GuiMenuPrincipal();
		gui.setVisible(true);
		


	}

}

