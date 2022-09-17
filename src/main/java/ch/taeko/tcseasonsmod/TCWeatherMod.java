package ch.taeko.tcseasonsmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.*;

public class TCWeatherMod implements ModInitializer {

    public static int dayOfYear;
    public static double currentTemperature;

    @Override
    public void onInitialize() {

	   // universal initalization
	   dayOfYear = TCSeason.getYearDay();
	   currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);

	   // output current day and season
	   System.out.println("TCWeatherMod Initialized. Current day of the year is " + dayOfYear +
			 ", current season is " + TCSeason.getCurrentSeason(dayOfYear));

	   // season command
	   CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
			 dispatcher.register(literal("tcseason")
				    .then(literal("seasonInfo")
						  .executes(context -> {
							 // For versions below 1.19, use ''new LiteralText''.
							 context.getSource().sendMessage(Text.literal(
                                            "Current season: " + TCSeason.getCurrentSeason(dayOfYear) + "Current temperature: " + currentTemperature + "Current day: " + dayOfYear
							 ));
							 return 1;
						  })
				    )
                        .then(literal("winter")
                                .executes(context -> {
                                    // For versions below 1.19, use ''new LiteralText''.
                                    dayOfYear = 0;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
                                    return 1;
                                })
                        )
                        .then(literal("summer")
                                .executes(context -> {
                                    // For versions below 1.19, use ''new LiteralText''.
                                    dayOfYear = 182;
							 currentTemperature = TCSeason.getSeasonalTemperature(dayOfYear, 1);
                                    return 1;
                                })
                        )
			 ));
    }
}
