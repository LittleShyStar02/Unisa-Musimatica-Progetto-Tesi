package it.v1nc3nz0.musimathics.automation.utility;

import it.v1nc3nz0.musimathics.data.musicfiles.entity.Metric;
import it.v1nc3nz0.musimathics.utility.NumberGen;

public class DurationUtils
{

	public static int getBarNotes(Metric metric)
	{
		int num = metric.getNumerator();
		int den = metric.getDenominator();
		
		if(den == 4 && (num == 4 || num == 3)) 
			return NumberGen.duplicate(num);
		
		if(den == 8 && num == 3)
			return NumberGen.duplicate(num);
		
		return num;
		
	}
	
}
