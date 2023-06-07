package com.after.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.after.dao.AfDao;
import com.after.model.AfModel;
import com.after.service.AfService;

@Service
public class AFServiceImpl implements AfService{

	@Autowired
	private AfDao afDao;

	@Override
	public AfModel createUSer(AfModel afModel) {
		// TODO Auto-generated method stub
		return this.afDao.save(afModel);
	}

	@Override
	public List<AfModel> getAll() {
		// TODO Auto-generated method stub
		List<AfModel> findAll = this.afDao.findAll();
		return findAll;
	}

	@Override
	public AfModel getSingle(int id) {
		// TODO Auto-generated method stub
		return this.afDao.findById(id).get();
	}

	@Override
	public AfModel update(AfModel afModel) {
		// TODO Auto-generated method stub
		return this.afDao.save(afModel);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.afDao.deleteById(id);
	}
	
	
}
