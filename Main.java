public class Main
{
    public static void main(String[] args)
    {
        CarRentalSystem crs = new CarRentalSystem();
        Car c1 = new Car("Porsche", "911", 20000);
        Car c2 = new Car("Mustang", "5f", 10000);
        Car c3 = new Car("Range Rover", "L460", 15000);
        Car c4 = new Car("MCLaren","p1",60000);
        System.out.println("\n");
        crs.addCar(c1);
        crs.addCar(c2);
        crs.addCar(c3);
        crs.addCar(c4);
        
        crs.display();
    }
}
