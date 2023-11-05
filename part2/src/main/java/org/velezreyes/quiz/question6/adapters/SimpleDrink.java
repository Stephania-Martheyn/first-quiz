package org.velezreyes.quiz.question6.adapters;

import org.velezreyes.quiz.question6.domain.Drink;

public class SimpleDrink implements Drink {

    private  String name;
    private  boolean fizzy;
    private  int price;

    public SimpleDrink(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    
    public SimpleDrink(String name, boolean fizzy, int price) {
        this.name = name;
        this.fizzy = fizzy;
        this.price = price;
    }


    public SimpleDrink() {
        
    }


    public String getName() {
        return name;
    }

    public boolean isFizzy() {
        return fizzy;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFizzy(boolean fizzy) {
        this.fizzy = fizzy;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (fizzy ? 1231 : 1237);
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleDrink other = (SimpleDrink) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (fizzy != other.fizzy)
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    
}