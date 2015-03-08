package br.com.ufpb.projetopoo;

public class Tes {

	public static void main(String [] args) throws ExercicioInexistenteException {
		
		ExercicioFacade sistema = new ExercicioFacade();
		
		Exercicio e = new Exercicio();
		Professor p = new Professor("Ayla", "133");
		e.setNomeExercicio("poo");
		e.setProfessor(p);
		e.cadastrarQuestao(1, "Libras é uma lingua de sinais ?","sim", TipoQuestao.QUESTAO_DISSERTATIVA);
		e.cadastrarQuestao(2, "Alta coesão e baixo acoplamento é um bom design para um projeto V ou F?", "v", TipoQuestao.QUESTAO_V_OU_F);
		e.cadastrarQuestao(3, "Quais são os tipo primitivos de java \na) int \nb) String \nc) Integer", "a", TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA);
		e.cadastrarQuestao(4, "O conjunto vazio esta contido em todos os conjuntos V ou F?","v", TipoQuestao.QUESTAO_V_OU_F);
		
		sistema.cadastrarExercicio(e);
		
		Exercicio exercicio = sistema.pesquisarExercicio("poo");
		System.out.println("exercico do(a) professor(a) :"+exercicio.getProfessor().getNome());
		for(Questao q : exercicio.getQuestoes()){
			System.out.println(q.toString()+"\n");
		}
		
		RespostaDoExercicio r = new RespostaDoExercicio();
		Aluno a = new Aluno("fernando", "123");
		r.setAluno(a);
		r.cadastrarRespostaDeQuestao(1, "nao", TipoQuestao.QUESTAO_DISSERTATIVA);
		r.cadastrarRespostaDeQuestao(2, "v", TipoQuestao.QUESTAO_V_OU_F);
		r.cadastrarRespostaDeQuestao(3, "a", TipoQuestao.QUESTAO_MULTIPLA_ESCOLHA);
		r.cadastrarRespostaDeQuestao(4, "f", TipoQuestao.QUESTAO_V_OU_F);
	
		sistema.cadastrarRespostaDoExercicio(r);
	
		String resp = sistema.corrigirExercicio("poo", "123");
		System.out.println(resp);
	}
}
