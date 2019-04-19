package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private SpringLayout appLayout;
	private JLabel firstLabel;
	private JButton saveButton;
	private JButton chatButton;
	private JButton loadButton;
	private JButton checkerButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;
	private ImageIcon saveIcon;
	private ImageIcon loadIcon;
	private ImageIcon chatIcon;
	private ImageIcon checkerIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchIcon;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JPanel buttonPanel;
	
	public ChatPanel(ChatController appController)
	{
		super(); //first line of code is super();
		
		this.appController = appController;
		appLayout = new SpringLayout();
		
		saveIcon = new ImageIcon(getClass().getResource("/chat/view/images/save.png"));
		loadIcon = new ImageIcon(getClass().getResource("/chat/view/images/load.png"));
		chatIcon = new ImageIcon(getClass().getResource("/chat/view/images/chat.png"));
		checkerIcon = new ImageIcon(getClass().getResource("/chat/view/images/search.png"));
		tweetIcon = new ImageIcon(getClass().getResource("/chat/view/images/tweet.png"));
		searchIcon = new ImageIcon(getClass().getResource("/chat/view/images/searchTwitter.png"));
		
		firstLabel = new JLabel("Words in a line.");
		saveButton = new JButton("Save", saveIcon);
		loadButton = new JButton("Load", loadIcon);
		chatButton = new JButton("Chat", chatIcon);
		checkerButton = new JButton("Check Text", checkerIcon);
		tweetButton = new JButton("Send tweet", tweetIcon);
		searchTwitterButton = new JButton("Search tweet", searchIcon);
		chatField = new JTextField("Talk to the Chatbot here", 50);
		buttonPanel = new JPanel(new GridLayout(1,0));
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 17, SpringLayout.SOUTH, chatField);
		chatPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
		chatArea = new JTextArea(30, 50);
		
		
		setupButtonPanel();
		
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
		this.setPreferredSize(new Dimension(1024, 768));
		this.setBackground(Color.MAGENTA);
		buttonPanel.setPreferredSize(new Dimension(900, 150));
		this.add(buttonPanel);
		this.add(chatPane);
		
		this.add(chatField);
		
		
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(chatButton);
		buttonPanel.add(checkerButton);
		buttonPanel.add(tweetButton);
		buttonPanel.add(searchTwitterButton);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if(choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == fileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
			
			else
			{
				result = fileChooser.showOpenDialog(this);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					path = fileChooser.getSelectedFile().getAbsolutePath();
				}
			}
			
			
		}
		return path;
	}
	
	private void setupLayout()
	{
		
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 24, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		
		
		
	
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
		
		saveButton.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent click)
				{
					String chatText = chatArea.getText();
					String path = getPath("save");
					IOController.saveText(appController, path, chatText);
					chatArea.setText("Chat saved!");
				}
		});
	}	
	
}