package com.excellence.springbootcrudoperationwithsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.springbootcrudoperationwithsecurity.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
