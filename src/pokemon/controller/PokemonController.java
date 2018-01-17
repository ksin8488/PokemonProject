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
		try
		{
			Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			return false;	//not a integer
		}
		return true;
	}
	
	public boolean isValidDouble(String input)
	{
		try
		{
			Double.parseDouble(input);
		}
		catch(NumberFormatException e)
		{
			return false;	//not a double
		}
		return true;
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
	
	/**
	 * Updates the selected pokemon from the PokemonPanel
	 * @param selection	- if it's selected
	 * @param health - health points of the pokemon
	 * @param attack - attack points of the pokemon
	 * @param evolve - whether or not the pokemon can evolve
	 * @param modify - modifier for the pokemon
	 * @param name - name of the pokemon
	 */
	public void updateSelected(int selection, int health, int attack, boolean evolve, double modify, String name)
	{
		Pokemon selected = pokedex.get(selection);
		
		selected.setAttackPoints(attack);
		selected.setCanEvolve(evolve);
		selected.setEnhancementModifier(modify);
		selected.setName(name);
		selected.setHealthPoints(health);
		
		FileController.savePokemonToFile((ArrayList<Pokemon>) pokedex);	//Don't need to define because it is static. Just tells it to run the save method.
	}
	
	public void start()
	{
		System.out.println("Hello This is a Placeholder");
	}
}
