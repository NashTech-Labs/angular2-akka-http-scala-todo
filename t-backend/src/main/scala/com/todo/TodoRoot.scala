package com.todo
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.TodoModul.TodoModule
import com.google.inject.Guice
import com.todo.api.TodoApi
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import net.codingwell.scalaguice.InjectorExtensions._


object TodoRoot extends App {

  val injector = Guice.createInjector(new TodoModule)

  implicit  val actor = ActorSystem("todoActor")
  implicit val matrlzer = ActorMaterializer()
  val todoApi = injector.instance[TodoApi]

  val Port = 9002

  Http().bindAndHandle(todoApi.routes, "localhost", Port)

}
