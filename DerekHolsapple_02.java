/**
* DerekHolsapple_02 

* This program will test the Student class and the GradeItem class.
* The program will utilize three .txt files to that contain student
   and grade item data.
* The program will import the .txt files, convert each line into an object, 
   and print a message.
* The output message will show a locally created object, the object's classes
   getter methods from the first file, and a comparison output between objects 
   of all the files versus the first file.

* @author Derek Holsapple
* @version 01, CS 2050
* Mac_OS, Intel Core m3, Visual Studio Code

* Abstruse: adj., difficult to comprehend
*  
* "Expect problems and eat them for breakfast" 
* ALFRED MONTAPERT (July 15, 1906 - September 19, 1997)
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


public class DerekHolsapple_02 {

        // Declare student objects
        static Student student;
        static Student student01;
        static Student student02;
        static Student student03;
        // Declarec grade item objects
        static GradeItem gradeItem; 
        static GradeItem gradeItem01;
        static GradeItem gradeItem02;
        static GradeItem gradeItem03;

        // Files that contains the same valid data of a Student and grade item
        static final String INPUT_FILE01 = "Project_02_Input01.txt";
        static final String INPUT_FILE02 = "Project_02_Input02.txt";
        // Files that contains different valid data of a student and grade item
        static final String INPUT_FILE03 = "Project_02_Input03.txt";
      
        static String[] studentArray01;   // Array for File 01 student
        static String[] gradeItemArray01; // Array for File 01 grade item 
        static String[] studentArray02;   // Array for File 02 student
        static String[] gradeItemArray02; // Array for File 02 grade item
        static String[] studentArray03;   // Array for File 03 student
        static String[] gradeItemArray03; // Array for File 03 grade item  

        // String that separates tests with "*"
        static final String separator = ( "\n**************************" 
        + "*****************************************\n" );

// ********************************************************************************    
  /** Main method to run test 1, test 2, and test 3.
  
    * Test 1: Create a local object student and a local object grade item.
               Output the local objects using the toString() method.
               
    * Test 2: Import data from file 'INPUT_FILE01'.
              Use the field arrays to store the data.
              Reference two validation methods from each objects class.
                  Each validation method will use an array as an argument
                  and create a local test object.
              Validate the 'INPUT_FILE01' field arrays. 
              Create a student object and grade item object 
                  from the field arrays.
              Output the student object using the getter methods.
              Output the grade item object using the getter methods. 
                            
    * Test 3: Import data from file 'INPUT_FILE02' and 'INPUT_FILE03'.
              Use the field arrays to store the data.
              Validate the 'INPUT_FILE02' and 'INPUT_FILE03' field arrays.
              Create two student objects and two grade item objects 
                  from the 'INPUT_FILE02' and 'INPUT_FILE03' field arrays.
              Use the equals() method to compare objects from 'INPUT_FILE01' 
                  against 'INPUT_FILE02' and 'INPUT_FILE03'.    
    
    * @throws, FileNotFoundException  -The file does not exist
    * @throws, System.err.            -'STUDENT' is not the first data entry 
    * @throws, System.err.            -'GRADE ITEM' is not the first data entry  
	 
    * @param,  studentArray01     -Array for 'INPUT_FILE01' student
    * @param,  gradeItemArray01;  -Array for 'INPUT_FILE02' grade item 
    * @param,  studentArray02;    -Array for 'INPUT_FILE03' student
    * @param,  gradeItemArray02;  -Array for 'INPUT_FILE01' grade item
    * @param,  studentArray03;    -Array for 'INPUT_FILE02' student
    * @param,  gradeItemArray03;  -Array for 'INPUT_FILE03' grade item 
    
    * @param,  student       -Student object created for test 1
    * @param,  gradeItem     -Grade item object created for test 1
        
    * @param,  student01     -Student object created form 'INPUT_FILE01'
    * @param,  student02     -Student object created form 'INPUT_FILE02' 
    * @param,  student03     -Student object created form 'INPUT_FILE03' 
    * @param,  gradeItem01   -Grade item object created form 'INPUT_FILE01'
    * @param,  gradeItem02   -Grade item object created form 'INPUT_FILE01'
    * @param,  gradeItem03   -Grade item object created form 'INPUT_FILE01'
    
    * @param,  INPUT_FILE01  -String, to store file path
    * @param,  INPUT_FILE02  -String, to store file path
    * @param,  INPUT_FILE03  -String, to store file path
    
    * @param,  input         -String, local variable used to read file
    * @param,  firstLine     -String, local variable storing data
    * @param,  secondLine    -String, local variable storing data

    * @param,  separator      -String, separates tests with "*"
    */ 
    
    public static void main( String[] args ) throws FileNotFoundException , 
                                                    IOException, 
                                                    IllegalArgumentException {
        // instantiate student object
        student = new Student( 
                  "ID12345","Derek", 
                  "Holsapple", "derekhols31@gmail.com");

        // instantiate Grade item object
        gradeItem = new GradeItem(
                  "H5678", 45654, 
                  "My Class Work", "Quiz", 
                  "20181129", 100, 95 );                                               
    
// ********************************************************************************        
// Test1a, Converting student object field to a string
        System.out.println( separator ); 
        System.out.println( "Running Test 1a:\n" );
        
        System.out.println( student.toString() );
        
// ********************************************************************************
// Test1b, Converting grade item object field to a string 
        System.out.println( "\nRunning Test 1b:\n" );
        
        System.out.println( gradeItem.toString() );

// ********************************************************************************
// Test 2 (Pre-work before test 2a and test 2b)

        System.out.println( separator );  
        System.out.println("Running Test 2a:\n"); 

        // Access the 'INPUT_FILE01' and create arrays for student and grade item 
        
        // Try block to import file 'INPUT_FILE01' and 
        // transfer the first and second line into an array
        try {
        
            Scanner input = new Scanner( new File( INPUT_FILE01 ) );
            String firstLine = input.nextLine();
            String secondLine = input.nextLine();
            // Split the string to form arrays from 'INPUT_FILE01'
            gradeItemArray01 = secondLine.split( "," );        
            studentArray01 = firstLine.split( "," );
            // Close the scanner
            input.close();
            } //End try
        // Catch block to throw exception if the file is not found
        catch ( FileNotFoundException e ) {
            System.err.println( "The file " + e.getMessage() );
            } // End catch

// ********************************************************************************        
// TEST2a, Import test file, fill arrays with data, and 
      // display Student data using getter methods
                  
         // Student validation
         // Throws error when "STUDENT" is not the first array element          

         if ( ! studentArray01[0].equals("STUDENT") ) {
            System.err.println("'STUDENT' is not the first data entry in file " 
                              + INPUT_FILE01);    
                  } // End if

         // If 'ADD' is the second data point in line 1 and
         // if no errors from Student constructor
        else if ( ! processStudentData( studentArray01 ) ) {
                  } // End else if
         
        else {   
            // Instantiate student01 constructor
            student01 = new Student( 
                studentArray01[2],studentArray01[3], 
                studentArray01[4], studentArray01[5]);         
            // Test the getter methods to display data from student01    
            System.out.println( student01.getStudentId() ); 
            System.out.println( student01.getFirstName() );      
            System.out.println( student01.getLastName() );
            System.out.println( student01.getEmail() );   
            } // End else
       // } // End if       
// ********************************************************************************
// TEST2b, Import test file, fill arrays with data, and 
       // display GradeItem data using getter methods
         
        System.out.println( "\nRunning Test 2b:\n" );        

         // Grade Item validation           
         // Throws error when "GRADE ITEM" is not the first array element
         if ( ! gradeItemArray01[0].equals( "GRADE ITEM" ) ) {
            System.err.println( "'GRADE ITEM' is not the first data entry in file " 
                              + INPUT_FILE01 );            
                  } // End if
                                 
         // If 'ADD' is the second data point in line 2 
         // If no errors in GradeItem constructor 
        else if ( ! processGradeItemData( gradeItemArray01 ) ) {
                  } // End else if
         
        else {
            // Instantiate gradeItem01 from gradeItemArray01
            gradeItem01 = new GradeItem( 
                gradeItemArray01[2], Integer.parseInt( gradeItemArray01[3] ), 
                gradeItemArray01[4], gradeItemArray01[5],
                gradeItemArray01[6], Integer.parseInt( gradeItemArray01[7] ),
                Integer.parseInt( gradeItemArray01[8] ) );
                     
            // Test the getter methods to display data from gradeItem01    
            System.out.println( gradeItem01.getStudentId() );
            System.out.println( gradeItem01.getGradeItem() );
            System.out.println( gradeItem01.getCourseId() );
            System.out.println( gradeItem01.getItemType() ); 
            System.out.println( gradeItem01.getDate() );
            System.out.println( gradeItem01.getMaxScore() );
            System.out.println( gradeItem01.getActualScore() );
            } // End else
                 
// ********************************************************************************

// Test 3 (Pre-work before test 3a and test 3b)
   // Access the 'INPUT_FILE02' and 'INPUT_FILE03' and fill 
   // arrays for student and grade item. 
        
   // There will be a total of 4 arrays to be filled
      // Create two student objects and validate
      // Create two grade item objects and validate
        
        // Try block to import file 'INPUT_FILE02' and 
        // transfer the first and second line into an array 
                    
        System.out.println( separator );  
        System.out.println( "Running Test 3a:\n" );   

        try {
        
            Scanner input = new Scanner( new File( INPUT_FILE02 ) );
            String firstLine = input.nextLine();
            String secondLine = input.nextLine();
            // Split the string to form arrays from 'INPUT_FILE02'
            gradeItemArray02 = secondLine.split( "," );        
            studentArray02 = firstLine.split( "," );
            // Close the scanner
            input.close();
            } //End try
        // Catch block to throw exception if the file is not found
        catch ( FileNotFoundException e ) {
            System.err.println( "The file " + e.getMessage() );
            } // End catch
        
        // Try block to import file 'INPUT_FILE03' and 
        // transfer the first and second line into an array    
        try {
            Scanner input = new Scanner( new File( INPUT_FILE03 ) );
            String firstLine = input.nextLine();
            String secondLine = input.nextLine();
            // Split the string to form arrays from 'INPUT_FILE03'
            gradeItemArray03 = secondLine.split( "," );        
            studentArray03 = firstLine.split( "," );
            // Close the scanner
            input.close();
            } //End try
        // Catch block to throw exception if the file is not found
        catch ( FileNotFoundException e ) {
            System.err.println( "The file " + e.getMessage() );
            } // End catch  


// ****
// Create student object 2 from INPUT_FILE02 and validate
        // If 'STUDENT' is not the first data point in line 1 throw exception
        if ( ! studentArray02[0].equals( "STUDENT" ) ) {
            System.err.println( "'STUDENT' is not the first data entry of file " 
                              + INPUT_FILE02 );            
            } // End if   
         // If 'ADD' is the second data point in line 1 
         // If no errors from Student constructor
        else if ( ! processStudentData( studentArray02 ) ) {
            } // End else if
         
                  // Create a instance object of student02 from studentArray02
        else {         
            student02 = new Student( 
                studentArray02[2],studentArray02[3], 
                studentArray02[4], studentArray02[5] );
            } // End else

// ****
// Create student object 3 from INPUT_FILE03 and validate
        // If 'STUDENT' is not the first data point in line 1 throw exception
        if ( ! studentArray03[0].equals( "STUDENT" ) ) {
            System.err.println( "'STUDENT' is not the first data entry of file " 
                              + INPUT_FILE03 );            
            } // End if   
         // If 'ADD' is the second data point in line 1 
         // If no errors from Student constructor
         else if ( ! processStudentData( studentArray03 ) ) {
                  } // End else if
               
                  // Create an object student03 from studentArray03
        else {         
            student03 = new Student( 
                studentArray03[2], studentArray03[3], 
                studentArray03[4], studentArray03[5] );
            } // End else
// ****
// Create grade item object 2 from INPUT_FILE02 and validate 
         // If 'GRADE ITEM' is not the first data point in line 2 throw exception    
        if ( ! gradeItemArray02[0].equals( "GRADE ITEM" ) ) {
            System.err.println("'GRADE ITEM' is not the first data entry of file " 
                              + INPUT_FILE02 );            
            } // End if
                                 
         // If 'ADD' is the second data point in line 2 
         // If no errors in GradeItem constructor 
        else if ( ! processGradeItemData( gradeItemArray02 ) ) {
            } // End else if 
                           
         // Create a object gradeItem02 from gradeItemArray02
         else {
             gradeItem02 = new GradeItem( 
                gradeItemArray02[2], Integer.parseInt( gradeItemArray02[3] ), 
                gradeItemArray02[4], gradeItemArray02[5],
                gradeItemArray02[6], Integer.parseInt( gradeItemArray02[7] ),
                Integer.parseInt( gradeItemArray02[8] ) ); 
            } // End else    
// ****
// Create grade item object 3 from INPUT_FILE03 and validate
         // If 'GRADE ITEM' is not the first data point in line 2 throw exception 
         if ( ! gradeItemArray03[0].equals( "GRADE ITEM" ) ) {
            System.err.println("'GRADE ITEM' is not the first data entry of file " 
                               + INPUT_FILE03 );            
            } // End if
                                 
         // If 'ADD' is the second data point in line 2 and
         // If no errors in GradeItem constructor 
         else if ( ! processGradeItemData( gradeItemArray03 ) ) {
            } // End else if      
          
                  // Create a object gradeItem03 from gradeItemArray03
         else {
             gradeItem03 = new GradeItem( 
                gradeItemArray03[2], Integer.parseInt( gradeItemArray03[3] ), 
                gradeItemArray03[4], gradeItemArray03[5],
                gradeItemArray03[6], Integer.parseInt( gradeItemArray03[7] ),
                Integer.parseInt( gradeItemArray03[8] ) );   
            } // End else  
        
// ********************************************************************************

// TEST 3a, Check equals method for two student objects.

        // Test that student01 is equal to student02        
        if ( student01.equals( student02 ) == true ) {
            System.out.println( "Student objects are equal: Student IDs are " + 
                                 student01.getStudentId() + " and " + 
                                 student02.getStudentId() );
            } // End if
        else {
            System.out.println( "Student objects are not equal: Student IDs are " + 
                                 student01.getStudentId() + " and " + 
                                 student02.getStudentId() );
            } // End else  
        
        // Test that student01 is equal to student03               
        if(student01.equals( student03 ) == true ) {
            System.out.println( "Student objects are equal: Student IDs are " + 
                                 student01.getStudentId() + " and " + 
                                 student03.getStudentId() );
            } // End if
        else {
            System.out.println( "Student objects are not equal: Student IDs are " + 
                                 student01.getStudentId() + " and " + 
                                 student03.getStudentId() );                                 
            }// End else
                                                     
// ********************************************************************************
               
// TEST 3b, Check equals method for two grade item objects.
              
        System.out.println( "\nRunning Test 3b:\n" );        
                                    
        // Test that gradeItem01 is equal to gradeItem02              
        if ( gradeItem01.equals( gradeItem02 ) == true ) {
         System.out.println( "Grade item objects are equal: Student IDs are " + 
                                 gradeItem01.getStudentId() + " and " + 
                                 gradeItem02.getStudentId() );
            } // End if
        else {
         System.out.println( "Grade item objects are not equal: Student IDs are " + 
                                 gradeItem01.getStudentId() + " and " + 
                                 gradeItem02.getStudentId() );
            } // End else
        
        // Test that gradeItem01 is equal to gradeItem03              
        if ( gradeItem01.equals( gradeItem03 ) == true ) {
         System.out.println( "Grade item objects are equal: Student IDs are " + 
                                 gradeItem01.getStudentId() + " and " + 
                                 gradeItem03.getStudentId() );
            } // End if
        else {
         System.out.println( "Grade item objects are not equal: Student IDs are " + 
                                 gradeItem01.getStudentId() + " and " + 
                                 gradeItem03.getStudentId() );
            } // End else        
    } // End main method                  

// ********************************************************************************    
	/** Helper method to check validity of student data from an array
   
    * @throws, IllegalArgumentException -if any of the student constructor's 
                                         parameter are not met
    * @throws, System.err.println       -if 'ADD' is not the second element 
                                         of the array
    * @param,  studentArray             -Array argument passed                        
	 * @param,  studentValidate          -local instance of student object created 
                                         to validate argument array
	 * @return, true                     -if student data is valid                                        
	 */                
  private static boolean processStudentData( String[] studentArray )  
                                            throws IllegalArgumentException {
        
        // Check to see if 'ADD' is in the first element of the studentArray
        if ( ! studentArray[1].equals( "ADD" ) ) {
            System.err.println( "'ADD' is not the second data entry of the line" );
            return false; 
            } // End if

        else  {
            try {     
                    Student studentValidate = new Student( 
                         studentArray[2], studentArray[3], 
                         studentArray[4], studentArray[5]);
                } // End try

            catch ( IllegalArgumentException i ) {   
                    System.err.println( i );
                    return false;
                } // End catch

            return true;
         } // End else 
   } // End processStudentData
    
// ********************************************************************************    
  /** Helper method to check validity of grade item data from an array
   
    * @throws, IllegalArgumentException -if any of the grade item constructor's 
                                         parameter are not met
    * @throws, System.err.println       -if 'ADD' is not the second element 
                                         of the array
    * @param,  gradeItemArray           -Array argument passed 
	 * @param,  gradeItemValidate        -local instance of grade item object 
                                         to validate argument array
	 * @return, true                     -if student data is valid                                        
	 */                
  private static boolean processGradeItemData( String[] gradeItemArray ) 
                                                throws IllegalArgumentException{
        
        // Check to see if 'ADD' is in the first element of the gradeItemArray
        if ( ! gradeItemArray[1].equals( "ADD" ) ) {
            System.err.println( "'ADD' is not the second data entry of the line" );
            return false; 
            } // End if

        else {
            try {     
                GradeItem gradeItemValidate = new GradeItem( 
                    gradeItemArray[2], Integer.parseInt( gradeItemArray[3] ), 
                    gradeItemArray[4], gradeItemArray[5],
                    gradeItemArray[6], Integer.parseInt( gradeItemArray[7] ),
                    Integer.parseInt( gradeItemArray[8] ) );
                } // End try

            catch ( IllegalArgumentException i ) {
                System.err.println( i );
                return false;
                } // End catch
            return true;  
            } // End else
    } // End processGradeItemData
} // End class DerekHolsapple_02     