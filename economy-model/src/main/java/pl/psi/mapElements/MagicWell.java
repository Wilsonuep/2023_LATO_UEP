package pl.psi.mapElements;

import com.google.common.collect.HashBiMap;
import pl.psi.hero.Hero;

import java.util.ArrayList;

// Magic Well: a hero can restore 100% of mana reserves here once per turn.
public class MagicWell implements MapElement {

    private ArrayList<Hero> currentTurnVisitedHeroes = new ArrayList<>();

    public void resetMagicWell() {
        this.currentTurnVisitedHeroes.clear();
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void apply(Hero aHero, HashBiMap map) {
        if (!currentTurnVisitedHeroes.contains(aHero)) {
            aHero.getHeroStatistics().setMana(aHero.getHeroStatistics().getMaxMana());
            currentTurnVisitedHeroes.add(aHero);
        }
    }
}
