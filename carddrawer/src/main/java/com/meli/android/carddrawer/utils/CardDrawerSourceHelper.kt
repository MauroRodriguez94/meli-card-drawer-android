package com.meli.android.carddrawer.utils

import com.meli.android.carddrawer.model.CardDrawerSource
import com.meli.android.carddrawer.model.GenericPaymentMethod
import com.meli.android.carddrawer.model.PaymentCard

object CardDrawerSourceHelper {

    private fun process(cardDrawerSource: CardDrawerSource, customMethodBlock: () -> Unit = {}, paymentCardBlock: () -> Unit = {}) {
        when(cardDrawerSource) {
            is GenericPaymentMethod -> customMethodBlock()
            is PaymentCard -> paymentCardBlock()
        }
    }

    fun processPaymentCard(cardDrawerSource: CardDrawerSource, block: () -> Unit) {
        process(cardDrawerSource, paymentCardBlock = block)
    }

    fun processCustomMethod(cardDrawerSource: CardDrawerSource, block: () -> Unit) {
        process(cardDrawerSource, customMethodBlock = block)
    }
}
