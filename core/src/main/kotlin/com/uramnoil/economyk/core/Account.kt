package com.uramnoil.economyk.core

import java.util.*

data class Account @ExperimentalUnsignedTypes constructor(val id: UUID, val amount: UInt)