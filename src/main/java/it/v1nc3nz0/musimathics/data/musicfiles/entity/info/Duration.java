package it.v1nc3nz0.musimathics.data.musicfiles.entity.info;

import it.v1nc3nz0.musimathics.data.musicfiles.exceptions.InvalidDurationException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duration
{
	
	public enum Values
	{
		W("WHOLE",4.0),
		H("HALF",2.0),
		Q("QUARTER",1.0),
		I("EIGHT",0.5),
		S("SIXTEENTH",0.25),
		T("THIRTY_SECOND",0.125),
		X("SIXTY_FOURTH",0.0625);
		
		private String name;
		private double value;
		
		Values(String name,double value)
		{
			this.name = name;
			this.value = value;
		}
		
		public String getName() { return name; }
		
		public double getValue() { return value; }
		
	}
	
	private Duration.Values value;
	private boolean isPointed;
	
	public Duration(Duration.Values value)
	{
		this.value = value;
		this.isPointed = false;
	}
	
	public Duration(Duration.Values value, boolean isPointed)
	{
		this.value = value;
		this.isPointed = isPointed;
	}
	
	public Duration(String dur) throws InvalidDurationException
	{
		dur = dur.toUpperCase();
		
		if(dur.endsWith("."))
		{
			dur = dur.substring(0,dur.length()-1);
			this.isPointed = true;
		}
		
		value = Values.valueOf(dur);
		
		if(!validate(dur))
			throw new InvalidDurationException(dur);
	}
	
	@Override
	public Duration clone()
	{
		return new Duration(value,isPointed);
	}
	
	public double get()
	{
		return value.getValue() + ((isPointed) ? (value.getValue()/2) : 0);
	}
	
	public String name()
	{
		return value.getName() + ((isPointed) ? "." : "");
	}
	
	public static Duration duplicate(Duration dur)
	{	
		double value = dur.getValue().getValue()*2;
		
		for(Duration.Values values : Duration.Values.values())
		{
			if(values.getValue() == value) 
			{
				try
				{
					return new Duration(values.name());
				} catch (InvalidDurationException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return dur;
	}
	
	public static Duration half(Duration dur)
	{	
		double value = dur.getValue().getValue()/2;
		
		for(Duration.Values values : Duration.Values.values())
		{
			if(values.getValue() == value) 
			{
				try
				{
					return new Duration(values.name());
				} catch (InvalidDurationException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return dur;
	}
	
	public static boolean validate(String str)
	{
		try
		{
			Duration.Values.valueOf(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
}
