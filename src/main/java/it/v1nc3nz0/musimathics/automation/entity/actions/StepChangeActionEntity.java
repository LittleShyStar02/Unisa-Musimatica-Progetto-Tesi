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
		DOWN {
			@Override
            public int nextStep(int currentStep) {
                return currentStep > 1 ? currentStep - 1 : 1; 
            }
        },
        UP {
            @Override
            public int nextStep(int currentStep) {
                return (currentStep == 3) ? 1 : currentStep + 1;
            }
        },
        RANDOM {
            @Override
            public int nextStep(int currentStep) {
                return ThreadLocalRandom.current().nextInt(2, 4);
            }
        };
		
		public abstract int nextStep(int currentStep);
		
	}
	
	@Setter
	private int step;
	private Mode mode;
	
	@Override
	public void run()
	{
		if(mode != null)
		{
			step = mode.nextStep(step);
		}
		
	}
	
	public int value(int actual_step)
	{
		setStep(actual_step);
		run();
		return step;
	}

}
