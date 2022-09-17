package ch.taeko.tcseasonsmod;

import java.util.Calendar;

public class TCSeason {

    public enum Season {
	   SPRING, SUMMER, FALL, WINTER
    }

    public static int getYearDay() {

	   Calendar calendar = Calendar.getInstance();
	   int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

	   //365-21 = 344, 344 is overflow point
	   // offset day by 3 weeks, the average coldest time of year.
	   if (dayOfYear >= 21) {
		  dayOfYear -= 21;
	   } else {
		  dayOfYear += 344;
	   }
	   return dayOfYear;

    }

    public static TCSeason.Season getCurrentSeason(int day) {

	   double daysPerSeason = 365f/4f;
	   int yearDay = day;

	   if (yearDay < daysPerSeason) {
		  return Season.SPRING;
	   } else if (yearDay < 2*daysPerSeason) {
		  return Season.SUMMER;
	   } else if (yearDay < 3*daysPerSeason) {
		  return Season.FALL;
	   } else {
		  return Season.WINTER;
	   }

    }

    public static double getSeasonalTemperature(int day, int a) {

	   /*
	   * Acceleration values under 1, as well as numbers not divisible by 1, will not function properly!
	   * For this reason, entries are limited to integers.
	   * */

	   if (a < 1) {a = 1;}

	   double dayc = (1f / 365f) * day;
	   double sin = Math.sin(a * Math.PI * dayc);
	   double sintemp = 4 * (Math.pow(sin, 2));

	   double temp = sintemp;
	   // double temp = Math.random() * (sintemp + 0.025) + (sintemp - 0.025);
	   // add variation to temperature. haven't figured out how to make temperature constant throughout whole day, as
	   // it is called every time a biome is called.

	   return temp;
	   // 0.025 temp plus per day
	   // temp variation 0.05, about 20 days variation
    }

}
