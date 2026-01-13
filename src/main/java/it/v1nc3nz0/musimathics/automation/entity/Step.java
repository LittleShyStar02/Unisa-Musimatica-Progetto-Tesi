package it.v1nc3nz0.musimathics.automation.entity;

import it.v1nc3nz0.musimathics.api.automation.ActionEntity;

public class Step
{

	private ActionEntity[] entities;
	private int counter;
 	
	public Step(int max_action)
	{
		entities = new ActionEntity[max_action];
		counter = 0;
	}
	
	public boolean addAction(ActionEntity entity)
	{
		if(counter == entities.length) return false;
		entities[counter] = entity;
		counter++;
		return true;
	}
	
	public ActionEntity get(int index)
	{
		if(index < 0 || index > (entities.length-1)) return null;
		return entities[index];
	}
}
