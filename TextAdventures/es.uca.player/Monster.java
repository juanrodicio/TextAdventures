import java.util.Set;
import es.uca.item.*;
package TextAdventures.es.uca.player;

public class Monster extends Enemy{

	public Monster(String name, int id, int HealthPoints, Set<Item> Inventory, int baseDamage, int Type) {
		super(name, id, HealthPoints, Inventory, baseDamage, Type);
	}



}
