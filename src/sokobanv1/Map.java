/*
 * 21005686
 * Owen Ross
 * Object Oriented Programming
 */
package sokobanv1;

public class Map {

    MapElement[][] myMap = new MapElement[12][12];
    int playerRow = 4, playerCol = 5;
    //int crate1Row = 7, crate1Col = 8;
    //int crate2Row = 4, crate2Col = 10;

    Map() {
        resetMap();

        // for (int i = 0; i < myMap.length; i++) {
        //   for (int j = 0; j < myMap.length; j++) {
        //     if (i == 0 || i == (myMap.length - 1) || j == 0 || j == (myMap.length - 1)) {
        //       myMap[i][j] = new Wall();
        // } else {
        //   myMap[i][j] = new Floor(); //put case/ifelse statement here to determine what goes where, ie if character = f, put floor etc. Reader would be implemented for the maps, and goes here.?
        //}
        // }
        //}
        //myMap[playerRow][playerCol] = new Player();
        //myMap[playerRow][playerCol].setUnderneath(new Floor());
        //myMap[9][5] = new Crate();
        //myMap[9][5].setUnderneath(new Floor());
        //myMap[4][8] = new Crate();
        //myMap[4][8].setUnderneath(new Floor());
        //myMap[3][7] = new Wall();
        //myMap[7][3] = new Diamond();
        //myMap[4][8] = new Diamond();
        //myMap[3][4] = new Crate();
        //myMap[3][4].setUnderneath(new Floor());
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

                            move(playerRow - 1, playerCol, playerRow - 2, playerCol); //moving the crate
                            move(playerRow, playerCol, --playerRow, playerCol);//moving the player
                            //myMap[playerRow - 2][playerCol] = new Crate();
                            //myMap[playerRow][playerCol] = new Floor();
                            //myMap[--playerRow][playerCol] = new Player();

                        }

                    }

                } else {
                    move(playerRow, playerCol, --playerRow, playerCol);
                    //myMap[playerRow][playerCol] = new Floor();
                    //myMap[--playerRow][playerCol] = new Player();
                }
                break;

            case 2:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow + 1, playerCol)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow + 1, playerCol)) {

                        if (!isObstacleAhead(playerRow + 2, playerCol)) {

                            move(playerRow + 1, playerCol, playerRow + 2, playerCol); //moving the crate
                            move(playerRow, playerCol, ++playerRow, playerCol);//moving the player
                            //myMap[playerRow + 2][playerCol] = new Crate();
                            //myMap[playerRow][playerCol] = new Floor();
                            //myMap[++playerRow][playerCol] = new Player();
                        }
                    }

                } else {
                    move(playerRow, playerCol, ++playerRow, playerCol);
                    //myMap[playerRow][playerCol] = new Floor();
                    //myMap[++playerRow][playerCol] = new Player();
                }
                break;

            case 3:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow, playerCol - 1)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow, playerCol - 1)) {

                        if (!isObstacleAhead(playerRow, playerCol - 2)) {

                            move(playerRow, playerCol - 1, playerRow, playerCol - 2); //moving the crate
                            move(playerRow, playerCol, playerRow, --playerCol);//moving the player
                            //myMap[playerRow][playerCol - 2] = new Crate();
                            //myMap[playerRow][playerCol] = new Floor();
                            //myMap[playerRow][--playerCol] = new Player();
                        }

                    }

                } else {

                    move(playerRow, playerCol, playerRow, --playerCol);

                }
                break;

            case 4:
                //checks to see if there's an obstacle ahead. if not, then move as normal. 
                if (isObstacleAhead(playerRow, playerCol + 1)) {
                    //checks if the obstacle ahead is pushable, and if so tells it to move
                    if (isPushableObject(playerRow, playerCol + 1)) {

                        if (!isObstacleAhead(playerRow, playerCol + 2)) {

                            move(playerRow, playerCol + 1, playerRow, playerCol + 2); //moving the crate
                            move(playerRow, playerCol, playerRow, ++playerCol);//moving the player

                            //myMap[playerRow][playerCol + 2] = new Crate();
                            //myMap[playerRow][playerCol] = new Floor();
                            //myMap[playerRow][++playerCol] = new Player();
                        }
                    }

                } else {
                    move(playerRow, playerCol, playerRow, ++playerCol);

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

    public void move(int currX, int currY, int newX, int newY) {
        //the goal of this function is to have a universal move function that will reuse the loaded assets by moving the player (and pushable object if applicable) to the new space (newCol, newRow)
        MapElement currentUnderneath = myMap[currX][currY].getUnderneath();
        MapElement currentSquare = myMap[currX][currY];
        MapElement newUnderneath = myMap[newX][newY];

        myMap[currX][currY] = currentUnderneath;
        myMap[newX][newY] = currentSquare;
        myMap[newX][newY].setUnderneath(newUnderneath);

        if (myMap[newX][newY].isCanBePushed() && newUnderneath.isIsDestination()) {
            //checking if pushable object is on destination (ie: is a crate on a diamond?)
            myMap[newX][newY].setImgFileName("/graphics/SokobanImages/CrateInPlace.png");
        } else if (myMap[newX][newY].isCanBePushed() && !newUnderneath.isIsDestination()) {
            //this is if the movable object is not on a destination square
            myMap[newX][newY].setImgFileName("/graphics/SokobanImages/Crate.png");
        }
        //checkForWin();

    }

    public final void resetMap() {
        playerRow = 4;
        playerCol = 5;
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
        myMap[playerRow][playerCol].setUnderneath(new Floor());
        myMap[7][3] = new Crate();
        myMap[7][3].setUnderneath(new Floor());
        myMap[2][2] = new Crate();
        myMap[2][2].setUnderneath(new Floor());
        myMap[4][8] = new Crate();
        myMap[4][8].setUnderneath(new Floor());
        myMap[6][9] = new Diamond();
        myMap[5][9] = new Diamond();
        myMap[4][2] = new Diamond();
        myMap[5][5] = new Wall();
        
        
        
    }

    public boolean checkForWin() {
        MapElement tempCheck;
        MapElement tempUnderneath;

        for (MapElement[] myMap1 : myMap) {
            for (int j = 0; j < myMap.length; j++) {
                tempCheck = myMap1[j];
                tempUnderneath = myMap1[j].getUnderneath();
                if (tempCheck.isCanBePushed() && !tempUnderneath.isIsDestination()) {
                    return false;
                }

            }
        }
        return true;

    }
}
