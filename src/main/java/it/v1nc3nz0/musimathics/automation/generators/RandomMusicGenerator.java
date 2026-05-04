package it.v1nc3nz0.musimathics.automation.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import it.v1nc3nz0.musimathics.MusicMain;
import it.v1nc3nz0.musimathics.api.automation.ActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.Step;
import it.v1nc3nz0.musimathics.automation.entity.actions.NoteActionEntity;
import it.v1nc3nz0.musimathics.automation.entity.actions.StepChangeActionEntity;
import it.v1nc3nz0.musimathics.automation.utility.DurationUtils;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Bar;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Metric;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale.Notes;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Alteration;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Duration;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;
import lombok.Getter;
import lombok.Setter;

public class RandomMusicGenerator
{
	
	private List<Step> basedSteps;
	private List<Step> steps;
	private Note[] basedNotes;
	private Note[] notes;
	private int barnotes;
	
	@Getter
	@Setter
	private Metric metric;
	
	@Getter
	@Setter
	private int bars;
	
	public RandomMusicGenerator(Scale scale, Metric metric, int bars) throws InvalidDurationException
	{
		setMetric(metric);
		setBars(bars);
		
		basedSteps = new ArrayList<>();
		steps = new ArrayList<>();
		basedNotes = new Note[7];
		notes = new Note[7];
		barnotes = DurationUtils.getBarNotes(getMetric());
		
		loadBasedNotes(scale);
		loadNotes(scale);
		loadBasedSteps();
		loadSteps();
	}
	
	private void loadBasedNotes(Scale scale) throws InvalidDurationException
	{
		Notes noteStart = scale.getNote();
		
		Duration dur = new Duration("q");
		if(getMetric().getDenominator() < barnotes || getMetric().getDenominator() == 8) 
			dur = Duration.half(dur);
		
		for(int x = 0;x < 7;x++)
		{
			Notes note = Notes.fromArrayIndex((noteStart.arrayIndex()+x)%7);
			basedNotes[x] = new Note(note.name()+"3",Alteration.createNatural(),dur.clone());
		}
	}
	
	private void loadNotes(Scale scale) throws InvalidDurationException
	{
		Notes noteStart = scale.getNote();
		
		Duration dur = new Duration("q");
		if(getMetric().getDenominator() < barnotes || getMetric().getDenominator() == 8) 
			dur = Duration.half(dur);
		
		for(int x = 0;x < 7;x++)
		{
			Notes note = Notes.fromArrayIndex((noteStart.arrayIndex()+x)%7);
			notes[x] = new Note(note.name()+"4",Alteration.createNatural(),dur.clone());
		}
	}
	
	private void loadBasedSteps() throws InvalidDurationException
	{
		
		Step step1 = new Step(4);
		step1.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.RANDOM));
		step1.addAction(new NoteActionEntity(basedNotes[0]));
		step1.addAction(new NoteActionEntity(basedNotes[2]));
		step1.addAction(new NoteActionEntity(basedNotes[5]));
		
		Step step2 = new Step(4);
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step2.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step2.addAction(new NoteActionEntity(basedNotes[1]));
		step2.addAction(new NoteActionEntity(basedNotes[3]));
		
		Step step3 = new Step(4);
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.UP));
		step3.addAction(new StepChangeActionEntity(0,StepChangeActionEntity.Mode.DOWN));
		step3.addAction(new NoteActionEntity(basedNotes[4]));
		step3.addAction(new NoteActionEntity(basedNotes[6]));
		
		basedSteps.add(step1);
		basedSteps.add(step2);
		basedSteps.add(step3);
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
	
	public MusicFileEntityList generateBasedVoice() throws Exception
	{
		
		MusicFileEntityList entities = new MusicFileEntityList();
		
		int step = ThreadLocalRandom.current().nextInt(1, 4);
		int maxnotes = getBars()*barnotes;
		int nextNode = 0;
		int notes = 0;
		
		while(notes < maxnotes)
		{
			int value = ThreadLocalRandom.current().nextInt(0,100)%4;
			ActionEntity ae = basedSteps.get(step-1).get(value);

			if(ae instanceof StepChangeActionEntity stepchange)
				step = stepchange.value(step);
			
			if(ae instanceof NoteActionEntity entnote)
			{
				Note testnote = (Note) MusicMain.getVoicesList().get(0).get(nextNode);
				Note enote = entnote.getValue();
				
				int index1 = Notes.fromNote(enote).arrayIndex();
				int index2 = Notes.fromNote(testnote).arrayIndex();
				if(Math.abs(index1-index2) == 1 || Math.abs(index1-index2) == 6) continue;
				
				entities.add(enote.clone());
				notes++;
				nextNode++;

				if(notes != 0 && notes%barnotes==0 && notes != maxnotes)
				{
					entities.add(new Bar());
					nextNode++;
				}
				
			}
		}
		
		return entities;
	}
	
	public MusicFileEntityList generateRandomVoice() throws Exception
	{
		
		MusicFileEntityList entities = new MusicFileEntityList();
		
		int step = ThreadLocalRandom.current().nextInt(1, 4);
		int maxnotes = getBars()*barnotes;
		int notes = 0;
		
		while(notes < maxnotes)
		{
			int value = ThreadLocalRandom.current().nextInt(0,100)%4;
			ActionEntity ae = steps.get(step-1).get(value);
			
			if(ae instanceof StepChangeActionEntity stepchange)
				step = stepchange.value(step);
			
			if(ae instanceof NoteActionEntity entnote)
			{
				entities.add(entnote.getValue().clone());
				notes++;

				if(notes != 0 && notes%barnotes==0 && notes != maxnotes)
				{
					entities.add(new Bar());
				}
				
			}
		}
		
		return entities;
		
	}
	
}
