package chat.model;
import java.util.ArrayList;

public class Chatbot
{
	//Declaration Section
	private ArrayList<String> spookyList;
	private ArrayList<String> responseList;
	private String content;
	private String currentUser;
	private String joke;	
	//End of declaration section
	
	/**
	 * Default constructor for a run
	 * Initializes all variables to valid but "bad" values
	 * used for later customization
	 */
	
	public Chatbot()
	{
		this.joke = "Why did the chicken cross the road?";
		this.content = new String("Boring content drab empty blah");
		this.currentUser = new String("This is default user");
		
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		
		buildTheLists();
	}
	
	private void buildTheLists()
	{
		responseList.add("Hello! How are you?");
		responseList.add("Goodbye - no more talking!");
		responseList.add("What is your name?");
		responseList.add("What is your favorite color?");
		responseList.add("Dumbo");
		
		spookyList.add("Happy Halloween!");
		spookyList.add("BOO!!!");
		spookyList.add("What are you dressing up as?");
		spookyList.add("Spooky!");
		spookyList.add("Trick or treat");
		spookyList.add("Have you carved pumpkins yet?");
		spookyList.add("Zombies!");
		spookyList.add("Candy! Yum.");
	}
	
	public String interactWithChatbot(String text)
	{
		String output = "";
		output += simpleBot.processText(text);
		return output;
	}
	
	public String processText(String userText)
	{
		String answer = "";
		
		if(!sentimentChecker(userText))
		{
			answer += "You said: " + userText + "\n";
		}
		else
		{
			answer += "You said the special words. \n";
		}
		
		return answer;
	}
	
	public boolean setimentChecker(String text)
	{
		boolean isValid = false;
		
		if(text!= null && text.length() > 3)
		{
			isValid = true;
		}
		
		return isValid;
	}
	
	public double getSentimentRatioFromTexts(ArrayList<String> texts)
	{
		double ratio = 0.0;
		return ratio;
	}
	
	public boolean spookyChecker(String input)
	{
		if (input.contains("Halloween") || input.contains("BOO") || input.contains("dressing up") || input.contains("Spooky") || input.contains("trick or treat") || input.contains("carved pumpkins") || input.contains("Zombies") || input.contains("Candy Yum"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

