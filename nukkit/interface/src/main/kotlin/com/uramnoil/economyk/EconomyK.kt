package com.uramnoil.economyk

import cn.nukkit.IPlayer
import java.util.*

interface EconomyK {
    fun new(player: IPlayer, amount: UInt = 0u): Account
    fun get(player: IPlayer): Account
    fun update(account: Account)
    fun exists(player: IPlayer): Boolean
    fun delete(account: Account)
}