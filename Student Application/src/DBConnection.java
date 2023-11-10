public class DBConnection {
    private StudentList studentList;
    private static DBConnection dBConnection;

    private DBConnection(){
        studentList=new StudentListImpl();
    }

    public static DBConnection getInstance(){
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }

    public StudentList getStudentList(){
        return studentList;
    }
}
