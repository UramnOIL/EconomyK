package com.uramnoil.economyk

import cn.nukkit.IPlayer
import cn.nukkit.Server
import com.uramnoil.knukkitutils.plugin.service.getProvider
import kotlinx.coroutines.*
import java.lang.Exception

interface EconomyK : CoroutineScope {
    fun findAsync(player: IPlayer): Deferred<Account?>
    fun findAllAsync(): Deferred<List<Account>>
    fun updateAsync(account: Account): Deferred<Result<Unit>>
    fun existsAsync(player: IPlayer): Deferred<Boolean>
    fun deleteAsync(account: Account): Deferred<Result<Unit>>

    fun transaction (block: suspend EconomyK.() -> Unit) {
        launch {
            block.invoke(this@EconomyK)
        }
    }

    @ExperimentalUnsignedTypes
    fun IPlayer.getMoneyAsync(): Deferred<Result<UInt>> = async {
        val account = Server.getInstance().serviceManager.getProvider<EconomyK>().provider.findAsync(this@getMoneyAsync).await()
        return@async if(account != null) {
            Result.success(account.amount)
        } else {
            Result.failure(Exception("Account not exist"))
        }
    }

    @ExperimentalUnsignedTypes
    fun IPlayer.setMoneyAsync(amount: UInt): Deferred<Result<Unit>> = async {
        val account = Server.getInstance().serviceManager.getProvider<EconomyK>().provider.findAsync(this@setMoneyAsync).await() ?: return@async Result.failure(Exception("Account not exist"))
        account.amount = amount
        Server.getInstance().serviceManager.getProvider<EconomyK>().provider.updateAsync(account).await()
        return@async Result.success(Unit)
    }
}