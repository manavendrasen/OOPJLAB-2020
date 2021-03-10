import java.util.StringTokenizer;

class Address {
  private String line1;
  private String line2;
  private String line3;
  private char[] city;
  private char[] state;
  private String pin;

  // Constructor takes in a string and splits it into all the instance fields
  Address(String arg) {
    // Using string tokenizers to split the string input into separate fields
    StringTokenizer st = new StringTokenizer(arg, "$");
    this.line1 = st.nextToken();
    this.line2 = st.nextToken();
    this.line3 = st.nextToken();
    this.city = st.nextToken().toCharArray();
    this.state = st.nextToken().toCharArray();
    this.pin = st.nextToken();
  }

  // ACCESSORS
  public String getLine1() {
    return line1;
  }

  public String getLine2() {
    return line2;
  }

  public String getLine3() {
    return line3;
  }

  // We wish to return a string from the char array, I made a anonymous String
  // object to return
  public String getCity() {
    return new String(city);
  }

  // We wish to return a string from the char array, I made a anonymous String
  // object to return
  public String getState() {
    return new String(state);
  }

  public String getPin() {
    return pin;
  }

  // Overriding the toString method to display the address in an easy manner
  @Override
  public String toString() {
    return (this.getLine1() + ", " + this.getLine2() + ", " + this.getLine3() + "\n" + this.getCity() + ", "
        + this.getState() + " " + this.getPin());
  }
}

// AddressList Class
// Provides all class functions to perform various operation on an array of
// addresses
class AddressList {
  public static int countAddressWithCity(Address[] addressList, String city) {

    // initializing the result to 0 and incrementing it when a match is found
    int res = 0;

    // if either the arguments are null or the addressList provided is empty we
    // return -1 as specified in the question
    if (addressList == null || city == null || addressList.length == 0)
      return -1;

    // for all the addresses passed through the argument, we check if the address's
    // city is equal to the one provided
    for (Address address : addressList) {
      if (address.getCity().equals(city)) // .equals returns a boolean
        res++;
    }
    return res;
  }

  public static int countAddressWithPin(Address[] addressList, String pin) {

    // initializing the result to 0 and incrementing it when a match is found
    int res = 0;

    // if either the arguments are null or the addressList provided is empty we
    // return -1 as specified in the question int res = 0;
    if (addressList == null || pin == null || addressList.length == 0)
      return -1;

    // for all the addresses passed through the argument, we check if the address's
    // pin is starts with the one provided
    for (Address address : addressList) {
      if (address.getPin().startsWith(pin))
        res++;
    }
    return res;
  }

  public static Address[] getAddressWithPin(Address[] addressList, String pin) {

    if (addressList == null || pin == null || addressList.length == 0)
      return null;

    // initialized i for using it as a index to add to the result array;
    int i = 0;

    // we call the function and add to the result array which is then returned
    Address res[] = new Address[AddressList.countAddressWithPin(addressList, pin)];

    for (Address address : addressList) {
      if (address.getPin().startsWith(pin))
        res[i++] = address;
    }
    return res;
  }

  public static Address[] getAddressWithCity(Address[] addressList, String city) {
    if (addressList == null || city == null || addressList.length == 0)
      return null;

    // initialized i for using it as a index to add to the result array;
    int i = 0;

    // we call the function and add to the result array which is then returned
    Address res[] = new Address[AddressList.countAddressWithCity(addressList, city)];

    for (Address address : addressList) {
      if (address.getCity().equals(city))
        res[i++] = address;
    }
    return res;
  }

}

class AddressTest {
  public static void main(String[] args) {
    // Sample inputs
    Address a1 = new Address("12 Street$A Block$Asdf$Delhi$New Delhi$102022");
    Address a2 = new Address("R12$Near SMT$East Wing$Pune$Maharashtra$300101");
    Address a3 = new Address("R231$4th Floor$Coast Town$Pune$Maharashtra$300101");
    Address a4 = new Address("B3104$Block B3$GSH$Jaipur$Rajasthan$303007");
    Address a5 = new Address("B3105$Block B3$GSH$Jaipur$Rajasthan$303007");

    // Making an array out of the entries
    Address addresses[] = { a1, a2, a3, a4, a5 };

    // Calculating the number of addresses which have jaipur in the city field
    int a = AddressList.countAddressWithCity(addresses, "Jaipur");
    System.out.println("Number of addresses with Jaipur: " + a);

    // Getting back the details of addresses in jaipur
    Address[] b = AddressList.getAddressWithCity(addresses, "Jaipur");

    // Displaying
    for (Address address : b) {
      System.out.println(address);
      System.out.println();
    }

    // Calculating the number of addresses which have 300101 in the pin field
    int c = AddressList.countAddressWithPin(addresses, "300101");
    System.out.println("Number addresses with pin - 300101: " + c);

    // Getting back the details of addresses in 300101 as pin
    Address[] d = AddressList.getAddressWithPin(addresses, "300101");

    // Displaying
    for (Address address : d) {
      System.out.println(address);
      System.out.println();
    }

  }
}