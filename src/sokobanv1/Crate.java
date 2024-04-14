/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokobanv1;

/**
 *
 * @author Owen
 */
public class Crate extends MapElement {

    public Crate() {
        setSymbol ("C");
        setImgFileName ("/graphics/SokobanImages/Crate.png");
        setObs  (true);
        setCanBePushed (true);
    }
    
}
