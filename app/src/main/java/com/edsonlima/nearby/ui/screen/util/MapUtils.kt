package com.edsonlima.nearby.ui.screen.util

import com.google.android.gms.maps.model.LatLng

fun findSouthWestPoint(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var southWest = points[0]

    for (point in points) {
        if (point.latitude < southWest.latitude
            || (point.latitude == southWest.latitude && point.longitude < southWest.longitude)
        ) {
            southWest = point
        }
    }

    return southWest
}

fun findNorthWestPoint(points: List<LatLng>): LatLng {
    if (points.isEmpty()) return LatLng(0.0, 0.0)

    var northWest = points[0]

    for (point in points) {
        if (point.latitude > northWest.latitude
            || (point.latitude == northWest.latitude && point.longitude > northWest.longitude)
        ) {
            northWest = point
        }
    }

    return northWest
}