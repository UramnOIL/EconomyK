package com.uramnoil.economyk

import cn.nukkit.IPlayer
import java.util.*

data class Account @ExperimentalUnsignedTypes internal constructor(val player: IPlayer, var amount: UInt)