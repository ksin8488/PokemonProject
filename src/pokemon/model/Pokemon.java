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

	/**
	 * @return the healthPoints
	 */
	public int getHealthPoints()
	{
		return healthPoints;
	}

	/**
	 * @param healthPoints the healthPoints to set
	 */
	public void setHealthPoints(int healthPoints)
	{
		this.healthPoints = healthPoints;
	}

	/**
	 * @return the attackPoints
	 */
	public int getAttackPoints()
	{
		return attackPoints;
	}

	/**
	 * @param attackPoints the attackPoints to set
	 */
	public void setAttackPoints(int attackPoints)
	{
		this.attackPoints = attackPoints;
	}

	/**
	 * @return the enhancmentModifier
	 */
	public double getEnhancmentModifier()
	{
		return enhancmentModifier;
	}

	/**
	 * @param enhancmentModifier the enhancmentModifier to set
	 */
	public void setEnhancmentModifier(double enhancmentModifier)
	{
		this.enhancmentModifier = enhancmentModifier;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the canEvolve
	 */
	public boolean isCanEvolve()
	{
		return canEvolve;
	}

	/**
	 * @param canEvolve the canEvolve to set
	 */
	public void setCanEvolve(boolean canEvolve)
	{
		this.canEvolve = canEvolve;
	}

	/**
	 * @return the number
	 */
	public int getNumber()
	{
		return number;
	}
}
