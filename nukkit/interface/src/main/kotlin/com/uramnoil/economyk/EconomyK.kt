package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Server
import com.uramnoil.knukkitutils.plugin.service.getProvider
import kotlinx.coroutines.*
import java.lang.RuntimeException

interface EconomyK : CoroutineScope {


    suspend fun find(player: IPlayer): Account?
    suspend fun findAll(): List<Account>
    suspend fun update(account: Account)
    suspend fun exists(player: IPlayer): Boolean
    suspend fun delete(account: Account)

    fun transaction (block: suspend EconomyK.() -> Unit) {
        launch {
            block.invoke(this@EconomyK)
        }
    }

    fun IPlayer.getMoneyAsync() = async {
        Server.getInstance().serviceManager.getProvider<EconomyK>().provider.find(this@getMoneyAsync)
    }

    @ExperimentalUnsignedTypes
    fun IPlayer.setMoneyAsync(amount: UInt) = async {
        val account = Server.getInstance().serviceManager.getProvider<EconomyK>().provider.find(this@setMoneyAsync) ?: throw RuntimeException("Account not found")
        account.amount = amount
        Server.getInstance().serviceManager.getProvider<EconomyK>().provider.update(account)
    }
}