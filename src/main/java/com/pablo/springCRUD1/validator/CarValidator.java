package com.pablo.springCRUD1.validator;

import com.pablo.springCRUD1.dao.CarDAO;
import com.pablo.springCRUD1.entity.Car;
import com.pablo.springCRUD1.service.washLogic.CostCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Pablo on 14.11.2016.
 */
public class CarSizeValidator implements Validator {

    @Autowired
    private CarDAO carDAO;

    public CostCounter counter;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == Car.class;
    }


    @Override
    public void validate(Object o, Errors errors) {

        Car car = (Car) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "NotEmpty.carForm.model");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "NotEmpty.carForm.width");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "NotEmpty.carForm.height");

        double width = car.getWidth();
        double height = car.getHeight();
        if (width >0 && height>0){
            if (counter.getCarCost(car)<0){
                errors.rejectValue("height", "Validation.carForm.size");
                errors.rejectValue("width", "Validation.carForm.size");
            }

        }
    }
}
