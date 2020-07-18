
public class Course
{
    private String courseName, courseNumber;
    private int courseGrade;
    private double courseWeight;
    
    /**
     * Constructs a course object with provided parameters
     * @param name
     * @param grade
     * @param weight
     */
    
    public Course (String name, String number, int grade, double weight){
    	courseName = name;
    	courseNumber = number;
    	courseGrade = grade;
    	courseWeight = weight;
    }
    
    //Getter methods to return values of the Course object
    public String getName(){
    	return courseName;
    }
    
    public String getNumber(){
    	return courseNumber;
    }
    
    public int getGrade(){
    	return courseGrade;
    }
    
    public double getWeight(){
    	return courseWeight;
    }
    
    public String toString(){
    	/*return (courseName + " " + courseNumber +
    			"\t" + courseGrade +
    			"%\t" + courseWeight + "\n");*/
    	return ("Course: " + courseName + " " + courseNumber +
    			"\tGrade: " + courseGrade +
    			"%\tWeight: " + courseWeight + "\n");
    }
}