package it.v1nc3nz0.musimathics.automation.entity.actions;

import java.util.concurrent.ThreadLocalRandom;

import it.v1nc3nz0.musimathics.api.automation.RunActionEntity;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class StepChangeActionEntity extends RunActionEntity
{

	public enum Mode
	{
		DOWN,UP,
		RANDOM
		{
			@Override
			public int between(int min,int max)
			{
				return ThreadLocalRandom.current().nextInt(min, max+1);
			}
		};
		
		public int between(int min, int max)
		{
			return -1;
		}
	}
	
	@Setter
	private int step;
	private Mode mode;
	
	@Override
	public void run()
	{
		if(mode == Mode.RANDOM)
			step = Mode.RANDOM.between(2, 3);
		
		if(mode == Mode.DOWN && step > 1) step--;
		
		if(mode == Mode.UP && step < 3) step++;
		
	}
	
	public int value(int actual_step)
	{
		setStep(actual_step);
		run();
		return step;
	}

}
