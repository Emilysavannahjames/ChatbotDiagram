package chat.controller;

import javax.swing.JOptionPane;

import chat.model.Chatbot;


public class ChatController
{

	private Chatbot simpleBot;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
	}
	
	public void start()
	{
	
	}
	private void close()
	{
		System.exit(0);
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
