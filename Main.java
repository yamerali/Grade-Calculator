
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);		
		Scanner fileScanner;
		boolean again = true;
		
		while (again){
			System.out.println("Enter name of the text file containing your information");
			File fileName = new File("src\\textfiles\\" + scan.nextLine() + ".txt");
			
			fileScanner = new Scanner(fileName);
			
			//check if input file is for a course or a transcript
			if (fileScanner.nextLine().equalsIgnoreCase("C")){
				Grade average = new Grade(fileScanner);
				average.evaluate();
				System.out.println(average.toString() + "\nGrade: " + average.getGPA());
				if (average.getMaxG() != 100)
					System.out.println("\nTHIS COURSE'S MAXIMUM POSSIBLE GRADE IS: " + average.getMaxG());
			} else {
				GPA average = new GPA(fileScanner);
				average.evaluate();
				System.out.println("Would you like to sort courses by grade? [y/n]");
				if (scan.nextLine().equalsIgnoreCase("y"))
					System.out.println(average.gradeSort());
				else
					System.out.println(average.toString());
			}
			fileScanner.close();

			System.out.println();
			System.out.print("Wanna go again? [y/n]");
			again = (scan.nextLine().equalsIgnoreCase("y"));
		}
		scan.close();
	}
}
