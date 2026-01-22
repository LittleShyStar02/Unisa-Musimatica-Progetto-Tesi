package it.v1nc3nz0.musimathics.data.configuration;

import java.io.File;
import java.io.IOException;

import it.v1nc3nz0.musimathics.api.configuration.AbstractConfiguration;
import it.v1nc3nz0.musimathics.api.configuration.FilesUtils;
import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;
import it.v1nc3nz0.musimathics.data.configuration.enums.MusicFileSettingsData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicFileSettings extends AbstractConfiguration
{
	
	private int BPM;
	private String metric;
	private String scaleAlteration;
	private String scaleNote;
	private String scaleType;
	private String title;
	private int voices;
	
	private MusicFileSettings()
	{
		super(ConfigContainer.getApplicationConfig().getMusicFileFolder(),"null.yml");
	}
	
	public MusicFileSettings(String name)
	{
		super(ConfigContainer.getApplicationConfig().getMusicFileSettingsFolder(), name);
		this.BPM = getInt(MusicFileSettingsData.DEFAULT_MUSIC_BPM.getPath());
		this.metric = getString(MusicFileSettingsData.DEFAULT_MUSIC_METRIC.getPath());
		this.scaleAlteration = getString(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_ALTERATION.getPath());
		this.scaleNote = getString(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_NOTE.getPath());
		this.scaleType = getString(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_TYPE.getPath());
		this.title = getString(MusicFileSettingsData.TITLE.getPath());
		this.voices = getInt(MusicFileSettingsData.VOICES.getPath());
	}
	
	public void copyDataFrom(MusicFileSettings mfs)
	{
		setBPM(mfs.getBPM());
		setMetric(mfs.getMetric());
		setScaleAlteration(mfs.getScaleAlteration());
		setScaleNote(mfs.getScaleNote());
		setScaleType(mfs.getScaleType());
		setTitle(mfs.getTitle());
		setVoices(mfs.getVoices());
	}
	
	public void saveData() throws IOException
	{
		set(MusicFileSettingsData.DEFAULT_MUSIC_BPM.getPath(),this.BPM);
		set(MusicFileSettingsData.DEFAULT_MUSIC_METRIC.getPath(),this.metric);
		set(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_ALTERATION.getPath(),this.scaleAlteration);
		set(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_NOTE.getPath(),this.scaleNote);
		set(MusicFileSettingsData.DEFAULT_MUSIC_SCALE_TYPE.getPath(),this.scaleType);
		set(MusicFileSettingsData.TITLE.getPath(),this.title);
		set(MusicFileSettingsData.VOICES.getPath(),this.voices);
		save();
	}
	
	public void saveVirtual(String name) throws IOException
	{
		File file = new File(ConfigContainer.getApplicationConfig().getMusicFileFolder(),"default.yml");
		if(!file.exists()) FilesUtils.extractFromJar(ConfigContainer.getApplicationConfig().getMusicFileSettingsFolder(), "default.yml");
		file.renameTo(new File(ConfigContainer.getApplicationConfig().getMusicFileFolder(),name));
		loadConfiguration(ConfigContainer.getApplicationConfig().getMusicFileFolder(),name);
		saveData();
	}
	
	public static MusicFileSettings createVirtualEmpty()
	{
		return new MusicFileSettings();
	}
	
}
