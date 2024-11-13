package api.endpoints;

import java.util.LinkedHashSet;

public class Test2 {
public static void main(String[] args) {
			String name ="Nitesh kumar Jha one of the good ";
			name = name.toLowerCase();
			char ch[]=name.toCharArray();
			LinkedHashSet<Character> li = new LinkedHashSet<Character>();
			for(int i=0;i<ch.length;i++)
			{
				li.add(ch[i]);
			}
			for(Character dd: li)
			{
				if(dd !=' ') {
				int count =0;
				for(int j=0;j<ch.length;j++)
				{
					if(dd == ch[j]) {
						count++;
						
					}
				}
				System.out.println("Count of character " +dd +" = " +count);
				}
			}
}
}
