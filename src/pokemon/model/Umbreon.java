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
}
