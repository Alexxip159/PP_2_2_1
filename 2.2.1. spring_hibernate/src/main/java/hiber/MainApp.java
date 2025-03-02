package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("Land Cruiser", 90);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      car1.setUser(user1);
      userService.add(user1);

      Car car2 = new Car("BMW", 325);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      car2.setUser(user2);
      userService.add(user2);

      Car car3 = new Car("Merserdes", 600);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      car3.setUser(user3);
      userService.add(user3);

      Car car4 = new Car("Mitsubishi", 200);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      car4.setUser(user4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println();
      }

      String model = "Land Cruiser";
      int series = 90;

      Car car = carService.getCarByModelAndSeries(model, series);
      if (car != null) {
         User user = car.getUser();
         System.out.println("For model = " + car.getModel() + ", Series = " + car.getSeries());
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
      }

      context.close();
   }
}
