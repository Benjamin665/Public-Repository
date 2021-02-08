package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Question;

public class Simulator {
	
	private static List<Question> questions = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char option = ' ';
		String lineInput;
		
		
		while(option != 'q') {
			System.out.println("Do you want to (a) add a new question or (b) ask a question? (q to Quit)");
			option = input.nextLine().charAt(0);
			
			if(option == 'a') {
				System.out.println("Please type in the question with the answers in the following format (<question>? ì<answer1>î ì<answer2>î ì<answerX>î):");
				
				lineInput = input.nextLine();
				
				switch(addNewQuestion(lineInput)) {
					case 5:	System.out.println("The new question was added successfully!");
							break;
					case 4:	System.out.println("The new question has to have at least one answer!");
							break;
					case 3:	System.out.println("The text of an answer must not be longer than 255 characters!");
							break;	
					case 2:	System.out.println("The text of a question must not be longer than 255 characters!");
							break;
					case 1: System.out.println("Please use the following format: <question>? ì<answer1>î ì<answer2>î ì<answerX>î!");
							break;
					case 0: System.out.println("Please type something in!");
							break;
				}
			} else if(option == 'b') {
				System.out.println("Please type in the question:");
				
				lineInput = input.nextLine();
				
				Question rq = askQuestion(lineInput);
				
				if(rq != null) {
					for(String str : rq.getAnswers()) {
						System.out.println("- " + str);
					}
				} else {
					System.out.println("The answer to life, universe and everything is 42");
				}
			} else if(option == 'q') {
				System.out.println("See you soon!");
			} else {
				System.out.println("Unknown Commando.");
			}
		}
		
		input.close();
	}
	
	public static int addNewQuestion(String lineInput) {
		String questionText;
		List<String> answers = new ArrayList<>();
		
		if(lineInput.isEmpty()) {		// Keine Eingabe
			return 0;
		} else if (!lineInput.contains("?") || !lineInput.contains("\"")) {	// ? oder " fehlt
			return 1;
		} else {
			questionText = lineInput.substring(0, lineInput.indexOf('?') + 1);
			
			if(questionText.length() > 255) {	// zu groﬂe Frage
				return 2;
			}
			
			for(String str : lineInput.substring(lineInput.indexOf('?') + 1).split("\"")) {
				if(str.length() > 255) {	// zu groﬂe Antwort
					return 3;
				} else if(!str.isBlank()) {
					answers.add(str);
				}
			}
			
			if(answers.isEmpty()) {		// keine Antworten
				return 4;
			}
			
			questions.add(new Question(questionText, answers));
			
			return 5;
		}
	}
	
	public static Question askQuestion(String lineInput) {
		for(Question question : questions) {
			if(question.getText().equals(lineInput)) {
				return question;
			}
		}
		
		return null;
	}
	
	public static void clearQuestions() {
		questions.clear();
	}

}
