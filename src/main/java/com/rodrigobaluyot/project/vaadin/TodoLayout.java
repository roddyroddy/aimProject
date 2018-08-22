package com.rodrigobaluyot.project.vaadin;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.VerticalLayout;

//@SpringComponent
public class TodoLayout extends VerticalLayout{
	

	private static final long serialVersionUID = -2947239020980507475L;

		public void add(Todo todo) {
//			repo.save(todo);
//			update();
			
			getUI().access(() -> addComponent(new TodoItemLayout(todo)));
			
			
			
		}

		
		
}
