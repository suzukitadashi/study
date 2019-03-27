package tada.suzu;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Animal {
    static Animal create(String name, int numberOfLegs, String aaa) {
        // See "How do I...?" below for nested classes.
        return new AutoValue_Animal(name, numberOfLegs, aaa);
    }

    abstract String name();
    abstract int numberOfLegs();
    abstract String aaa();
}
