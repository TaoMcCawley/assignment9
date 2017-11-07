package game;

import junit.framework.TestCase;

import static org.junit.Assert.*;

public class GameBoardTest extends TestCase{
    public GameBoardTest(String name){
        super(name);
    }

    /**
     * Tests adding a cell to the gameboard and checking the size of said gameboard
     */
    public void testAddCell(){
        GameBoard gameBoard = new GameBoard();
        assertEquals(1, gameBoard.getCellNumber());
        Cell cell = new Cell();
        gameBoard.addCell(cell);
        assertEquals(2, gameBoard.getCellNumber());
    }

    /**
     * Checking to see if the GoCell is the same as the first Cell
     */
    public void testFirstCell(){
        GameBoard gameboard = new GameBoard();
        Cell firstCell = gameboard.getCell(0);
        assertSame(GoCell.class, firstCell.getClass());
    }

    /**
     * Tests to make sure the getCellIndex method works both with real indices and counts for fake indeces
     */
    public void testGetCellIndex(){
        GameBoard gameBoard = new SimpleGameBoard();
        Cell blue2 = gameBoard.getCell(2);
        int index = gameBoard.getCellIndex(blue2);
        assertEquals(2, index);
        Cell notExist = new Cell();
        index = gameBoard.getCellIndex(notExist);
        assertEquals(-1, index);
    }

}