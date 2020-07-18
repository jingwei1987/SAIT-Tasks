package task_1;
import java.util.*;

public class Programs {
	
	public class Program{
		public String title;
		public int priority;
		public boolean status;
		
		public Program(String title, int priority, boolean status) {
			this.title = title;
			this.priority = priority;
			this.status = status;
		}
	}
	
	public List<Program> programs;
	
	public Programs() {
		programs = new ArrayList<Program>();
	}
	
	public Programs(List<Program> programs) {
		programs = programs;
	}
	
	public void print() {
		for(Program p : programs) {
			System.out.print(p.title);
			System.out.print(", ");
			if(p.priority==1)
				System.out.print("High");
			else if(p.priority==2)
				System.out.print("Medium");
			else if(p.priority==3)
				System.out.print("Low");
			System.out.print(", ");
			System.out.print(p.status?"Available":"Not Available");
			System.out.println("");
		}
	}
	
	public void print(List<Program> list) {
		for(Program p : list) {
			System.out.print(p.title);
			System.out.print(", ");
			if(p.priority==1)
				System.out.print("High");
			else if(p.priority==2)
				System.out.print("Medium");
			else if(p.priority==3)
				System.out.print("Low");
			System.out.print(", ");
			System.out.print(p.status?"Available":"Not Available");
			System.out.println("");
		}
	}
	
	public void sort(boolean desc) {
		//quick sort
		sort(programs, 0, programs.size()-1, desc);
		
	}
	
	private void sort(List<Program> list, int start, int end, boolean desc) {
		if(start>=end) return;
		int i = start;
		int j = end;
		Program a = list.get(start);
		while(true) {
			while(i<j) {
				if(!desc && list.get(j).priority<a.priority || 
					(desc && list.get(j).priority>a.priority)) {
					Program tmp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, tmp);
					break;
				}
				j--;
			}
			
			while(i<j) {
				if(!desc && list.get(i).priority>a.priority ||
					(desc && list.get(i).priority<a.priority)) {
					Program tmp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, tmp);
					break;
				}
				i++;
			}
			if(i==j) {
				sort(list, start, i-1, desc);
				sort(list, i+1, end, desc);
				return;
			}
		}
	}
	
	public List<Program> query(int priority, boolean status) {
		List<Program> res = new ArrayList<Program>();
		for(Program p : programs) {
			if(p.priority == priority && p.status == status) {
				res.add(p);
			}
		}
		return res;
	}
}
