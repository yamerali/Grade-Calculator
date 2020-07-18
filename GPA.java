
import java.util.*;
import java.io.*;


public class GPA
{
	private Stack<Course> courseStack;
	private double sum = 0;			//the sum of grades
	private double credits = 0;			//the number of half credits taken
	
    public GPA(Scanner scan) throws FileNotFoundException{
    	String name, number;
    	int grade;
    	double weight;
    	courseStack = new Stack();

    	while (scan.hasNext()){
    		name = scan.next();
    		if (name.equals("#")) break;
    		number = scan.next();
    		grade = scan.nextInt();
    		weight = scan.nextDouble();
    		courseStack.push(new Course(name, number, grade, weight));
    	}
    	
    	scan.close();
    }

    public void evaluate(){
    	Stack<Course> tempStack = (Stack<Course>)courseStack.clone();
    	Course temp;
    	while(!tempStack.isEmpty()){
    		temp = tempStack.pop();
    		sum +=  temp.getGrade() * 2 * temp.getWeight();
    		credits += 2 * temp.getWeight();
    	}
    }
    
    public String toString(){
    	return (courseStack.toString().replace(", ", "").replace("[", "").replace("]", "")
    			+ "\nAverage is " + getGPA() + " over " + getCredits() + " credits.");
    }
    
    public String gradeSort(){
    	Stack<Course> tempStack = (Stack<Course>)courseStack.clone();
    	Stack<Course> sortedStack = new Stack();
    	Course temp;
    	String s = "";
    	while(!tempStack.isEmpty()){
    		temp = tempStack.pop();
    		while(!sortedStack.isEmpty() && sortedStack.peek().getGrade() > temp.getGrade()) {
                tempStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
    	}
    	
    	while(!sortedStack.isEmpty()){
    		s = sortedStack.pop().toString() + s;
    	}
    	return (s + "\nAverage is " + getGPA() + " over " + getCredits() + " credits.");
    }
        
    public double getGPA(){
    	return Math.round(sum/credits * 100.0)/100.0;
    }
    
    public double getCredits(){
    	return (credits/2);
    }
}
