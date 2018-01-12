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
	
	/**
	 * Retrieves data from the Pokedex.
	 * @return returns the names of the Pokemon.
	 */
	public String [] convertPokedex()
	{
		String [] names = new String [pokedex.size()];
		
		for (int index = 0; index < pokedex.size(); index++)
		{
			names[index] = pokedex.get(index).getName();
		}
		
		return names;
	}
	
	public void updateSelected(int selection, int health, int attack, boolean evolve, double modify, String name)
	{
		Pokemon selected = pokedex.get(selection);
		
		selected.setAttackPoints(attack);
		selected.setCanEvolve(evolve);
		selected.setEnhancementModifier(modify);
		selected.setName(name);
		selected.setHealthPoints(health);
	}
	
	public void start()
	{
		System.out.println("Hello This is a Placeholder");
	}
}
