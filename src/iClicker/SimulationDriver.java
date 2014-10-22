package iClicker;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ian Burton
 *
 */
public class SimulationDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Question[] questions = generateQuestions(5);
		Student[] students = new Student[30];
		IClickerService iClicker;
		
		for(int i = 0; i < students.length; i++)
			students[i] = new Student(i + "");
		
		for(int i = 0; i < questions.length; i++)
		{
			iClicker = new IClickerService(questions[i]);
			
			System.out.println(questions[i]);
			System.out.println();
			
			System.out.println("Student 0");
			iClicker.takeVote(students[0]);//arbitrary student voting
			iClicker.printStats();//printStats to show initial value
			System.out.println();
			
			System.out.println("Student 0");
			iClicker.takeVote(students[0]);//do this again to show value for same student voting can change
			iClicker.printStats();
			System.out.println();
			
			for(int n = 1; n < students.length; n++)
				iClicker.takeVote(students[n]);//take the rest of the students votes
			
			iClicker.printStats();
			System.out.println();
			System.out.println(questions[i].printCorrectAnswers() + "\n");//show correct answers
			System.out.println();
		}

	}

	private static Question[] generateQuestions(int n)
	{
		Question[] questions = new Question[n];
		Random rand = new Random();
		
		for(int i = 0; i < n; i++)
		{
			if(rand.nextBoolean())//MultipleChoice
			{
				//int tmp = rand.nextInt((n-2)) + 2; didnt want to generate large number of answers for this
				int tmp = rand.nextInt(5) + 2;//range from 2-6
				
				String[] answers = new String[tmp];
				
				for(int j = 0; j < tmp; j++)
				{
					answers[j] = "Answer" + j;
				}
				
				tmp = rand.nextInt(tmp) + 1;//range 1-5
				int[] answersIndex = new int[tmp];
				ArrayList<Integer> alreadyAdded = new ArrayList<Integer>(tmp);
				int ansInd = -1;
				
				for(int j = 0; j < tmp; j++)
					answersIndex[j] = -1;
				
				for(int j = 0; j < tmp; j++)
				{	
					do { ansInd = rand.nextInt(answers.length); }
					while(alreadyAdded.contains(ansInd));
					
					alreadyAdded.add(ansInd);
					answersIndex[j] = ansInd;
				}
				
				try {
					questions[i] = new MultipleChoice("Question " + (i+1) + ".", answers, answersIndex);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else//SingleChoice
			{
				questions[i] = new SingleChoice("Question " + i + ".", rand.nextBoolean());
			}
			
			//spent 10 minutes wondering why my questions were returning null, turns out I forgot to call setUpAnswers here
			questions[i].setUpAnswers();
		}
		
		return questions;
	}
	
}
