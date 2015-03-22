package br.com.ufpb.projetopoo;

import br.com.ufpb.projetopoo.Exercicio;
import br.com.ufpb.projetopoo.ExercicioInexistenteException;
import br.com.ufpb.projetopoo.RespostaDoExercicio;
import br.com.ufpb.projetopoo.TipoQuestao;

public class AlunoInexistenteException extends Exception{
	public AlunoInexistenteException(String mensagem){
		super(mensagem);
	}
}
//public String corrigirExercicio(String nomeExercicio, String matriculaAluno) 
//		throws ExercicioInexistenteException{
//	Exercicio e = this.pesquisarExercicio(nomeExercicio);
//	String txt = "\n";
//    for(RespostaDoExercicio r: this.respostaDoExercicio){
//        if(r.getAluno().getMatricula().equals(matriculaAluno)){
//        	txt += "Resposta do(a) aluno(a): "+r.getAluno().toString()+"\n";
//    	    for(int i=0; i < e.getQuestoes().size(); i++){
//    	    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
//    	    		txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta para essa questão Dissertativa foi:  "+r.getResposta().get(i).getResposta()+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
//    	    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
//    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
//    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta CORRETA";
//    	    		}else{
//    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão V ou F esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
//    	    		}
//    	    	}else{
//    	    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
//    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta CORRETA";
//    	    		}else{
//    	    			txt += "\n"+r.getResposta().get(i).getNumResposta()+": "+"Resposta da questão Multipla Escolha esta INCORRETA"+", A resposta que o professor deu para essa questão foi: "+e.getQuestoes().get(i).getResposta();
//    	    		}
//    	    	}			    
//		    }
//        }
//    }
//    return txt;
//}
