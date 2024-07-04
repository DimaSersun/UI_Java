package utils.managers;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
    private static final Faker faker = new Faker();

    public static String fakeFirstName() {
        return faker.name().firstName();
    }

    public static String fakeLastName() {
        return faker.name().lastName();
    }

    public static String fakeZipCode() {
        return faker.address().zipCode();
    }
}
