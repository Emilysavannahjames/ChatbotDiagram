package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatController app;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController app)
	{
		super();
		this.app = app;
		this.appPanel = new ChatPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 600);
		this.setTitle("Chatbot");
		this.setResizable(true);
		this.setVisible(true);
	}
}


