package pokemon.model;

public class Dragonair extends Pokemon implements Dragon
{
	public Dragonair(int number, String name)
	{
		super(number, name);
	}
	
	//Dragon Attacks
		public int dragonRage()
		{
			int attackPower = 0;
			
			return attackPower;
		}
		
		public void roarOfTime()
		{
			System.out.print("Dragonair uses Roar of Time");
		}
		
		public String dragonBreath()
		{
			String roar = "ROAR!!!";
			
			return roar;
		}
}
