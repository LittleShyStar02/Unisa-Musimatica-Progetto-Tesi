package it.v1nc3nz0.musimathics.automation.genetics;

import java.util.List;

import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note.NoteInfo;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;
import it.v1nc3nz0.musimathics.utility.NumberGen;

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
		for(int x = 0;x < entities.size();x++)
		{
			if(!(entities.get(x) instanceof Note note)) continue;
			
			if(x > 0)
			{	
				Note last = (Note) entities.get(lastNoteIndex);
				int diff = Math.abs(last.getSemitone() - note.getSemitone());
				NoteInfo info = note.getNoteInfo();
				
				if(diff > 10)
				{
					if(last.getSemitone() > note.getSemitone()) 
						info = NoteInfo.fromSemitone(info.getSemitone()+12);
					else 
						info = NoteInfo.fromSemitone(info.getSemitone()-12);	
				}
				else
				{
					if(NumberGen.binary()==0)
					{
						if(NumberGen.binary()==0) 
							info = NoteInfo.fromSemitone(info.getSemitone()+12);
						else 
							info = NoteInfo.fromSemitone(info.getSemitone()-12);
					}
				}
				
				if(info != null)
				{
					note.update(info);
					entities.set(x, note);
				}
			}
			
			lastNoteIndex = x;
		}
		return entities;
	}
	
}
