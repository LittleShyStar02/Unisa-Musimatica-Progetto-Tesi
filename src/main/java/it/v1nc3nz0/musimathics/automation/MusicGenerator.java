package it.v1nc3nz0.musimathics.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.v1nc3nz0.musimathics.api.automation.ActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.Step;
import it.v1nc3nz0.musimathics.automation.entity.actions.NoteActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.actions.StepChangeActionEntity;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Bar;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Alteration;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Duration;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;

public class MusicGenerator
{
	
	private List<Step> steps;
	
	public MusicGenerator() throws InvalidDurationException
	{
		steps = new ArrayList<>();
		loadSteps();
	}
	
	private void loadSteps() throws InvalidDurationException
	{
		Alteration natural = Alteration.createNatural();
		Duration quarter = new Duration("q");
		
		Step step1 = new Step(4);
		step1.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.RANDOM));
		step1.addAction(new NoteActionEntity(new Note("DO4",natural,quarter)));
		step1.addAction(new NoteActionEntity(new Note("MI4",natural,quarter)));
		step1.addAction(new NoteActionEntity(new Note("LA4",natural,quarter)));
		
		Step step2 = new Step(4);
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step2.addAction(new NoteActionEntity(new Note("RE4",natural,quarter)));
		step2.addAction(new NoteActionEntity(new Note("FA4",natural,quarter)));
		
		Step step3 = new Step(4);
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step3.addAction(new NoteActionEntity(new Note("SOL4",natural,quarter)));
		step3.addAction(new NoteActionEntity(new Note("SI4",natural,quarter)));
		
		steps.add(step1);
		steps.add(step2);
		steps.add(step3);
	}
	
	public void generate() throws Exception
	{
		
		File file = new File("output.mf");
		if(file.exists()) file.delete();
 		if(!file.exists()) file.createNewFile();
 		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		int step = ThreadLocalRandom.current().nextInt(1, 4);
		int notes = 0;
		
		
		while(notes < 100)
		{
			int value = ThreadLocalRandom.current().nextInt(0,4);
			ActionEntity ae = steps.get(step-1).get(value);
			
			if(ae instanceof StepChangeActionEntity stepchange)
				step = stepchange.value(step);
			
			if(ae instanceof NoteActionEntity entnote)
			{
				writer.write(entnote.getValue().toString());
				writer.newLine();
				notes++;

				if(notes != 0 && notes%4==0 && notes != 100)
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
