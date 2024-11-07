package _04_InterfacesAndAbstraction.Lab.P01_P02_CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer TIRES = 4;

     String getModel();
     String getColor();
     Integer getHorsePower();
     String countryProduced();

}
