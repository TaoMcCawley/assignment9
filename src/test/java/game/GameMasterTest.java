package game;

import junit.framework.TestCase;

public class GameMasterTest extends TestCase{

    GameMaster master;

    public void setUp(){
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
    }

    /**
     * Tests to make sure that the singletons are the same throughout
     */
    public void testSingleton(){
        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);
        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    /**
     * Makes sure that players initialize properly on the SimpleGameBoard object
     */
    public void testPlayerInit(){
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(6);
        assertEquals(6, master.getNumberOfPlayers());
    }

    /**
     * Tests a simple player motion for every cell
     */
    public void testMovePlayerSimple(){
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master.movePlayer(0, 2);
        assertEquals("Blue 2", player.getPosition().getName());
        master.movePlayer(0,3);
        assertEquals("Blue 2", player.getPosition().getName());
    }

    /**
     * Tests to make sure that a player can move multiple times sucessfully
     */
    public void testMovePlayerCycle(){
        master = GameMaster.instance();
        master.setGameBoard(new SimpleGameBoard());
        master.setNumberOfPlayers(1);
        Player player = master.getPlayer(0);
        master.movePlayer(0, 2);
        master.movePlayer(0, 5);
        assertEquals("Blue 1", player.getPosition().getName());
    }


}
