/*
 * 21005686
 * Object Oriented Programming
 */
package sokobanv1;

/**
 *
 * @author Owen Ross
 */
public class Wall extends MapElement{

    public Wall() {
        setSymbol ("W");
        setImgFileName ("/graphics/SokobanImages/Wall.png");
        setObs  (true);
        setCanBePushed (false);
    }
    
}
