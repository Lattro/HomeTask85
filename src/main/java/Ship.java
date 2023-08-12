public class Ship implements Runnable
{
    private String shipType;
    private int capacity;
    private String nameShip;
    Pier pier;

    public Ship(String shipType, int capacity, String nameShip, Pier pier) {
        this.shipType = shipType;
        this.capacity = capacity;
        this.nameShip = nameShip;
        this.pier = pier;
    }

    @Override
    public void run()
    {
        try
        {
            pier.loadProduct(capacity,shipType,nameShip);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
