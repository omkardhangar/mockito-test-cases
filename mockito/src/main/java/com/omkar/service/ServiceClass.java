package com.omkar.service;

import java.util.ArrayList;
import java.util.List;

import com.omkar.repo.AppRepository;

public class ServiceClass {

	private AppRepository mockRepo;
	List<String> hindiUsersList = new ArrayList<String>();
	List<String> teluguUsersList = new ArrayList<String>();

	public ServiceClass(AppRepository mockRepo) {
		this.mockRepo = mockRepo;

	}

	public List<String> getAllUsers() {

		return mockRepo.fetchUsers();
	}

	public List<String> getHindiUsers() {
		mockRepo.getHindiUsers();

		List<String> allUsers = getAllUsers();

		for (String user : allUsers) {
			if (user.contains("khan")) {
				hindiUsersList.add(user);

			}
		}

		return hindiUsersList;
	}

	public List<String> getTeluguUsers() {
		mockRepo.getTeluguUsers();

		List<String> allUsers = getAllUsers();

		for (String user : allUsers) {
			if (!user.contains("khan")) {
				teluguUsersList.add(user);

			}
		}
		return teluguUsersList;
	}
	
	public void getTamilUsers() {
		mockRepo.getTamilUsers("kamal hasan");
	}

}
