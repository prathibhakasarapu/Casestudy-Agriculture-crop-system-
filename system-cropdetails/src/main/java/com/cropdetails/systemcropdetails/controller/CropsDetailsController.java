package com.cropdetails.systemcropdetails.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cropdetails.systemcropdetails.model.CropDetails;
import com.cropdetails.systemcropdetails.repo.CropDetailsRepo;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CropsDetailsController {
	
	@Autowired
   CropDetailsRepo repo;
	
	@RequestMapping(value="/crop",method=RequestMethod.GET)
	public List<CropDetails> getAllCropsDetails(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/crop/{id}",method=RequestMethod.GET)
	  public Optional<CropDetails> getCropsDetails(@PathVariable String id) {
		return repo.findById(id);
	  }
	
	@RequestMapping(value="/farmerCrop/{farmerId}",method=RequestMethod.GET)
	  public List<CropDetails> getByFarmerId(@PathVariable String farmerId) {
		return repo.findByFarmerId(farmerId);
	  }
	

	  @RequestMapping(value="/crop",method=RequestMethod.POST)
	  public void addCropDetails(@RequestBody CropDetails crops) {
		  repo.insert(crops);
	  }

	  @RequestMapping(value="/crop/{id}",method=RequestMethod.PUT)
	  public void updateCropsDetails(@PathVariable String id, @RequestBody CropDetails crops) {
		  repo.save(crops);
	  }

	  @RequestMapping(value="/crop/{id}",method=RequestMethod.DELETE)
	  public void deleteCropsDetails(@PathVariable String id) {
	    repo.deleteById(id);
	  }
}
