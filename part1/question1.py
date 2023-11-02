################################################################################
#     ____                          __     _                          ___
#    / __ \  __  __  ___    _____  / /_   (_)  ____    ____          <  /
#   / / / / / / / / / _ \  / ___/ / __/  / /  / __ \  / __ \         / / 
#  / /_/ / / /_/ / /  __/ (__  ) / /_   / /  / /_/ / / / / /        / /  
#  \___\_\ \__,_/  \___/ /____/  \__/  /_/   \____/ /_/ /_/        /_/   
#                                                                        
#  Question 1
################################################################################
#
# Instructions:
# The two functions below are used to tell the weather. They have some bugs that
# need to be fixed. The test suite in `question1_test.py` will verify the output.
# Read the test suite to know the values that these functions should return.

def get_city_temperature(city): 
    temperatures =  { 
        "Quito": 22, 
        "Sao Paulo": 17, 
        "San Francisco": 16, 
        "New York": 14 
     } 
    try: 
        return temperatures[city] 
    except KeyError: 
        raise KeyError(f"The city ' {city }' does not have a registered temperature.") 
 
 
 
 
def get_city_weather(city): 
    conditions =  { 
        "Sao Paulo": "cloudy", 
        "New York": "rainy", 
        "Quito": "sunny", 
        "San Francisco":"cloudy"
     } 
 
    try: 
        sky_condition = conditions[city] 
    except KeyError: 
        raise KeyError(f"The city ' {city }' does not have registered weather conditions.") 
 
    try: 
        temperature = get_city_temperature(city) 
    except KeyError: 
        raise KeyError(f"The temperature for the city ' {city }' could not be found.") 
 
    return f"{temperature } degrees and {sky_condition }" 