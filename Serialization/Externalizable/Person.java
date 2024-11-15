import java.io.*;

class Employee implements Externalizable {
    private static final long serialVersionUID = 1L;
    String name;
    int id;

    // Default constructor (mandatory for Externalizable)
    public Employee() {}

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Custom serialization logic
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(id);
    }

    // Custom deserialization logic
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        id = in.readInt();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', id=" + id + "}";
    }
}
