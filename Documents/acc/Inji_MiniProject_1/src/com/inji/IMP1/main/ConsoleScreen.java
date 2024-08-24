package com.inji.IMP1.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.inji.IMP1.tasks.Task;
import com.inji.IMP1.users.User;

public class ConsoleScreen {
	private Scanner inputSystem;
	
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public int showMainMenu() {
		System.out.println("------To Do List------");
		System.out.println("1. 회원 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 회원 수정");
		System.out.println("5. 할 일 조회");
		System.out.println("6. 할 일 등록");
		System.out.println("7. 할 일 삭제");
		System.out.println("8. 할 일 수정");
		System.out.println("9. 할 일 상태(완료/진행중/미완료) 전환");
		System.out.println("10. 프로그램 종료");
		System.out.println("----------------------");
		System.out.println("번호를 선택하세요 : ");
		return inputSystem.nextInt();
	}
	
	public void printUserResult(String result) {
		System.out.println(result);
	}
	
	public void printUserResult(ArrayList<User> users) {
		for(User user : users) {
			System.out.print(user.getId() + " / ");
			System.out.print(user.getName() + " / ");
			System.out.println(user.getBirth());
			System.out.println("-----------------");
		}
	}
	
	public User showRegUsersMenu() {
		System.out.println("추가할 회원 ID : ");
		String id = inputSystem.next();
		
		System.out.println("추가할 회원 이름 : ");
		String n = inputSystem.next();
		
		System.out.println("추가할 회원 생일 : ");
		String b = inputSystem.next();
		
		return new User(id, n, b);
	}
	
	public User showDeleteUsersMenu() {
		System.out.println("삭제할 회원 ID : ");
		String id = inputSystem.next();
		
		return new User(id);
	}
	
	public User showUpdateUsersMenu() {
		System.out.println("회원 ID : ");
		String id = inputSystem.next();
		
		System.out.println("수정할 회원 이름 : ");
		String n = inputSystem.next();
		
		System.out.println("수정할 회원 생일 : ");
		String b = inputSystem.next();
		
		return new User(id, n, b);
	}
	
	public void printTaskResult(String result) {
		System.out.println(result);
	}
	
	public void printTaskResult(ArrayList<Task> tasks) {
		for(Task task : tasks) {
			System.out.print(task.getUser_id() + " / ");
			System.out.print(task.getNo() + " / ");
			System.out.print(task.getTitle() + " / ");
			System.out.print(task.getDescription() + " / ");
			System.out.print(task.getStatus() + " / ");
			System.out.print(task.getPriority() + " / ");
			System.out.print(task.getStartdate() + " / ");
			System.out.println(task.getDuedate());
			System.out.println("-----------------");
		}
	}
	
	public Task showRegTasksMenu() {
		System.out.println("추가할 할일 제목 : ");
		String t = inputSystem.next();
		
		System.out.println("추가할 할일 세부 설명 : ");
		String d = inputSystem.next();
		
		System.out.println("추가할 할일 상태(완료, 미완료, 진행중) : ");
		String s = inputSystem.next();
		
		System.out.println("추가할 할일 중요도(상, 중, 하) : ");
		String p = inputSystem.next();
		
		System.out.println("추가할 할일 시작 날짜(yymmdd) : ");
		String sd = inputSystem.next();
		
		System.out.println("추가할 할일 종료 날짜(yymmdd) : ");
		String dd = inputSystem.next();
		
		System.out.println("회원 ID : ");
		String id = inputSystem.next();
		
		return new Task(0, t, d, s, p, sd, dd, id);
	}
	
	public Task showDeleteTasksMenu() {
		System.out.println("회원 ID : ");
		String id = inputSystem.next();
		
		System.out.println("삭제할 할일 번호 : ");
		int n = inputSystem.nextInt();
		
		return new Task(id, n);
	}
	
	public Task showUpdateTasksMenu() {
		System.out.println("회원 ID : ");
		String id = inputSystem.next();
		
		System.out.println("수정될 할일 제목 : ");
		String t = inputSystem.next();
		
		System.out.println("수정될 할일 세부 설명 : ");
		String d = inputSystem.next();
		
		System.out.println("수정될 할일 중요도(상, 중, 하) : ");
		String p = inputSystem.next();
		
		System.out.println("수정될 할일 시작 날짜(yymmdd) : ");
		String sd = inputSystem.next();
		
		System.out.println("수정될 할일 종료 날짜(yymmdd) : ");
		String dd = inputSystem.next();
		
		return new Task(id, t, d, p, sd, dd);
	}
	
	public Task showStausTasksMenu() {
		System.out.println("회원 ID : ");
		String id = inputSystem.next();
		
		System.out.println("할일 번호 : ");
		int n = inputSystem.nextInt();
		
		System.out.println("수정될 할일 상태(완료, 미완로, 진행중) : ");
		String s = inputSystem.next();
		
		return new Task(id, n, s);
	}
	
	public String end() {
		String end = "종료합니다";
		inputSystem.close();
		return end;
	}

}
