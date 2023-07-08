//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int C = sc.nextInt();
//        int P = sc.nextInt();
//        ArrayList<Person> contrib = new ArrayList<>();
//        ArrayList<Project> projects = new ArrayList<>();
//        while (C > 0){
//            String name = sc.next();
//            Person p = new Person(name);
//            int n = sc.nextInt();
//            HashMap<String, Integer> con = new HashMap<>();
//            while (n > 0){
//                String lang = sc.next();
//                int lvl = sc.nextInt();
//                con.put(lang, lvl);
//                n--;
//            }
//            p.skill_map = con;
//            contrib.add(p);
//            C--;
//        }
//        while (P > 0){
//            String name = sc.next();
//            int days = sc.nextInt();
//            int score = sc.nextInt();
//            int bestbefore = sc.nextInt();
//            int roles = sc.nextInt();
//            HashMap<String, Integer> map = new HashMap<>();
//            int c = roles;
//            while (c > 0){
//                c--;
//                String lang = sc.next();
//                int lvl = sc.nextInt();
//                map.put(lang, lvl);
//            }
//            Project project = new Project(name, days, score, bestbefore, roles, map);
//            projects.add(project);
//            P--;
//        }
//        for (Project project: projects){
//            int mems = project.roles;
//            for (Person person: contrib){
//                for ()
//            }
//        }
//    }
//}
//class Person{
//    String Name;
//    HashMap<String, Integer> skill_map = new HashMap<>();
//    int assigned = 0;
//    public Person(String name){
//        this.Name = name;
//    }
//}
//
//class Project{
//    String name;
//    int days;
//    int score;
//    int best_before;
//    int roles;
//    int startday;
//    boolean is_done;
//    HashMap<String, Integer> skillreq;
//    public Project(String name, int days, int score, int best_before, int roles, HashMap<String, Integer> skillreq) {
//        this.name = name;
//        this.days = days;
//        this.score = score;
//        this.best_before = best_before;
//        this.roles = roles;
//        startday = 0;
//        is_done = false;
//        this.skillreq = skillreq;
//    }
//}
