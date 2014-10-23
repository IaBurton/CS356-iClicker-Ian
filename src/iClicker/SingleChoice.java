package iClicker;

import java.util.Random;

public class SingleChoice extends Question {
	//Extended question SingleChoice with correct answer boolean
	//SingleChoice has inherently fewer questions and answers so we simply need the correct
	//boolean value and we can handle the rest in the setUpAnswers method
	private boolean trueFalse;

	public SingleChoice(String question, boolean answer) {
		super(question);
		this.trueFalse = answer;
		super.answers = new String[2];//can only have true or false as answers
		super.answerIndex = new int[1];//can only have one correct answer
	}

	@Override
	public void setUpAnswers() {
		//randomly select where correct boolean answer will be placed in array
		//then set other index to opposite boolean
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
