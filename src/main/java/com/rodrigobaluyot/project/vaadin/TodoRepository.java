package com.rodrigobaluyot.project.vaadin;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	@Transactional
	void deleteByDone(boolean done);
	
	

}
