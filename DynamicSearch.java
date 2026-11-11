// 1. Custom Checked Exception extending Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// 2. WorkshopRegistration Class
class WorkshopRegistration {
    public void registerParticipant(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException(
                "Registration denied for [" + name + "]: Must be at least 18 years old (provided age: " + age + ")"
            );
        } else {
            System.out.println("Success: Participant " + name + " has been successfully registered!");
        }
    }
}

// 3. Main Execution Class
public class WorkshopDemo {
    public static void main(String[] args) {
        WorkshopRegistration registrationSystem = new WorkshopRegistration();

        // Testing your code: attempting to register a 16-year-old participant
        try {
            System.out.println("Attempting to register participant (Age: 16)...");
            registrationSystem.registerParticipant("Ali", 16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}
