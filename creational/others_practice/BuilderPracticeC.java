class Meal{
    String starter;
    String mainDish;
    String dessert;
    public String getStarter() {
        return starter;
    }
    public void setStarter(String starter) {
        this.starter = starter;
    }
    public String getMainDish() {
        return mainDish;
    }
    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }
    public String getDessert() {
        return dessert;
    }
    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}

interface MealBuilder{
    public void setStarter();
    public void setMainDish();
    public void setDessert();
    public Meal getMeal();
}

class BengaliMealBuilder implements MealBuilder{
    Meal meal = new Meal();
    public void setStarter(){
        meal.setStarter("vegetable");
    }
    public void setMainDish(){
        meal.setMainDish("chicken curry");
    }
    public void setDessert(){
        meal.setDessert("sweet curd");
    }

    public Meal getMeal(){
        return meal;
    }
}

class ChineseMealBuilder implements MealBuilder{
    Meal meal = new Meal();
    public void setStarter(){
        meal.setStarter("soup");
    }
    public void setMainDish(){
        meal.setMainDish("Peking Duck");
    }
    public void setDessert(){
        meal.setDessert("Pudding");
    }

    public Meal getMeal(){
        return meal;
    }
}

class MealDirector{
    MealBuilder builder;
    public MealDirector(MealBuilder builder){
        this.builder = builder;
    }
    public void setBuilder(MealBuilder builder){
        this.builder = builder;
    }
    public Meal getMeal(){
        builder.setStarter();
        builder.setMainDish();
        builder.setDessert();

        return builder.getMeal();
    }
}

