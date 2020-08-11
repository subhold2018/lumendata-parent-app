package com.xml.sample;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
public class Question {
	@XmlAttribute  
	private int id;  
	@XmlElement  
	private String questionname;  
	@XmlElement  
	private List<Answer> answers;  

	public Question() {}  
	public Question(int id, String questionname, List<Answer> answers) {  
		super();  
		this.id = id;  
		this.questionname = questionname;  
		this.answers = answers;  
	}  

	public int getId() {  
		return id;  
	}  
	public void setId(int id) {  
		this.id = id;  
	}  

	public String getQuestionname() {  
		return questionname;  
	}  
	public void setQuestionname(String questionname) {  
		this.questionname = questionname;  
	}  
	public List<Answer> getAnswers() {  
		return answers;  
	}  
	public void setAnswers(List<Answer> answers) {  
		this.answers = answers;  
	}  
}  