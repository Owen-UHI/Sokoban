/*
 * 21005686
 * Object Oriented Programming
 */
package sokobanv1;

/**
 *
 * @author Owen Ross
 */
public class Crate extends MapElement {

    public Crate() {
        setSymbol ("C");
        setImgFileName ("/graphics/SokobanImages/Crate.png");
        setObs  (true);
        setCanBePushed (true);
        //setUnderneath(new Floor());
    }
    
}
