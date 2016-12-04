package es.uca.TextAdventures.Item;

/**
 * es.uca.item.Item
 *
 * @author Manuel Rodríguez-Sánchez Guerra
 */

public abstract class Item {

    public Item(int id) {
        this.id = id;
    }

    protected int id;

    public int getId() {
        return id;
    }

    public abstract int use();

}