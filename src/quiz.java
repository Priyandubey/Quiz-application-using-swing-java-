//Author : Priyanshu Dubey
//Platform : Eclipse

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class quiz  extends JFrame{	
	
	int p;
	int randomNum;
	JButton startButton ;
	JButton submit;
	JButton play;
	JTextArea question;
	JTextArea startName;
	JRadioButton option1;
	JRadioButton option2;
	JRadioButton option3;
	JRadioButton option4;
	JLabel name;
	static ArrayList< Question > list;
	JButton proceed;
	JLabel score;
	int corr = 0,total = 0;
	
	
	quiz(){
		startButton = new JButton("Congrats you have won");
		submit = new JButton("Submit");
		question = new JTextArea("Sample Question");
		option1 = new JRadioButton("Option 1");
		option2 = new JRadioButton("Option 2");
		option3 = new JRadioButton("Option 3");
		option4 = new JRadioButton("Option 4");
		proceed = new JButton("Incorrect, proceed here");
		startName = new JTextArea("Enter Your Username");
		name = new JLabel("Sample");
		play = new JButton("Play");
		score = new JLabel("0 / 0");
				
		question.setBackground(Color.orange);
		option1.setBackground(Color.green);
		option2.setBackground(Color.green);
		option3.setBackground(Color.green);
		option4.setBackground(Color.green);
		submit.setBackground(Color.blue);
		proceed.setBackground(Color.white);
		startButton.setBackground(Color.red);
		score.setBackground(Color.pink);
		play.setBackground(Color.GREEN);
		startName.setBackground(Color.MAGENTA);
		
		
		startButton.setBounds(200,250,200,60);
		question.setBounds(100,100,400,70);
		option1.setBounds(100, 190, 170, 70);
		option2.setBounds(330, 190, 170, 70);
		option3.setBounds(100, 280, 170, 70);
		option4.setBounds(330, 280, 170, 70);
		submit.setBounds(250, 400, 100, 50);
		proceed.setBounds(200,500 , 200, 50);
		score.setBounds(10,500,50,40);
		startName.setBounds(200, 200, 200, 60);
		play.setBounds(250,280,100, 40);
		name.setBounds(250, 10, 170, 40);
		
		question.setVisible(false);
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);
		submit.setVisible(false);
		proceed.setVisible(false);
		score.setVisible(false);
		startName.setVisible(false);
		play.setVisible(false);
		name.setVisible(false);
		
		add(startButton);
		add(question);
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(submit);
		add(proceed);
		add(score);
		add(startName);
		add(play);
		add(name);
		
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		group.add(option4);
		
		setLayout(null);
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				startButton.setVisible(false);
				play.setVisible(true);
				startName.setVisible(true);
				
				
			}
		});
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				play.setVisible(false);
				name.setText("Username:- " + startName.getText());
				startName.setVisible(false);
				name.setVisible(true);
				randomNum = ThreadLocalRandom.current().nextInt(0, 17);
				 p = ThreadLocalRandom.current().nextInt(0, 4);
				 boolean[] tak = new boolean[17] ;
				for(boolean s : tak) s = false;
				int min,max;
				if(Math.abs(randomNum - 16) > randomNum + 1) {
					min = randomNum + 1;
					max = 10;
				}
				else {
					min = 0;
					max = randomNum;
				}
				question.setText(list.get(randomNum).prob);
				int a[] = {0,0,0,0};
				a[p] = 1;
				tak[randomNum] = true;
				if(a[0] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option1.setText(list.get(c).ans);
				}else {
					option1.setText(list.get(randomNum).ans);
				}
				if(a[1] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option2.setText(list.get(c).ans);
				}else {
					option2.setText(list.get(randomNum).ans);
				}
				if(a[2] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option3.setText(list.get(c).ans);
				}else {
					option3.setText(list.get(randomNum).ans);
				}
				if(a[3] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option4.setText(list.get(c).ans);
				}else {
					option4.setText(list.get(randomNum).ans);
				}
				
				
				startButton.setVisible(false);
				question.setVisible(true);
				option1.setVisible(true);
				option2.setVisible(true);
				option3.setVisible(true);
				option4.setVisible(true);
				submit.setVisible(true);
				score.setVisible(true);
				
				
			}
		});
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
		
				
				proceed.setVisible(true);
				submit.setVisible(false);
				total++;
				if(option1.isSelected()) {
					
					if(p == 0) {
						option1.setBackground(Color.BLUE);
						proceed.setText("Correct, proceed here");
						corr++;
					}else {
						option1.setBackground(Color.RED);
						proceed.setText("Incorrect, proceed here");
					}
					
				}else if(option2.isSelected()) {
					if(p == 1) {
						option2.setBackground(Color.BLUE);
						proceed.setText("Correct, proceed here");
						corr++;
					}else {
						option2.setBackground(Color.RED);
						proceed.setText("Incorrect, proceed here");
					}
					
				}else if(option3.isSelected()) {
					if(p == 2) {
						option3.setBackground(Color.BLUE);
						proceed.setText("Correct, proceed here");
						corr++;
					}else {
						option3.setBackground(Color.RED);
						proceed.setText("Incorrect, proceed here");
					}
												
				}else if(option4.isSelected()) {
					if(p == 3) {
						option4.setBackground(Color.BLUE);
						proceed.setText("Correct, proceed here");
						corr++;
					}else {
						option4.setBackground(Color.RED);
						proceed.setText("Incorrect, proceed here");
					}							
					
				}
				
				if(total == 10) {
					String l = "You have won";
					if(corr < 4) {
						l = "You have lost";
					}
					startButton.setVisible(false);
					question.setVisible(false);
					option1.setVisible(false);
					option2.setVisible(false);
					option3.setVisible(false);
					option4.setVisible(false);
					submit.setVisible(false);
					score.setVisible(false);
				}
				
				score.setText(corr + " / " + total);
				
				
				if(total == 10) {
					String l = "you have passed";
					if(corr < 5) {
						l = "you have failed"; 
					}
				}
				
				
			}
		});
		proceed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proceed.setVisible(false);
				submit.setVisible(true);
				randomNum = ThreadLocalRandom.current().nextInt(0, 17);
				 p = ThreadLocalRandom.current().nextInt(0, 4);
				 boolean[] tak = new boolean[17] ;
				 for(boolean s : tak) s = false;
				 question.setBackground(Color.orange);
					option1.setBackground(Color.green);
					option2.setBackground(Color.green);
					option3.setBackground(Color.green);
					option4.setBackground(Color.green);
					submit.setBackground(Color.blue);
					proceed.setBackground(Color.white);
					startButton.setBackground(Color.red);
				int min,max;
				if(Math.abs(randomNum - 16) > randomNum + 1) {
					min = randomNum + 1;
					max = 10;
				}
				else {
					min = 0;
					max = randomNum;
				}
				question.setText(list.get(randomNum).prob);
				int a[] = {0,0,0,0};
				a[p] = 1;
				if(a[0] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option1.setText(list.get(c).ans);
				}else {
					option1.setText(list.get(randomNum).ans);
				}
				if(a[1] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option2.setText(list.get(c).ans);
				}else {
					option2.setText(list.get(randomNum).ans);
				}
				if(a[2] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option3.setText(list.get(c).ans);
				}else {
					option3.setText(list.get(randomNum).ans);
				}
				if(a[3] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					while(tak[c]==true) {
						c = ThreadLocalRandom.current().nextInt(min, max);
					}
					tak[c] = true;
					option4.setText(list.get(c).ans);
				}else {
					option4.setText(list.get(randomNum).ans);
				}
				
			}
		});

	}
	
	

	public static void main(String[] args) {
		list = new ArrayList();
		list.add(new Question("Which of the following is the IDE for Java ?", "Eclipse"));
		list.add(new Question("what type of language is Java ?", "OOP"));
		list.add(new Question("what type of language is C ?", "POP"));
		list.add(new Question("what type of language is C++ ?", "OOP & POP"));
		list.add(new Question("what type of data structure is stack ?", "LIFO"));
		list.add(new Question("what type of data structure is queue ?", "FIFO"));
		list.add(new Question("Package which contain Button class ?", "awt"));
		list.add(new Question("Package which contain String class ?", "lang"));
		list.add(new Question("Package which contain ArrayList class ?", "util"));
		list.add(new Question("Keyword used to create a sub-class of a super class ?", "extends"));
		list.add(new Question("Keyword used to inherit methods using interface in a class ?", "implements"));
		list.add(new Question("Fastest sorting Algorithm ?", "QuickSort"));
		list.add(new Question("Class used to take input from user ?", "Scanner"));
		list.add(new Question("A non-Liner Data structure ?", "Tree"));
		list.add(new Question("A Tree with all node having atmost 2 children ?", "Binary Tree"));
		list.add(new Question("Keyword used to declare a variable which can be used any where ?", "public"));
		list.add(new Question("Keyword used to declare a variable which can be used only in a class ?", "private"));
	
		
		quiz q = new quiz();
		
	}

}
