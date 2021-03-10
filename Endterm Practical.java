// End Term Examination, Odd Semester 2020-21
// IT2130 Object-Oriented Proghramming Lab 
// Please type your name and registartion number below  

// Name of Student: Manavendra Sen
// Registration Number: 199302058

// Rename the File as YourName_RegistrationNumber.java
// Do not Remove the Comments.

class StudentException extends Exception {
	// Complete This Class. Write Your Code Below
	StudentException(String errorMessage) {
		super(errorMessage);
	}
}// End of StudentException class

class AgeException extends StudentException {
	// Complete This Class. Write Your Code Below
	int invalidAge;

	AgeException(String errorMessage, int invalidAge) {
		super(errorMessage);
		this.invalidAge = invalidAge;
		System.out.println("Age Exception: " + invalidAge + " is not a valid age, enter >0");

	}

}// End of AgeException class

class NameException extends StudentException {
	String invalidName;

	// Complete This Class. Write Your Code Below
	NameException(String errorMessage, String invalidName) {
		super(errorMessage);
		this.invalidName = invalidName;
		System.out.println("Name Exception: " + invalidName + " is not a valid name");

	}
}// End of NameException class

class Student {
	private String name;
	private int age;

	Student(String name, int age) throws NameException, AgeException {
		/*
		 * Complete the Constructor. This Constructor assigns the values of instance
		 * fields if the values are valid. age is valid if it is greater than zero
		 * otherwise the constructor will throw AgeException. Similarly, name is valid
		 * if it only contains alphabets �A-Z� or �a-z� otherwise the constructor will
		 * throw NameException.
		 */
		boolean hasNonAlpha = false;

		for (int i = 0; i < name.length(); i++) {
			if (!(Character.isAlphabetic(name.charAt(i)))) { // using a static method from Character
				hasNonAlpha = true;
				break;
			}
		}

		if (hasNonAlpha)
			throw new NameException("Contains a digit", name);

		if (age <= 0)
			throw new AgeException("Less than 0", age);

		this.name = name;
		this.age = age;
	} // End of Method

	public void setAge(int age) throws AgeException {
		/*
		 * This mutator method sets the value of �age� if it is valid (> 0) otherwise
		 * the method will throw AgeException. Complete the Method
		 */
		if (age <= 0)
			throw new AgeException("Less than 0", age);

		this.age = age;
	} // End of Method

	public void setName(String name) throws NameException {
		/*
		 * This mutator method sets the value of �name� if it is valid otherwise the
		 * method will throw NameException. Complete the Method
		 */
		boolean hasNonAlpha = false;

		for (int i = 0; i < name.length(); i++) {
			if (!(Character.isAlphabetic(name.charAt(i)))) {
				hasNonAlpha = true;
				break;
			}
		}

		if (hasNonAlpha)
			throw new NameException("Contains a digit", name);

		this.name = name;
	}// End of Method
}// End of class Student

class Driver {
	public static void main(String args[]) {
		/*
		 * Write any suitable Java code that demonstrates the catching of each of the
		 * above defined exception classes.
		 */
		// Write Your Code Below
		System.out.println("Example of name exception: ");
		try {
			Student newStudent = new Student("ABC12", 12);
		} catch (NameException e) {
			System.out.println(e.getMessage());
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Example of name exception: ");
		try {
			Student newStudent1 = new Student("ABC", 12);
			newStudent1.setName("ABC32");
		} catch (NameException e) {
			System.out.println(e.getMessage());
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nExample of age exception: ");
		try {
			Student newStudent2 = new Student("ABC", 0);
		} catch (NameException e) {
			System.out.println(e.getMessage());
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nExample of age exception: ");
		try {
			Student newStudent3 = new Student("ABC", 10);
			newStudent3.setAge(-12);
		} catch (NameException e) {
			System.out.println(e.getMessage());
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}

	} // End of Method
}
// End of class Driver
