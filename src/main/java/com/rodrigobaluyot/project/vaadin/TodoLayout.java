package com.rodrigobaluyot.project.vaadin;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
public class TodoLayout extends VerticalLayout{
	
		@Autowired
		TodoRepository repo;
		
		@PostConstruct
		void init() {
			update();
		}
		
		private void update() {
			setTodos(repo.findAll());

		}

		private void setTodos(List<Todo> todos) {
			removeAllComponents();
			
			todos.forEach(todo-> addComponent(new TodoItemLayout(todo)));
			
			
		}

		public void add(Todo todo) {
			repo.save(todo);
			update();
		}

		public void deleteCompleted() {
			repo.deleteByDone(true);
			update();

			
		}
		
		
}
