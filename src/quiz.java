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
		
		
		startButton.setBounds(100,160,200,40);
		question.setBounds(50,50,300,50);
		option1.setBounds(50, 120, 140, 50);
		option2.setBounds(210, 120, 140, 50);
		option3.setBounds(50, 180, 140, 50);
		option4.setBounds(210, 180, 140, 50);
		submit.setBounds(150, 270, 100, 40);
		proceed.setBounds(100,320 , 200, 40);
		score.setBounds(10,320,50,40);
		
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
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 randomNum = ThreadLocalRandom.current().nextInt(0, 10);
				 p = ThreadLocalRandom.current().nextInt(0, 4);
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
					option1.setText(list.get(c).ans);
				}else {
					option1.setText(list.get(randomNum).ans);
				}
				if(a[1] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					option2.setText(list.get(c).ans);
				}else {
					option2.setText(list.get(randomNum).ans);
				}
				if(a[2] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					option3.setText(list.get(c).ans);
				}else {
					option3.setText(list.get(randomNum).ans);
				}
				if(a[3] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
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
						proceed.setText("Correct proceed here");
						corr++;
					}else {
						option1.setBackground(Color.RED);
					}
					
				}else if(option2.isSelected()) {
					if(p == 1) {
						option2.setBackground(Color.BLUE);
						proceed.setText("Correct proceed here");
						corr++;
					}else {
						option2.setBackground(Color.RED);
					}
					
				}else if(option3.isSelected()) {
					if(p == 2) {
						option3.setBackground(Color.BLUE);
						proceed.setText("Correct proceed here");
						corr++;
					}else {
						option3.setBackground(Color.RED);
					}
												
				}else if(option4.isSelected()) {
					if(p == 3) {
						option4.setBackground(Color.BLUE);
						proceed.setText("Correct proceed here");
						corr++;
					}else {
						option4.setBackground(Color.RED);
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
					option1.setText(list.get(c).ans);
				}else {
					option1.setText(list.get(randomNum).ans);
				}
				if(a[1] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					option2.setText(list.get(c).ans);
				}else {
					option2.setText(list.get(randomNum).ans);
				}
				if(a[2] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
					option3.setText(list.get(c).ans);
				}else {
					option3.setText(list.get(randomNum).ans);
				}
				if(a[3] == 0) {
					int c = ThreadLocalRandom.current().nextInt(min, max);
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
