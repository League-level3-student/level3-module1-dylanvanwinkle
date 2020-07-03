package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	String pop;
	String blank;
	int lives = 10;

	public void run() {
		Stack<String> words = new Stack<String>();
		String a = JOptionPane.showInputDialog("How many words would you like to answer");
		int an = Integer.parseInt(a);
		addKey();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 200);
		p.add(l);
		f.add(p);

		for (int i = 0; i < an; i++) {
			String rw = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!words.contains(rw)) {
				words.push(rw);
			}
		}
		if (!words.isEmpty()) {
			pop = words.pop();
			System.out.println(pop);
		}
		blank = "";
		for (int i = 0; i < pop.length(); i++) {
			blank += "_";
		}
		l.setText(blank);
	}

	public void addKey() {
		f.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char kh = e.getKeyChar();
		String newBlank = "";
		if (!pop.contains(kh + "")) {
			lives--;
		} else {
			for (int i = 0; i < pop.length(); i++) {
				if (blank.charAt(i) != '_') {
					newBlank += blank.charAt(i);
				} else {
					if (pop.charAt(i) == kh) {
						newBlank += kh;
					} else {
						newBlank += blank.charAt(i);
					}
				}
			}
			blank = newBlank;
			l.setText(blank);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}