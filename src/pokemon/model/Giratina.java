package pokemon.model;

public class Giratina extends Pokemon implements Ghost, Dragon
{
	public Giratina(int number, String name)
	{
		super(number, name);
	}
	
	//Dragon attacks
	public int dragonRage()
	{
		int attackPower = 0;
		
		return attackPower;
	}
	
	public void roarOfTime()
	{
		System.out.print("Giratina uses Roar of Time!");
	}
	
	public String dragonBreath()
	{
		String roar = "ROAR!!!";
		
		return roar;
	}
	
	
	//Ghost attacks
	public String nightmare()
	{
		String describeNightmare = "You dream of a dark shape that decends from above...";
		return describeNightmare;
	}
	
	public void shadowBall()
	{
		System.out.print("Giratina uses Shadow Ball!");
	}
	
	public int shadowClaw()
	{
		int attackPower = 70;
		
		return attackPower;
	}
	
	//Setup code
	public Giratina()
	{
		super(487, "Giratina");
		setup();
	}
	
	public Giratina(String name)
	{
		super(487, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(100);
		this.setCanEvolve(false);
		//this.setEnhancementModifier(.89);
		this.setHealthPoints(150);
	}
}
