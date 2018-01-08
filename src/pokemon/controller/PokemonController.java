package pokemon.controller;

import java.util.List;
import java.util.ArrayList;
import pokemon.view.PokemonFrame;

import pokemon.model.Darkrai;
import pokemon.model.Dragonair;
import pokemon.model.Dusknoir;
import pokemon.model.Giratina;
import pokemon.model.Pokemon;
import pokemon.model.Salamence;
import pokemon.model.Shelgon;
import pokemon.model.Umbreon;

public class PokemonController
{
	private List<Pokemon> pokedex;
	private PokemonFrame appFrame;
	
	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		appFrame = new PokemonFrame(this);
	}
	
	public void buildPokedex()
	{
		pokedex.add(new Darkrai());
		pokedex.add(new Dragonair());
		pokedex.add(new Dusknoir());
		pokedex.add(new Giratina());
		pokedex.add(new Salamence());
		pokedex.add(new Shelgon());
		pokedex.add(new Umbreon());
	}
	
	
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
	
	
	public void start()
	{
		System.out.println("Hello This is a Placeholder");
	}
}
