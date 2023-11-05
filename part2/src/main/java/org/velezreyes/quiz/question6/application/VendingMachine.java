package org.velezreyes.quiz.question6.application;

import org.velezreyes.quiz.question6.adapters.SimpleDrink;
import org.velezreyes.quiz.question6.domain.Drink;
import org.velezreyes.quiz.question6.domain.exceptions.NotEnoughMoneyException;
import org.velezreyes.quiz.question6.domain.exceptions.UnknownDrinkException;

public interface VendingMachine {

  public void insertQuarter();

  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException;

  public void insertDrink(SimpleDrink drik) ;
}