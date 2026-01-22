package it.v1nc3nz0.musimathics.data.configuration;

import java.io.File;

import it.v1nc3nz0.musimathics.api.configuration.AbstractConfiguration;
import it.v1nc3nz0.musimathics.data.configuration.enums.ApplicationData;
import lombok.Getter;

public class ApplicationConfig extends AbstractConfiguration
{

	@Getter
	private File musicFileFolder;
	
	@Getter
	private File musicFileSettingsFolder;
	
	public ApplicationConfig()
	{
		super(null, "applications.yml");
	}
	
	public void loadData()
	{
		this.musicFileFolder = new File(ApplicationData.MUSIC_FILES_LOCATION.getString());
		this.musicFileSettingsFolder = new File(ApplicationData.MUSIC_FILES_SETTINGS_LOCATION.getString());
	}
	
}
