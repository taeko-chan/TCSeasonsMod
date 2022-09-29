package ch.taeko.tcseasonsmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.fabricmc.loader.impl.util.log.LogLevel;
import net.minecraft.text.Text;

import static ch.taeko.tcseasonsmod.WeatherUtilities.updateWeather;
import static java.lang.Math.round;
import static net.minecraft.server.command.CommandManager.*;

public class TCWeatherMod implements ModInitializer {

    public static int dayOfYear;
    public static double currentTemperature;
    public static double currentDownfall;

    public static boolean staticWeather;

    @Override
    public void onInitialize() {

	   // universal initalization
	   dayOfYear = TCSeason.getYearDay();
	   currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
	   currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);

	   ServerTickEvents.END_SERVER_TICK.register((server) -> {
				if (staticWeather) {
					updateWeather();
				}
			 }
	   );

	   Events.registerEvents();

	   // output current day and season
	   Log.log(LogLevel.INFO, LogCategory.GENERAL, "TCWeatherMod Initialized. Current day of the year is " + dayOfYear +
			 ", current season is " + TCSeason.getCurrentSeason(dayOfYear));

	   // season command
	   CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
			 dispatcher.register(literal("TCSeason")
				    .then(literal("WeatherReport")
						  .executes(context -> {
							 context.getSource().sendMessage(Text.literal(
                                            "Current Season: " + TCSeason.getCurrentSeason(dayOfYear) +
										  ", Current Temperature: " + round(TCSeason.temperatureConverter(currentTemperature, true)) + "°C" +
										  ", Current Day: " + dayOfYear
							 ));
							 return 1;
						  })
				    )
                        .then(literal("winter").requires(source -> source.hasPermissionLevel(4))
                                .executes(context -> {
							 staticWeather = true;
							 dayOfYear = 5;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
							 currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);
                                    return 1;
                                })
                        )
                        .then(literal("summer").requires(source -> source.hasPermissionLevel(4))
                                .executes(context -> {
							 staticWeather = true;
							 dayOfYear = 184;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
							 currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);
                                    return 1;
                                })
                        )
				    .then(literal("fall").requires(source -> source.hasPermissionLevel(4))
						  .executes(context -> {
							 staticWeather = true;
							 dayOfYear = 278;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
							 currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);
							 return 1;
						  })
				    )
				    .then(literal("spring").requires(source -> source.hasPermissionLevel(4))
						  .executes(context -> {
							 staticWeather = true;
							 dayOfYear = 95;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
							 currentDownfall = TCSeason.getSeasonalDownfall(dayOfYear, 1);
							 return 1;
						  })
				    )
				    .then(literal("reset").requires(source -> source.hasPermissionLevel(4))
						  .executes(context -> {
							 staticWeather = false;
							 updateWeather();
							 return 1;
						  })
				    )
			 ));

    }
}
