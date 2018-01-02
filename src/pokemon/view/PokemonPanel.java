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
		
		//Initialize GUI data members
		healthLabel = new JLabel();
		attackLabel = new JLabel();
		nameLabel = new JLabel();
		numberLabel = new JLabel();
		evolvableLabel = new JLabel();
		modifierLabel = new JLabel();
		iconLabel = new JLabel();
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField();
		numberField = new JTextField();
		attackField = new JTextField();
		healthField = new JTextField();
		modifierField = new JTextField();
		
		descriptionArea = new JTextArea();
		typeArea = new JTextArea();
		
		saveButton = new JButton();
		clearButton = new JButton();
		pokedexDropdown = new JComboBox();
		firstType = new JPanel();
		secondType = new JPanel();
		thirdType = new JPanel();
		fourthType = new JPanel();
		
		
		
		//Method Calls
		setupPanel();
		setupLayout();
		setupListeners();
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
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
