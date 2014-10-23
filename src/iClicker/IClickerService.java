package iClicker;

import java.util.HashMap;

/**
 * @author Ian Burton
 *
 */
public class IClickerService {
	//simple class that handles votes and prints statistics
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
	}//an interface for canVote would have been best
	
	public void printStats()
	{//generate some temp vars
		String [] answers = question.getAnswers();
		int[] answerCount = new int[answers.length];
		for(int i = 0; i < answerCount.length; i++)
			answerCount[i] = 0;
		
		//several nested for loops, must be better way of doing this
		for(int[] answerIndexStudent : answerHash.values())
		{//get all value/voting arrays
			for(int i = 0; i < answerCount.length; i++)
			{//for how many answers in the question
				for(int n = 0; n < answerIndexStudent.length; n++)
				{//iterate through what was voted on and increment the counter
					if(i == answerIndexStudent[n])
						answerCount[i]++;
				}
			}
		}
		
		for(int i = 0; i < answerCount.length; i++)
			System.out.println(answers[i] + " : " + answerCount[i]);
	}
}
