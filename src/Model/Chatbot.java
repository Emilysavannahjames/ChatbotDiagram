package Model;

public class Chatbot
{
	//Declaration Section
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
		//constructor default
	}
	
	/**
	 * Initializes a name 
	 * @param name or the run
	 */
	
	public Chatbot(String content)
	{
		this.content = content;
	}
	
	public Chatbot(String content, String currentUser, String joke)
	{
		this.content = content;
		this.currentUser = currentUser;
		this.joke = joke;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public String getCurrentUser()
	{
		return currentUser;
	}
	
	public String getJoke()
	{
		return joke;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public void setCurrentUser(String currentUser)
	{
		this.currentUser = currentUser;
	}
	
	public void setJoke(String joke)
	{
		this.joke = joke;
	}
	
}

