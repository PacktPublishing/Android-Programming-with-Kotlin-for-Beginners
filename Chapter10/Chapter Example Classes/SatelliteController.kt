package com.gamecodeschool.basicclasses

class SatelliteController {
    var gpsCoordinates = "51.331958,0.029057"
    private set

    private var bigProblem = false

    private fun dropOutOfTheSky() {
    }

    private fun doDiagnostics() {
        // etc
    }


    private fun recalibrateSensors(){
        // etc
    }

    fun updateCoordinates(){
        // Recalculate coordinates and update
        // the gpsCoordinates property
        gpsCoordinates = "21.123456, 2.654321"

        // user can now access the new coordinates
        // but still can't change them
    }

    fun runMaintenance(){
        if(bigProblem){
            dropOutOfTheSky()
        }
        else{
            doDiagnostics()
            recalibrateSensors()
        }

    }
}