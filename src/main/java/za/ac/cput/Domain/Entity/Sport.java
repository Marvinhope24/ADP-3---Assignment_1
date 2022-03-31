package za.ac.cput.Domain.Entity;
//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//sport.java
public class Sport {
private int sportID;
private int studentID;
private int teacherID;
private  double  perormanceScore;

    private Sport(Sport.Builder builder){

        this.sportID = builder.sportID;
        this.studentID = builder.studentID;
        this.teacherID = builder.teacherID;
        this.perormanceScore = builder.perormanceScore;


    }



    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public double getPerormanceScore() {
        return perormanceScore;
    }

    public void setPerormanceScore(double perormanceScore) {
        this.perormanceScore = perormanceScore;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportID=" + sportID +
                ", studentID=" + studentID +
                ", teacherID=" + teacherID +
                ", perormanceScore=" + perormanceScore +
                '}';
    }
    public static class Builder {
        private int sportID;
        private int studentID;
        private int teacherID;
        private  double  perormanceScore;


        public Builder setSportID(int sportID) {
            this.sportID = sportID;
            return this;
        }

        public Builder setStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setTeacherID(int teacherID) {
            this.teacherID = teacherID;
        return this;
        }

        public Builder setPerormanceScore(double perormanceScore) {
            this.perormanceScore = perormanceScore;
            return this;
        }
        public Sport.Builder copy(Sport  sport){

            this.sportID = sport.sportID;
            this.studentID = sport.studentID;
            this.teacherID = sport.teacherID;
            this.perormanceScore = sport.perormanceScore;
            return this;

        }
        public Sport build(){
            return new Sport (this);
        }
    }
    }
