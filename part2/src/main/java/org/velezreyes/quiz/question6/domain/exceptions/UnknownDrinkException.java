package org.velezreyes.quiz.question6.domain.exceptions;

public class UnknownDrinkException extends Exception {

  public UnknownDrinkException(String string) {
    super("Unknown drink!");
  }
}
