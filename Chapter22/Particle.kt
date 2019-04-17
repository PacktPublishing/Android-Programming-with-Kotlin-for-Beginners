package com.gamecodeschool.livedrawingpart2

import android.graphics.PointF

class Particle(direction: PointF) {
    private val velocity: PointF = PointF()
    val position: PointF = PointF()

    init {
        // Determine the direction
        velocity.x = direction.x
        velocity.y = direction.y
    }

    fun update() {
        // Move the particle
        position.x += velocity.x
        position.y += velocity.y
    }
}