package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	private String name;
	private int weight;
	public Person(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
        return "Name: " + name + ", Weight: " + weight;
    }
}
public class SerializationExample {
	public static void main(String[] args) throws Exception {
		
		  //serialized
          Person obj=new Person("Raghu",70);
          FileOutputStream fos=new FileOutputStream("source4.txt");
          ObjectOutputStream ois=new ObjectOutputStream(fos);
          
          ois.writeObject(obj);
          ois.close();
          System.out.println("serialized person "+ obj);
          
          //deserialized
          ObjectInputStream in = new ObjectInputStream(new FileInputStream("source4.txt"));
          Person deserializedPerson = (Person) in.readObject();
          in.close();
          System.out.println("Deserialized person: " + deserializedPerson);
          
	}
}
