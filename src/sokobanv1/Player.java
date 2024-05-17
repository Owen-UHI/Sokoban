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
public class Player extends MapElement {
    Player(){
        setSymbol("P");
        setImgFileName("/graphics/SokobanImages/WarehouseKeeper.png");
                
    }
    
    Player(String Symbol){
        setSymbol(Symbol);
    }
    
}
