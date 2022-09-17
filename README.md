# TCWeatherMod
By Taeko, initially developed for the Taeko & Co Server
## What is this mod?
Ever wanted to have that wintery feeling in Minecraft when it's cold out?
This mod changes the behavoir of weather events in Minecraft. It cycles through temperatures and weather based on the real world day of the year. Yes, other Fabric weather mods exist out there, but the beauty of
this one is that it is __*server side*__.
## How do I use the mod?
The mod is server side only! Just drop it into your server's mod folder (or your personal mod folder, if you're playing in singleplayer). Supports 1.19.x.
## Current Features
Based on the current day (out of 365) of the year, a Minecraft temperature is calculated (0-4, with decimals) using a simple sine wave. This determines the precipitation and if ice or snow melts naturally outside. 
$$T=4sin^2(\pi x a)$$
Where $x$ is the current day of the year and $a$ is the accelerator (not yet in use), see Control of Seasons.
## Current Development Plans
The mod currently functions. However it is in development and is rough around the edges. Here are some features planned for the future:
### Spring (season 1)
All biomes take their standard (vanilla) characteristics for melting snow/ice. Depending on the progression through the season, the chance of snow or rain
falling will change. The snow will melt in warmer biomes but may stay in colder ones still. Snow always falls higher up in the mountains.
### Summer (season 2)
All biomes are hot. It will rain everywhere and the grass will appear a warm green. Any snow remaining from spring will melt.
### Fall (season 3)
The reverse of spring. As fall progresses, snow will become more probable, even in warmer biomes. At the end, snow will be all but certain everywhere.
### Winter (season 4)
It will snow everywhere, and ice/snow will not melt. Grass will take on a grayish-green color.
### Control of seasons
Seasons are controlled by the day of the year in real life. This means it will reflect the real meterologic current season (in the northern hemisphere).
The total amount of days in the cycle, 365, which begins roughly on the 1st of March, is divided into the 4 seasons, each lasting 91.25 days. 
A season accelerator function will be avaliable. This will multiply the days by a number (0≤x≤1, where 0 is a static season and 1 is 365 days) given by the user.
## Notable limitations
If you go out exploring, load new chunks, then leave and don't return for half a year, the season's attributes will only update once you return.
This is because the mod changes the biome's temperature. This means that if you go to a plains biome, for example, in winter, it will be automatically
snowy. Once you come back, in summer, for example, the snow will still be there, but will of course begin to melt instantly.
