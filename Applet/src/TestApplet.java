import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestApplet extends Applet implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1889780156567096538L;
	StringBuffer strbuffer = new StringBuffer("Click Me");
	
	public void init(){
		addMouseListener(this);
	}
	public void paint(Graphics g){
		
		g.drawString(strbuffer.toString(), 100, 100);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		strbuffer.append("Good!");
		repaint();		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
