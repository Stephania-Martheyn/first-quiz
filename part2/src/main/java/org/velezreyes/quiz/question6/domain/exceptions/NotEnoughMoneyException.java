package org.velezreyes.quiz.question6.domain.exceptions;

public class NotEnoughMoneyException extends Exception {

  public NotEnoughMoneyException(String string) {
    super("Not enough money inserted.");
  }
  
}
