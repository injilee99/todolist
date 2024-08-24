package com.inji.IMP1.main;

import java.util.ArrayList;

import com.inji.IMP1.tasks.Task;
import com.inji.IMP1.tasks.TaskDAO;
import com.inji.IMP1.users.User;
import com.inji.IMP1.users.UserDAO;

//얘가 MVC 중 C
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		
		int menu;
		User u;
		String result;
		ArrayList<User> users;
		Task t;
		ArrayList<Task> tasks;
		
		while (true) {
			menu = cs.showMainMenu();
			if (menu == 1) {
				users = UserDAO.getUdao().get();
				cs.printUserResult(users);
				
			} else if (menu == 2) {
				u = cs.showRegUsersMenu();
				result = UserDAO.getUdao().reg(u);
				cs.printUserResult(result);
				
			} else if (menu == 3) {
				u = cs.showDeleteUsersMenu();
				result = UserDAO.getUdao().delete(u);
				cs.printUserResult(result);
				
			} else if (menu == 4) {
				u = cs.showUpdateUsersMenu();
				result = UserDAO.getUdao().update2(u);
				cs.printUserResult(result);
				
			} else if (menu == 5) {
				tasks = TaskDAO.getTdao().get();
				cs.printTaskResult(tasks);
				
			} else if (menu == 6) {
				t = cs.showRegTasksMenu();
				result = TaskDAO.getTdao().reg(t);
				cs.printTaskResult(result);
				
			} else if (menu == 7) {
				t = cs.showDeleteTasksMenu();
				result = TaskDAO.getTdao().delete(t);
				cs.printTaskResult(result);
				
			} else if (menu == 8) {
				t = cs.showUpdateTasksMenu();
				result = TaskDAO.getTdao().update2(t);
				cs.printUserResult(result);
			
			} else if (menu == 9) {
				t = cs.showStausTasksMenu();
				result = TaskDAO.getTdao().status2(t);
				cs.printUserResult(result);
			
			} else if (menu == 10) {
				break;
			}
		}	
		cs.end();
	}

}