package Implementing_the_Method_Pattern;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document...");
    }
}
