package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Player
import com.uramnoil.economyk.core.repository.AccountRepository
import com.uramnoil.economyk.core.repository.AccountRepositoryFactory
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class EconomyService : EconomyK {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Unconfined
    val repository: AccountRepository = AccountRepositoryFactory.repository

    internal fun open() = repository.open()

    internal fun close() {
        job.cancel()
        repository.close()
    }

    internal suspend fun create(player: Player, amount: UInt): Account = withContext(Dispatchers.IO) {
        AccountTranslator(repository.new(player.uniqueId))
    }

    override suspend fun find(player: IPlayer): Account = AccountTranslator(repository.find(player.uniqueId))

    override suspend fun findAll(): List<Account> = repository.findAll().map { AccountTranslator(it) }

    override suspend fun update(account: Account) = repository.update(AccountTranslator(account))

    override suspend fun exists(player: IPlayer): Boolean = repository.exists(player.uniqueId)

    override suspend fun delete(account: Account) = repository.delete(AccountTranslator(account))
}