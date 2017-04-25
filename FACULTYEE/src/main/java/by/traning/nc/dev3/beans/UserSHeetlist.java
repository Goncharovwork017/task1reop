package by.traning.nc.dev3.beans;

/**
 * Created by ivan on 24.04.2017.
 */
public class UserSHeetlist extends Entity {
    public int sheetId;
    public int idStudent;
    public int idCourse;
    public int score;
    public String shortComment;
    private String firstName;
    private String lastName;

    public UserSHeetlist() {
    }


    public int getSheetId() {
        return sheetId;
    }

    public void setSheetId(int sheetId) {
        this.sheetId = sheetId;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserSHeetlist that = (UserSHeetlist) o;

        if (sheetId != that.sheetId) return false;
        if (idStudent != that.idStudent) return false;
        if (idCourse != that.idCourse) return false;
        if (score != that.score) return false;
        if (shortComment != null ? !shortComment.equals(that.shortComment) : that.shortComment != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + sheetId;
        result = 31 * result + idStudent;
        result = 31 * result + idCourse;
        result = 31 * result + score;
        result = 31 * result + (shortComment != null ? shortComment.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "UserSHeetlist{" +
                "sheetId=" + sheetId +
                ", idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                ", score=" + score +
                ", shortComment='" + shortComment + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
