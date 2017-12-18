package pokemon.controller;

import pokemon.model.Pokemon;
import pokemon.view.PokemonFrame;

public class PokemonController
{
	private PokemonFrame appFrame;
	
	public PokemonController()
	{
		appFrame = new PokemonFrame(this);
	}
	
	public void start()
	{
		System.out.println("Hello");
	}
}
