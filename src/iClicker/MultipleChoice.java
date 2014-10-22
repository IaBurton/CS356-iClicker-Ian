package iClicker;

public class MultipleChoice extends Question {
	
	private char[] ALPHA = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	public MultipleChoice(String question, String[] answers, int[] answerIndex) throws Exception {
		super(question);
		super.answers = answers;
		super.answerIndex = answerIndex;
		
		if(answers.length >= 26)
			throw new Exception("Cannot have MultipleChoice question with more than 25 answers.");
	}

	@Override
	public void setUpAnswers() {
		for(int i = 0; i < answers.length; i++)
		{
			answers[i] = ALPHA[i] + ". " + answers[i];
		}
	}
}
