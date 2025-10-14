import java.util.Scanner;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        // оголошуємо массив з 10ма супергероями
        SuperHero[] superHeroBase = {new SuperHero("Luminator","-керує світлом, осліплює ворогів та створює енергетичні проміні",25,10,"енергетичний промінь"),
                new SuperHero("StormBringer","-володар бурь та ураганів",25,10,"ураган"),
                new SuperHero("ShadowHawk ","-майстер-скритність, товаришує з тінню",13,10,"невидімість"),
                new SuperHero("Steelwing","-людина з металевими крилами, швидко літає та пробиє стіни" ,20,10,"супершвидкість"),
                new SuperHero("FrostGuardian","-захист холодом, створює льодяні стіни і заморожує ворогів",13,5,"зледеніння"),
                new SuperHero("QuakeTitan","-контролює сейсмічну енергію, викликає землетрус",11,7,"потужний землетрус"),
                new SuperHero("EternalPhoenix","-відроджується як птиця фенікс, володіє полум*ям",16,30,"полум*я"),
                new SuperHero("AquaSentinel","-керує водою, використовує водяний щит та швилі, цунамі",22,21,"цунамі"),
                new SuperHero("PlantsGuardian","-контролює рослини, викликає дерева, ліани для атаки та захисту",23,10,"потужні ліани")};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вітаємо на битьві Супергероїв");
        System.out.println("У битві хочуть взяти участь такі супер-герої:");


        for (int i=0;i<9;i++)
        {
            System.out.print("Супергерой №"+(i+1)+": "); superHeroBase[i].showStats();

        }
        System.out.println("Оберіть 2х супергероїв, хто візьме учать у битві (1-9)");
        int userInput1 = scanner.nextInt();
        int userInput2 = scanner.nextInt();

        System.out.println("Отже в битві візьмуть участь такі герої");
        userInput1-=1;
        userInput2-=1;
        superHeroBase[userInput1].showStats();
        superHeroBase[userInput2].showStats();

        System.out.println("ТАК РОЗПОЧНЕТЬСЯ ЖЕ ЕПІЧНА БИТВА СУПЕРГЕРОЇВ!!!. Герої можуть використовувати інколи свої суперсили");

        int i=1;
        Random rand = new Random();
        int lucky;
      do {
           System.out.println("Раунд: "+ i);
           lucky=rand.nextInt(5); // якщо випадає 3, то в цьому раунді додається +5 до здоров*я, якщо 1 - то зменьшується на 5 здоров*я
            superHeroBase[userInput1].attack(superHeroBase[userInput2]);
            superHeroBase[userInput2].attack(superHeroBase[userInput1]);
            if (lucky==3) {
                System.out.println("Була активована вищими силами РЕГЕНЕРАЦІЯ. Герої отримали +5 до здоров*я");
                superHeroBase[userInput1].health += 5;
                superHeroBase[userInput2].health += 5;
            }
          if (lucky==1) {
              System.out.println("Було активована вищими силами ОГЛУШЕННЯ. Герої отримали -5 до здоров*я");
              superHeroBase[userInput1].health -= 5;
              superHeroBase[userInput2].health -= 5;
          }

          superHeroBase[userInput1].healthCheck();
          superHeroBase[userInput2].healthCheck();
            i+=1;
       }
       while (superHeroBase[userInput1].isAlive()&&superHeroBase[userInput2].isAlive());

        if (superHeroBase[userInput1].isAlive() == true)
        { System.out.println("В ЦІЙ БИТВІ ПЕРЕМІГ СУПЕРГЕРОЙ "+ superHeroBase[userInput1].name);}
            else if (superHeroBase[userInput2].isAlive() == true)
                   {System.out.println("В ЦІЙ БИТВІ ПЕРЕМІГ СУПЕРГЕРОЙ"+ superHeroBase[userInput2].name);}
                        else {System.out.println("В ЦІЙ БИТВІ НИЧІЯ");}


       // Тут має розгортатися епічна битва між Супергероями

    }
}
