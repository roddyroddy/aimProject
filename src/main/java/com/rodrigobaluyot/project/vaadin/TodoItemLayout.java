package com.rodrigobaluyot.project.vaadin;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class TodoItemLayout extends HorizontalLayout {
	private final TextField text;
	private final CheckBox done;
	public TodoItemLayout(Todo todo) {
		done = new CheckBox(); 
		text = new TextField();
		text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
		
		
		
		addComponents(done);
		addComponentsAndExpand(text);
		setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		
		Binder<Todo> binder = new Binder<>(Todo.class);
		binder.bindInstanceFields(this);
		binder.setBean(todo);
	}
	
	
}

	