package com.lti.exam;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {
	
	public static List<Question> loadQuestionOnJava() {
		
		QuestionBank qb =  new QuestionBank();
		
		Subject s = new Subject();
		s.setName("Java");
		qb.addNewSubject(s);
		
		Question q = new Question();
		q.setQuestion("What is G1 in Java");
		
		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("G1 is a garbage Collector",true));
		ops.add(new Option("G1 is a name for Jeevan",false));
		ops.add(new Option("G1 is the name of a spy agency",false));
		ops.add(new Option("G1 is the sequel of Ra.one",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
	
		q = new Question();
		q.setQuestion("What is a class");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("class is used in oop to describe one or more objects ",true));
		ops.add(new Option("class is a template",false));
		ops.add(new Option("class is a instance of object",false));
		ops.add(new Option("class is a blue print of object",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		q = new Question();
		q.setQuestion("Which of these have highest precedence");
		
		ops = new ArrayList<Option>();
		ops.add(new Option("++ ",false));
		ops.add(new Option("*",false));
		ops.add(new Option(">>",false));
		ops.add(new Option("()",true));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
	
		q = new Question();
		q.setQuestion("Which of these statements are incorrect?");
	
		ops = new ArrayList<Option>();
		ops.add(new Option("equal to operator has least precedence ",false));
		ops.add(new Option("brackets have highest precedence",false));
		ops.add(new Option("division operator has higher precedence than multiplication operator",true));
		ops.add(new Option("addition operator and subtraction operator have equal precedence",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
	
		q = new Question();
		q.setQuestion("What is the numerical range of a char data type in java");
	
		ops = new ArrayList<Option>();
		ops.add(new Option("-128 to 127 ",false));
		ops.add(new Option("0 to 65535",true));
		ops.add(new Option("0 to 256",false));
		ops.add(new Option("0 to 32767",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		return qb.getQuestionsFor(s); 
	}

}
