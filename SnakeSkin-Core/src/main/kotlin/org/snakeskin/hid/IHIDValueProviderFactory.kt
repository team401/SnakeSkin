package org.snakeskin.hid

import org.snakeskin.hid.provider.IAxisValueProvider
import org.snakeskin.hid.provider.IButtonValueProvider
import org.snakeskin.hid.provider.IHatValueProvider

/**
 * Factory interface for value providers for human interface devices.
 */
interface IHIDValueProviderFactory {
    fun createAxisValueProvider(id: Int): IAxisValueProvider
    fun createButtonValueProvider(id: Int): IButtonValueProvider
    fun createHatValueProvider(id: Int): IHatValueProvider
}