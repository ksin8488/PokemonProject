package pokemon.controller;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import pokemon.model.Pokemon;
import java.util.ArrayList;

public class FileController
{
	public static void savePokemonToFile(ArrayList<Pokemon> pokedex)		//static being used because File doesn't need to read itself or anything.
	{
		File saveFile = new File("Saved Pokedex.txt");	//create a file that is a text document
		try
		{
			PrintWriter writeToDisk = new PrintWriter(saveFile);
			
			for (int index = 0; index < pokedex.size(); index++) 
			{
				String name = pokedex.get(index).getName();
				int number = pokedex.get(index).getNumber();
				int attack = pokedex.get(index).getAttackPoints();
				int health = pokedex.get(index).getHealthPoints();
				boolean evolve = pokedex.get(index).isCanEvolve();
				double modify = pokedex.get(index).getEnhancementModifier();
				
				String row = name + "," + number + "," + health + "," + attack + "," + modify + "," + evolve;
				
				writeToDisk.println(row);
			}
			writeToDisk.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
	}
	
	public static String readPokemonFromFile()
	{
		String contents = "";
		String path = "Saved Pokedex.txt";
		try
		{
			Scanner fileScanner = new Scanner(new File(path));
			while (fileScanner.hasNextLine())
			{
				String row = fileScanner.nextLine();
				contents +=row + "/n";
			}
			fileScanner.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		return contents;
	}
}
