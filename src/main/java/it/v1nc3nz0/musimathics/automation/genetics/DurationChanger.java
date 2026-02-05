package it.v1nc3nz0.musimathics.automation.genetics;

import java.util.List;

import it.v1nc3nz0.musimathics.api.musicfiles.MusicFileEntity;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Bar;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Note;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.info.Duration;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;
import it.v1nc3nz0.musimathics.utility.NumberGen;

public class DurationChanger
{

	public static List<MusicFileEntityList> transform(List<MusicFileEntityList> list)
	{
		MusicFileEntityList ents;
		for(int x = 0;x < list.size();x++)
		{
			ents = list.get(x);
			ents = DurationChanger.transform(ents);
			list.set(x, ents);
		}
		return list;
	}
	
	public static MusicFileEntityList transform(MusicFileEntityList entities)
	{
		MusicFileEntityList list = new MusicFileEntityList();
		
		Note lastNote = null;
		int count = 0;
		
		for(MusicFileEntity entity : entities)
		{
			if(!(entity instanceof Note note))
			{
				list.add(entity);
				
				if(entity instanceof Bar)
					lastNote = null;
				
				continue;
			}
			
			if(lastNote != null)
			{
				if(lastNote.getNoteInfo().name().equals(note.getNoteInfo().name()))
				{
					if(NumberGen.binary() == 0)
					{
						if(count%2 == 0)
						{
							note.setDuration(Duration.duplicate(note.getDuration()));
							note.getDuration().setPointed(false);
						}
						else
							note.getDuration().setPointed(true);
						
						list.removeLast();
						list.add(note);
						lastNote = note;
						count++;
						continue;
					}
				}
				if(count > 0) count = 0;
			}
			
			list.add(note);
			lastNote = note;
		}
		
		return list;
	}
	
}
