public class StudentListImpl implements StudentList{
    private Student front;
    private int nextIndex=0;

    private boolean isEmpty(){
        return front==null;
    }

    @Override
    public void add(String name, String age, String contact, String emailAddress, String gender){
        nextIndex++;
        Student n1=new Student(name, age, contact, emailAddress, gender);
        if(isEmpty()){
            front=n1;
        }else{
            Student lastNode=front;
            while(lastNode.getNext()!=null) {
                lastNode=lastNode.getNext();
            }
            lastNode.setNext(n1);
        }
    }
}
