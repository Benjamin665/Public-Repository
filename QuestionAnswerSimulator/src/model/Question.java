package model;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String text;
	private List<String> answers = new ArrayList<>();
	
	public Question() {
	}
	
	public Question(String text, List<String> answers) {
		this.setText(text);
		this.setAnswers(answers);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	
}
