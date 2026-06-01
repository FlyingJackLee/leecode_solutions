package easy;

import java.util.concurrent.Semaphore;

public class TrafficLight {


    public TrafficLight() {

    }

    private Semaphore a = new Semaphore(1); // 有许可证就是绿灯
    private Semaphore b = new Semaphore(0); // 有许可证就是绿灯

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        try {
            if(roadId < 3) {
                a.acquire();
                turnGreen.run();
                crossCar.run();
                b.release();
            } else {
                b.acquire();
                turnGreen.run();
                crossCar.run();
                a.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
