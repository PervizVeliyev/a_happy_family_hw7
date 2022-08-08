import java.util.Objects;
import java.util.Random;

public class Human{
    private String name;
    private String surname;
    private int year;                   //date of birth
    private int iq;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("A new human is being loaded");
    }

    {
        System.out.println("A new human object is created");
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String getSchedule() {
        if(schedule == null) return "There's no schedule";
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < schedule[0].length; i++){
            for(int j = 0; j < schedule.length; j++){
                if(j == 0) {
                    sb.append("[" + schedule[j][i] + ", ");
                }
                else if(i == schedule[0].length - 1 && j == schedule.length - 1){
                    sb.append(schedule[j][i] + "]");
                }
                else {
                    sb.append(schedule[j][i] + "], ");
                }
            }
        }
        return sb.toString();
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + this.getSchedule() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && name.equals(human.name) && surname.equals(human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    protected void finalize() {
        System.out.println("Human object is destroyed");
    }

    public void greetPet(){
        System.out.printf("Hello, %s!\n", family.getPet().getNickname());
    }
    public void describePet(){
        String message;
        if(family.getPet().getAge() > 50) message = "very sly";
        else message = "almost not sly";
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",family.getPet().getSpecies(),family.getPet().getAge(),message);
    }
    public boolean feedPet(boolean isItTimeForFeeding){
        Random random =new Random();
        int randomNumber = random.nextInt(1,101);
        if (isItTimeForFeeding) {
            System.out.printf("Hm... I will feed %s's %s.%n",this.name,this.family.getPet().getSpecies());
            return true;
        }
        else {
            if(this.family.getPet().getTrickLevel() > randomNumber){
                System.out.printf("Hm... I will feed %s's %s.%n",this.name,this.family.getPet().getSpecies());
                return true;
            }
            else {
                System.out.printf("I think %s's %s is not hungry.%n",this.name,this.family.getPet().getSpecies());
                return false;
            }
        }
    }
}
