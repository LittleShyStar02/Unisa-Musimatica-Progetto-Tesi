package it.v1nc3nz0.musimathics.tests;

import java.util.ArrayList;
import java.util.List;

import it.v1nc3nz0.musimathics.automation.generators.RandomMusicGenerator;
import it.v1nc3nz0.musimathics.automation.genetics.OctaveChanger;
import it.v1nc3nz0.musimathics.data.configuration.ApplicationConfig;
import it.v1nc3nz0.musimathics.data.configuration.MusicFileSettings;
import it.v1nc3nz0.musimathics.data.music.Piece;
import it.v1nc3nz0.musimathics.data.music.caches.ScaleCache;
import it.v1nc3nz0.musimathics.data.music.caches.entity.ScaleKey;
import it.v1nc3nz0.musimathics.data.musicfiles.MusicFile;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;
import it.v1nc3nz0.musimathics.data.musicfiles.io.MusicFileWriter;
import it.v1nc3nz0.musimathics.data.musicfiles.io.MusicWriter;

public class Test1Main
{

	public static void main(String[] args) throws Exception
	{
		MusicFileSettings mfs = MusicFileSettings.createVirtualEmpty();
		mfs.setBPM(120);
		mfs.setMetric("4/4");
		mfs.setScaleAlteration("NONE");
		mfs.setScaleNote("E");
		mfs.setScaleType("MAJ");
		mfs.setTitle("Default");
		mfs.setVoices(2);
		
		Scale scale = ScaleCache.get(ScaleKey.create(mfs.getScaleNote(), mfs.getScaleAlteration(), mfs.getScaleType()));
		
		RandomMusicGenerator rmg = new RandomMusicGenerator(scale);
		
		List<MusicFileEntityList> list = new ArrayList<>();
		for(int x = 0;x < mfs.getVoices();x++) list.add(rmg.generate());
		list = OctaveChanger.transform(list);
		
		Piece piece = new Piece(mfs,list);
		
		piece.compose();
		piece.play();
		
		MusicFileWriter writer;
		MusicFile mfile;
		for(int x = 0;x < list.size();x++)
		{
			mfile = new MusicFile(ApplicationConfig.getMusicFileFolder(),"v"+x+"_generated.mf");
			if(mfile.exists()) mfile.delete();
			mfile.createNewFile();
			writer = new MusicFileWriter(new MusicWriter(
					mfile));
			
			writer.save(list.get(x));
			
			writer.close();
		}
	}

}
