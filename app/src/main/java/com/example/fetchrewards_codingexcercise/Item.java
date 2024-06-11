package com.example.fetchrewards_codingexcercise;


/**This is a model class that represents an item with its attributes*/
public class Item {

    private int id;
    private int listId;
    private String name;

    // setting up getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
