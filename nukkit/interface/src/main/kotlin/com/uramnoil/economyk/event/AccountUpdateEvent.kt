package com.uramnoil.economyk.event

import cn.nukkit.event.Cancellable
import com.uramnoil.economyk.Account

class AccountUpdateEvent @ExperimentalUnsignedTypes constructor(val account: Account, val to: UInt) : AccountEvent()