/**
 * 
 */
package com.sample.nace.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.nace.exceptions.NaceException;
import com.sample.nace.model.NaceDataModel;
import com.sample.nace.service.NaceService;


/**
 * @author saranya
 *
 */
@RestController
@RequestMapping(path = "/nace")
public class NaceController {
	
	@Autowired
	NaceService naceService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> createStudent(@RequestBody List<NaceDataModel> requestData) {
		naceService.saveNaceDetails(requestData);
		return ResponseEntity.noContent().build();
	
	}
	
	@GetMapping("/getNaceDetails/{order}")
	public Optional<NaceDataModel> retrieveNaceDetails(@PathVariable String order) {
		//Optional<Student> student = studentRepository.findById(id);
		Optional<NaceDataModel> responseModel= naceService.retrieveNaceDetails(order);
		if (!responseModel.isPresent()) {
			throw new NaceException("Details not found");
		}
		return responseModel;
	}
}
