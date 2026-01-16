package it.v1nc3nz0.musimathics;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGen
{

	public static int binary()
	{
		return ThreadLocalRandom.current().nextInt(0,2);
	}
	
}
