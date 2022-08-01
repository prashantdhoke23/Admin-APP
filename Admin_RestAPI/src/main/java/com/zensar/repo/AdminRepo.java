package com.zensar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}