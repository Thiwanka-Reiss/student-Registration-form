public class Student {
    private String name;
    private String age;
    private String contact;
    private String emailAddress;
    private String gender;

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    private Student next;

    //Maven was not used due to assignment Guidlines
    public Student(String name, String age, String contact, String emailAddress, String gender) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }
}
