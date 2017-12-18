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
}
