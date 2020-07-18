
public class Assignment {
	private String assignmentName;
	private double assignmentWeight, assignmentGrade;
	
	public Assignment (String name, double grade, double weight){
		assignmentName = name;
		assignmentGrade = grade;
		assignmentWeight = weight;
	}
	
	public String getName(){
		return assignmentName;
	}
	
	public double getWeight(){
		return assignmentWeight;
	}
	
	public double getGrade(){
		return assignmentGrade;
	}
	
	public String toString(){
		return ("Assignment: " + assignmentName +
				"\t\tGrade: " + assignmentGrade +
				"%\tWeight: " + assignmentWeight + "\n");
	}
}
