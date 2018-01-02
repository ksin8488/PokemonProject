package pokemon.model;

public class Umbreon extends Pokemon implements Dark
{
	public Umbreon(int number, String name)
	{
		super(number, name);
	}
	
	//Dark Attacks
	public int nightSlash()
	{
		int attackPower = 70;
		
		return attackPower;
	}
	
	public String snarl()
	{
		String growl = "GRRRRR";
		
		return growl;
	}
	
	public void torment()
	{
		System.out.print("You start thinking of your greatest fear.");
	}
	
	//Setup code
	public Umbreon()
	{
		super(187, "Umbreon");
		setup();
	}
	
	public Umbreon(String name)
	{
		super(187, name);
		setup();
	}
	
	public double enhancementModifier()
	{
		double enhancementModifier = 0.90;
		return enhancementModifier;
	}
	
	protected void setup()
	{
		this.setAttackPoints(65);
		this.setCanEvolve(false);
		this.setEnhancementModifier(.89);
		this.setHealthPoints(95);
	}
}
