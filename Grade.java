
import java.util.*;
import java.io.*;


public class Grade
{
	private Stack<Assignment> assignmentStack;
	private double sum = 0, maxGrd = 0;
	
    public Grade(Scanner scan) throws FileNotFoundException{
    	String name;
    	double grade, weight;
    	assignmentStack = new Stack();

    	while (scan.hasNext()){
    		name = scan.next();
    		weight = scan.nextDouble();
    		grade = scan.nextDouble();
    		assignmentStack.push(new Assignment(name, grade, weight));
    	}
    	
    	scan.close();
    }

    public void evaluate(){
    	Stack<Assignment> tempStack = (Stack<Assignment>)assignmentStack.clone();
    	Assignment temp;
    	while(!tempStack.isEmpty()){
    		temp = tempStack.pop();
    		sum +=  temp.getGrade() * temp.getWeight()/100;
    		maxGrd += temp.getWeight();
    	}
    }
    
    public String toString(){
    	return (assignmentStack.toString().replace(", ", "").replace("[", "").replace("]", ""));
    }
   
    public double getGPA(){
    	return Math.round(sum * 100.0)/100.0;
    }
    
    public double getMaxG(){
    	return maxGrd;
    }
}
