package Classes;

public class Rule {

	private String rule ;
	private int weight ;
	
	public Rule(String rule) {
		this.rule=rule;
		this.weight=0;
	}
	
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
