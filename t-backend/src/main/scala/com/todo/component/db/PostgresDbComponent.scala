package com.todo.component.db

import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api.Database

// $COVERAGE-OFF$
trait PostgresDbComponent extends DBComponent {

  val driver = PostgresProfile

  val db: Database = DBConnection.connectionPool
}

object DBConnection {
  val connectionPool = Database.forConfig("db")
}
// $COVERAGE-ON$
