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

    public static double getSeasonalDownfall(int day, int a) {

	   if (a < 1) {a = 1;}

	   double dayc = (1f / 365f) * day;
	   double sin = Math.sin(2 * a * Math.PI * dayc);
	   double sindownfall = 0.75 * Math.pow(sin, 2) + 0.25;

	   return sindownfall;

    }

    public static double getSeasonalTemperature(int day, int a) {

	   if (a < 1) {a = 1;}

	   double dayc = (1f / 365f) * day;
	   double sin = Math.sin(a * Math.PI * dayc);
	   double sintemp = Math.pow(sin, 2);

	   double temp = sintemp;

	   return temp;

    }

    public static double temperatureConverter(double temp, boolean toCelcius) {

	   double unit = 9f / 0.2f;

	   if (toCelcius) {
		  temp -= 0.2;
		  return temp * unit;
	   } else {
		  temp += 9;
		  return temp / unit;
	   }

    }

}
