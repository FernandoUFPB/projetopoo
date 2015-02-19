package br.com.ufpb.projetopoo;

public class Tes {

	public static void main(String[] args) throws ExercicioInexistenteException {
		ExercicioFacade sistema = new ExercicioFacade();
		
		Exercicio exer = new Exercicio();
		exer.setNomeExercicio("poo");
		exer.cadastrarQuestao(1, "Libras é uma lingua de sinais V ou F?", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarQuestao(2, "Alta coesão e baixo acoplamento é um bom design para um projeto V ou F?", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarRespostaDeQuestao(1, "v", TipoQuestao.QUESTAO_V_OU_F);
		exer.cadastrarRespostaDeQuestao(2, "v", TipoQuestao.QUESTAO_V_OU_F);
	
		exer.cadastrarQuestao(3, "Quais os tipos primitivos na liguagem de programação Java?", TipoQuestao.QUESTAO_DISSERTATIVA);
		exer.cadastrarRespostaDeQuestao(3, "byte, short, int, long, float, double, char e boolean", TipoQuestao.QUESTAO_DISSERTATIVA);
		
		CadastroDeRespostaDoAluno respostaAluno = new CadastroDeRespostaDoAluno();
		Aluno a = new Aluno("fernando", "99");
		respostaAluno.setAluno(a);
		respostaAluno.cadastrarRespostaDeQuestao(1, "v", TipoQuestao.QUESTAO_V_OU_F);
		respostaAluno.cadastrarRespostaDeQuestao(2, "v", TipoQuestao.QUESTAO_V_OU_F);
		
		exer.adicionaCadastroDeRespostaDoAluno(respostaAluno);
		sistema.cadastrarExercicio(exer);
	
		boolean cc = sistema.corrigirExercicio("poo", "99");
		System.out.println(cc);	
	}
}
