package com.uramnoil.economyk

import cn.nukkit.IPlayer
import com.uramnoil.economyk.core.repository.AccountRepository
import com.uramnoil.economyk.core.repository.AccountRepositoryFactory

class EconomyService : EconomyK {
    val repository: AccountRepository = AccountRepositoryFactory.repository
    override fun new(player: IPlayer, amount: UInt): Account {
        TODO("Not yet implemented")
    }

    override fun get(player: IPlayer): Account = AccountTranslator.translate(repository.get(player.uniqueId))

    override fun update(account: Account) = repository.update(AccountTranslator.translate(account))

    override fun exists(player: IPlayer): Boolean = repository.exists(player.uniqueId)

    override fun delete(account: Account) = repository.delete(AccountTranslator.translate(account))

    internal fun save() = repository.save()
}