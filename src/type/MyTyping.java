package type;
import java.awt.*;
import javax.swing.*;
public class MyTyping extends JFrame{
	public static void main(String[] ad){
		JFrame f=new JFrame();
		f.setLocationRelativeTo(null);
		f.setSize(400,400);
		f.setTitle("alphabet game");
		MyPanel p=new MyPanel();
		f.add(p);
		f.addKeyListener(p);
		p.addKeyListener(p);
		Thread t=new Thread(p);
		t.start();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
