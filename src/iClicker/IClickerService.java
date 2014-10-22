package iClicker;

import java.util.HashMap;

/**
 * @author Ian Burton
 *
 */
public class IClickerService {
	
	private Question question;
	private HashMap<String, int[]> answerHash;

	public IClickerService(Question question)
	{
		this.question = question;
		answerHash = new HashMap<String, int[]>();
	}
	
	public void takeVote(Student s)
	{//debated about whether or not taking a string and int[] was better than Student object itself
		answerHash.put(s.getID(), s.vote(question.getAnswers().length));
	}
	
	public void printStats()
	{
		String [] answers = question.getAnswers();
		int[] answerCount = new int[answers.length];
		for(int i = 0; i < answerCount.length; i++)
			answerCount[i] = 0;
		
		for(int[] answerIndexStudent : answerHash.values())
		{
			for(int i = 0; i < answerCount.length; i++)
			{
				for(int n = 0; n < answerIndexStudent.length; n++)
				{
					if(i == answerIndexStudent[n])
						answerCount[i]++;
				}
			}
		}
		
		for(int i = 0; i < answerCount.length; i++)
			System.out.println(answers[i] + " : " + answerCount[i]);
	}
}
