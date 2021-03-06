package com.sample.nace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.nace.entity.Nace;
import com.sample.nace.model.NaceDataModel;
import com.sample.nace.repo.NaceRepo;

@Service
public class NaceService {

	@Autowired
	NaceRepo naceRepo;

	public void saveNaceDetails(List<NaceDataModel> requestData) {

		if (null != requestData && !requestData.isEmpty()) {

			for (NaceDataModel naceModel : requestData) {
				ModelMapper modelMapper = new ModelMapper();
				Nace naceEntity = modelMapper.map(naceModel, Nace.class);
				naceRepo.save(naceEntity);
			}
		}

	}

	public NaceDataModel retrieveNaceDetails(String order) {

		NaceDataModel naceResponseModel = new NaceDataModel();
		Optional<Nace> nace = Optional.ofNullable(naceRepo.findByOrderNumber(order));
		if (nace.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			naceResponseModel = modelMapper.map(nace, NaceDataModel.class);
		}
		return naceResponseModel;

	}
	
	public List<NaceDataModel> getAllNaceDetails(){
		
		List<NaceDataModel> responseModel= new ArrayList<NaceDataModel>();
		List<Nace> responseEntities=naceRepo.findAll();
		if(null!=responseEntities && !responseEntities.isEmpty()) {
			for(Nace nace:responseEntities) {
				ModelMapper modelMapper = new ModelMapper();
				NaceDataModel naceResponseModel =new NaceDataModel();
				naceResponseModel = modelMapper.map(nace, NaceDataModel.class);
				responseModel.add(naceResponseModel);
			}
		}
		return responseModel;
		
	}
}