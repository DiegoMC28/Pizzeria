package DAOs;

import java.util.ArrayList;

import Modelo.Pizza;

public class DAOPizza {

    private static DAOPizza daoPizza = null;
    private static ArrayList listaPizza = null;

    private DAOPizza(){

    }
    //Singleton, solo se instancia una vez
    public static DAOPizza getInstance(){
        if(daoPizza == null){
            daoPizza = new DAOPizza();
        }
        if(listaPizza == null){
            listaPizza = new ArrayList();
            listaPizza.add(new Pizza("Queen BBQ", "Queso mozarella", "Salsa barbacoa", "Pollo", "Bacon", ""));
            listaPizza.add(new Pizza("Italian Carbonara", "Queso mozarella", "Nata", "Bacon", "Champiñones", ""));
            listaPizza.add(new Pizza("King Cheese", "Queso mozarella", "Queso de cabra", "Queso roquefort", "Queso gouda", ""));
            listaPizza.add(new Pizza("Green Fit", "Queso mozarella", "Pimiento verde", "Cebolla", "Aceituna negra", ""));
            listaPizza.add(new Pizza("Joseroni", "Queso mozarella", "Peperoni", "Carne picada", "Extra de queso", ""));
            listaPizza.add(new Pizza("Red Devil", "Queso mozarella", "Pimiento chili", "Guindilla", "Pimiento Habanero", ""));
        }
        return daoPizza;
    }



    public ArrayList<Pizza> getPizzas(){

        return listaPizza;
    }

    public void añadirPizza(Pizza pizza){

        this.listaPizza.add(pizza);

    }

    public  ArrayList getListaPizza() {
        return listaPizza;
    }

    public  void setListaPizza(ArrayList listaPizza) {
        DAOPizza.listaPizza = listaPizza;
    }
}
