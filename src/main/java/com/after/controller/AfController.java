package com.after.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.after.model.AfModel;
import com.after.service.AfService;

@RestController
@RequestMapping("/af")
@CrossOrigin("*")
public class AfController {

	@Autowired
	private AfService afService;
	
//	@PostMapping("/")
//	public AfModel createUser(@RequestBody AfModel afModel)
//	{
//		return this.afService.createUSer(afModel);
//	}
	
	@PostMapping("/")
	public ResponseEntity<AfModel> createUSer(@RequestBody AfModel afModel)
	{
		AfModel model=null;
		try {
			this.afService.createUSer(afModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(model);
		}
	}
	
	@GetMapping("/all")
	public List<AfModel> getAll()
	{
		List<AfModel> all = this.afService.getAll();
		return all;
	}
	
//	@GetMapping("/all")
//	public ResponseEntity<List<AfModel>> getAll(@RequestBody AfModel afModel)
//	{
//		 List<AfModel> all = this.afService.getAll();
//		 if(all.size()<=0)
//		 {
//			 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(all);
//		 }
//		 return ResponseEntity.status(HttpStatus.FOUND).body(all);
//	}
	
//	@GetMapping("/s/{id}")
//	public ResponseEntity<AfModel> getSigle(@PathVariable("id") int id)
//	{
//		AfModel single = this.afService.getSingle(id);
//		if(single==null)
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(single);
//		}
//		return ResponseEntity.status(HttpStatus.FOUND).body(single);
//	}
	
	@GetMapping("/s/{id}")
	public AfModel getSigle(@PathVariable("id") int id)
	{
		return this.afService.getSingle(id);
	}

	@PutMapping("/up")
	public ResponseEntity<AfModel> updateUser(@RequestBody AfModel afModel)
	{
		AfModel update = this.afService.update(afModel);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
	}
	
	@DeleteMapping("/d/{id}")
	public ResponseEntity<AfModel> deleteUser(@PathVariable("id") int id)
	{
		this.afService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
