package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Functions {

    public void randomGenerator(){
        double min = 1;
        double max = 5;
        double res;
        res = Math.random()*(max-min)*10;
    }

    public boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
