package it.v1nc3nz0.musimathics;

import java.util.ArrayList;
import java.util.List;

import it.v1nc3nz0.musimathics.automation.generators.RandomMusicGenerator;
import it.v1nc3nz0.musimathics.automation.genetics.DurationChanger;
import it.v1nc3nz0.musimathics.automation.genetics.OctaveChanger;
import it.v1nc3nz0.musimathics.data.configuration.MusicFileSettings;
import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.data.music.Piece;
import it.v1nc3nz0.musimathics.data.music.caches.ScaleCache;
import it.v1nc3nz0.musimathics.data.music.caches.entity.ScaleKey;
import it.v1nc3nz0.musimathics.data.musicfiles.MusicFile;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Metric;
import it.v1nc3nz0.musimathics.data.musicfiles.entity.Scale;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;
import it.v1nc3nz0.musimathics.data.musicfiles.generics.MusicFileEntityList;
import it.v1nc3nz0.musimathics.data.musicfiles.io.MusicFileWriter;
import it.v1nc3nz0.musimathics.data.musicfiles.io.MusicWriter;
import lombok.Getter;

public class MusicMain
{
	@Getter
	private static MusicFileSettings musicFileSettings;
	
	@Getter
	private static RandomMusicGenerator randomMusicGenerator;
	
	@Getter
	private static List<MusicFileEntityList> voicesList;
	
	@Getter
	private static Metric metric;
	
	@Getter
	private static Scale scale;
	
	@Getter
	private static Piece piece;
	
	static {
		MusicMain.voicesList = new ArrayList<>();
	}
	
	public static void generateMFS(int BPM, String Metric, String scaleAlteration, String scaleType, int voices)
	{
		MusicMain.musicFileSettings = MusicFileSettings.createVirtualEmpty();
		MusicMain.musicFileSettings.setBPM(BPM);
		MusicMain.musicFileSettings.setMetric("4/4");
		MusicMain.musicFileSettings.setScaleAlteration("NONE");
		MusicMain.musicFileSettings.setScaleNote("C");
		MusicMain.musicFileSettings.setScaleType("MAJ");
		MusicMain.musicFileSettings.setTitle("Default");
		MusicMain.musicFileSettings.setVoices(1);
	}
	
	public static void generateVoices() throws Exception
	{
		int voices = MusicMain.getMusicFileSettings().getVoices();
		for(int x = 0;x < voices;x++) 
			MusicMain.getVoicesList().add(MusicMain.getRandomMusicGenerator().generate());
		
		MusicMain.voicesList = DurationChanger.transform(MusicMain.getVoicesList());
		MusicMain.voicesList = OctaveChanger.transform(MusicMain.getVoicesList());
		
		MusicMain.piece = new Piece(MusicMain.getMusicFileSettings(),MusicMain.getVoicesList());
		
		MusicMain.piece.compose();
		MusicMain.piece.play();
	}
	
	public static void initialize(int bars) throws InvalidDurationException
	{
		ScaleKey scaleKey = ScaleKey.create(MusicMain.musicFileSettings.getScaleNote(), 
				MusicMain.musicFileSettings.getScaleAlteration(), 
				MusicMain.musicFileSettings.getScaleType());
		MusicMain.scale = ScaleCache.get(scaleKey);
		MusicMain.metric = new Metric(musicFileSettings.getMetric());
		
		MusicMain.randomMusicGenerator = new RandomMusicGenerator(MusicMain.scale,MusicMain.metric,bars);
	}
	
	public static void saveToMusicFiles() throws Exception
	{	
		MusicFileWriter writer;
		MusicFile mfile;
		for(int x = 0;x < MusicMain.getVoicesList().size();x++)
		{
			mfile = new MusicFile(ConfigContainer.getApplicationConfig().getMusicFileFolder(),"v"+x+"_generated.mf");
			if(mfile.exists()) mfile.delete();
			mfile.createNewFile();
			writer = new MusicFileWriter(new MusicWriter(mfile));
			
			writer.save(MusicMain.getVoicesList().get(x));
			
			writer.close();
		}
	}

}
