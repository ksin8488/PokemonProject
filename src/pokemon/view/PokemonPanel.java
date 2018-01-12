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
		
		for (String current : appController.getPokedex().get(index)..getPokemonTypes())
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
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/TransparentPokeball.png")), JLabel.CENTER);
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
		numberField = new JTextField("##");
		attackField = new JTextField("ap");
		healthField = new JTextField("hp");
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
		String defaultName= "logo";
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
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableLabel, 13, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, -293, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, 0, SpringLayout.NORTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, modifierLabel, -159, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 6, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, 0, SpringLayout.SOUTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 6, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 157, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 149, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 164, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -6, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 6, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 6, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, -5, SpringLayout.NORTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 6, SpringLayout.EAST, modifierLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, descriptionArea, -77, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, descriptionArea, -301, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 12, SpringLayout.EAST, descriptionArea);
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 0, SpringLayout.NORTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 6, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, typeArea, 40, SpringLayout.NORTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.EAST, typeArea, -17, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, typeArea);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 15, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 183, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -92, SpringLayout.WEST, clearButton);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 17, SpringLayout.SOUTH, firstType);
		appLayout.putConstraint(SpringLayout.WEST, firstType, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, firstType);
		appLayout.putConstraint(SpringLayout.NORTH, firstType, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, secondType, 0, SpringLayout.NORTH, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, secondType, 18, SpringLayout.EAST, firstType);
		appLayout.putConstraint(SpringLayout.WEST, thirdType, 12, SpringLayout.EAST, secondType);
		appLayout.putConstraint(SpringLayout.SOUTH, thirdType, 0, SpringLayout.SOUTH, firstType);
		appLayout.putConstraint(SpringLayout.WEST, fourthType, 16, SpringLayout.EAST, thirdType);
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
					repaint();
				}
			});	
	}
}
