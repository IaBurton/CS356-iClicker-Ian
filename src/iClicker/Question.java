package iClicker;

/**
 * @author Ian Burton
 *
 */
public abstract class Question {
	//abstract question class, question and answers attributes can technically be anything
	//but answerIndex will likely always be an int[] since it is simply a mapping of answer indexes
	protected String question;
	protected String[] answers;
	protected int[] answerIndex;
	
	public Question(String question)
	{
		this.question = question;
	}
	
	//leave it up to extended classes to handle their style of answers
	public abstract void setUpAnswers();
	
	public int[] getAnswersIndex()
	{
		return answerIndex;
	}
	
	public String[] getAnswers()
	{
		return answers;
	}
	
	public String printAllAnswers() 
	{//a sort of toString method for just answers
		String tmp = "";
		
		for(int i = 0; i < answers.length; i++)
			tmp += answers[i] + "\n";
		
		return tmp;
	}
	
	public String printCorrectAnswers()
	{//like printAllAnswers, acts like a toString method for just correct Answers
		String tmp = "";
		
		for(int i = 0; i < answerIndex.length; i++)
				tmp += answers[answerIndex[i]] + " is correct.\n";
		
		return tmp;
	}
	
	public String toString()
	{//return the actual question
		return question;
	}
}
