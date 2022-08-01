package com.zensar.service;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;

import com.zensar.dto.AdminDTO;

public interface AdminService {

    List<AdminDTO> adminList();

    List<AdminDTO> searchByCriteria(String name);

    AdminDTO registerAdmin(AdminDTO admin);

	AdminDTO updateAdmin(int id, AdminDTO data);

	AdminDTO userDetailsById(int id);

	Boolean deleteUserById(int id);

}
