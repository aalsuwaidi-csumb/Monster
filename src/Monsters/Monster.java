package Monsters;
import Abilities.Attack;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {
    private Integer hp;
    private Integer xp = 10;
    Integer agi = 5;
    Integer def = 5;
    Integer str = 5;
    Attack attack;
    private Integer maxHP = null;
    private HashMap<String,Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    public Integer attackTarget(Monster target){
        return this.attack.attack(target);
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getXp() {
        return xp;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getAgi() {
        return agi;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getStr() {
        return str;
    }

    /**
     * This methods returns an integer value between min and max.
     * @param min an integer
     * @param max an integer
     * @return a random integer between min and max
     */
    Integer getAttribute(Integer min, Integer max){
        Random rand = new Random();
        if(min > max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max
        return rand.nextInt(max-min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monster monster = (Monster) o;

        if (!hp.equals(monster.hp)) return false;
        if (!xp.equals(monster.xp)) return false;
        if (!agi.equals(monster.agi)) return false;
        if (!def.equals(monster.def)) return false;
        if (!str.equals(monster.str)) return false;
        if (!attack.equals(monster.attack)) return false;
        if (!maxHP.equals(monster.maxHP)) return false;
        return items.equals(monster.items);
    }

    @Override
    public int hashCode() {
        int result = hp.hashCode();
        result = 31 * result + xp.hashCode();
        result = 31 * result + agi.hashCode();
        result = 31 * result + def.hashCode();
        result = 31 * result + str.hashCode();
        result = 31 * result + attack.hashCode();
        result = 31 * result + maxHP.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  "hp=" + hp + "/" + maxHP;
    }
}
