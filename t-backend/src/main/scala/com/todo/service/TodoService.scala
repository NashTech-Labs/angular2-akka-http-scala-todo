package com.todo.service

import com.google.inject.Inject
import com.todo.component.TodoComponent

class TodoService @Inject()(todoComponent: TodoComponent) {


  def getTodoList = {
    todoComponent.listTodos()
  }

}
