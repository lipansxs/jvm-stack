package com.lipanre.jvm.stack.mapstruct.mapper;

import com.lipanre.jvm.stack.mapstruct.domain.Car;
import com.lipanre.jvm.stack.mapstruct.dto.CarDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LiPan
 */
class CarMapperTest {

    @org.junit.jupiter.api.Test
    void carToCarDto() {
        // given
        Car car = new Car("Morris", 5);

        // when
        CarDto carDto = Car.INSTANCE.carToCarDto(car);
        assertEquals(car.getMake(), carDto.getMake());
        assertEquals(car.getNumberOfSeats(), carDto.getSeatCount());
    }
}