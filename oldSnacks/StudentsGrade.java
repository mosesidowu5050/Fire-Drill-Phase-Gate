import java.util.Scanner;

class StudentsGrade {
   public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.print("Enter the number of students: ");
int numberOfStudents = input.nextInt();

System.out.print("Enter the number of subjects: ");
int numberOfSubjects = input.nextInt();
System.out.println("Saving>>>>>>>>>>>>>>>>>" + "\nSaved Successfully");

int[][] studentRecords = new int [numberOfStudents][numberOfSubjects];
int[] studentScores = new int [numberOfStudents];
double[] studentsAverage = new double [numberOfStudents];
int[] positions = new int[numberOfStudents];
//int[] subjectSummary = new int[numberOfSubjects];


for (int totalStudents = 0; totalStudents < numberOfStudents; totalStudents++){
  String studentCount = " " + (totalStudents+1);
    System.out.print("Enter score for student " + studentCount + ": ");

int totalScore = 0;

for (int totalSubjects = 0; totalSubjects < numberOfSubjects; totalSubjects++){
  String subjectCount = " " + (totalSubjects+1);
    System.out.print("\nEnter score for subject " + subjectCount + ": ");
      studentRecords[totalStudents][totalSubjects] = input.nextInt();

while (studentRecords[totalStudents][totalSubjects] < 0 || studentRecords[totalStudents][totalSubjects] > 100){
    System.out.print("Invalid, enter the studnet correct score: ");
    studentRecords[totalStudents][totalSubjects] = input.nextInt();
}

      totalScore += studentRecords[totalStudents][totalSubjects];
      System.out.println("Saving>>>>>>>>>>>>>>>>>" + "\nSaved Successfully");
  }
     studentScores[totalStudents] = totalScore;
     studentsAverage[totalStudents] = (double) totalScore / numberOfStudents;
}

System.out.println();
System.out.println("\n===================================================================");
System.out.printf("%-10s", "STUDENT");

for (int totalSubjects = 0; totalSubjects < numberOfSubjects; totalSubjects++) {
 System.out.printf("%-10s", "SUB " + (totalSubjects + 1));

}

System.out.printf("%-10s%-10s%-10s", "TOTAL", "AVERAGE", "POSITION");
System.out.println("\n===================================================================");



for (int totalStudents = 0; totalStudents < numberOfStudents; totalStudents++){
int studentPosition = 1;
for(int check = 0; check < numberOfStudents; check++){
   if (studentsAverage[totalStudents] < studentsAverage[check]){
        studentPosition++;
  } 
}
positions[totalStudents] = studentPosition;

}


for (int totalStudents = 0; totalStudents < numberOfStudents; totalStudents++){
  System.out.printf("%-10s", "Student " + (totalStudents + 1));

for (int totalSubject = 0; totalSubject < numberOfSubjects; totalSubject++) {
System.out.printf("%-10d", studentRecords[totalStudents][totalSubject]);

}


System.out.printf("%-10d%-10.2f%-10d", studentScores[totalStudents], studentsAverage[totalStudents], positions[totalStudents]);

System.out.println();

}

System.out.println("\n==================================================================");


//[] highestScore = new int[numberOfSubjects];

System.out.println("SUBJECT SUMMARY" + "\nSubject 1");

for (int totalSubject = 0; totalSubject < studentRecords.length; totalSubject++){
int highestScore = 0;
int count = 1;
int counter = 0;


int lowestScore = 0;


for (int check = 1; check < studentRecords.length; check++){
    if(studentRecords[totalSubject][counter] > studentRecords[check][counter]){
         count--;
} else  count++; 

   studentRecords[totalSubject][counter] = studentRecords[check][counter];
   highestScore = count;

}

System.out.printf("Highest Scoring Student is: Student %d%s%d ", highestScore, " Scoring ", studentRecords[totalSubject][counter]);
System.out.println();
 
}






  }
}