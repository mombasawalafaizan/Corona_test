import java.io.*;
import java.util.Scanner;

public class ProjectCorona {
    public static void main(String[] args) throws IOException{
        File file = new File("person_data_corona.txt");
        try(
           Scanner input = new Scanner(file);
        ){
            while(input.hasNext()){
                input.next();
                String name = input.nextLine().trim();
                System.out.println(name);
                input.next();
                int age = input.nextInt();
                System.out.println(age);
                input.next(); input.next();
                String pno = input.nextLine().trim();
                input.next();
                System.out.println(pno);
                boolean health_issues;
                String healthy_str = input.nextLine();
                health_issues = (healthy_str.contains("Yes"))? true : false;
                System.out.println(health_issues);
                if(!health_issues){
                    Person person = new Healthy();
                    person.setAge(age);
                    person.setName(name);
                    person.setPhone_no(pno);
                    createReport(person);
                    if(!input.hasNext()) break;
                    continue;
                }
                boolean travelled = input.nextLine().contains("Yes")?true:false;
                String test1 = input.nextLine();
                String [] symptoms = test1.substring(test1.indexOf(':') + 1).split(",");
                for(int i = 0; i < symptoms.length; i++) 
                    symptoms[i] = symptoms[i].trim();
                boolean pre_med_cond = input.nextLine().contains("Yes")?true:false;
                boolean severe = input.nextLine().contains("Yes")?true:false;
                input.next(); input.next(); input.next(); input.next();
                int days_ill = input.nextInt();
                boolean improvement = input.nextLine().contains("Yes")?true:false;
                boolean nearby_cov = input.nextLine().contains("Yes")?true:false;
                Person p = new Ill(symptoms, severe, pre_med_cond, improvement, days_ill, travelled, nearby_cov);
                if(((Ill)p).probableCoronaVirus()){
                    Person p2 = new COVID_19((Ill)p);
                    p2.setName(name);
                    p2.setAge(age);
                    p2.setPhone_no(pno);
                    createReport(p2);
                }
                else{
                    Person p3 = new CommonColdOrFlu((Ill)p);
                    p3.setName(name);
                    p3.setAge(age);
                    p3.setPhone_no(pno);
                    createReport(p3);
                }
                if(!input.hasNext()) break;
                input.nextLine();
            }
            
            
        }
        
    }
    
    public static void createReport(Person p) throws IOException{
        String nameOfFile []= p.getName().split(" ");
        
        if(p instanceof Healthy){
            try(PrintWriter report = new PrintWriter("Result\\"+nameOfFile[0]+"_"+nameOfFile[1])){
                report.println(((Healthy)p).toString().toUpperCase());
                report.println();
                report.println("What to eat for wellness and health? ");
                report.println(((Healthy)p).whatToEat());
                report.println();
                report.println("OK, good to go, but \n\"PREVENTION IS BETTER THAN CURE\"");
                report.println(((Healthy)p).preventiveMeasures());
            }
        }
        
        else if(p instanceof COVID_19){
            try(PrintWriter report = new PrintWriter("Result\\"+nameOfFile[0]+"_"+nameOfFile[1])){
                report.println(p.toString().toUpperCase());
                report.println();
                report.println(((COVID_19)p).advice());
                report.println();
                report.println("You may have to take some PREVENTIVE MEASURES: ");
                report.println(((COVID_19)p).preventiveMeasures());
            }
        }
        
        else if(p instanceof CommonColdOrFlu){
            try(PrintWriter report = new PrintWriter("Result\\"+nameOfFile[0]+"_"+nameOfFile[1])){
                report.println(p.toString().toUpperCase());
                report.println();
                report.println(((CommonColdOrFlu)p).advice());
                report.println();
                report.println("You may have to take some PREVENTIVE MEASURES: ");
                report.println(((CommonColdOrFlu)p).preventiveMeasures());
            }
        }
        
    }
    
    
}
    