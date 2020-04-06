package com.uramnoil.economyk

import cn.nukkit.IPlayer
import com.uramnoil.economyk.core.repository.AccountRepository
import com.uramnoil.economyk.core.repository.AccountRepositoryFactory

class EconomyService : EconomyK {
    val repository: AccountRepository = AccountRepositoryFactory.repository

    internal fun open() = repository.open()

    internal fun close() = repository.close()

    internal fun save() = repository.save()

    override suspend fun new(player: IPlayer, amount: UInt): Account {
        TODO("Not yet implemented")
    }

    override suspend fun get(player: IPlayer): Account = AccountTranslator.translate(repository.get(player.uniqueId))

    override suspend fun update(account: Account) = repository.update(AccountTranslator.translate(account))

    override suspend fun exists(player: IPlayer): Boolean = repository.exists(player.uniqueId)

    override suspend fun delete(account: Account) = repository.delete(AccountTranslator.translate(account))
}