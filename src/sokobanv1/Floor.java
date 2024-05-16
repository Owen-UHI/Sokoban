/*
 * 21005686
 * Object Oriented Programming
 */
package sokobanv1;

/**
 *
 * @author Owen Ross
 * 
 */
public class Floor extends MapElement {
    Floor(){
        setSymbol ("F");
        setImgFileName ("/graphics/SokobanImages/Floor.png");
        //setUnderneath(new Floor());
    }
    
}
