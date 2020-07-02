package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public static void main(String[] args) {
		Stack<String> words = new Stack<String>();
		String a = JOptionPane.showInputDialog("How many words would you like to answer");
		int an = Integer.parseInt(a);
		HangMan hm = new HangMan();
		
		hm.f.setVisible(true);
		hm.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hm.p.add(hm.l);
		hm.f.add(hm.p);
		
		for (int i = 0; i < an; i++) {
			String rw = Utilities.readRandomLineFromFile("dictionary.txt");
			
			if (!words.contains(rw)) {
				words.push(rw);
			}
		}
		String pop = words.pop();
		String blanks;
		for (int i = 0; i < args.length; i++) {	
		}
		hm.l.setText(pop);
	}
}
