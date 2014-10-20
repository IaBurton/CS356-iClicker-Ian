package iClicker;

import java.util.Random;

public class SingleChoice extends Question {
	
	private boolean trueFalse;

	public SingleChoice(String question, boolean answer) {
		super(question);
		this.trueFalse = answer;
		this.answers = new String[2];
		this.answerIndex = new int[1];
	}

	@Override
	public void setUpAnswers() {
		Random rand = new Random();
		int tmp = rand.nextInt(2);
		
		answerIndex[0] = tmp;
		answers[tmp] = (tmp+1) + ". " + trueFalse;
		
		if(tmp == 1)
			answers[0] = "1. " + !trueFalse;
		else
			answers[1] = "2. " + !trueFalse;
	}
}
