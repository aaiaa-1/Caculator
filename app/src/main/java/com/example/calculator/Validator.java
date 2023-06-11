package com.example.calculator;


//this class is the class that checks if there's an opening parentheses and a closing one

import java.util.Stack;

public class Validator {

    public boolean validateParentheses(String s) {
        Stack<Character> output = new Stack<>();

        if (s.length() == 1) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c == '(') {
                output.push(c);
            } else if (c == ')' && output.peek() == '(') {
                output.pop();
            }
        }

        return output.isEmpty();

    }
}
