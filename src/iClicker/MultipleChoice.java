package iClicker;

public class MultipleChoice extends Question {
	
	private final char[] ALPHA = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	public MultipleChoice(String question, String[] answers, int[] answerIndex) {
		super(question);
		this.answers = answers;
		this.answerIndex = answerIndex;
	}

	@Override
	public void setUpAnswers() {
		for(int i = 0; i < answers.length; i++)
		{
			answers[i] = ALPHA[i] + ". " + answers[i];
		}
	}
}
