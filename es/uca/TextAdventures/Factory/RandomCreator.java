package es.uca.TextAdventures.Factory;

import es.uca.TextAdventures.Action.BattleAction;
import es.uca.TextAdventures.EnemyBehaviour.EnemyBehaviour;
import es.uca.TextAdventures.EnemyBehaviour.RandomEnemyBehaviour;

import java.util.Set;

/**
 * Created by manuel on 19/12/16.
 */
public class RandomCreator extends Creator {
    @Override
    public EnemyBehaviour makeEnemyBehaviour(Set<BattleAction> Actions) {
        return new RandomEnemyBehaviour(Actions);
    }
}
