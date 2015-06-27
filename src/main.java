import Hibernate.*;

import java.util.ArrayList;

/**
 * Created by Andrew on 26.06.2015.
 */
public class main {
    public static void main(String arqs[]){
        try {
            for(int i=10; i< 30;i++){
            Dish dish = FactoryDAO.getInstance().getImplementationDAO().getDishById((long)i);
          /*  System.out.println(dish.getIdDish());
            System.out.println(dish.getName());
            System.out.println(dish.getIngridients());
            System.out.println(dish.getRecept());*/

            Parser parser = new Parser();

            parser.parseString(dish.getIngridients());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
