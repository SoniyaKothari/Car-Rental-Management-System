class Car
{
    //Encapsulation
    private String carName;
    private String id;
    private int price;
    private boolean isAvailable;
    
    //setting data in the constructor
    public Car(String carName,String id,int price)
    {
        this.carName=carName;
        this.id=id;
        this.price=price;
        isAvailable=true;
    }

    //all getter methods
    public String getcarName()
    {
        return carName;
    }

    public String getid()
    {
        return id;
    }

    public int getprice()
    {
        return price;
    }

    //car is reserved and unavailable.
    public void carRent()
    {
        isAvailable=false;
    }

    //available 
    public void returnCar()
    {
        isAvailable=true;
    }

    //calculate total amount based on price and days
    public int totalPrice(int no_of_days)
    {
        return price*no_of_days;
    }

    //returns current value of isAvailable
    public boolean isAvailable()
    {
        return isAvailable;
    }
}
