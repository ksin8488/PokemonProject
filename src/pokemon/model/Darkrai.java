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
}
