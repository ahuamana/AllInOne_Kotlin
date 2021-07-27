package com.paparazziteam.allinone.utils

import androidx.lifecycle.Observer

class Event<T> {

    // Based on this article:
    // https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150
    open class Event<out T>(private val content: T) {

        private var hasBeenHandled = false

        /**
         * Returns the content and prevents its use again.
         */
        fun getEventIfNotHandled(): T? =
            if (hasBeenHandled) null
            else {
                hasBeenHandled = true
                content
            }
    }

    // Taken from this gist: https://gist.github.com/JoseAlcerreca/e0bba240d9b3cffa258777f12e5c0ae9
    class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {

        override fun onChanged(event: Event<T>?) {
            event?.getEventIfNotHandled()?.let { value -> onEventUnhandledContent(value) }
        }
    }

}