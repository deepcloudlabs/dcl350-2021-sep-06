package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crm.event.CustomerEvent;

public interface CustomerEventRepository<T> extends JpaRepository<CustomerEvent<T>, String>{

}
