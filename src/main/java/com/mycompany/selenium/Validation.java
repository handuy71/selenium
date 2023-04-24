/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.selenium;

import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;

/**
 *
 * @author handu
 */
public class Validation {

    public static float sumString(String[] arr) {
        float sum = 0;
        for (String s : arr) {
            if (s == null || s.isEmpty()) {
                continue;
            }
            try {
                sum += Float.parseFloat(s);
            } catch (NumberFormatException e) {
                // ignore non-numeric values
            }
        }
        return sum;
    }

    public static boolean moneyFormat(String str) {
    if (str.equals("")) {
        return true;
    }
    try {
        float f = Float.parseFloat(str);
        return f >= 0;
    } catch (NumberFormatException e) {
        return false;
    }
}


    public static boolean codeFormat(String a) {
        return a.matches("[a-zA-Z0-9]+");
    }

    public static boolean nameFormat(String a) {
        return a.matches("[\\p{L}\\p{Zs}]+");
    }

    public static boolean numberFormat(String a) {
        return a.matches("\\d+");
    }

    public static boolean emailFormat(String a) {
        String regexPattern = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(regexPattern).matcher(a).matches();
    }

    public static boolean isAnySelected(List<WebElement> checkBoxes) {
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                return true;
            }
        }
        return false;
    }
}
