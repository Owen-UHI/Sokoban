/*
 * 21005686
 * Owen Ross
 * Object Oriented Programming
 */
package sokobanv1;

public class Map {

    MapElement[][] myMap = new MapElement[12][12];
    int playerRow = 4, playerCol = 5;
    int crate1Row = 7, crate1Col = 8;
    int crate2Row = 4, crate2Col = 10;

    Map() {
        for (int i = 0; i < myMap.length; i++) {
            for (int j = 0; j < myMap.length; j++) {

                if (i == 0 || i == (myMap.length - 1) || j == 0 || j == (myMap.length - 1)) {

                    myMap[i][j] = new Wall();
                } else {
                    myMap[i][j] = new Floor(); //put case/ifelse statement here to determine what goes where, ie if character = f, put floor etc. Reader would be implemented for the maps, and goes here.?
                }
            }

        }
        myMap[playerRow][playerCol] = new Player();
        myMap[crate1Row][crate1Col] = new Crate();
        myMap[crate2Row][crate2Col] = new Crate();
        myMap[3][7] = new Wall();
        myMap[5][3] = new Diamond();

    }

    public MapElement[][] getMyMap() {
        return myMap;
    }

    public void movePlayer(int dir) {

        switch (dir) {

            case 1:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow - 1, playerCol)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow - 1, playerCol)) {

                        if (!isObstacleAhead(playerRow - 2, playerCol)) {

                            myMap[playerRow - 2][playerCol] = new Crate();
                            myMap[playerRow][playerCol] = new Floor();
                            myMap[--playerRow][playerCol] = new Player();

                        }

                    }

                } else {
                    myMap[playerRow][playerCol] = new Floor();
                    myMap[--playerRow][playerCol] = new Player();
                }
                break;

            case 2:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow + 1, playerCol)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow + 1, playerCol)) {

                        if (!isObstacleAhead(playerRow + 2, playerCol)) {

                            myMap[playerRow + 2][playerCol] = new Crate();
                            myMap[playerRow][playerCol] = new Floor();
                            myMap[++playerRow][playerCol] = new Player();
                        }
                    }

                } else {
                    myMap[playerRow][playerCol] = new Floor();
                    myMap[++playerRow][playerCol] = new Player();
                }
                break;

            case 3:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow, playerCol - 1)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow, playerCol - 1)) {

                        if (!isObstacleAhead(playerRow, playerCol - 2)) {

                            myMap[playerRow][playerCol - 2] = new Crate();
                            myMap[playerRow][playerCol] = new Floor();
                            myMap[playerRow][--playerCol] = new Player();
                        }

                    }

                } else {
                    myMap[playerRow][playerCol] = new Floor();
                    myMap[playerRow][--playerCol] = new Player();
                }
                break;

            case 4:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow, playerCol + 1)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow, playerCol + 1)) {

                        if (!isObstacleAhead(playerRow, playerCol + 2)) {

                            myMap[playerRow][playerCol + 2] = new Crate();
                            myMap[playerRow][playerCol] = new Floor();
                            myMap[playerRow][++playerCol] = new Player();

                        }
                    }

                } else {
                    myMap[playerRow][playerCol] = new Floor();
                    myMap[playerRow][++playerCol] = new Player();
                }
                break;

        }
    }

    public boolean isObstacleAhead(int x, int y) {
        //checks if the object ahead of the player is set to be an obstacle
        return myMap[x][y].isObs();
    }

    public boolean isPushableObject(int x, int y) {
        //checks if the object ahead of the player can be pushed
        return myMap[x][y].isCanBePushed();
    }

    public boolean isDestAhead(int x, int y) {

        return myMap[x][y].isIsDestination();
    }

}
