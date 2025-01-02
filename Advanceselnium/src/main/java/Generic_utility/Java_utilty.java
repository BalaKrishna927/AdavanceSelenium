package Generic_utility;

import java.util.Random;

public class Java_utilty {
	
	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author Balu
	 */

	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}


}
