import java.util.concurrent.locks.Lock;

public class Pier
{
    private String pierType;
    public Pier(String pierType)
    {
        this.pierType = pierType;
    }
    public void loadProduct (int capacity, String shipType,String nameShip) throws InterruptedException
    {
        System.out.println(nameShip+" прибыл на причал ("+pierType+") \n"+"ТИП ЗАГРУЖАЕМОГО ТОВАРА КОРАБЛЯ - "+shipType+"\nВМЕСТИТЕЛЬНОСТЬ КОРОБЛЯ - "+capacity);
        int timeLoading = capacity*100;
        System.out.println(nameShip+" загружается...");
        Thread.sleep(timeLoading);
        System.out.println(nameShip+" загружен полностью и покидает причал");
    }
}
