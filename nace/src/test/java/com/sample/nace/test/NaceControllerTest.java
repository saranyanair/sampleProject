package com.sample.nace.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sample.nace.model.NaceDataModel;
import com.sample.nace.service.NaceService;
import com.sample.nace.web.NaceController;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@WebMvcTest(NaceController.class)
public class NaceControllerTest {
	
	 @Autowired
	 private MockMvc mvc;

	 @MockBean
	 private NaceService naceService;
	  
	 @Test
	 public void retrieveNaceDetails() throws Exception {
	    
		 NaceDataModel naceDataModel=new NaceDataModel();
		 naceDataModel.setCode("A122");
		 naceDataModel.setDescription("desc");
		 naceDataModel.setExcludedItems("Item1");
		 naceDataModel.setIncludedItems("Item1");
		 naceDataModel.setLevel(1);
		 naceDataModel.setOrderNumber("A1");
		 naceDataModel.setParent("Ttem2");
		 naceDataModel.setReferance("Ref");
		 naceDataModel.setRuling("");
		 
		 when(naceService.retrieveNaceDetails("A1")).thenReturn(naceDataModel);
		 
		 mvc.perform(get("/nace/getNaceDetails/A1").
	                contentType(MediaType.APPLICATION_JSON)).
	                  andExpect(status().isOk())
	                    .andExpect(jsonPath("$.order").
	                            value("A1"));
	    }
	 
	 @Test
	    public void saveNaceDetails() throws Exception {

	        
	        NaceDataModel naceDataModel=new NaceDataModel();
			 naceDataModel.setCode("A122");
			 naceDataModel.setDescription("desc");
			 naceDataModel.setExcludedItems("Item1");
			 naceDataModel.setIncludedItems("Item1");
			 naceDataModel.setLevel(1);
			 naceDataModel.setOrderNumber("A1");
			 naceDataModel.setParent("Ttem2");
			 naceDataModel.setReferance("Ref");
			 naceDataModel.setRuling("");
			 
	        mvc.perform(MockMvcRequestBuilders.post("/nace/save").
	                content(asJsonString(naceDataModel))
	                .contentType(MediaType.APPLICATION_JSON).
	                   accept(MediaType.APPLICATION_JSON)).
	                              andExpect(status().isOk());
	    }

	  @Test
	    public void getAllUsers() throws Exception {

		  NaceDataModel naceDataModel=new NaceDataModel();
			 naceDataModel.setCode("A122");
			 naceDataModel.setDescription("desc");
			 naceDataModel.setExcludedItems("Item1");
			 naceDataModel.setIncludedItems("Item1");
			 naceDataModel.setLevel(1);
			 naceDataModel.setOrderNumber("A1");
			 naceDataModel.setParent("Ttem2");
			 naceDataModel.setReferance("Ref");
			 naceDataModel.setRuling("");
			 
			 NaceDataModel naceDataModel2=new NaceDataModel();
			 naceDataModel2.setCode("A122");
			 naceDataModel2.setDescription("desc");
			 naceDataModel2.setExcludedItems("Item1");
			 naceDataModel2.setIncludedItems("Item1");
			 naceDataModel2.setLevel(1);
			 naceDataModel2.setOrderNumber("A1");
			 naceDataModel2.setParent("Ttem2");
			 naceDataModel2.setReferance("Ref");
			 naceDataModel2.setRuling("");
	        
	        List<NaceDataModel> model = new ArrayList<NaceDataModel>();
	        model.add(naceDataModel);
	        model.add(naceDataModel2);
	        
	        when(naceService.getAllNaceDetails()).thenReturn(model);


	        mvc.perform(get("/nace/getAllDetails").
	                contentType(MediaType.APPLICATION_JSON)).
	                  andExpect(status().isOk())
	                  .andExpect(MockMvcResultMatchers.
	                          jsonPath("$.length()").value(2));

	    }
	    
	  
	 public static String asJsonString(final Object obj)
	            throws JsonProcessingException {

	        return new ObjectMapper().writeValueAsString(obj);

	    }

}
