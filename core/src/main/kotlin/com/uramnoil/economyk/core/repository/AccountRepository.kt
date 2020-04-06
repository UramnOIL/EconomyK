package com.uramnoil.economyk.core.repository

import com.uramnoil.economyk.core.Account
import java.util.*

interface AccountRepository {
    @ExperimentalUnsignedTypes
    fun new(uuid: UUID, amount: UInt = 0u): Account
    fun get(uuid: UUID): Account
    fun update(account: Account)
    fun exists(uuid: UUID): Boolean
    fun delete(account: Account)
    fun save()
}