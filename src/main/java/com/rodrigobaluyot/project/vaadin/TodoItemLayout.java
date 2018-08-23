package com.rodrigobaluyot.project.vaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class TodoItemLayout extends HorizontalLayout {

	private static final long serialVersionUID = -1787852325042446118L;
	private final Label text;
//	private final CheckBox done;
	public TodoItemLayout(Todo todo) {
//		done = new CheckBox(); 
		text = new Label();
		text.addStyleName(ValoTheme.LABEL_LARGE);
		
		
		
		addComponents(text);
		addComponentsAndExpand(text);
		setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		
//		Binder<Todo> binder = new Binder<>(Todo.class);
//		binder.bindInstanceFields(this);
//		binder.setBean(todo);
	}
	
	
}

	