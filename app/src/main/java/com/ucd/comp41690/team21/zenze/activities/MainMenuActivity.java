package com.ucd.comp41690.team21.zenze.activities;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.ucd.comp41690.team21.zenze.R;
import com.ucd.comp41690.team21.zenze.backend.weather.WeatherService;
import com.ucd.comp41690.team21.zenze.backend.weather.WeatherStatus;

/**
 * Main Activity that launches on start
 * contains the game Menu
 */
public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    /**
     * is called when start-button is clicked
     * @param v
     */
    public void startGame(View v){
        Intent gameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
        // TODO: Get Location from GPS, and change null to a Location
        gameIntent.putExtra("Game State", WeatherService.getWeatherStatus(null, getApplicationContext()));
        startActivity(gameIntent);
    }
}
