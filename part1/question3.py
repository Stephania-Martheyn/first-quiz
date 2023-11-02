################################################################################
#     ____                          __     _                          _____
#    / __ \  __  __  ___    _____  / /_   (_)  ____    ____          |__  /
#   / / / / / / / / / _ \  / ___/ / __/  / /  / __ \  / __ \          /_ < 
#  / /_/ / / /_/ / /  __/ (__  ) / /_   / /  / /_/ / / / / /        ___/ / 
#  \___\_\ \__,_/  \___/ /____/  \__/  /_/   \____/ /_/ /_/        /____/  
#                                                                          
#  Question 3
################################################################################
#
# Instructions:
# Make a Python class for a magical oven that can combine ingredients at 
# different temperatures to craft special materials.
# 
# The oven class should have the methods:
# - add(item) to add an oven to be combined
# - freeze() to freeze the ingredients
# - boil() to boil the ingredients
# - wait() to combine the ingredients with no change in temperature
# - get_output() to get the result 
#
# You will need to change the `make_oven()` function to return a new instance
# of your oven.
#
# The `alchemy_combine()` function will use your oven. You can see the expected 
# formulas and their outputs in the test file, `question3_test.py`.

# This function should return an oven instance!

from abc import ABC, abstractmethod

class CookingError(Exception):
    pass

class IngredientError(Exception):
    pass

class Cookable(ABC):
    @abstractmethod
    def add(self, item):
        pass

    @abstractmethod
    def cook(self, temperature):
        pass

    @abstractmethod
    def get_output(self):
        pass

class Oven(Cookable):
    def __init__(self):
        self.ingredients = []

    def add(self, ingredients):
        self.ingredients = ingredients

    def cook(self, temperature):
        if temperature < 0:
            result = self.freeze()
        elif temperature >= 100:
            result = self.boil()
        else:
            self.wait()
            result = None

        if result is not None:
            self.ingredients = [result]

    def freeze(self):
        if "water" in self.ingredients and "air" in self.ingredients:
            return "snow"

    def boil(self):
        if "lead" in self.ingredients and "mercury" in self.ingredients:
            return "gold"
        elif "cheese" in self.ingredients and "dough" in self.ingredients and "tomato" in self.ingredients:
            return "pizza"

    def wait(self):
        pass

    def get_output(self):
        if self.ingredients:
            return " and ".join(self.ingredients)
        else:
            return ""

def make_oven():
    return Oven()

def alchemy_combine(oven, ingredients, temperature):
    if not isinstance(oven, Oven):
        raise CookingError("Se esperaba una instancia de Oven para cocinar.")

    try:
        oven.add(ingredients)
        oven.cook(temperature)
        return oven.get_output()
    except CookingError as ce:
        print(f"Error de cocción: {ce}")
    except IngredientError as ie:
        print(f"Error de ingrediente: {ie}")
    except Exception as e:
        print(f"Error inesperado: {e}")


