class Rent
{ 
    private Car car;
    private Client client;
    private int day;

    public Rent(Car car,Client client,int day)
    {
        this.car=car;
        this.client=client;
        this.day=day;
    }

    public Car getCar()
    {
        return car;
    }

    public Client getClient()
    {
        return client;
    }

    public int getday()
    {
        return day;
    }
}
