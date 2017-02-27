package com.lohika.training;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lohika.training.exception.VehicleNotReadyException;
import com.lohika.training.factory.VehicleFactory;
import com.lohika.training.model.storage.Garage;
import com.lohika.training.model.transportation.Boat;
import com.lohika.training.model.transportation.Car;
import com.lohika.training.model.transportation.VehicleId;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        VehicleFactory vehicleFactory = new VehicleFactory();
        try {
            Car car1 = vehicleFactory.makeCar(4, "Silver", new VehicleId("ВС7075ВВ", "JF1GE3LF39G006564"));
            System.out.println("created car" + car1);

            Garage<Car> carGarage = new Garage<>();
            carGarage.addVehicle(car1);

            carGarage.getVehicles().entrySet().stream().forEach(e -> System.out.println(e.getValue()));

            Car selectedCar = carGarage.getVehicle(car1.getVehicleId());
            System.out.println("selected car" + selectedCar);

            Boat boat1 = vehicleFactory.makeBoat("Silver", new VehicleId("ВС7075ВВ", "JF1GE3LF39G006564"));

//            Compilation error
//            carGarage.addVehicle(boat1);

        } catch (VehicleNotReadyException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {

            Runnable worker = () -> System.out.println("Thread executed");
            Callable<String> callable = () -> " Thread executed and returned value";
            Future<String> result = executor.submit(callable);
            System.out.println(result.get());
            executor.execute(worker);

        }

        executor.shutdown();

    }
}
