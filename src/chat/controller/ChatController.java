package chat.controller;

import Model.Chatbot;


import javax.swing.JOptionPane;


public class Chatbot
{

	private Chatbot simpleBot;
	
	public Chatbot()
	{
		simpleBot = new Chatbot();
	}
	
	public void start()
	{
		String userInput = "";
		
		while (!userInput.equalsIgnoreCase("quit"))
		{
			userInput = interactWithChatbot(userInput);
		}
	}
	
	public String interactWithChatbot(String text)
	{
		String output = "";
		String userResponse = JOptionPane.showInputDialog(null, "Hi, what's up?");
		output = simpleBot.processText(userResponse);
		return output;
	}
	
	public String processText(String userText)
	{
		String answer = "";
		answer += "You said: " + userText;
		return answer;
	}
	public Chatbot getChatebot()
	{
		return simpleBot;
	}
	
	
}
