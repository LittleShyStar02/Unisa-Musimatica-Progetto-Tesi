package it.v1nc3nz0.musimathics.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ThreadLocalRandom;

import it.v1nc3nz0.musimathics.data.musicfiles.entity.Bar;

public class MusicGenerator
{
	
	public static void generate() throws Exception
	{
		String firstStep[] = {"GENERIC_CHANGE","NOTE DO4;q","NOTE MI4;q","NOTE LA4;q"};
		String secondStep[] = {"CHANGE_UP","CHANGE_DOWN","NOTE RE4;q","NOTE FA4;q"};
		String thirdStep[] = {"CHANGE_UP","CHANGE_DOWN","NOTE SOL4;q","NOTE SI4;q"};
		
		File file = new File("output.mf");
		if(file.exists()) file.delete();
 		if(!file.exists()) file.createNewFile();
 		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		int step = ThreadLocalRandom.current().nextInt(1, 4);
		int bar = 0;
		
		for(int x = 1; x < 101;x++)
		{
			int value = ThreadLocalRandom.current().nextInt(0,4);
			String action = "";
			
			if(step == 1) action = firstStep[value];
			if(step == 2) action = secondStep[value];
			if(step == 3) action = thirdStep[value];
			
			if(action.equals("GENERIC_CHANGE"))
			{
				int change = ThreadLocalRandom.current().nextInt(0,2);
				if(change == 0)
				{
					step = step+1;
					if(step == 4) step = 1;
				}
				if(change == 1)
				{
					step = step-1;
					if(step == 0) step = 3;
				}
			}
			else if(action.equals("CHANGE_UP"))
			{
				step = step+1;
				if(step == 4) step = 1;
			}
			else if(action.equals("CHANGE_DOWN"))
			{
				step = step-1;
				if(step == 0) step = 3;
			}
			else
			{
				writer.append(action);
				writer.newLine();
				bar++;
				
				if(bar != 0 && bar%4==0)
				{
					writer.append(Bar.word());
					writer.newLine();
				}
			}
		}
		
		writer.flush();
		writer.close();
		
	}
	
}
