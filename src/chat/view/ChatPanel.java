package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JLabel firstLabel;
	private JButton saveButton;
	private JButton chatButton;
	private JButton loadButton;
	private JButton checkerButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	
	
	public ChatPanel(ChatController appContoller)
	{
		super(); //first line of code is super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		firstLabel = new JLabel("Words in a line.");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		chatField = new JTextField("Talk to the Chatbot here", 50);
		chatPane = new JScrollPane();
		
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 11, SpringLayout.EAST, loadButton);
		
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 145, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 17, SpringLayout.EAST, chatButton);
		
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 6, SpringLayout.EAST, saveButton);
		
		
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 60, SpringLayout.SOUTH, chatField);
		
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.MAGENTA);
		this.add(saveButton);
		this.add(chatPane);
		this.add(chatButton);
		this.add(chatField);
		this.add(checkerButton);
		this.add(loadButton);
		chatArea = new JTextArea("Chat Area", 20, 50);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 24, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 93, SpringLayout.WEST, this);
		add(chatArea);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 11, SpringLayout.EAST, loadButton);
		
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 145, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 17, SpringLayout.EAST, chatButton);
		
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 6, SpringLayout.EAST, saveButton);
		
		
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 60, SpringLayout.SOUTH, chatField);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText(" ");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}
		});
	}
	
	
}