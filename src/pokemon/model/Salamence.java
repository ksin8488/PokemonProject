package pokemon.model;

public class Salamence extends Shelgon implements Dragon
{
	public Salamence(int number, String name)
	{
		super(number, name);
	}
	
	//Don't need to rewrite methods of the same implement unless you need to change what they do
	public void roarOfTime()
	{
		System.out.print("Salamance uses Roar of Time");
	}
	
	//Setup code
	public Salamence()
	{
		super(373, "Salamence");
		setup();
	}
	
	public Salamence(String name)
	{
		super(373, name);
		setup();
	}
	
	@Override //only used for when it is implementing from elsewhere
	protected void setup()
	{
		this.setAttackPoints(135);
		this.setCanEvolve(false);
		//this.setEnhancementModifier(.89);
		this.setHealthPoints(95);
	}
}
