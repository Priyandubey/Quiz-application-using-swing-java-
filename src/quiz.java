//Author : Priyanshu Dubey
//Platform : Eclipse

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JTextArea question;
	JRadioButton option1;
	JRadioButton option2;
	JRadioButton option3;
	JRadioButton option4;
	static ArrayList< Question > list;
	JButton proceed;
	JLabel score;
	int corr = 0,total = 0;
	
	
	quiz(){
		startButton = new JButton("Click To Start Quiz");
		submit = new JButton("Submit");
		question = new JTextArea("We Belong to the species of \n the 21st century");
		option1 = new JRadioButton("Option 1");
		option2 = new JRadioButton("Option 2");
		option3 = new JRadioButton("Option 3");
		option4 = new JRadioButton("Option 4");
		proceed = new JButton("Incorrect, proceed here");
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
		
		
		startButton.setBounds(200,250,200,60);
		question.setBounds(100,100,400,70);
		option1.setBounds(100, 190, 170, 70);
		option2.setBounds(330, 190, 170, 70);
		option3.setBounds(100, 280, 170, 70);
		option4.setBounds(330, 280, 170, 70);
		submit.setBounds(250, 400, 100, 50);
		proceed.setBounds(200,500 , 200, 50);
		score.setBounds(10,500,50,40);
		
		question.setVisible(false);
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);
		submit.setVisible(false);
		proceed.setVisible(false);
		score.setVisible(false);
		
		
		add(startButton);
		add(question);
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(submit);
		add(proceed);
		add(score);
		
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
				 randomNum = ThreadLocalRandom.current().nextInt(0, 10);
				 p = ThreadLocalRandom.current().nextInt(0, 4);
				 boolean[] tak = new boolean[10] ;
				for(boolean s : tak) s = false;
				int min,max;
				if(Math.abs(randomNum - 9) > randomNum + 1) {
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
				
				score.setText(corr + " / " + total);
				
				
			}
		});
		proceed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proceed.setVisible(false);
				submit.setVisible(true);
				randomNum = ThreadLocalRandom.current().nextInt(0, 10);
				 p = ThreadLocalRandom.current().nextInt(0, 4);
				 boolean[] tak = new boolean[10] ;
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
				if(Math.abs(randomNum - 9) > randomNum) {
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
		// TODO Auto-generated method stub
		list = new ArrayList();
		list.add(new Question("Which of the following is the IDE for Java ?", "Eclipse"));
		list.add(new Question("what type of language is Java ?", "OOP"));
		list.add(new Question("what type of language is C ?", "POP"));
		list.add(new Question("what type of language is C++ ?", "OOP & POP"));
		list.add(new Question("what type of data structure is stack ?", "LIFO"));
		list.add(new Question("what type of data structure is queue ?", "FIFO"));
		list.add(new Question("Which company acquired Java from Sun Microsystem ?", "Oracle"));
		list.add(new Question("Package which contain Button class ?", "awt"));
		list.add(new Question("Package which contain String class ?", "lang"));
		list.add(new Question("Package which contain ArrayList class ?", "util"));
		
		quiz q = new quiz();
		
		
	}

}
