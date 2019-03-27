

package tada.suzu;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Animal extends Animal {

  private final String name;
  private final int numberOfLegs;
  private final String aaa;

  AutoValue_Animal(
      String name,
      int numberOfLegs,
      String aaa) {
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    this.numberOfLegs = numberOfLegs;
    if (aaa == null) {
      throw new NullPointerException("Null aaa");
    }
    this.aaa = aaa;
  }

  @Override
  String name() {
    return name;
  }

  @Override
  int numberOfLegs() {
    return numberOfLegs;
  }

  @Override
  String aaa() {
    return aaa;
  }

  @Override
  public String toString() {
    return "Animal{"
         + "name=" + name + ", "
         + "numberOfLegs=" + numberOfLegs + ", "
         + "aaa=" + aaa
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Animal) {
      Animal that = (Animal) o;
      return (this.name.equals(that.name()))
           && (this.numberOfLegs == that.numberOfLegs())
           && (this.aaa.equals(that.aaa()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= name.hashCode();
    h$ *= 1000003;
    h$ ^= numberOfLegs;
    h$ *= 1000003;
    h$ ^= aaa.hashCode();
    return h$;
  }

}
