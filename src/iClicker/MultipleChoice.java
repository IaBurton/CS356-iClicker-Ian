package iClicker;

public class MultipleChoice extends Question {
	//Extended question MultipleChoice with final alphabet array for answers/range
	//MultipleChoice can have a wide range of question and answers
	//so practically it would need those given to it in an actual webserver/app implementation
	private final char[] ALPHA = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	public MultipleChoice(String question, String[] answers, int[] answerIndex) throws Exception {
		super(question);
		super.answers = answers;
		super.answerIndex = answerIndex;
		
		if(answers.length >= 26)//check we do not go beyond our alphabet array
			throw new Exception("Cannot have MultipleChoice question with more than 26 answers.");
	}

	@Override
	public void setUpAnswers() {
		for(int i = 0; i < answers.length; i++)
		{//Simply append char to beginning of answer
			answers[i] = ALPHA[i] + ". " + answers[i];
		}
	}
}
