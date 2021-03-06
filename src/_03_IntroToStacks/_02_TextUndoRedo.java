package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel. J Every time a key is pressed,
	 * add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	String wi = "";
	Stack<String> ll = new Stack<String>();
	public static void main(String[] args) {
		_02_TextUndoRedo tur = new _02_TextUndoRedo();

		tur.f.setVisible(true);
		tur.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tur.akl();
		tur.p.add(tur.l);
		tur.f.add(tur.p);
		tur.f.pack();
	}

	public void akl() {
		f.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			wi += ll.pop();
		}else if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
		wi += e.getKeyChar() + "";
		}else {
			ll.push((wi.charAt((wi.length() - 1)) + ""));
			wi = wi.substring(0,(wi.length() - 1));
		}

		l.setText(wi);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
