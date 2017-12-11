package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import Classes.Analyzer;
import Classes.FileReader;
import Classes.Rule;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {
	
	private Analyzer analyser = new Analyzer();
	private FileReader reader = new FileReader();

	  public AntiSpamFilterProblem() {
	    // 10 variables (anti-spam filter rules) by default 
	    this(335);
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }
	  
	  
	  public void evaluate(DoubleSolution solution){
	    double aux, xi, xj;
	    double[] fx = new double[getNumberOfObjectives()];
	    double[] x = new double[getNumberOfVariables()];
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      x[i] = solution.getVariableValue(i) ;
	    }
	    
	    /**
	  		 * 
	  		 * Feedback para o jMetal
	  		 */
	    System.out.println("its in");
	    List<Rule> ruleList = reader.getRulesFromFile("../rules.cf",x);
	    
	    solution.setObjective(0,  analyser.getFPcount(reader.getEmailsFromFile("../spam.log"), ruleList));
	    solution.setObjective(1, analyser.getFNcount(reader.getEmailsFromFile("../ham.log"), ruleList));
	  }
	}
