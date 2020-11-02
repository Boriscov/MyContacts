//This class is the equivalent of the Api Rest call with the annotation @RepositoryRestResource

package com.sid.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.dao.TaskRepository;
import com.sid.entities.Task;

@RestController
public class TaskRestController {
	@Autowired
	private TaskRepository taskRepository;
	
	// Alternative for @autowired
	/*public TaskRestController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}*/

	//Get a task
	@GetMapping("/tasks")
	public List<Task> listTasks(){
		return taskRepository.findAll();
	}
	
	//Add a task
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t) {
		return taskRepository.save(t);
	}
}
