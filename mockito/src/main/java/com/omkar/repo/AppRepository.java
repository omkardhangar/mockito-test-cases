package com.omkar.repo;

import java.util.ArrayList;
import java.util.List;

public interface AppRepository {
	
	public List<String> fetchUsers();
	public void getHindiUsers();
	public void getTeluguUsers();
	public void getTamilUsers(String user);



}
