package iClicker;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ian Burton
 *
 */
public class Student {
	//Student class with UniqueID string and the ability to vote
	private final String ID;

	public Student(String UniqueID)
	{
		ID = UniqueID;
	}
	
	public String getID()
	{//getter for ID
		return ID;
	}
	
	public String toString()
	{//redundant with respect to getID(), added just in case anyways
		return ID;
	}
	
	public int[] vote(int length)
	{//Randomly select how many answers we're going to pick, since multiplechoice can have multiple answers
	 //then randomly select which indexes we think are the right answers and return this array
	 //part of the code is similar to the generateQuestions method in SimulationDriver for multiplechoice
		Random rand = new Random();
		//makes sure we can pick only one answer for singlechoice, and correctly ranges for multiplechoice
		int tmp = rand.nextInt(length - 1) + 1;
		int[] answersIndex = new int[tmp];
		ArrayList<Integer> alreadyAdded = new ArrayList<Integer>(tmp);
		int ansInd = -1;
		
		for(int i = 0; i < tmp; i++)
			answersIndex[i] = -1;
		
		for(int i = 0; i < tmp; i++)
		{	
			do { ansInd = rand.nextInt(length); }
			while(alreadyAdded.contains(ansInd));
			
			alreadyAdded.add(ansInd);
			answersIndex[i] = ansInd;
		}
		
		return answersIndex;
	}//this entire method would be different if it were to be implemented in a webserver/app
	 //since we wouldn't be generating answers randomly. Only it's implementation should change
	 //nothing else should break or need changing
}
