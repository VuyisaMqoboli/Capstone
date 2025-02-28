package za.ac.cput.factory;

import za.ac.cput.domain.Base;
import za.ac.cput.util.Helper;
/* BaseFactory.java
 Author: Timothy Lombard (220154856)
 Date: 30th July (last updated) 2023
*/
public class BaseFactory {

    public static Base buildBase(Base.BaseCrust crust, Base.BaseThickness thickness, Base.BaseTexture texture, double price){
        if(Helper.isNullOrEmpty(String.valueOf(crust)) || Helper.isNullOrEmpty(String.valueOf(thickness)) || Helper.isNullOrEmpty(String.valueOf(texture)) || Helper.isNullOrEmpty(String.valueOf(price))){
            return null;
        }

        Integer baseId = Helper.generateId2();

        Base b = new Base.Builder().setBaseId(baseId).setCrust(crust).setThickness(thickness).setTexture(texture).setPrice(price).build();
        return b;
    }
}
