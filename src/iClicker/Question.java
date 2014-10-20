package iClicker;

/**
 * @author Ian Burton
 *
 */
public abstract class Question {
	
	protected String question;
	protected String[] answers;
	protected int[] answerIndex;
	
	public Question(String question)
	{
		this.question = question;
	}
	
	public abstract void setUpAnswers();
	
	public int[] getAnswersIndex()
	{
		return answerIndex;
	}
	
	public String[] getAnswers()
	{
		return answers;
	}
	
	public String printAnswers() 
	{
		String tmp = "";
		
		for(int i = 0; i < answers.length; i++)
			tmp += answers[i] + "\n";
		
		return tmp;
	}
	
	public String toString()
	{
		return question;
	}
}
