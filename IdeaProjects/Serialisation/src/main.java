import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class main {

    static class Animal implements Serializable {
         final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        Animal[] animals;

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){

            int numOfAnimals = ois.readInt();
            animals = new Animal[numOfAnimals];

            for (int i = 0; i < animals.length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }

    public static void main(String[] args) throws IOException {
        Animal[] animals = new Animal[] {new Animal("Cat"),
                                        new Animal("Dog")};
        for (Animal animal : animals) {
            System.out.println(animal.name);
        }

        int[] array;
        int n = 7;
        array = new int[n];

        ByteArrayOutputStream data = new ByteArrayOutputStream();


        try (ObjectOutputStream ois = new ObjectOutputStream(data)) {
            ois.writeInt(2);
//            for (Animal animal : animals) {
//                ois.writeObject(animal);
//            }
        }

        byte[] values = data.toByteArray();

        System.out.println(Arrays.toString(values));
        System.out.println(values.length);


    }
}
