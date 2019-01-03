package datastructure;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		List<String> ArmyList = new ArrayList<String>();
		ArmyList.add("General");
		ArmyList.add("Lt General");
		ArmyList.add("Major General");
		ArmyList.add("Brigadier General");
		ArmyList.add("Colonel");

		List<String> NavyList = new ArrayList<String>();
		NavyList.add("Admiral");
		NavyList.add("Vice Admiral");
		NavyList.add("Rear Admiral");
		NavyList.add("Commodore");
		NavyList.add("Captain");

		Map<String, List<String>> institute = new HashMap<String, List<String>>();
		institute.put("Pentagon Military HQ", ArmyList);
		institute.put("US Naval HQ", NavyList);

		System.out.println("Printing HashMap by using For Each Loop :\n");
		for(Map.Entry<String,List<String>> professionalList : institute.entrySet()){
			System.out.println(professionalList.getKey()+" ----> "+professionalList.getValue());
		}
		System.out.println("\n---------------------------------------\n");
		System.out.println("Printing HashMap by using Iterator :\n");
		Iterator<Map.Entry<String,List<String>>> it = institute.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,List<String>> pair = it.next();
			System.out.println(pair.getKey()+" --> "+pair.getValue());
		}
	}

}
