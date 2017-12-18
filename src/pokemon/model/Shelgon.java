package pokemon.model;

public class Shelgon extends Pokemon implements Dragon
{
	public Shelgon(int number, String name)
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
