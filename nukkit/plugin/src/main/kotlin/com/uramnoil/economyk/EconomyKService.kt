package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Player
import com.uramnoil.economyk.core.repository.AccountRepository
import com.uramnoil.economyk.core.repository.AccountRepositoryFactory
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class EconomyKService : EconomyK {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Unconfined
    val repository: AccountRepository = AccountRepositoryFactory.repository

    internal fun open() = repository.open()

    internal fun close() {
        job.cancel()
        repository.close()
    }

    @ExperimentalUnsignedTypes
    internal fun createAsync(player: Player, amount: UInt): Deferred<Account> = async {
        AccountTranslator(repository.create(player.uniqueId))
    }

    override fun findAsync(player: IPlayer): Deferred<Account?> = async {
        AccountTranslator(repository.find(player.uniqueId))
    }

    override fun findAllAsync(): Deferred<List<Account>> = async {
        repository.findAll().map { AccountTranslator(it) }
    }

    @ExperimentalUnsignedTypes
    override fun updateAsync(account: Account): Deferred<Result<Unit>> = async {
        runCatching {
            repository.update(AccountTranslator(account))
        }
    }

    override fun existsAsync(player: IPlayer): Deferred<Boolean> = async {
        repository.exists(player.uniqueId)
    }

    override fun deleteAsync(account: Account): Deferred<Result<Unit>> = async {
        runCatching {
            repository.delete(AccountTranslator(account))
        }
    }
}