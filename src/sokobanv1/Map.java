/*
 * 21005686
 * Owen Ross
 * Object Oriented Programming
 */
package sokobanv1;


public class Map {
    
    MapElement[][] myMap = new MapElement[12][12];
    int playerRow = 4, playerCol = 5;
    
    
    Map(){
        for (int i = 0; i < myMap.length; i++) {
            for (int j = 0; j < myMap.length; j++) {
                myMap[i][j] = new Floor(); //put case/ifelse statement here to determine what goes where, ie if character = f, put floor etc. Reader would be better maybe?
            }
            
        }
        myMap[playerRow][playerCol] = new Player();
    }
    public MapElement[][] getMyMap() {
        return myMap;
    }
    
    public void movePlayer(int dir){
        if (dir ==1){
            myMap[playerRow][playerCol] = new Floor();
            myMap[--playerRow][playerCol] = new Player();
        } else if (dir == 2) {
           myMap[playerRow][playerCol] = new Floor();
           myMap[++playerRow][playerCol] = new Player(); 
        } else if (dir == 3) {
           myMap[playerRow][playerCol] = new Floor();
           myMap[playerRow][--playerCol] = new Player(); 
        } else if (dir == 4) {
           myMap[playerRow][playerCol] = new Floor();
           myMap[playerRow][++playerCol] = new Player(); 
        }
    }
}
