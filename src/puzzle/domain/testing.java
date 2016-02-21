package puzzle.domain;

import java.util.Hashtable;

public class testing {
	public static void main(String[] args){
		Hashtable<Integer,Integer> usedSet=new Hashtable<Integer,Integer>(16);
		for(int i=0;i<16;i++){
			usedSet.put(i, i+16);
		}
		System.out.println(usedSet.get(1));
	}

}
