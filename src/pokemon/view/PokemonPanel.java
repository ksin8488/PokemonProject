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
	
	private void updatePokedexinfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
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
		
	}
	
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
		
	}
	
	private void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent selection)
				{
					int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
					updatePokedexinfo(selectedPokemonIndex);
					updateImage();
					updateTypePanels();
					repaint();
				}
			});	
	}
}
