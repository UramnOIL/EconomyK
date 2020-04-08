package com.uramnoil.economyk.core.infrastructure

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.*

object Accounts : IdTable<UUID>() {
	class Account(id: EntityID<UUID>) : UUIDEntity(id) {
		companion object : UUIDEntityClass<Account>(Accounts)
		var amount by Accounts.amount
	}

	override val id: Column<EntityID<UUID>> = uuid("id").uniqueIndex().entityId()
	val amount = integer("amount")
}