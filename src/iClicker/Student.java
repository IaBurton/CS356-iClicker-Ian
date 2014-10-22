package iClicker;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ian Burton
 *
 */
public class Student {
	
	private final String ID;

	public Student(String UniqueID)
	{
		ID = UniqueID;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String toString()
	{
		return ID;
	}
	
	public int[] vote(int length)
	{
		Random rand = new Random();
		int tmp = rand.nextInt(length) + 1;
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
	}
}
