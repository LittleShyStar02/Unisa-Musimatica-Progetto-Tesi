package it.v1nc3nz0.musimathics.api.automation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ValueActionEntity<Type> implements ActionEntity
{

	private Type value;
	
}
