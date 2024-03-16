package com.lipanre.jvm.stack.mapstruct.domain;

import com.lipanre.jvm.stack.mapstruct.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author LiPan
 */
@Data
@AllArgsConstructor
public class Car {

    public static CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    /**
     * @author LiPan
     */
    @Mapper
    public interface CarMapper {

        @Mapping(source = "numberOfSeats", target = "seatCount")
        CarDto carToCarDto(Car car);

    }

    private String make;
    private int numberOfSeats;
}