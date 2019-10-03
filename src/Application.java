/**
 * The application class and main body of code for a program that determines whether a string 
 * is a substring of another
 * Drake Hovsepian
 * Version 1
 * Computer Science
 * Semester 1, Year 2
 */
//imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Application {
	public static void main(String [] args) throws FileNotFoundException{
		//instance variables
		boolean goodStart; //a boolean to help determine whether a legitimate option is being selected (M or F) 
		boolean more; //a boolean that controls whether the program will test another pair of sequences 
		String answer;//the scanned response to the choice between M and F
		String answer2;//the scanned response to the choice of inputting two more sequences
		String fileName;//the name of the text file where sequences are stored
		String firstSequence;//this will be determined to be a subsequence of its partner
		String secondSequence;//this sequence will be compared to the first sequence
		File file;
		Scanner s = new Scanner(System.in);//this scanner scans most of the inputs in the program
		Scanner fileScan;//this scanner scans the inputs for the name of the text file
		
		
     do {
		System.out.print("Would you like to enter sequences manually or from a file? (M/F): ");
		answer = s.next();
		
			if (answer.equals("M") || answer.equals("F")) {
			goodStart = true;
			} else {
			goodStart = false;
			}//this if-else statement controls whether a legitimate input has been given
	} while (goodStart = false); //end do-while loop to choose how sequences will be entered
		
	if (answer.equals("M")) {
		do {
			System.out.print("Enter the first sequence: ");
			firstSequence = s.next();
			System.out.print("Enter the second sequence: ");
			secondSequence = s.next();
			
			ArrayStack firstArray = new ArrayStack(firstSequence.length());
			ArrayStack secondArray = new ArrayStack(secondSequence.length());
			//These two lines create the array-based stacks of equal length to their matched sequences
			
			firstSequence.toLowerCase();
			secondSequence.toLowerCase();
			//These two lines change each character in the sequences to lower-case
			
			for (int i = 0; i < firstSequence.length(); i++) {
				firstArray.push(firstSequence.charAt(i));
			}//end for loop
			
			for (int z = 0; z < secondSequence.length(); z++) {
				secondArray.push(secondSequence.charAt(z));
			}//end for loop
			//These two for loop fill the stacks with characters from the sequences
			
			do {
				if(!firstArray.isEmpty()) {
				if (firstArray.peek() == secondArray.peek()) {
					firstArray.pop();
					secondArray.pop();
				} else {
					secondArray.pop();
				}  //end if-else statement comparing stacks
				}
			} while ( !secondArray.isEmpty() && !firstArray.isEmpty()); //end while loop checking for subsequence
			//This do while loop compares the top elements of both stacks, if they both match, they are both discarded
			//otherwise, only the element from the second stack is discarded
			//This way each character in the first sequence can be matched to one in the second, even if they are not consecutive
			
			if (firstArray.isEmpty() == true) {
				System.out.print(firstSequence + " IS A SUBSEQUENCE OF " + secondSequence + "\n");
			} else {
				System.out.print(firstSequence + " IS NOT A SUBSEQUENCE OF " + secondSequence + "\n");
			}//end if-else statement printing the results of the porgram
			
			System.out.print("Would you like to enter more sequences? (Y/N): ");
			answer2 = s.next();
			//These two lines ask the user if they want to compare two more sequences
			
			if (answer2.equals("Y")) {
				more = true;
			} else {
				more = false;
				System.out.println("<END RUN>");
			}//end if-else statement controlling whether the loop will be run again to compare two more sequences
			
			firstArray.clear();
			secondArray.clear();
			//these two lines ensure the two array-stacks are empty before another round of comparison begins
			
		} while (more = true); //end do-while loop for manual entry
	}
	
	if (answer.equals("F")) {
		
		System.out.print("Enter the name of the file to process: ");
		fileName = s.next();
		try {
			file = new File(fileName);
			fileScan = new Scanner(file);
	    	while (fileScan.hasNextLine()) {
	    	
	    	String fileSequence = fileScan.nextLine(); //This code should read each line of the text file individually
	    	
	    	final String[] splitStringArray = fileSequence.split(",");
	    	String firstFileSequence = splitStringArray[0];
	    	String secondFileSequence = splitStringArray[1];
	    	//These three lines split the line in the text file into two strings, along the comma
	    	//The first string will be the first sequence, and the second string will be the second sequence
	    	
	    	ArrayStack firstFileArray = new ArrayStack(firstFileSequence.length());
			ArrayStack secondFileArray = new ArrayStack(secondFileSequence.length());
			
			firstFileSequence.toLowerCase();
			secondFileSequence.toLowerCase();
			//These two lines change each character in the sequences to lower-case
	    	
	    	for (int x = 0; x < firstFileSequence.length(); x++) {
				firstFileArray.push(firstFileSequence.charAt(x));
			}//end for loop
			
			for (int y = 0; y < secondFileSequence.length(); y++) {
				secondFileArray.push(secondFileSequence.charAt(y));
			}//end for loop
	    	
			do {
				if(!firstFileArray.isEmpty()) {
				if (firstFileArray.peek() == secondFileArray.peek()) {
					firstFileArray.pop();
					secondFileArray.pop();
				} else {
					secondFileArray.pop();
				}  //end if-else statement comparing stacks
				}
			} while ( !secondFileArray.isEmpty() && !firstFileArray.isEmpty()); //end while loop checking for subsequence
			
			if (firstFileArray.isEmpty() == true) {
				System.out.print(firstFileSequence + " IS A SUBSEQUENCE OF " + secondFileSequence + "\n");
			} else {
				System.out.print(firstFileSequence + " IS NOT A SUBSEQUENCE OF " + secondFileSequence + "\n");
			}//end if-else statement printing the results of the program	
	    	
			firstFileArray.clear();
			secondFileArray.clear();
			//these two lines ensure the two array-stacks are empty before another round of comparison begins
	    		
	    	}//end while
	    	
	    }//end try 
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
			//System.out.println("This file does not exist");
			
		}//end catch
		System.out.println("<END RUN>");
	}
	
	
	}//end Main
}//end Application
