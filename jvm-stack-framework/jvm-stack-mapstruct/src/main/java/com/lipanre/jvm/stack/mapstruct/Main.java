package com.lipanre.jvm.stack.mapstruct;

import com.lipanre.jvm.stack.mapstruct.domain.Car;
import com.lipanre.jvm.stack.mapstruct.dto.CarDto;

/**
 * @author LiPan
 */
public class Main {
    public static void main(String[] args) {
        //given
        Car car = new Car( "Morris", 5);

        //when
        CarDto carDto = Car.INSTANCE.carToCarDto( car );
    }
}
