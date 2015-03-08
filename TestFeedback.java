package br.com.ufpb.projetopoo;

import java.io.IOException;

public class TestFeedback {

	public static void main(String[] args) throws ExercicioInexistenteException {
		GerenteDeExercicio sistema = new GerenteDeExercicio();
		GerenteDeFeedback feedback = new GerenteDeFeedback();
		Aluno a = new Aluno("fernando", "99");
		Professor p = new Professor("Diogo", "03");
		Exercicio exer = new Exercicio();
		
		
		exer.setNomeExercicio("poo");
	/*	exer.cadastrarQuestao(1, "Libras é uma lingua de sinais V ou F?", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarQuestao(2, "Alta coesão e baixo acoplamento é um bom design para um projeto V ou F?", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarRespostaDeQuestao(1, "v", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarRespostaDeQuestao(2, "v", TipoQuestao.QUESTAO_V_OU_F);
		
		exer.cadastrarQuestao(3, "Quais os tipos primitivos na liguagem de programação Java?", TipoQuestao.QUESTAO_DISSERTATIVA);
		exer.cadastrarRespostaDeQuestao(3, "byte, short, int, long, float, double, char e boolean", TipoQuestao.QUESTAO_DISSERTATIVA);
		
		feedback.EnviarFeedback(exer.getNomeExercicio(), p.getMatricula(),"A resposta deverá ter no mínimo esses cinco tipos: int, double, boolean, short e long");
		//Na linha acima será enviado um feedback do professor para o aluno.
		
		
		//A baixo será enviado um feedback do aluno para o professor.
		feedback.EnviarFeedback(exer.getNomeExercicio(), a.getMatricula(), "Professor, eu só consegui lembrar desses três tipos: boolean, short e long");
		
		CadastroDeRespostaDoAluno respostaAluno = new CadastroDeRespostaDoAluno();
		respostaAluno.setAluno(a);
		respostaAluno.cadastrarRespostaDeQuestao(1, "v", TipoQuestao.QUESTAO_V_OU_F);
		respostaAluno.cadastrarRespostaDeQuestao(2, "v", TipoQuestao.QUESTAO_V_OU_F);
		
		exer.adicionaCadastroDeRespostaDoAluno(respostaAluno);
		sistema.cadastrarExercicio(exer);
		
		
		try {
			sistema.gravarQuestoesEmArquivo("Questoes.txt");
		} catch (IOException e1) {
			e1.getMessage();
		}
		
		
		
		try {
			System.out.println("Feedback do professor: "+feedback.PesquisaFeedback(exer.getNomeExercicio(), p.getMatricula()));
			System.out.println("Feedback do aluno: "+feedback.PesquisaFeedback(exer.getNomeExercicio(), a.getMatricula()));
		} catch (FeedbackInexistenteException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		*/
	}
}
