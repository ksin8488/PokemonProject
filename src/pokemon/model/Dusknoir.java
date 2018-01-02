package pokemon.model;

public class Dusknoir extends Pokemon implements Ghost
{
	public Dusknoir(int number, String name)
	{
		super(number, name);
	}
	
	//Ghost attacks
	public String nightmare()
	{
		String describeNightmare = "You dream of a creature coming to take you away.";
		return describeNightmare;
	}
	
	public void shadowBall()
	{
		System.out.print("Dusknoir uses Shadow Ball!");
	}
	
	public int shadowClaw()
	{
		int attackPower = 70;
		
		return attackPower;
	}
	
	//Setup code
	public Dusknoir()
	{
		super(477, "Dusknoir");
		setup();
	}
	
	public Dusknoir(String name)
	{
		super(477, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(100);
		this.setCanEvolve(false);
		//this.setEnhancementModifier(.89);
		this.setHealthPoints(45);
	}
}
