import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CarRentalSystem 
{ 
    //here all the previous 3 classes details will be stored in arraylist
    //declared
    private List<Car> c1;
    private List<Client> c2;
    private List<Rent> r;

    public CarRentalSystem()
    {
        //memory alloctaed
        c1 = new ArrayList<>();
        c2 = new ArrayList<>();
        r = new ArrayList<>();
    }

    //method to add cars
    public void addCar(Car car)
    {
        c1.add(car);
    }

    //method to add customers
    public void addCustomer(Client client)
    {
        c2.add(client);
    }

    //method to rent the cars
    public void rentCar(Car car,Client client,int day)
    {
        //we have already set the isAvailable value by true so when the IF condition is executed, the car will be rented and isAvailable will be false
        if(car.isAvailable())
        {
            //car is rented
            car.carRent();
            //add records in Rent arraylist
            r.add(new Rent(car, client, day));
        }
        else
        {
            System.out.println("Car is not available! ");
        }
    }

    public void returnCar(Car car)
    {
        car.returnCar();
        Rent findCar=null;
        for(Rent check: r)
        {
            if(check.getCar()==car)
            {
                findCar=check;
                break;
            }
        }
        if(findCar != null)
        {
            r.remove(findCar);
        }
        else
        {
            System.out.println("Car was not rented");
        }
    }

    public void display()
    {
        Scanner sc = new Scanner(System.in);
        loop: while(true)
        {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Welcome to our Car Rental System! ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Press 1 to Rent a Car ");
            System.out.println("Press 2 to Return a Car ");
            System.out.println("Press 3 to Exit \n ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("***RENTING A CAR***");
                    System.out.print("Enter your name:- ");
                    String cust=sc.nextLine();
                    System.out.print("Enter your phone number:- ");
                    String num=sc.nextLine();
                    System.out.println();
                    System.out.println("Available cars");
                    for(Car c: c1)
                    {
                        if(c.isAvailable())
                        {
                            System.out.println(c.getid()+" "+c.getcarName()+" "+c.getprice());
                        }
                    }
                    System.out.print("Enter the car id which u want to rent:- ");
                    String id=sc.nextLine();
                    System.out.print("For how many days u want to rent the car:- ");
                    int d=sc.nextInt();
                    sc.nextLine();
                    Client cli = new Client(cust,num);
                    addCustomer(cli);

                    Car selectedCar=null;
                    for(Car v : c1)
                    {
                        if(v.getid().equals(id) && v.isAvailable())
                        {
                            selectedCar=v;
                            break;
                        }
                    }
                    if(selectedCar != null )
                    {
                        int checkout=selectedCar.totalPrice(d);
                        System.out.println("==============================");
                        System.out.println("CONFIRMATION");
                        System.out.println("==============================");
                        System.out.println("Customer Name:- "+cli.getName()+"\nCustomer's Phone no. "+cli.getNo());
                        System.out.println("CarName:- "+selectedCar.getcarName()+"\n CarID:- "+selectedCar.getid()+"\n CarPrice:- "+selectedCar.getprice());
                        System.out.println("Rental Days:- "+d);
                        System.out.println("Total Price:- "+checkout);
                        System.out.println();
                        System.out.println("CONFIRM BOOKING (Y/N):- ");
                        char conf=sc.next().trim().charAt(0);
                        System.out.println();
                        if(conf=='Y' || conf=='y')
                        {
                            rentCar(selectedCar, cli, d);
                            System.out.println("==============================");
                            System.out.println("Thank you for choosing our service!");
                            System.out.println("Your booking is confirmed.");
                            System.out.println("==============================");
                        }
                        else if(conf=='N' || conf=='n')
                        {
                            System.out.println("Booking cancelled");
                        }
                        else
                        {
                            System.out.println("You are almost there! Please confirm the details.");
                        }
                    }
                    break;
            case 2:
                System.out.println("RETURNING A CAR ");
                System.out.print("Enter the carId u want to return:- ");
                String inp=sc.nextLine();
    
                Car carReturn=null;
                for(Car car: c1)
                {
                    if(car.getid().equalsIgnoreCase(inp) && !car.isAvailable())
                    {
                        carReturn=car;
                        break;
                    }
                }
                if(carReturn != null)
                {
                    Client ct = null;
                    for(Rent ren: r)
                    {
                        if(ren.getCar()==carReturn)
                        {
                            ct=ren.getClient();
                            break;
                        }
                    }
                    if(ct != null)
                    {
                        returnCar(carReturn);
                        System.out.println("Car returned successfully by "+ct.getName());
                    }
                    else
                    {
                        System.out.println("Car was not rented or rental information is missing");
                    }
                }
                else
                {
                    System.out.println("Invalid car Id or car is not rented");
                }
                break;
            case 3:
                break loop;
            default:
                System.out.println("Invalid choice!");
            }
        }
    }
}
