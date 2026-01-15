package it.v1nc3nz0.musimathics.automation.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.v1nc3nz0.musimathics.api.automation.ActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.Step;
import it.v1nc3nz0.musimathics.automation.entity.actions.NoteActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.actions.StepChangeActionEntity;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Bar;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale.Notes;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Alteration;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Duration;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;

public class RandomMusicGenerator
{
	
	private List<Step> steps;
	private Note[] notes;
	
	public RandomMusicGenerator(Scale scale) throws InvalidDurationException
	{
		steps = new ArrayList<>();
		notes = new Note[7];
		loadNote(scale);
		loadSteps();
	}
	
	private void loadNote(Scale scale) throws InvalidDurationException
	{
		Notes noteStart = scale.getNote();
		
		for(int x = 0;x < 7;x++)
		{
			Notes note = Notes.fromArrayIndex((noteStart.arrayIndex()+x)%7);
			notes[x] = new Note(note.name()+"4",Alteration.createNatural(),new Duration("q"));
		}
	}
	
	private void loadSteps() throws InvalidDurationException
	{
		
		Step step1 = new Step(4);
		step1.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.RANDOM));
		step1.addAction(new NoteActionEntity(notes[0]));
		step1.addAction(new NoteActionEntity(notes[2]));
		step1.addAction(new NoteActionEntity(notes[5]));
		
		Step step2 = new Step(4);
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step2.addAction(new NoteActionEntity(notes[1]));
		step2.addAction(new NoteActionEntity(notes[3]));
		
		Step step3 = new Step(4);
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step3.addAction(new NoteActionEntity(notes[4]));
		step3.addAction(new NoteActionEntity(notes[6]));
		
		steps.add(step1);
		steps.add(step2);
		steps.add(step3);
	}
	
	public MusicFileEntityList generate() throws Exception
	{
		
		MusicFileEntityList entities = new MusicFileEntityList();
		
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
				entities.add(entnote.getValue().clone());
				notes++;

				if(notes != 0 && notes%4==0 && notes != 100)
				{
					entities.add(new Bar());
				}
				
			}
		}
		
		return entities;
		
	}
	
}
