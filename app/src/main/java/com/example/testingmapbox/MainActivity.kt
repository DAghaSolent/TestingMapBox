package com.example.testingmapbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.testingmapbox.ui.theme.TestingMapBoxTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.MapViewportState
import com.mapbox.maps.extension.compose.style.MapStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingMapBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MapComposable()
                }
            }
        }
    }
}

@Composable
fun MapComposable(){
    AndroidView(factory = { context ->
        val mapView = MapView(context)

        mapView.mapboxMap.setCamera(
            CameraOptions.Builder()
                .zoom(13.0)
                .center(Point.fromLngLat(-1.3649, 50.9161))
                .pitch(0.0)
                .bearing(0.0)
                .build()
        )

        mapView.mapboxMap.loadStyle(Style.LIGHT)

        mapView
    },
        modifier = Modifier.fillMaxSize()
    )
}