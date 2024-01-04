package com.cars.serevice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cars.entity.Car;
import com.cars.entity.Reservation;
import com.cars.repository.CarRepository;
import com.cars.repository.ReservationRepository;

@Service
public class AvailabilityUpdateService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Scheduled(fixedRate = 60) // Exécuter toutes les minutes
    public void updateAvailability() {
        List<Reservation> reservations = reservationRepository.findAll();
        Date currentDate = new Date();

        for (Reservation reservation : reservations) {
            if (currentDate.after(reservation.getEndDate())) {
                Car car = reservation.getCar();
                car.setAvailable(true);
                carRepository.save(car);
            }
        }
    }
}
