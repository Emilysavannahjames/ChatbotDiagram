package chat.controller;

import javax.swing.JOptionPane;
import chat.view.ChatFrame;
import chat.model.Chatbot;


public class ChatController
{

	private Chatbot simpleBot;
	
	private ChatFrame appFrame;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
	
	}
	private void close()
	{
		System.exit(0);
	}
	
	public String interactWithChatbot(String text)
	{
		String output = "";
		output += simpleBot.processText(text);
		return output;
	}
	
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
	
	public ChatFrame getAppFrame()
	{
		return appFrame;
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	
}
