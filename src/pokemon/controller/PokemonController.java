package pokemon.controller;

import pokemon.model.Pokemon;
import java.util.List;
import java.util.ArrayList;
import pokemon.view.PokemonFrame;

public class PokemonController
{
	private List<Pokemon> pokedex;
	
	public List<Pokemon> getPokedex()
	{
		return pokedex;
	}
	
	public boolean isValidInteger(String input)
	{
		return false;
	}
	
	public boolean isValidDouble(String input)
	{
		return false;
	}
	
	
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
