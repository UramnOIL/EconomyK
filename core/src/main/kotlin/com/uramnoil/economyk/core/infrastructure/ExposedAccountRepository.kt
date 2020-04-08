package com.uramnoil.economyk.core.infrastructure

import com.uramnoil.economyk.core.Account
import com.uramnoil.economyk.core.repository.AccountRepository
import org.jetbrains.exposed.sql.Database
import java.util.*

class ExposedAccountRepository : AccountRepository {
	override fun open() {
		Database.connect("jdbc:h2:mem:test", "org.h2.Driver")
	}

	override fun close() {
		TODO("Not yet implemented")
	}

	@ExperimentalUnsignedTypes
	override fun create(uuid: UUID, amount: UInt): Account {
		TODO("Not yet implemented")
	}

	override fun find(uuid: UUID): Account {
		TODO("Not yet implemented")
	}

	override fun findAll(): List<Account> {
		TODO("Not yet implemented")
	}

	override fun update(account: Account) {
		TODO("Not yet implemented")
	}

	override fun exists(uuid: UUID): Boolean {
		TODO("Not yet implemented")
	}

	override fun delete(account: Account) {
		TODO("Not yet implemented")
	}
}