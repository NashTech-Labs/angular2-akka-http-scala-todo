package com.todo.api


import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.google.inject.Inject
import com.todo.service.TodoService

class TodoApi @Inject () (todoService: TodoService) {

  val listTodoApi: Route =
    path("todo" / "list") {
      get {
        complete {
              "todoList" + todoService.getTodoList
        }
      }
    }

  val routes = listTodoApi
}
