package it.v1nc3nz0.musimathics;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGen
{

	public static int binary()
	{
		return NumberGen.number(0, 1);
	}
	
	public static int duplicate(int num)
	{
		return num * NumberGen.number(1, 2);
	}
	
	public static int number(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}
}
