package it.v1nc3nz0.musimathics;

import java.io.IOException;
import java.util.Arrays;

import it.v1nc3nz0.musimathics.data.configuration.ApplicationConfig;
import it.v1nc3nz0.musimathics.data.configuration.MusicFileSettings;
import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.data.music.Piece;
import it.v1nc3nz0.musimathics.data.musicfiles.MusicFile;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidMusicFileException;
import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.NoMixedSymbolsException;

public class Main
{

	public static void main(String[] args) throws InvalidMusicFileException, NoMixedSymbolsException, InvalidDurationException, IOException
	{
		ConfigContainer.init();
		
		MusicFileSettings mfs = new MusicFileSettings("example.yml");
		MusicFile mf = new MusicFile(ApplicationConfig.getMusicFileFolder(),"example.mf");
		
		mfs.loadConfiguration();
		
		Piece piece = new Piece(mfs, Arrays.asList(mf.getEntities()));
		piece.play();
	}

}
