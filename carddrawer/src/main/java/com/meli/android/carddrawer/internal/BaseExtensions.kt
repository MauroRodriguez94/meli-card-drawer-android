package com.meli.android.carddrawer.internal

import com.meli.android.carddrawer.model.CardDrawerSource
import com.meli.android.carddrawer.model.CardUI
import com.meli.android.carddrawer.model.GenericPaymentMethod
import com.meli.android.carddrawer.model.PaymentCard

internal fun CardDrawerSource.process(
    genericPaymentMethodBlock: (genericPaymentMethod: GenericPaymentMethod) -> Unit = {},
    paymentCardBlock: (cardUI: CardUI) -> Unit = {}
) {
    when(this) {
        is GenericPaymentMethod -> genericPaymentMethodBlock(this)
        is PaymentCard -> paymentCardBlock(cardUI)
    }
}

internal fun CardDrawerSource.processPaymentCard(block: (cardUI: CardUI) -> Unit) {
    process(paymentCardBlock = block)
}

internal fun CardDrawerSource.processGenericPaymentMethod(block: (genericPaymentMethod: GenericPaymentMethod) -> Unit) {
    process(genericPaymentMethodBlock = block)
}

internal fun CardDrawerSource.either() : Pair<CardUI?, GenericPaymentMethod?> {
    return Pair(if (this is PaymentCard) cardUI else null, if (this is GenericPaymentMethod) this else null)
}
