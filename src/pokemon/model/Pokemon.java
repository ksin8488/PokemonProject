package pokemon.model;

public abstract class Pokemon
{
	private int healthPoints;
	private int attackPoints;
	private double enhancmentModifier;
	private int number;
	private String name;
	private boolean canEvolve;
	
	public Pokemon (int number, String name)
	{
		this.name = name;
		this.number = number;
	}
	
	public final String[] getPokemonTypes()
	{
		Class<?> [] types = getClass().getInterfaces();
		String [] pokeTypes = new String[types.length];
		
		for(int index = 0; index < types.length; index++)
		{
				String currentInterface = types[index].getCanonicalName();
				currentInterface = currentInterface.replaceAll(this.getClass().getPackage().getName() + ".", "");
				pokeTypes[index] = currentInterface;
		}
		
		return pokeTypes;
	}
	
	public String toString()		//this sort of method is almost like a "constant method" in that it doesn't really change
	{
		String description = "Hi, I am a " + name + ", and my HP is " + healthPoints;
		
		return description;
	}
	
	public String getPokemonInformation()
	{
		String pokemonInfo = "THis pokemon is of type: " + this.getClass().getSimpleName();
		
		return pokemonInfo;
	}
}
