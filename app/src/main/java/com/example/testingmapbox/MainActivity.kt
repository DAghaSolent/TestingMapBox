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
import com.example.testingmapbox.ui.theme.TestingMapBoxTheme
import com.mapbox.geojson.Point
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.MapViewportState
import com.mapbox.maps.extension.compose.style.MapStyle

class MainActivity : ComponentActivity() {
    @OptIn(MapboxExperimental::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapboxMap(
                Modifier.fillMaxSize(),
                mapViewportState = MapViewportState().apply {
                    setCameraOptions {
                        zoom(13.0)
                        center(Point.fromLngLat(-1.3649, 50.9161))
                        pitch(0.0)
                        bearing(0.0)
                    }
                },
                style = { MapStyle(style = Style.LIGHT)}
            )
        }
    }
}
