package com.javawiz.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock
    Player player;

    @InjectMocks
    Game game;//subject under test
    
    
    //We will also get same behavior using @Spy annotation. Even if the attribute name is different.
    @Spy 
    List<String> enemies = new ArrayList<>();
    
    /**
     * As you can see, Game class need Player to perform an attack.
     * Mockito will mock a Player class and it's behavior using when and thenReturn method. Lastly, 
     * using @InjectMocks Mockito will put that Player into Game.
     * Notice that you don't even have to create a new Game object. Mockito will inject it for you.
     */
    @Test
    public void attackWithSwordTest() throws Exception {
        Mockito.when(player.getWeapon()).thenReturn("Sword");
        
        enemies.add("Dragon");
        enemies.add("Orc");

        assertEquals(2, game.numberOfEnemies());

        assertEquals("Player attack with: Sword", game.attack());
    }
}