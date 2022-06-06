package io.github.usbharu.hayasaka.event

import io.github.usbharu.hayasaka.model.Reaction

class ReactionEvent(source: Any, val reaction: Reaction) : MaidHayasakaEvent(source)
