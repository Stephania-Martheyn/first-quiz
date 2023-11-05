package org.velezreyes.quiz.question6.application;

import java.util.ArrayList;

import org.velezreyes.quiz.question6.adapters.SimpleDrink;
import org.velezreyes.quiz.question6.domain.Drink;
import org.velezreyes.quiz.question6.domain.exceptions.NotEnoughMoneyException;
import org.velezreyes.quiz.question6.domain.exceptions.UnknownDrinkException;

public class VendingMachineImpl implements VendingMachine {

  private int quartersInserted;
  private ArrayList<SimpleDrink> drinks;

  public VendingMachineImpl() {
    this.quartersInserted = 0;
    this.drinks = new ArrayList<SimpleDrink>();
    setInitalsDrinks();

  }

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    quartersInserted++;
  }

  @Override
public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (quartersInserted < 1) {
        throw new NotEnoughMoneyException("Not enough money inserted.");
    }

    for (SimpleDrink drink : drinks) {
        if (drink.getName().equals(name)) {
            int price = drink.getPrice();
            if (quartersInserted >= price) {
                quartersInserted -= price;
                return drink;
            }
            throw new NotEnoughMoneyException("Not enough money inserted.");
        }
    }

    throw new UnknownDrinkException("Unknown drink!");
}


  @Override
  public void insertDrink(SimpleDrink newDrink) {
    newDrink.setFizzy(true);
    drinks.add(newDrink);
  }

  public void setInitalsDrinks() {
    drinks.add(new SimpleDrink("ScottCola", true, 3));
    drinks.add(new SimpleDrink("Pepsi", true, 3));
    drinks.add(new SimpleDrink("Sprite", true, 3));
    drinks.add(new SimpleDrink("Fanta", true, 3));
    drinks.add(new SimpleDrink("Water", false, 2));
    drinks.add(new SimpleDrink("KarenTea", false, 4)); 
  }

}
