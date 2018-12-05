package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		this.appController = app;
		appLayout = new SpringLayout();
		
		firstLabel = new JLabel("Words in a line.");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		
		chatField = new JTextField("Talk to the Chatbot here", 50);
		chatArea = new JTextArea("Chat Area", 20, 50);
		
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
		
		chatPane.setViewportView(chatArea);
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
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, firstLabel, 70, SpringLayout.NORTH, this); 
		appLayout.putConstraint(SpringLayout.EAST, firstLabel, -90, SpringLayout.EAST, this); 
		appLayout.putConstraint(SpringLayout.WEST, firstLabel, 175, SpringLayout.WEST, this); 
		appLayout.putConstraint(SpringLayout.SOUTH, firstLabel, -135, SpringLayout.SOUTH, this); 
	}
	
	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent mouseClick)
					{
						changeBackground();
					}
				});
	}
}