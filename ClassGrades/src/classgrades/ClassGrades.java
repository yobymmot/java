
package classgrades;
import java.util.*;
public class ClassGrades {

    private static Scanner sc = new Scanner(System.in);
    private static  Random rnd = new Random();
    
    public static void main(String[] args) {
        HashMap<String,Integer> studentGrade = new HashMap<String,Integer>();
        while(true){
        System.out.println("Enter the student name with the corresponding Grade");
            System.out.println("Enter 'stop' to stop adding data");
        String name = sc.next().toLowerCase();
        if(name.equals("stop")){
            while(true){
            System.out.println("Enter name of student you want to get data from");
            String student = sc.next();
            int val = studentGrade.get(student);
            System.out.println(student + " got " +val+ " in his test.");
            System.out.println("Do you want to analyse more students?");
            String repeat = sc.next().toLowerCase();
            if(repeat.equals("no")){
                System.exit(0);
            }
            }   
        }
        int score = sc.nextInt();
        studentGrade.put(name,score);
  
            
                
            
            
        }
    }
    }
    

