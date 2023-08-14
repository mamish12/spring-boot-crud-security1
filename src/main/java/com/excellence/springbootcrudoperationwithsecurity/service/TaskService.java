package com.excellence.springbootcrudoperationwithsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellence.springbootcrudoperationwithsecurity.models.Task;
import com.excellence.springbootcrudoperationwithsecurity.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	
	@Autowired
	public TaskService(TaskRepository taskRepository)
	{
		this.taskRepository=taskRepository;
	}
	
	//create a new task
	public Task createTask(Task task)
	{
		return taskRepository.save(task);
	}

	//get all task
	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}
	
	//get a specific task by id
	public Optional<Task> getTaskById(Long taskid)
	{
		return taskRepository.findById(taskid);
	}
	
	//update a task
	public Task updateTask(Task task)
	{
		return taskRepository.save(task);
	}
	
	//delete a task by id
	public void deleteTaskById(Long taskId)
	{
		taskRepository.deleteById(taskId);
	}
}
