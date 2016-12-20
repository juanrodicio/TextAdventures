package es.uca.TextAdventures.Player;

import es.uca.TextAdventures.Item.ArmorItem;
import es.uca.TextAdventures.Item.Item;
import es.uca.TextAdventures.Item.WeaponItem;

import java.util.Set;


/**
 * es.uca.playerCharacter.TextAdventures.Enemy
 *
 * @author Manuel Rodríguez-Sánchez Guerra
 */

public abstract class Enemy extends Player {

    private static final int TYPE_WATER = 0;
    private static final int TYPE_FIRE = 1;
    private static final int TYPE_WIND = 2;
    private static final int TYPE_EARTH = 3;
    private static final int TYPE_TEPIC = 4;

    private int type;

    public Enemy(String name, int id, double healthPoints, Set<Item> inventory, int baseDamage, int type) throws TypeNotFoundException {
        super(name, id, healthPoints, inventory, baseDamage);
        if (type > TYPE_TEPIC || type < TYPE_WATER) {
            TypeNotFoundException exceptionType = new TypeNotFoundException();
            throw exceptionType;
        }
        this.type = type;
    }

    @Override
    public boolean attack(Player currentPlayer) {

        int armor = 0;
        Item playerArmor;
        try {
            playerArmor = currentPlayer.inventory.stream().filter((i) -> i instanceof ArmorItem).iterator().next();
        } catch (Exception e) {
            playerArmor = null;
        }
        if (playerArmor != null) {
            armor = playerArmor.use();
        }

        if (this.hasWeapon()) {
            WeaponItem EnemyWeapon = (WeaponItem) inventory.stream().filter((i) -> i instanceof WeaponItem).iterator().next();
            WeaponItem PlayerWeapon = (WeaponItem) currentPlayer.inventory.stream().filter((i) -> i instanceof WeaponItem).iterator().next();
            setHealthPoints((currentPlayer.getHealthPoints() + armor) - EnemyWeapon.use() * DAMAGE_TABLE[EnemyWeapon.getType()][PlayerWeapon.getType()]);
        } else {
            setHealthPoints(currentPlayer.getHealthPoints() + armor - this.baseDamage);
        }

        return currentPlayer.isAlive();
    }

    public int getType() {
        return this.type;
    }

    public class TypeNotFoundException extends Exception {
    }

}
