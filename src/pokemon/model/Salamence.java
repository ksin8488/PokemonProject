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
	
}
