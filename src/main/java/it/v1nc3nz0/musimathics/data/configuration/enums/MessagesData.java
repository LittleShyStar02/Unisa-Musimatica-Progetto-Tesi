package it.v1nc3nz0.musimathics.data.configuration.enums;

import it.v1nc3nz0.musimathics.data.configuration.container.ConfigContainer;

public enum MessagesData
{

	COMPONENTS_GENGUI_BUTTONS_ABORT("components.gengui.buttons.abort"),
	COMPONENTS_GENGUI_BUTTONS_FULLGEN("components.gengui.buttons.fullgen"),
	COMPONENTS_GENGUI_BUTTONS_PARTIALGEN("components.gengui.buttons.partialgen"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_ERRORDIALOG_CONTENT("components.gengui.listeners.basedMusicGenListener.errorDialog.content"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_ERRORDIALOG_TITLE("components.gengui.listeners.basedMusicGenListener.errorDialog.title"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_SUCCESSDIALOG_CONTENT("components.gengui.listeners.basedMusicGenListener.successDialog.content"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_SUCCESSDIALOG_TITLE("components.gengui.listeners.basedMusicGenListener.successDialog.title"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_WARNDIALOG_CONTENT("components.gengui.listeners.basedMusicGenListener.warnDialog.content"),
	COMPONENTS_GENGUI_LISTENERS_BASEDMUSICGENLISTENER_WARNDIALOG_TITLE("components.gengui.listeners.basedMusicGenListener.warnDialog.title"),
	COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_ERRORDIALOG_CONTENT("components.gengui.listeners.randomMusicGenListener.errorDialog.content"),
	COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_ERRORDIALOG_TITLE("components.gengui.listeners.randomMusicGenListener.errorDialog.title"),
	COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_SUCCESSDIALOG_CONTENT("components.gengui.listeners.randomMusicGenListener.successDialog.content"),
	COMPONENTS_GENGUI_LISTENERS_RANDOMMUSICGENLISTENER_SUCCESSDIALOG_TITLE("components.gengui.listeners.randomMusicGenListener.successDialog.title"),
	COMPONENTS_GENGUI_TITLE("components.gengui.title"),
	COMPONENTS_MAINGUI_BUTTONS_CLOSE("components.maingui.buttons.close"),
	COMPONENTS_MAINGUI_BUTTONS_GENERATE("components.maingui.buttons.generate"),
	COMPONENTS_MAINGUI_BUTTONS_PLAY("components.maingui.buttons.play"),
	COMPONENTS_MAINGUI_BUTTONS_SAVEFORMATMF("components.maingui.buttons.saveFormatMF"),
	COMPONENTS_MAINGUI_BUTTONS_SAVEFORMATMIDI("components.maingui.buttons.saveFormatMidi"),
	COMPONENTS_MAINGUI_BUTTONS_STOPMUSIC("components.maingui.buttons.stopMusic"),
	COMPONENTS_MAINGUI_LABELS_BPM("components.maingui.labels.bpm"),
	COMPONENTS_MAINGUI_LABELS_METRIC("components.maingui.labels.metric"),
	COMPONENTS_MAINGUI_LABELS_SCALEALTERATION("components.maingui.labels.scaleAlteration"),
	COMPONENTS_MAINGUI_LABELS_SCALENOTE("components.maingui.labels.scaleNote"),
	COMPONENTS_MAINGUI_LABELS_SCALETYPE("components.maingui.labels.scaleType"),
	COMPONENTS_MAINGUI_LABELS_VOICES("components.maingui.labels.voices"),
	COMPONENTS_MAINGUI_LISTENERS_GENERATERANDOMMUSICLISTENER_BARSINPUT("components.maingui.listeners.generateRandomMusicListener.barsInput"),
	COMPONENTS_MAINGUI_LISTENERS_GENERATERANDOMMUSICLISTENER_ERRORDIALOG_EXCEPTIONS_INVALIDDURATION("components.maingui.listeners.generateRandomMusicListener.errorDialog.exceptions.invalidDuration"),
	COMPONENTS_MAINGUI_LISTENERS_GENERATERANDOMMUSICLISTENER_ERRORDIALOG_EXCEPTIONS_NUMBERFORMAT("components.maingui.listeners.generateRandomMusicListener.errorDialog.exceptions.numberFormat"),
	COMPONENTS_MAINGUI_LISTENERS_GENERATERANDOMMUSICLISTENER_ERRORDIALOG_TITLE("components.maingui.listeners.generateRandomMusicListener.errorDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_PLAYMUSICLISTENER_ERRORDIALOG_CONTENT("components.maingui.listeners.playMusicListener.errorDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_PLAYMUSICLISTENER_ERRORDIALOG_TITLE("components.maingui.listeners.playMusicListener.errorDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_PLAYMUSICLISTENER_SUCCESSDIALOG_CONTENT("components.maingui.listeners.playMusicListener.successDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_PLAYMUSICLISTENER_SUCCESSDIALOG_TITLE("components.maingui.listeners.playMusicListener.successDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_ERRORDIALOG_EXCEPTIONS_CONTENT("components.maingui.listeners.saveMidiListener.errorDialog.exceptions.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_ERRORDIALOG_EXCEPTIONS_TITLE("components.maingui.listeners.saveMidiListener.errorDialog.exceptions.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_ERRORDIALOG_NOVOICE_CONTENT("components.maingui.listeners.saveMidiListener.errorDialog.novoice.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_ERRORDIALOG_NOVOICE_TITLE("components.maingui.listeners.saveMidiListener.errorDialog.novoice.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_SUCCESSDIALOG_CONTENT("components.maingui.listeners.saveMidiListener.successDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMIDILISTENER_SUCCESSDIALOG_TITLE("components.maingui.listeners.saveMidiListener.successDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_ERRORDIALOG_EXCEPTIONS_CONTENT("components.maingui.listeners.saveMusicFileListener.errorDialog.exceptions.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_ERRORDIALOG_EXCEPTIONS_TITLE("components.maingui.listeners.saveMusicFileListener.errorDialog.exceptions.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_ERRORDIALOG_NOVOICE_CONTENT("components.maingui.listeners.saveMusicFileListener.errorDialog.novoice.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_ERRORDIALOG_NOVOICE_TITLE("components.maingui.listeners.saveMusicFileListener.errorDialog.novoice.title"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_SUCCESSDIALOG_CONTENT("components.maingui.listeners.saveMusicFileListener.successDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_SAVEMUSICFILELISTENER_SUCCESSDIALOG_TITLE("components.maingui.listeners.saveMusicFileListener.successDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_ERRORDIALOG_CONTENT("components.maingui.listeners.stopMusicListener.errorDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_ERRORDIALOG_TITLE("components.maingui.listeners.stopMusicListener.errorDialog.title"),
	COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_SUCCESSDIALOG_CONTENT("components.maingui.listeners.stopMusicListener.successDialog.content"),
	COMPONENTS_MAINGUI_LISTENERS_STOPMUSICLISTENER_SUCCESSDIALOG_TITLE("components.maingui.listeners.stopMusicListener.successDialog.title"),
	COMPONENTS_MAINGUI_TITLE("components.maingui.title"),
	ERROR_MUSIC_FILES_ENTITIES_CANNOT_MIX_ALT_SYMBOLS("error.music-files.entities.cannot-mix-alt-symbols"),
	ERROR_MUSIC_FILES_ENTITIES_INVALID_DURATION("error.music-files.entities.invalid-duration"),
	ERROR_MUSIC_FILES_ENTITIES_NOTE_OUTOFBOUND("error.music-files.entities.note-outofbound"),
	ERROR_MUSIC_FILES_ISNT_VALID_EXTENSION("error.music-files.isnt-valid-extension");
	
	private String path;
	
	MessagesData(String path)
	{
		this.path = path;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public String getString()
	{
		return ConfigContainer.getMessagesConfig().getString(getPath());
	}
	
	public String toString()
	{
		return getPath();
	}
	
}
