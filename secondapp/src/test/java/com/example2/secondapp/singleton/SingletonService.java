package com.example2.secondapp.singleton;

//Basic Singleton pattern
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        //Private Constructor in order to prevent generate another SingletonService object
    }

    public void logic(){
        System.out.println("SingletonService is called");
    }
}
