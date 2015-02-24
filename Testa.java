package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
public class Testa {
	public static void main(String[] args) {
		ExercicioFacade g = new ExercicioFacade();
		Exercicio e = new Exercicio();
		System.out.println("ok");
	}
}
//		try {
//			e.cadastrarQuestaoDeVouF(1, "prolog é uma linguagem declarativa V ou F?", TipoQuestao.QUESTAO_V_OU_F);
//			e.cadastrarQuestaoDeVouF(2, "java é uma linguagem de oo V ou F?", TipoQuestao.QUESTAO_V_OU_F);
//			g.cadastrarExercicio(e);
//			Exercicio exercicio = g.pesquisarExercicio(10);
//			
//			Aluno a = new Aluno("fernando", "111");
//			a.cadastrarRespostaDeQuestaoVouF(1, "V", TipoQuestao.QUESTAO_V_OU_F);
//			a.cadastrarRespostaDeQuestaoVouF(2, "V", TipoQuestao.QUESTAO_V_OU_F);
//			exercicio.cadastrarAluno(a);
//			
//			Aluno aa = new Aluno("TOMAZ", "222");
//			aa.cadastrarRespostaDeQuestaoVouF(1, "F", TipoQuestao.QUESTAO_V_OU_F);
//			aa.cadastrarRespostaDeQuestaoVouF(2, "V", TipoQuestao.QUESTAO_V_OU_F);
//			exercicio.cadastrarAluno(aa);
//			
//			List<Exercicio> ex = g.listarExercíciosCadastrados();
//			for(Exercicio i: ex){
//				if(i.getNumExercicio() == 10){
//					Aluno x = i.pesquisaAluno("222");
//					List<Questao> q = x.getQuestoes();
//					for(Questao qq : q){
//						System.out.println(qq.getResposta());
//					}
//				}
//			}
//		}catch(ExercicioInexistenteException e1) {
//			e1.printStackTrace();
//		}catch(AlunoJaExisteException e3){
//			System.out.println(e3.getMessage());
//		}catch (QuestaoJaExisteException e1) {
//			e1.printStackTrace();
//		}
//		
//	}
//}
