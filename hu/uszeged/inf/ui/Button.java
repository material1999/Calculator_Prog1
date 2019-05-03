package hu.uszeged.inf.ui;
import javax.swing.JButton;

public class Button extends JButton{
	private static final long serialVersionUID = 1L;
	private String showing_id;
	private String id;
	
	public Button(String id, String showing_id) {
		super(showing_id);
		this.showing_id = showing_id;
		this.id = id;		
	}
	
	public String getID() {
		return id;
	}
	
	public String getShowingID() {
		return showing_id;
	}
}
