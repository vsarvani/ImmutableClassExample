package com.package1;

import java.util.ArrayList;
import java.util.List;


public final class ImmutableExample {
	private final int houseNumber;
	private final String houseOwner;
	private final ArrayList<String> houseMembers;
	public int getHouseNumber() {
		return houseNumber;
	}
	public String getHouseOwner() {
		return houseOwner;
	}
	public ArrayList<String> getHouseMembers() {
/*return houseMembers; 
		perform deepcopy to makesure we dont give direct reference to original object */
       return (ArrayList<String>) houseMembers.clone();
	}
	
	public ImmutableExample(int hNo,String hOwner,ArrayList<String> hMembers){
		this.houseNumber=hNo;
		this.houseOwner=hOwner;
		ArrayList<String> hMem= new ArrayList<String>();
		for(int i=0;i<hMembers.size();i++){
		 String list = hMembers.get(i);
		hMem.add(list);
	
		}
		this.houseMembers=hMem;
	}
	
	public static void main(String[] args) {
		int i=662;
		String s="Sarvani";
		ArrayList<String> s1=new ArrayList<String>();
		s1.add("Vennala");
		s1.add("Salma");
		s1.add("Abc");
		ImmutableExample ie = new ImmutableExample(i,s,s1);
		System.out.println("performing deep copy");
		System.out.println("housenumber is "+ ie.getHouseNumber() );
		System.out.println("houseowner is "+ ie.getHouseOwner());
		System.out.println("housemembers are "+ ie.getHouseMembers());
		
// checking whether we can change the values or not
		i=112;
		s="vani";
		ArrayList<String> s2 = ie.getHouseMembers();
		s2.add("lucky");
		System.out.println("after modifying data");
		System.out.println("house number after modification "+ ie.getHouseNumber());
		System.out.println("house owner after modification "+ ie.getHouseOwner());
	    System.out.println("house members are "+ ie.getHouseMembers());
	}

}
