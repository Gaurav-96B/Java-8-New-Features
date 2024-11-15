public class DeserializationExample {
    public static void main(String[] args) {
        // Deserialize the object from the file
        try {
          FileInputStream fis=new FileInputStream("person.ser");
          ObjectInputStream ois = new ObjectInputStream(fis); 
          Person person = (Person) ois.readObject();
          System.out.println("Deserialization successful: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
