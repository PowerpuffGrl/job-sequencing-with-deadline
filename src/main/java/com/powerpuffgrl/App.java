package com.powerpuffgrl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		int n = 5;
		Job[] jobs = new Job[n];

		jobs[0] = new Job('a', 2, 100);
		jobs[1] = new Job('b', 1, 19);
		jobs[2] = new Job('c', 2, 27);
		jobs[3] = new Job('d', 1, 25);
		jobs[4] = new Job('e', 3, 15);

		printJobScheduling(jobs, n);
	}

	

	public static void printJobScheduling(Job jobs[], int n) {
		// Creating object of Sorted class
		for(Job j:jobs) {System.out.print(j.id);}
		
		Comparator<Job> profitComparator =  Comparator.comparing(Job::getProfit).reversed();
		Comparator<Job> deadlineComparator =  Comparator.comparing(Job::getDeadline).reversed();
		Comparator<Job> comparator = profitComparator.thenComparing(deadlineComparator);
		
		Arrays.sort(jobs,comparator);
		System.out.println();
		for(Job j:jobs) {System.out.print(j.id);}
		System.out.println();
	
		// Creating TreeSet Object
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < n; i++)
			ts.add(i);

		for (int i = 0; i < n; i++) {
			Integer x = ts.floor(jobs[i].deadline - 1);

			if (x != null) {
				System.out.print(jobs[i].id + " ");
				ts.remove(x);
			}
		}
	}

}
