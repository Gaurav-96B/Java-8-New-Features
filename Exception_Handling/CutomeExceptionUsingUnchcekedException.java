class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}
class AgeVerification{
    public void getValidAge(int age){
        if(age<20){
            throw new InvalidAgeException("Age is invalid");
        }
    }
}
class Main {
    public static void main(String[] args) {
        new AgeVerification().getValidAge(16);
    }
}
