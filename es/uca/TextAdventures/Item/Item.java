package es.uca.TextAdventures.Item;

/**
 * es.uca.item.Item
 *
 * @author Manuel Rodríguez-Sánchez Guerra
 */

public abstract class Item {

    protected int id;

    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract int use();

}
