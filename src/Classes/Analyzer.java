package Classes;

import java.util.List;

/**
 * Classe com objetivo de calcular o FP(Falso Positivo) e FN(Falso Negativo)
 * FP = Spam mal identificados (mensagens válidas que foram identificadas como spam)
 * FN = Spam não identificados
 * 
 * @author Kevin Corrales nº 73529
 *
 */
public class Analyzer {
	
	/**
	 * Calcula o FP
	 * Primeiro percorre a lista do spam , depois percorre a lista de regras contidas em cada spam 
	 * e depois percorre a lista de regras para comparar cada valor da regra do spam com cada valor
	 * da regra da lista de regras, conta quantas regras em cada spam (inner_count) e se a contagem
	 * for igual que zero , ele conta que esse spam é FP
	 * 
	 * @param lista de spam
	 * @param lista de regras
	 * @return total de FP (inteiro)
	 */
	public int getFPcount(List<Email> spamList, List<Rule> rulesList ) {
		int fp_counter = 0;
		for(int x=0; x<spamList.size(); x++) {
			int totalWeight = 0;
			for(int y=0; y<spamList.get(x).getRules().size();y++) {
				String spamRule = spamList.get(x).getRules().get(y);
					for(int k=0; k<rulesList.size();k++) {
						Rule ruleItem = rulesList.get(k);
							if(spamRule.equals(ruleItem.getRule())) {
								totalWeight+= rulesList.get(k).getWeight();
							}
					}
			}
			if(totalWeight<5)
				fp_counter++;
		}
		return fp_counter;
	}
	
	/**
	 * Calcula o FN
	  * Primeiro percorre a lista do ham , depois percorre a lista de regras contidas em cada ham 
	 * e depois percorre a lista de regras para comparar cada valor da regra do ham com cada valor
	 * da regra da lista de regras, conta quantas regras em cada spam (inner_count) e se a contagem
	 * for igual que zero , ele conta que esse ham é FN
	 * 
	 * @param lista de e-mails
	 * @param lista de regras
	 * @return total de FN (inteiro)
	 */
	public int getFNcount(List<Email> emailList, List<Rule> rulesList) {
		int fn_counter = 0;
		for(int x=0; x<emailList.size(); x++) {
			int totalWeight = 0;
			for(int y=0; y<emailList.get(x).getRules().size();y++) {
				String spamRule = emailList.get(x).getRules().get(y);
					for(int k=0; k<rulesList.size();k++) {
						Rule ruleItem = rulesList.get(k);
						if(spamRule.equals(ruleItem.getRule())) {
							totalWeight+= rulesList.get(k).getWeight();
						}
					}
			}
			if(totalWeight>5)
				fn_counter++;
		}
		return fn_counter;
	}
	
	
	
	
	/**
	 * Calcula o FP em percentagem
	 * 
	 * @param lista de spam
	 * @param lista de regras
	 * @return total de FP (percentagem)
	 */
	public double getFPpercentage(List<Email> spamList, List<Rule> rulesList) {
		return (getFPcount(spamList,rulesList)*100)/spamList.size();
	}
	
	/**
	 * Calcula o FN em percentagem
	 * 
	 * @param lista de spam
	 * @param lista de regras
	 * @return total de FN (percentagem)
	 */
	public double getFNpercentage(List<Email> emailList, List<Rule> rulesList) {
		return (getFNcount(emailList,rulesList)*100)/emailList.size();

	}
	
	
	
}
