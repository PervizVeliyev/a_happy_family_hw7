import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class FamilyTest {

    Human mother = new Human("Arzu","Ismayilova",1975);
    Human father = new Human("Senan","Ismayilov",1975);
    Family family = new Family(mother, father);
    Dog dog = new Dog("Danny",6,55,new String[]{"eat","run","bite"});
    Human child = new Human("Elnur","Ismayilov",2000,94,null);
    Human child1 = new Human("Emil","Ismayilov",1996,92,null);
    Human child2 = new Human("Elvin","Ismayilov",1996,92, null);

    @Test
    void bornChildTest(){
        Human child3 = family.bornChild();
        Assertions.assertEquals(family.getChildren()[family.getChildren().length - 1], child3);
    }

    @Test
    void bornChildRelationshipTest(){
        Human child3 = family.bornChild();
        Assertions.assertEquals(family.getChildren()[family.getChildren().length - 1].getFamily().getFather() , family.getFather());
    }

    @Test
    void testToString() {
        family.setPet(dog);
        family.addChild(child);

        Assertions.assertEquals("Family{mother=Human{name='Arzu', surname='Ismayilova', year=1975, iq=0, schedule=There's no schedule}," +
                " father=Human{name='Senan', surname='Ismayilov', year=1975, iq=0, schedule=There's no schedule}, pet=DOG{nickname='Danny', age=6," +
                " trickLevel=55, habits=[eat, run, bite], canFly=false, numberOfLegs=4, hasFur=true}," +
                " children=[Human{name='Elnur', surname='Ismayilov', year=2000, iq=94, schedule=There's no schedule}]}", family.toString());
    }

    @Test
    void addChildLengthTest() {
        family.setPet(dog);
        family.addChild(child);
        family.addChild(child1);

        Assertions.assertEquals(2, family.getChildren().length);
    }

    @Test
    void addChildRelationshipTest1(){
        family.setPet(dog);
        family.addChild(child);
        family.addChild(child1);

        Assertions.assertEquals(mother, family.getChildren()[family.getChildren().length - 1].getFamily().getMother());
    }

    @Test
    void addChildRelationshipTest2(){
        family.setPet(dog);
        family.addChild(child);
        family.addChild(child1);

        Assertions.assertEquals(dog, family.getChildren()[family.getChildren().length - 1].getFamily().getPet());
    }

    @Test
    void deleteChildWithIndex() {
        boolean condition = true;
        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);
        Human removedChild = family.getChildren()[1];

        boolean condition2 = family.deleteChild(1);
        for(int i = 0; i < family.getChildren().length; i++){
            if(family.getChildren()[i].equals(removedChild)) {
                condition = false;
                break;
            }
        }
        Assertions.assertTrue(condition);
        Assertions.assertTrue(condition2);
    }

    @Test
    void deleteChildWithIndex2(){
        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);
        Human[] tempArray = family.getChildren();

        boolean condition = family.deleteChild(100);

        Assertions.assertEquals(Arrays.toString(tempArray), Arrays.toString(family.getChildren()));
        Assertions.assertFalse(condition);
    }

    @Test
    void DeleteChild() {
        boolean condition = true;
        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);
        family.deleteChild(child1);

        for(int i = 0; i < family.getChildren().length; i++){
            if(family.getChildren()[i].equals(child1)) {
                condition = false;
                break;
            }
        }

        Assertions.assertTrue(condition);
    }

    @Test
    void DeleteChild2(){
        family.addChild(child);
        family.addChild(child1);
        family.addChild(child2);
        Human[] tempArray = family.getChildren();
        family.deleteChild(mother);

        Assertions.assertEquals(Arrays.toString(tempArray), Arrays.toString(family.getChildren()));
    }

    @Test
    void countFamily() {
        family.addChild(child);
        family.addChild(child1);
        Assertions.assertEquals(4, family.countFamily());
    }
}