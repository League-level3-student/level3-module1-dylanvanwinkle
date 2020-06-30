package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}

	Random ran = new Random();
	ArrayList<Song> songs = new ArrayList<Song>();
	Song s1 = new Song("demo.mp3");
	Song s2 = new Song("harp.mp3");
JFrame f = new JFrame();
JButton b = new JButton("Surprise Me!");
	public static void main(String[] args) {
		_06_IPodShuffle is = new _06_IPodShuffle();
		is.f.setVisible(true);
		is.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		is.f.add(is.b);
		is.add();
		is.f.pack();
		new _06_IPodShuffle();
	}

	public void randomSong(){
		_06_IPodShuffle is = new _06_IPodShuffle();
		int r = is.ran.nextInt(2);
		is.songs.add(is.s1);
		is.songs.add(is.s2);
		if (r == 0) {
			is.songs.get(0).play();
		} else if (r == 1) {
			is.songs.get(1).play();
		}
	}
public void add() {
	b.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	randomSong();
}
}