public final class Man extends Human{

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello, %s! I am your male owner.\n", super.getFamily().getPet().getNickname());
    }

    public void repairCar() {
        System.out.println("I repaired my car");
    }
}
