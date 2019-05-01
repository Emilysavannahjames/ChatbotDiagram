package chat.controller;

import javax.swing.JOptionPane;

import chat.view.ChatFrame;
import chat.model.*;




public class ChatController
{

	private Chatbot simpleBot;
	private ChatTwitter myTwitter;
	
	private ChatFrame appFrame;
	
	public ChatController()
	{
		simpleBot = new Chatbot();
		myTwitter = new ChatTwitter(this);
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
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	public String findWords(String user)
	{
		String results = myTwitter.getMostCommonWord(user);
		return results;
	}
	
	
}
