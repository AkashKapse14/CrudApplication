package com.after.service;

import java.util.List;

import com.after.model.AfModel;

public interface AfService {

	public AfModel createUSer(AfModel afModel);
	
	public List<AfModel> getAll();
	
	public AfModel getSingle(int id);
	
	public AfModel update(AfModel afModel);
	
	public void delete(int id);
}
