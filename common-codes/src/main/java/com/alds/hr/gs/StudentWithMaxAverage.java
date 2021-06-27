package com.alds.hr.gs;

import java.util.HashMap;
import java.util.Map;

public class StudentWithMaxAverage {
	
	
	public static void main(String[] args) {
		
		String[][] input = new String[][] {
			{"Jane", "60"},
			{"Frey", "70"},
			{"Myra", "40"},
			{"Frey", "70"},
			{"Jane", "90"},
			{"Jane", "90"}
		};
		
		System.out.println(maxAverage(input));
	}
	
	public static String maxAverage(String[][] input) {
		
		Map<String, Student> data = new HashMap<String, Student>();
		
		if(input!= null) {
			for(int i=0; i< input.length; i++) {
					String name = input[i][0];
					if(!data.containsKey(name)) {
						Student stu = new Student(name, 1, Integer.valueOf(input[i][1]));
						data.put(input[i][0], stu);
					} else {
						data.get(name).setSubjects(data.get(name).getSubjects() +1);
						data.get(name).setTotalScore(data.get(name).getTotalScore() + Integer.valueOf(input[i][1]));				
					}
				}
			}
		
		System.out.println(data);
		
		int maxScore = 0;
		Student result = null;
		for(Map.Entry<String, Student> entry : data.entrySet()) {
			int avgScore = entry.getValue().getTotalScore() / entry.getValue().getSubjects();
			if(maxScore ==0 || avgScore > maxScore) {
				maxScore = avgScore;
				result = entry.getValue();
			}
		}
		return result != null ? result.getName() + " : " + result.getTotalScore()/result.getSubjects() : "Mistake";
	}
	
}


class Student {
	
	String name;
	Integer subjects;
	Integer totalScore;
	
	public Student(String name, Integer subjects, Integer totalScore) {
		super();
		this.name = name;
		this.subjects = subjects;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public Integer getSubjects() {
		return subjects;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setSubjects(Integer subjects) {
		this.subjects = subjects;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", subjects=" + subjects + ", totalScore=" + totalScore + "]";
	}
	
}
 