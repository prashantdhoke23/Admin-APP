package com.zensar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.dto.AdminDTO;
import com.zensar.service.AdminService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
class AdminControllerTest {

	@MockBean
	    AdminService adminService;


	    @Autowired
	    MockMvc mockMvc;

	    @Autowired
	    AdminController adminController;

	    @Autowired
	    ObjectMapper objectMapper;
	    
	    @Test
	    public void testRegisterAdmin() throws Exception {

	        AdminDTO admin = new AdminDTO();
	        admin.setName("prashant");

	        when(this.adminService.registerAdmin(admin)).thenReturn(admin);
	        MvcResult mvcResult = this.mockMvc.perform(post("http://localhost:7779/admin/user")
	                .contentType("application/json").content(objectMapper.writeValueAsString(admin)))
	                .andExpect(status().isCreated()).andReturn();

	        String response = mvcResult.getResponse().getContentAsString();
	        assertEquals(response.contains("name"), true);

	    }

	    @Test
	    public void testSearchByCriteria() throws Exception {
	        List<AdminDTO> adminDTOList = new ArrayList<AdminDTO>();
	        adminDTOList.add(new AdminDTO());
	        adminDTOList.add(new AdminDTO());
	        when(this.adminService.searchByCriteria("prashant")).thenReturn(adminDTOList);

	        MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:7779/admin/")
	                .param("name", "prashant")).andExpect(status().isOk()).andReturn();
	        String response = mvcResult.getResponse().getContentAsString();
	        assertEquals(response.contains("email"), true);

	    }
	    
	    @Test
		public void testuUpdateAdmin() throws Exception {
	    	AdminDTO adminDTO=new AdminDTO();
	    	adminDTO.setId(1);
	    	adminDTO.setName("prashants");
	    	adminDTO.setEmail("prashant23@gmail.com");
			when(this.adminService.updateAdmin(1, adminDTO)).thenReturn(adminDTO);
			MvcResult mvcResult = this.mockMvc
					.perform(put("http://localhost:7779/admin/user/1").contentType("application/json")
							.content(objectMapper.writeValueAsString(adminDTO)))
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("prashants")))
					.andReturn();

			String response = mvcResult.getResponse().getContentAsString();
			assertEquals(response.contains("prashants"), true);

		}
	    
	    @Test
	    public void testUserDetailsById() throws Exception{

	        AdminDTO adminDTO=new AdminDTO();
	        adminDTO.setName("Prashant");
	     

	        when(this.adminService.userDetailsById(1)).thenReturn(adminDTO);

	        MvcResult mvcResult=this.mockMvc.perform(get("http://localhost:7779/admin/user/"+1))
	        .andExpect(status().isOk())
	        .andExpect(content().string(containsString("Prashant")))
	        .andReturn();

	        String response=mvcResult.getResponse().getContentAsString();
	        assertEquals(response.contains("Prashant"),true);
	        }
	    
	    @Test                              
	    public void testAdminList() throws Exception {
	    List<AdminDTO> adminDTO=new ArrayList<>();
	    adminDTO.add(new AdminDTO());
	    adminDTO.add(new AdminDTO());
	    when(this.adminService.adminList()).thenReturn(adminDTO);

	    MvcResult mvcResult=this.mockMvc.perform(get("http://localhost:7779/admin/user")
	    
	    )
	    .andExpect(status().isOk())
	    .andReturn();

	    String response=mvcResult.getResponse().getContentAsString();
	    assertEquals(response.contains("email"),true);
	    }
	    
		@Test									//Service-12
		public void testDeleteUserById() throws Exception{

		
		when(this.adminService.deleteUserById(1)).thenReturn(true);

		MvcResult mvcResult=this.mockMvc.perform(delete("http://localhost:7779/admin/user/"+1)
		)
		.andExpect(status().isOk())
		.andReturn();

		String response=mvcResult.getResponse().getContentAsString();
		assertEquals(response.contains("true"),true);
		}
}
