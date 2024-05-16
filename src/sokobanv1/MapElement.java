/*
 * 21005686
 * Object Oriented Programming
 */
package sokobanv1;

/**
 *
 * @author Owen Ross
 */
public class MapElement {
    private String symbol;
    private String imgFileName;
    private boolean canBePushed;
    private boolean isDestination; //this is relating to the diamonds that the crates have to go to
    private boolean obs;
    private MapElement underneath;

    /**
     *
     * @return
     */
    public boolean isCanBePushed() {
        return canBePushed;
    }

    /**
     *
     * @param canBePushed
     */
    public void setCanBePushed(boolean canBePushed) {
        this.canBePushed = canBePushed;
    }

    /**
     *
     * @return
     */
    public boolean isIsDestination() {
        return isDestination;
    }

    /**
     *
     * @param isDestination
     */
    public void setIsDestination(boolean isDestination) {
        this.isDestination = isDestination;
    }

    /**
     *
     * @return
     */
    public boolean isObs() {
        return obs;
    }

    /**
     *
     * @param obs
     */
    public void setObs(boolean obs) {
        this.obs = obs;
    }

    /**
     *
     * @return
     */
    public MapElement getUnderneath() {
        return underneath;
    }

    /**
     *
     * @param underneath
     */
    public void setUnderneath(MapElement underneath) {
        this.underneath = underneath;
    }
    
    /**
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return
     */
    public String getImgFileName() {
        return imgFileName;
    }

    /**
     *
     * @param imgFileName
     */
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    



}
