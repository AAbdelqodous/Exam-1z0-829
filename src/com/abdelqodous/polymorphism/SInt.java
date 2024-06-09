package com.abdelqodous.polymorphism;

public sealed interface SInt permits Story, Art {
        default String getTitle(){
            return "Book title";
        }
}
