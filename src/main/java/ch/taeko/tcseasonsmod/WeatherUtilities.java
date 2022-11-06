package ch.taeko.tcseasonsmod;

import static ch.taeko.tcseasonsmod.TCWeatherMod.dayOfYear;

public class WeatherUtilities {

    public static void updateWeather() {
	   dayOfYear = TCSeason.getYearDay();
	   TCWeatherMod.currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
	   TCWeatherMod.currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);
    }

}
