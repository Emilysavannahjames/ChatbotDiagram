package Model;
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
	}
	
	public String processText(String userText)
	{
		String answer = "";
		answer += "You said: " + userText;
		return answer;
	}
	
	
	
	
}

