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
		//driver for simulation
		//any number of questions and students can be created, 5 / 30 simply for demonstration
		//simply change the two numbers below to see more output, or run the program multiple times to see
		//the variety of questions/answers that can be generated
		Question[] questions = generateQuestions(5);
		Student[] students = new Student[30];
		IClickerService iClicker;
		
		//initialize students array, loop with strings for ease of demonstration here
		for(int i = 0; i < students.length; i++)
			students[i] = new Student(i + "");
		
		for(int i = 0; i < questions.length; i++)
		{//for loop to run through printing of stats and voting on questions
			iClicker = new IClickerService(questions[i]);
			
			System.out.println("***********************************");
			System.out.println(questions[i]);
			System.out.println(questions[i].printAllAnswers());
			System.out.println();
			
			System.out.println("Student 0");
			iClicker.takeVote(students[0]);//arbitrary student voting
			iClicker.printStats();//printStats to show initial value
			System.out.println();
			
			System.out.println("Student 0");
			iClicker.takeVote(students[0]);//do this again to show value for same student voting can change
			iClicker.printStats();//though it is random so it may be the same
			System.out.println();
			
			for(int n = 1; n < students.length; n++)
				iClicker.takeVote(students[n]);//take the rest of the students votes
			
			iClicker.printStats();
			System.out.println();
			System.out.println(questions[i].printCorrectAnswers() + "\n");//show correct answers
		}

	}

	private static Question[] generateQuestions(int n)
	{//method for creating questions of random size (except for singlechoice) and random answer indexes
		Question[] questions = new Question[n];
		Random rand = new Random();
		
		for(int i = 0; i < n; i++)
		{
			if(rand.nextBoolean())//MultipleChoice
			{
				//int tmp = rand.nextInt((n-2)) + 2; didnt want to generate large number of answers for this
				//but can be anything up to 25, as the alphabet is indexed from 0-25, feel free to change this
				//and test how many answers MultipleChoice can have
				int tmp = rand.nextInt(5) + 2;//range from 2-6 for demonstration
				
				String[] answers = new String[tmp];
				
				for(int j = 0; j < tmp; j++)
				{//generic answers array, could be anything
					answers[j] = "Answer" + j;
				}
				
				tmp = rand.nextInt(tmp) + 1;//range 1-5
				int[] answersIndex = new int[tmp];
				ArrayList<Integer> alreadyAdded = new ArrayList<Integer>(tmp);
				int ansInd = -1;
				
				//initialize array
				for(int j = 0; j < tmp; j++)
					answersIndex[j] = -1;
				
				for(int j = 0; j < tmp; j++)
				{//keep looping until sufficient number of non-same answer indexes chosen
					do { ansInd = rand.nextInt(answers.length); }
					while(alreadyAdded.contains(ansInd));
					
					alreadyAdded.add(ansInd);
					answersIndex[j] = ansInd;
				}
				
				try {//since multiplechoice cant go beyond 26 answers, need try catch block
					questions[i] = new MultipleChoice("Question " + (i+1) + ".", answers, answersIndex);
				} catch (Exception e) { e.printStackTrace(); }
			}
			else//SingleChoice
			{
				questions[i] = new SingleChoice("Question " + (i+1) + ".", rand.nextBoolean());
			}
			
			//spent 10 minutes wondering why my questions were returning null, turns out I forgot to call setUpAnswers here
			questions[i].setUpAnswers();
		}
		
		return questions;
	}
	
}
