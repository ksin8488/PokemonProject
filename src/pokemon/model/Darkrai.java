package pokemon.model;

public class Darkrai extends Pokemon implements Dark
{
	public Darkrai(int number, String name)
	{
		super(number, name);
	}
	
	//Dark attacks
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
			public Darkrai()
			{
				super(491, "Darkrai");
				setup();
			}
			
			public Darkrai(String name)
			{
				super(491, name);
				setup();
			}
			
			public double enhancementModifier()
			{
				double enhancementModifier = 0.90;
				return enhancementModifier;
			}
			
			protected void setup()
			{
				this.setAttackPoints(90);
				this.setCanEvolve(false);
				this.setEnhancementModifier(.89);
				this.setHealthPoints(70);
			}
}
