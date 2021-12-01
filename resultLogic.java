import java.util.Date;

public class resultLogic {
    final private String enrollNumber;
    final private String studentName;
    final private String fatherName;
    final private String dob;
    final private int currsem;
    final private int deptno;
    final private int session;

    resultLogic(String enrollNumber,String studentName,String fatherName, String dob, int currsem, int deptno, int session){
        this.enrollNumber = enrollNumber;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.dob = dob;
        this.currsem = currsem;
        this.deptno = deptno;
        this.session = session;
    }

    public String getenrollNumber() {
        return enrollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getfatherName() {
        return fatherName;
    }
    public String getdob() {
        return dob;
    }
    public int getcurrsem() {
        return currsem;
    }
    public int getdeptno() {
        return deptno;
    }
    public int getsession() {
        return session;
    }


}

