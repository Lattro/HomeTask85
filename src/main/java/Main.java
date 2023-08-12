import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Pier pierBread = new Pier("Хлеб");
        Pier pierBanana = new Pier("Бананы");
        Pier pierClothes = new Pier("Одежда");
        List<String> shipTypeList = new ArrayList<String>();
        List<Integer> shipCapacityList = new ArrayList<Integer>();
        shipTypeList.add("Хлеб");
        shipTypeList.add("Бананы");
        shipTypeList.add("Одежда");
        shipCapacityList.add(10);
        shipCapacityList.add(50);
        shipCapacityList.add(100);
        Random random = new Random();
        System.out.println("Укажите количество кораблей");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countShips = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < countShips; i++)
        {
            int typeProductIndex = random.nextInt(3);
            int capacityShipIndex = random.nextInt(3);
            if(typeProductIndex == 0)
            {
                executorService.submit(new Ship("Хлеб",
                        shipCapacityList.get(capacityShipIndex),"КОРАБЛЬ "+i,pierBread));
            }
            else if (typeProductIndex == 1)
            {
                executorService.submit(new Ship("Бананы",
                        shipCapacityList.get(capacityShipIndex),"КОРАБЛЬ "+i,pierBanana));
            }
            else if (typeProductIndex == 2)
            {
                executorService.submit(new Ship("Одежда",
                        shipCapacityList.get(capacityShipIndex),"КОРАБЛЬ "+i,pierClothes));
            }
        }
        executorService.shutdown();
    }
}
