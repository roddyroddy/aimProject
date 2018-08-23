package com.rodrigobaluyot.project.vaadin;

import java.util.Date;

import com.vaadin.annotations.Push;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
//@ViewScope
@Push
public class AimUI extends UI {
	
	private static final long serialVersionUID = 1537035658309537468L;

	private VerticalLayout root;
	
	
	TodoLayout todoLayout = new TodoLayout();
	
	
	@Override
	protected void init(VaadinRequest request) {
		setupLayout();
		addHeader();
		addForm();
		addTodoList();
//		addDeleteButton();
		
	}
	
	private void setupLayout() {
		root = new VerticalLayout();
		root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		
		setContent(root);
	}
	
	private void addHeader() {
		Label header = new Label("Aim");
		header.addStyleNames(ValoTheme.LABEL_H1);
		root.addComponent(header);
		
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					getUI().access(new Runnable() {
						
						@Override
						public void run() {
							header.setCaption(new Date().toString());;
							
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			};
			
		};
		
		thread.start();
	}
	private void addForm() {
		HorizontalLayout formLayout = new HorizontalLayout();
		formLayout.setWidth("80%");
		
		TextField task = new TextField();
		Button add = new Button("");
		add.addStyleName(ValoTheme.BUTTON_PRIMARY);
		add.setIcon(VaadinIcons.PLUS);
		
		formLayout.addComponentsAndExpand(task);
		formLayout.addComponents(add);
		
		add.addClickListener(click->{
			todoLayout.add(new Todo(task.getValue()));
			task.clear();
			task.focus();
			
		});
		task.focus();
		add.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		
		root.addComponent(formLayout);
		root.setSizeFull();
		root.setComponentAlignment(formLayout, Alignment.BOTTOM_CENTER);
		
	}
	
	
	
	private void addTodoList() {
		root.addComponent(todoLayout);
		
	}
//	private void addDeleteButton() {
//		root.addComponent(new Button("Delete Completed", click -> {
//			todoLayout.deleteCompleted();
//		}));
//		
//	}

	
	
	
	
//	stuff below is all the red*************************
	
//	WebSocketClient client = new StandardWebSocketClient();
//	 
//	WebSocketStompClient stompClient = new WebSocketStompClient(client);
//	stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//	 
//	StompSessionHandler sessionHandler = new MyStompSessionHandler();
//	stompClient.connect("/topic/greetings", sessionHandler);
//	 
//	new Scanner(System.in).nextLine(); // Don't close immediately.
//	
//	
//	
//	
}
