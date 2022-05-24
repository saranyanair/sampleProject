package com.sample.nace.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.nace.entity.Nace;
import com.sample.nace.model.NaceDataModel;
import com.sample.nace.repo.NaceRepo;
import com.sample.nace.service.NaceService;

@RunWith(SpringRunner.class)
public class NaceServiceTest {

	@InjectMocks
	private NaceService naceService;

	@Mock
	private NaceRepo naceRepo;

	@Before
	public void setUp() {

		Nace nace = new Nace();
		nace.setId(1L);
		nace.setOrderNumber("1A");
		nace.setCode("A");
		nace.setDescription("desc");
		nace.setExcludedItems("Item1");
		nace.setIncludedItems("Item2");
		nace.setIncludedItemsExtn("extn");
		nace.setLevel(1);
		nace.setParent("parent");
		nace.setReference("A123");
		nace.setRuling("ruling");
		
		Nace nace2 = new Nace();
		nace2.setId(2L);
		nace2.setOrderNumber("2A");
		nace2.setCode("A");
		nace2.setDescription("desc");
		nace2.setExcludedItems("Item1");
		nace2.setIncludedItems("Item2");
		nace2.setIncludedItemsExtn("extn");
		nace2.setLevel(1);
		nace2.setParent("parent");
		nace2.setReference("A123");
		nace2.setRuling("ruling");
		
		List<Nace> naceList= new ArrayList<Nace>();
		naceList.add(nace2);
		naceList.add(nace);
		
		Mockito.when(naceRepo.findByOrderNumber(nace.getOrderNumber())).thenReturn(nace);
		 Mockito.when(naceRepo.findAll()).thenReturn(naceList);
	}

	@Test
	public void getNaceByOrderNumber() {
		String orderNumber = "1A";
		NaceDataModel naceDataModel = naceService.retrieveNaceDetails(orderNumber);
		Assert.assertEquals(naceDataModel.getOrderNumber(), orderNumber);
	}

	@Test
	public void saveNaceDetails() {

		List<NaceDataModel> testData = new ArrayList<NaceDataModel>();
		NaceDataModel nace = new NaceDataModel();
		nace.setOrderNumber("Dummy1");
		nace.setCode("A");
		nace.setDescription("desc");
		testData.add(nace);
		ModelMapper modelMapper = new ModelMapper();
		Nace naceEntity = modelMapper.map(nace, Nace.class);
		naceService.saveNaceDetails(testData);
		verify(naceRepo, times(1)).save(naceEntity);
	}

	  @Test
	    public void getAllDetails() {

	        List<NaceDataModel> naceDetails = naceService.getAllNaceDetails();
	        Assert.assertEquals(naceDetails.size(), 2);
	    }
}
