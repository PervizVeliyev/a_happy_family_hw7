public final class Woman extends Human{

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello, %s! I am your female owner.\n", super.getFamily().getPet().getNickname());
    }

    public void makeUp() {
        System.out.println("I used my makeup");
    }
}
