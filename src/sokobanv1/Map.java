/*
 * 21005686
 * Object Oriented Programming
 */
package sokobanv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Owen Ross
 */
public class Map {

    MapElement[][] myMap = new MapElement[12][12];
    int playerRow, playerCol;
    //int level = 1; //this will be ammended when loading through the levels, however it will also be used in a switch case statement to select maps
       
    Map(String mapNames) {            
        readMap(mapNames);
    }

    /**
     *
     * @return
     */
    public MapElement[][] getMyMap() {
        return myMap;
    }

    /**
     *
     * @param dir
     */
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

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isObstacleAhead(int x, int y) {
        //checks if the object ahead of the player is set to be an obstacle
        return myMap[x][y].isObs();
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isPushableObject(int x, int y) {
        //checks if the object ahead of the player can be pushed
        return myMap[x][y].isCanBePushed();
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isDestAhead(int x, int y) {

        return myMap[x][y].isIsDestination();
    }

    /**
     *
     * @param currX
     * @param currY
     * @param newX
     * @param newY
     */
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
        //boolean complete = checkForWin();

    }

    /**
     *
     * @param mapName is the filepath of a specific level, determined by the logic in game
     */
    public final void readMap(String mapName) {
        
                InputStreamReader fileReader = new InputStreamReader(getClass().getResourceAsStream(mapName));
                BufferedReader bufferReader = new BufferedReader(fileReader);
                String line;
                int i = 0;

                try {

                    while ((line = bufferReader.readLine()) != null) {
                        for (int j = 0; j < line.length(); j++) {
                            //for(int j = 0; j<line.length();j++){
                            if (line.substring(j, j + 1).equals("X")) {
                                myMap[i][j] = new Wall();
                            } else if (line.substring(j, j + 1).equals("*")) {
                                myMap[i][j] = new Crate();
                                myMap[i][j].setUnderneath(new Floor());
                            } else if (line.substring(j, j + 1).equals(" ")) {
                                myMap[i][j] = new Floor();
                            } else if (line.substring(j, j + 1).equals("@")) {
                                myMap[i][j] = new Player();
                                myMap[i][j].setUnderneath(new Floor());
                                playerRow = i;
                                playerCol = j;
                            } else if (line.substring(j, j + 1).equals(".")) {
                                myMap[i][j] = new Diamond();
                                //myMap[i][j].setUnderneath(new Floor());
                            } else {
                                myMap[i][j] = new Wall();
                            }
                            //}
                        }
                        i++;
                    }

                } catch (IOException e) {
                    System.out.println("ERROR: Map not read");
                }
        
        
       
    }

    /**
     *
     * @param mapName
     */
    public final void resetMap(String mapName) {
        readMap(mapName);
    }

    /**
     *
     * @return
     */
    public boolean checkForWin() {
        MapElement tempCheck;
        MapElement tempUnderneath;

        for (MapElement[] myMap1 : myMap) {

            for (int j = 0; j < myMap.length; j++) {
                tempCheck = myMap1[j];
                if (tempCheck != null) {
                    tempUnderneath = myMap1[j].getUnderneath();
                    if (tempCheck.isCanBePushed() && !tempUnderneath.isIsDestination()) {
                        return false;
                    }
                }
            }
        }
        return true;

        }
    }
