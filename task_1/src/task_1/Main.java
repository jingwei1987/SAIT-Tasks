package task_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import task_1.Programs;

public class Main {
	 public static void main(String[] args) {
		 Programs programs = new Programs();
		 BufferedReader reader;
		 try {
			 reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data.txt"));
			 String line = reader.readLine();
			 while(line != null) {
				 String[] strs = line.split(",");
				 Programs.Program p = programs.new Program(strs[0],
						 Integer.valueOf(strs[1]),
						 strs[2].equals("Available")?true:false);
				 programs.programs.add(p);
				 line = reader.readLine();
			 }
			 reader.close();
		 }catch (IOException e) {
			 e.printStackTrace();
		 }
		 programs.print();
		 System.out.println("");
		 
		 programs.sort(false);
		 programs.print();
		 System.out.println("");
		 
		 programs.sort(true);
		 programs.print();
		 System.out.println("");
		 
		 List<Programs.Program> list = programs.query(1, true);
		 programs.print(list);
		 System.out.println("");
		 
		 list = programs.query(2, false);
		 programs.print(list);
		 System.out.println("");
	 }
}
