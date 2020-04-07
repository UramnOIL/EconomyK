package com.uramnoil.economyk.core.repository

import com.uramnoil.economyk.core.Account
import java.util.*

interface AccountRepository {
    fun open()
    fun close()

    @ExperimentalUnsignedTypes
    fun new(uuid: UUID, amount: UInt = 0u): Account
    fun find(uuid: UUID): Account
    fun findAll(): List<Account>
    fun update(account: Account)
    fun exists(uuid: UUID): Boolean
    fun delete(account: Account)
}