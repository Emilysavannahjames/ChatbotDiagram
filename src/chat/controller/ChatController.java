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
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	
}
