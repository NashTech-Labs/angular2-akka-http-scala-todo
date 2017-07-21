package com.todo.component

import com.google.inject.ImplementedBy
import com.todo.component.db.{DBComponent, PostgresDbComponent}
import com.todo.component.mapping.TodoMapping
import com.todo.util.Todo

import scala.concurrent.Future

@ImplementedBy(classOf[TodoPostgresComponent])
trait TodoComponent extends  TodoMapping {this:DBComponent =>

  import driver.api._

  def listTodos(): Future[List[Todo]] = {
    db.run(todoInfo.to[List].result)
  }
}

class TodoPostgresComponent extends TodoComponent with PostgresDbComponent
