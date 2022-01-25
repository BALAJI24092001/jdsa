package com.balaji.dsa.datastructures.array;

public class ArrayObject{
	public static void main(String[] args) {
		Student[] arr = new Student[2];
		arr[0] = new Student("Balaji", 1);
		arr[1] = new Student("Shyam", 2);
		for(Student i:arr){
			System.out.println("My name is "+i.name + ". With roll number " + i.rollNo);
		}
	}
}


class Student{
	String name;
	int rollNo;
	Student(String name, int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}

}
