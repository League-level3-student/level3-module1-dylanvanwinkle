package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> ds = new Stack<Double>();
		Random ran = new Random();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			double r = 101 * ran.nextDouble();
			ds.push(r);

		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		JOptionPane.showMessageDialog(null, "You wil give 2 numbers the first one should be smaller than the second \nyou can use decimal numbers."
				+ " Make your numbers between 0 and 100 inclusive.");
	String	a1 = JOptionPane.showInputDialog("Give a number.");
	String	a2 = JOptionPane.showInputDialog("Give a second number.");
	//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		double an1 = Double.parseDouble(a1);
		double an2 = Double.parseDouble(a2);
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		for (int i = 0; i < ds.size(); i++) {
			double dsp = ds.pop();
			if (dsp >= an1 && dsp <= an2  ) {
				System.out.println(dsp);
			}
		}
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	} 
}
