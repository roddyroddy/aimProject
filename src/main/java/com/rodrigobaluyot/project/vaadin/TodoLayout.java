package com.rodrigobaluyot.project.vaadin;

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
