package type;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
class MyPanel extends Panel implements Runnable,KeyListener {
	int x[]=new int[10];
	int y[]=new int[10];
	char c[]=new char[10];
	int grade=1000;
	public MyPanel(){
		for(int i=0;i<10;i++){
			x[i]=(int)(Math.random()*300);
			y[i]=(int)(Math.random()*50);
			c[i]=(char)(Math.random()*26+97);
		}
	}
	public void paint(Graphics g){
		if(grade>0){
		for(int i=0;i<10;i++){
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman",Font.PLAIN,20));
			g.drawString(new Character(c[i]).toString().toUpperCase(), x[i], y[i]);
		}
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman",Font.PLAIN,20));
		g.drawString("grade:"+grade, 5, 15);
		}
		else{
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman",Font.PLAIN,30));
			g.drawString("GAME OVER", 100, 170);
		}
	}
	public void run(){
		while(grade>0){
			for(int i=0;i<10;i++){
				y[i]+=10;
				if(y[i]>350){
					y[i]=0;
					y[i]=(int)(Math.random()*300);
					c[i]=(char)(Math.random()*26+97);
					grade-=100;
				}
				try{
					Thread.sleep(40);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				repaint();
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		char keyC=e.getKeyChar();
		int start=-1;
		int now=-1;
		for(int i=0;i<10;i++){
			if(keyC==c[i]){
//				y[i]=0;
//				y[i]=(int)(Math.random()*300);
//				c[i]=(char)(Math.random()*26+97);
//				grade+=100;
//				break;
				if(y[i]>start) {
					start=y[i];
					now=i;
				}
			}
			
//			else{
//				start=-1;
//			}
//			if (start==-1){
//				grade-=100;
//			}
		}
		if(now!=-1) {
			y[now]=0;
			x[now]=(int)(Math.random()*300);
			c[now]=(char)(Math.random()*26+97);
			grade+=100;
		}else {
			grade-=100;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
