## Software Engineering Homework - "WeatherBoy" :cloud: :zap: :umbrella: 

### About the project:
---
"WeatherBoy" represents a weather forecast application with a simple GUI, written in Java, which provides the user with a list of cities to choose from in order to display weather statistics related to that location at the current time. The user might find statistics such as: date and time, temperature, atmospheric pressure, wind speed and humidity level.

### Requirements:
---
The application requires a "locations_input.txt" text file with cities information and internet access. The format must be as the following: (ID, NAME, LATITUDE, LONGITUDE, COUNTRY CODE)  
683506 Bucharest 44.432 26.106 RO  
678306 Fetesti 44.383 27.833 RO  
727011 Sofia 42.697 23.324 BG  
728203 Pleven 43.417 24.617 BG

### Languages:
---
Java (OpenJDK 15)

### Usage:
---
The application is rather straightforward. The user is prompted with a window which contains a ComboBox with the list of cities to be selected. When the "Show" Button is clicked, weather statistics information will be displayed about the selected location.

### Testing:
---
The applications contains the following tests:
* JUnit test for ValuesConverter class
* Mock test for DataCollector class

#### Contributors:
---
Ghita Alexandru-Andrei, C-114B

