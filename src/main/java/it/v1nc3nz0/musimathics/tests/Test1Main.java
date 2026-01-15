package it.v1nc3nz0.musimathics.tests;

import java.util.Arrays;

import it.v1nc3nz0.musimathics.automation.generators.RandomMusicGenerator;
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
		mfs.setScaleNote("C");
		mfs.setScaleType("MAJ");
		mfs.setTitle("Default");
		mfs.setVoices(1);
		
		Scale scale = ScaleCache.get(ScaleKey.create(mfs.getScaleNote(), mfs.getScaleAlteration(), mfs.getScaleType()));
		
		RandomMusicGenerator rmg = new RandomMusicGenerator(scale);
		
		MusicFileEntityList list = rmg.generate();
		MusicFileEntityList list2 = rmg.generate();
		
		Piece piece = new Piece(mfs,Arrays.asList(list,list2));
		
		piece.compose();
		piece.play();
		
		MusicFileWriter writer = new MusicFileWriter(
				new MusicWriter(
						new MusicFile(ApplicationConfig.getMusicFileFolder(),"generated.mf")));
		
		writer.save(list);
		
		writer.close();
	}

}
