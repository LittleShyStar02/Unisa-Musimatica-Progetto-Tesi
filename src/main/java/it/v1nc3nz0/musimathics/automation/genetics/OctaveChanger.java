package it.v1nc3nz0.musimathics.automation.genetics;

import java.util.List;

import it.v1nc3nz0.musimathics.NumberGen;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note.NoteInfo;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;

public class OctaveChanger
{

	public static List<MusicFileEntityList> transform(List<MusicFileEntityList> list)
	{
		MusicFileEntityList ents;
		for(int x = 0;x < list.size();x++)
		{
			ents = list.get(x);
			ents = OctaveChanger.transform(ents);
			list.set(x, ents);
		}
		return list;
	}
	
	public static MusicFileEntityList transform(MusicFileEntityList entities)
	{
		int lastNoteIndex = -1;
		int noteCounter = 0;
		for(int x = 0;x < entities.size();x++)
		{
			if(!(entities.get(x) instanceof Note note)) continue;
			noteCounter++;
			
			if(noteCounter > 2)
			{	
				Note last = (Note) entities.get(lastNoteIndex);
				int diff = Math.abs(last.getSemitone() - note.getSemitone());
				if(diff > 10 || NumberGen.binary()==0);
				{
					NoteInfo info = note.getNoteInfo();
					
					if(last.getSemitone() > note.getSemitone()) 
						info = NoteInfo.fromSemitone(info.getSemitone()+12);
					else 
						info = NoteInfo.fromSemitone(info.getSemitone()-12);
					
					if(info != null)
					{
						note.update(info);
						entities.set(x, note);
					}
						
				}
			}
			
			lastNoteIndex = x;
		}
		return entities;
	}
	
}
