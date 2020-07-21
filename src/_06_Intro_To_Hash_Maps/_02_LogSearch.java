package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> ls = new HashMap<Integer, String>();
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b1 = new JButton("Add Entry");
	JButton b2 = new JButton("Search by ID");
	JButton b3 = new JButton("View List");
	JButton b4 = new JButton("");

	public void run() {
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		f.add(p);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String a = JOptionPane.showInputDialog("Please put in the user's ID.");
			String a2 = JOptionPane.showInputDialog("Please put in the user's name.");
			int an = Integer.parseInt(a);
			ls.put(an, a2);
		}
		if (e.getSource() == b2) {
			String a = JOptionPane.showInputDialog("Please put in the user's ID.");
			int an = Integer.parseInt(a);
			if (ls.containsKey(an)) {
				JOptionPane.showMessageDialog(null, ls.get(an));
			} else {
				JOptionPane.showMessageDialog(null, "That key does not exist.");
			}
		}
		if (e.getSource() == b3) {
			String he = "";
			for (Entry<Integer, String> set : ls.entrySet()) {
				he += "ID: " + set.getKey() + " Name: " + set.getValue() + "\n";
			}
			JOptionPane.showMessageDialog(null, he);
		}
	}
}
