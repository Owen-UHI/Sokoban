/*
 * 21005686
 * Owen Ross
 * Object Oriented Programming
 */
package sokobanv1;


public class MapElement {
    private String symbol;
    private String imgFileName;
    private boolean canBePushed;
    private boolean isDestination; //this is relating to the diamonds that the crates have to go to
    private boolean obs;
    private int x;
    private int y;
    private MapElement underneath;
    
    
    
    
    

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    



}
