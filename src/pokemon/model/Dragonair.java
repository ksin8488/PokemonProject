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
		
		//Setup code
		public Dragonair()
		{
			super(148, "Dragonair");
			setup();
		}
		
		public Dragonair(String name)
		{
			super(148, name);
			setup();
		}
		
		protected void setup()
		{
			this.setAttackPoints(84);
			this.setCanEvolve(false);
			//this.setEnhancementModifier(.89);
			this.setHealthPoints(61);
		}
}
