package com.excellence.springbootcrudapisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.springbootcrudapisecurity.models.UserBatch;

@Repository
public interface UserBatchRepository extends JpaRepository<UserBatch, Long>{

}
