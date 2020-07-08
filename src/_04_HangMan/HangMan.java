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
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	String pop;
	String blank;
	int lives = 10;
	int nw = 0;
	int an = 0;
	Stack<String> words = new Stack<String>();

	public void run() {
		String a = JOptionPane.showInputDialog("How many words would you like to answer");
		an = Integer.parseInt(a);
		nw = an;
		addKey();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 200);
		p.add(l1);
		p.add(l2);
		f.add(p);
		l2.setText("you have " + lives + " live(s) left.");

		for (int i = 0; i < an; i++) {
			String rw = Utilities.readRandomLineFromFile("dictionary.txt");

			if (!words.contains(rw)) {
				words.push(rw);
			}
		}
		snr();
		l1.setText(blank);
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
			l1.setText(blank);
		}
		if (!blank.contains("_")) {
			snr();
		} else {
			nw = 0;
		}
		l2.setText("you have " + lives + " live(s) left.");
		if (lives <= 0) {
			if (nw <= 0) {
				int a = JOptionPane.showConfirmDialog(null, "You Lost.\n Would you like to play again.");
				if (a == JOptionPane.YES_OPTION) {
					run();
				} else {
					System.exit(0);
				}
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void snr() {
		if (!words.isEmpty()) {
			pop = words.pop();
			rb();
			l1.setText(blank);
			lives = 10;
		} else {
			lives = 0;
		}
	}

	public void rb() {
		blank = "";
		for (int i = 0; i < pop.length(); i++) {
			blank += "_";
		}
	}
}