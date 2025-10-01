import java.util.Random;

public class SuperHero {

    //public boolean isAlive;
    String name; // ім'я Супергероя
    String superHeroDescription;// опис супергероя
    int attackPower ; // сила атаки
    int defensePower;  //сила захисту
    int health = 100; // (здоров'я, початково — 100).
    String superPower ; // опис супер сили
    // суперсила буде у вигляді подвоєної сили атаки, якщо герой атакує, або подвоєний захист , якщо героя атакують, застосовується випадковим чином



    public void takeDamage(int damage) {
        health-=damage;

    } ; //— розрахунок і нанесення ушкоджень супернику.

    Random rand = new Random();
    int useSuperPower = 0;
    int damageLevel;

    public void attack(SuperHero opponent) {
        useSuperPower=rand.nextInt(3); // використання суперсили: якщо 0 - ніхто не використовує, якщо 1 - той хто атакує, 2- той хто захищається

        switch (useSuperPower) {
            case 0 -> {
                System.out.print(name + " атакує " + opponent.name + " з силою " + attackPower);
                damageLevel = attackPower - opponent.defensePower;
                if ((damageLevel) > 0) {
                    System.out.println(" і наносить урон " + (attackPower - opponent.defensePower));
                    opponent.takeDamage(attackPower - opponent.defensePower);

                } else {
                    System.out.println();
                    System.out.println(opponent.name + " зміг відбити удар і не отримав шкоди");
                }
            }
            case 1 -> { // той хто атакує застосовує подвійну атаку
                System.out.print(name + " атакує " + opponent.name);
                System.out.println(" та  використовує " + superPower + ", сила атаки збільшується до " + (2 * attackPower));
                damageLevel = 2 * attackPower - opponent.defensePower;
                if (damageLevel > 0) {
                    System.out.println(name + " наносить урон " + damageLevel);
                    opponent.takeDamage(damageLevel);

                } else {
                     System.out.println(opponent.name + "зміг відбити удар і не отримав шкоди");
                }
            }
            case 2 -> {
                System.out.println(name + " атакує " + opponent.name + " з силою " + attackPower);
                System.out.println(opponent.name + " використовує " + opponent.superPower + ", сила захисту збільшується до " + (2 * opponent.defensePower));
                damageLevel = attackPower - 2 * opponent.defensePower;
                if (damageLevel > 0) {
                    System.out.println(name + " все-рівно наносить урон " + damageLevel);
                    opponent.takeDamage(damageLevel);

                } else {
                       System.out.println(opponent.name + " завдяки суперсилі зміг відбити удар і не отримав шкоди");
                }


            }
        };//— застосування ушкоджень (зменшує здоров'я героя).
    }
        public boolean isAlive() // — перевірка, чи герой ще живий (здоров'я > 0).
    {
        if (health <= 0)
        {
            return false;
        } else {
            return true;}

    };
    // конструктор
   public SuperHero (String name, String superHeroDescription,int attackPower, int defensePower, String superPower) {
     this.name=name;
     this.superHeroDescription=superHeroDescription;
     this.attackPower=attackPower;
     this.defensePower=defensePower;
     this.superPower=superPower;

   }

    public void showStats() // — виведення характеристики героя в консоль.
    {

        System.out.println(name+" "+superHeroDescription+". Властивості: здоров*я- "+health+","+" удар- "+attackPower+", захист- "+defensePower+ ", суперсила-"+superPower+")");

    }
    public void healthCheck() // — виведення характеристики героя в консоль.
    {

        System.out.println(name + " поточний стан здоров*я: " + health);
    }





    }
