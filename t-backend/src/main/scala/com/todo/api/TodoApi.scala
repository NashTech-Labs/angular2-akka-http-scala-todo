package com.todo.api
import io.circe._
import io.circe.syntax._
import io.circe.generic.auto._

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.google.inject.Inject
import com.todo.service.TodoService

import scala.util.{Failure, Success}

class TodoApi @Inject () (todoService: TodoService) {

  val listTodoApi: Route =
    path("todo" / "list") {
      get {
        onComplete(todoService.getTodoList) {
          case Success(data) => complete(data.asJson.noSpaces)
          case Failure(ex) => complete(HttpResponse(StatusCodes.InternalServerError, entity = ex.getMessage))
        }
      }
    }

  val routes = listTodoApi
}
