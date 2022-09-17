# TCSeasonsMod
## This mod is still under development and the features listed below are not yet avaliable!
## What is this mod?
Ever wanted to have that wintery feeling in Minecraft when it's cold out?
This mod changes the behavoir of weather events in Minecraft. At the moment it is only used to remove snow from all biomes, a sort of summer
setting, but in the future will be a __*server side*__ weather mod with all 4 seasons. Yes, other Fabric seasons mods exist out there, but the beauty of
this one is that it is server side only. That means that you can install it on your server and your players won't need to install the mod as it does 
not add to or modify the registry in any way. 
## How do I use the mod?
The mod is server side only! Just drop it into your server's mod folder (or your personal mod folder, if you're playing in singleplayer). Supports 1.19.X.
## How will the 4 seasons work?
Here is a brief overview of what's in development currently:
### Spring (season 1)
All biomes take their standard (vanilla) characteristics for melting snow/ice. Depending on the progression through the season, the chance of snow or rain
falling will change. The snow will melt in warmer biomes but may stay in colder ones still. Snow always falls higher up in the mountains.
### Summer (season 2)
All biomes are hot. It will rain everywhere and the grass will appear a warm green. Any snow remaining from spring will melt.
### Fall (season 3)
The reverse of spring. As fall progresses, snow will become more probable, even in warmer biomes. At the end, snow will be all but certain everywhere.
### Winter (season 4)
It will snow everywhere, and ice/snow will not melt. Grass will take on a grayish-green color.
## Notable limitations
If you go out exploring, load new chunks, then leave and don't return for half a year, the season's attributes will only update once you return.
This is because the mod changes the biome's temperature. This means that if you go to a plains biome, for example, in winter, it will be automatically
snowy. Once you come back, in summer, for example, the snow will still be there, but will of course begin to melt instantly.
## Control of seasons
Seasons are controlled by the day of the year in real life. This means it will reflect the real meterologic current season (in the northern hemisphere).
The total amount of days in the cycle, 365, which begins roughly on the 1st of March, is divided into the 4 seasons, each lasting 91.25 days. 
A season accelerator function will be avaliable. This will multiply the days by a number (0≤x≤1, where 0 is a static season and 1 is 365 days) given by the user.
