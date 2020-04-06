package com.uramnoil.economyk

import cn.nukkit.IPlayer
import java.util.*

interface EconomyK {
    suspend fun new(player: IPlayer, amount: UInt = 0u): Account
    suspend fun get(player: IPlayer): Account
    suspend fun update(account: Account)
    suspend fun exists(player: IPlayer): Boolean
    suspend fun delete(account: Account)
}