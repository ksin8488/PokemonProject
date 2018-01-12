package pokemon.view;

import javax.swing.*;


import pokemon.controller.PokemonController;
import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates the panel for the GUI and manipulates objects and layout as well as interaction within the panel
 * @author ksin8488
 *
 */
public class PokemonPanel extends JPanel
{
	private PokemonController appController;
	private SpringLayout appLayout;
	
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokedexDropdown;
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType;
	
	/**
	 * updatePokedexInfo sets different parts of the GUI with the needed words/numbers
	 * @param index - index number for the pokemon?
	 */
	private void updatePokedexInfo(int index)
	{
		//Update basic fields
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
		
		//Update Text areas
		descriptionArea.setText(appController.getPokedex().get(index).toString());
		typeArea.setText("");
		
		for (String current : appController.getPokedex().get(index).getPokemonTypes())
		{
			typeArea.append(current + "\n");
		}
	}
	
	/**
	 * Initializes GUI data members then calls the methods when program runs
	 * @param appController checks if the program ran
	 */
	public PokemonPanel(PokemonController appController)
	{
		super();
		this.appController = appController;
		this.appLayout = new SpringLayout();
		
		//Initialize GUI data members
		healthLabel = new JLabel("health");
		attackLabel = new JLabel("attack");
		nameLabel = new JLabel("name");
		numberLabel = new JLabel("number");
		evolvableLabel = new JLabel("evolvable");
		modifierLabel = new JLabel("modifier");
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/Pokeball.png")), JLabel.CENTER);
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
		
		numberField = new JTextField("##");
		attackField = new JTextField("ap");
		healthField = new JTextField("hp");
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, 0, SpringLayout.EAST, healthField);
		modifierField = new JTextField("mod");
		
		descriptionArea = new JTextArea(5, 10);
		typeArea = new JTextArea(4,15);
		
		
		saveButton = new JButton("save");
		clearButton = new JButton("clear");
		pokedexDropdown = new JComboBox();
		
		
		firstType = new JPanel();
		secondType = new JPanel();
		thirdType = new JPanel();
		fourthType = new JPanel();
		
		//Method Calls
		setupComboBox();
		setupTypePanels();
		updateImage();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Creates a model view controller in our Panel and sets it
	 */
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	
	/**
	 * Sets up the type panels that we have created
	 */
	private void setupTypePanels()
	{
		firstType.setSize(50, 50);
		secondType.setSize(50, 50);
		thirdType.setSize(50, 50);
		fourthType.setSize(50, 50);
	}
	
	private void updateImage()
	{
		String path = "/pokemon/view/images/";
		String defaultName= "Pokeball";	//rename to whatever your "logo" image is
		String name = pokedexDropdown.getSelectedItem().toString();
		String extension = ".png"; //if you have a gif then change it to ".gif"
		ImageIcon pokemonIcon;
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		iconLabel.setIcon(pokemonIcon);
	}
	
	/**
	 * Sets the panel with the necessary components that will be used in the design tab
	 */
	private void setupPanel()
	{
		this.setBackground(Color.red);
		this.setLayout(appLayout);
		this.add(healthLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(evolvableLabel);
		this.add(modifierLabel);
		this.add(iconLabel);
		
		this.add(evolvableBox);
		this.add(nameField);
		this.add(numberField);
		this.add(attackField);
		this.add(healthField);
		this.add(modifierField);
		this.add(descriptionArea);
		this.add(typeArea);
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(pokedexDropdown);
		this.add(firstType);
		this.add(secondType);
		this.add(thirdType);
		this.add(fourthType);
		
	}
	
	/**
	 * Updates the type panels to match the background of the type(s) that the pokemon may have. Including if it has multiple types.
	 */
	private void updateTypePanels() //change what goes on in the GUI
	{
		String [] types = appController.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		
		//Change this to match your 3 minimum Types in your pokedex
		if (types[0].equals("Dark"))
		{
			firstType.setBackground(Color.BLACK);
		}
		else if (types[0].equals("Dragon"))
		{
			firstType.setBackground(Color.BLUE);
		}
		else if (types[0].equals("Ghost"))
		{
			firstType.setBackground(Color.DARK_GRAY);
		}
		else
		{
			firstType.setBackground(Color.WHITE);
		}
		
		
		if(types.length > 1)	//sets up types for pokemon that have multiple types
		{
			if(types[1].equals("Dark"))
			{
				secondType.setBackground(Color.BLACK);
			}
			else if (types[1].equals("Dragon"))
			{
				firstType.setBackground(Color.BLUE);
			}
			else if (types[1].equals("Ghost"))
			{
				firstType.setBackground(Color.DARK_GRAY);
			}
			else
			{
				firstType.setBackground(Color.WHITE);
			}
			
			
			if (types.length == 3)	//for pokemon that have 3 types total
			{
				if(types[2].equals("Dark"))	//remember index starts from 0
				{
					secondType.setBackground(Color.BLACK);
				}
				else if (types[2].equals("Dragon"))
				{
					firstType.setBackground(Color.BLUE);
				}
				else if (types[2].equals("Ghost"))
				{
					firstType.setBackground(Color.DARK_GRAY);
				}
				else
				{
					firstType.setBackground(Color.WHITE);
				}
			}
			
			
			if (types.length == 4)	//for pokemon that have 4 types total
			{
				if(types[3].equals("Dark"))	//remember index starts from 0
				{
					secondType.setBackground(Color.BLACK);
				}
				else if (types[3].equals("Dragon"))
				{
					firstType.setBackground(Color.BLUE);
				}
				else if (types[3].equals("Ghost"))
				{
					firstType.setBackground(Color.DARK_GRAY);
				}
				else
				{
					firstType.setBackground(Color.WHITE);
				}
			}
		}
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -176, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableLabel, -6, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, 0, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, -6, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 144, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, -4, SpringLayout.WEST, evolvableBox);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 285, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -16, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 15, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -6, SpringLayout.NORTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 9, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -1, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, -3, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 140, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, modifierLabel, -6, SpringLayout.WEST, modifierField);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, -1, SpringLayout.NORTH, modifierField);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, descriptionArea, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 320, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, typeArea, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 10, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.WEST, descriptionArea, 0, SpringLayout.WEST, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 22, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -20, SpringLayout.NORTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 113, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, firstType, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, firstType, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, secondType, 6, SpringLayout.EAST, firstType);
		appLayout.putConstraint(SpringLayout.SOUTH, secondType, 0, SpringLayout.SOUTH, firstType);
		appLayout.putConstraint(SpringLayout.WEST, thirdType, 6, SpringLayout.EAST, secondType);
		appLayout.putConstraint(SpringLayout.SOUTH, thirdType, 0, SpringLayout.SOUTH, firstType);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 13, SpringLayout.EAST, fourthType);
		appLayout.putConstraint(SpringLayout.WEST, fourthType, 6, SpringLayout.EAST, thirdType);
		appLayout.putConstraint(SpringLayout.SOUTH, fourthType, 0, SpringLayout.SOUTH, firstType);
	}
	
	private void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent selection)
				{
					int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
					updatePokedexInfo(selectedPokemonIndex);
					updateImage();
					updateTypePanels();
					repaint();		//makes the application re-draw itself
				}
			});	
	}
}
