package com.todo.component.mapping

import com.todo.component.db.DBComponent
import com.todo.util.Todo
import slick.lifted.ProvenShape


trait TodoMapping { this: DBComponent =>

  import driver.api._

    class TodoMapping(tag: Tag) extends Table[Todo](tag, "todo"){

      def id:Rep[String] = column[String]("id", O.PrimaryKey)
      def task: Rep[String] = column[String]("task")
      def status:Rep[String] =  column[String]("status")

      def * : ProvenShape[Todo] = (
        id,
        task,
        status
      )<>(Todo.tupled, Todo.unapply)
    }

  val todoInfo = TableQuery[TodoMapping]
}
