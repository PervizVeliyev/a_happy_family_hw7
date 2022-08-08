public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Danny", 6, 56, new String[]{"eat", "run", "sleep"});
        DomesticCat cat = new DomesticCat("Garfield", 8, 80, new String[]{"eat", "drink", "watch Tv"});
        System.out.println(dog);
        System.out.println(cat.getNickname());
        cat.eat();
        dog.foul();
        dog.respond();
        System.out.println(cat.getSpecies());

        Human mother = new Human("Arzu","Ismayilova",1975, 90, null);
        Human father = new Human("Senan","Ismayilov",1975, 94, null);
        Human child = new Human("Elnur","Ismayilov",2000,94, null);
        Human child1 = new Human("Emil","Ismayilov",1996,92, null);
        Human child2 = new Human("Elvin","Ismayilov",1996,92, null);
        Family family = new Family(mother, father);

        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);
        family.setPet(dog);

        System.out.println(family.deleteChild(2));
        family.deleteChild(child1);
        System.out.println(family.countFamily());

        Human child3 = family.bornChild();              // a newborn child automatically will be added to the family.

        System.out.println(child3);
        System.out.println(family.countFamily());
        child3.greetPet();

        child.setSchedule(new String[][]{{DayOfWeek.MONDAY.name(),DayOfWeek.TUESDAY.name(),DayOfWeek.WEDNESDAY.name(),
                DayOfWeek.THURSDAY.name(),DayOfWeek.FRIDAY.name(),DayOfWeek.SATURDAY.name(),
                DayOfWeek.SUNDAY.name()},{"go","run","fall","stand","go","run","fall"}});
    }
}
