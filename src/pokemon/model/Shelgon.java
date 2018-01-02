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
		
		//Setup code
		public Shelgon()
		{
			super(372, "Shelgon");
			setup();
		}
		
		public Shelgon(String name)
		{
			super(372, name);
			setup();
		}
		
		protected void setup()
		{
			this.setAttackPoints(95);
			this.setCanEvolve(true);
			//this.setEnhancementModifier(.89);
			this.setHealthPoints(65);
		}
}

 

/*ADD THIS CODE TO THE POKEMON
 * public Turtwig()
 * {
 * super(387, "Turtwig");
 * setup();
 * }
 * 
 * public Turtwig(String name)
 * {
 * super(387, name);
 * setup();
 * }
 * 
 * public Turtwig(int number, String name)
 * {
 * super(number, name);
 * setup();
 * }
 * 
 * @Override
 * protected void setup()
 * {
 * this.setAttackPoints(234);
 * this.setCanEvolve(false);
 * this.setEnhancementModifier(.89);
 * this.setHealthPoints(123);
 * }
 */