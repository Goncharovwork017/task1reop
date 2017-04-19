package by.traning.nc.dev3.beans;

/**
 * Created by ivan on 16.04.2017.
 */
public class SheetList extends Entity {
    public int sheetId;
    public int idStudent;
    public int idCourse;
    public int score;
    public String shortComment;

    @Override
    public String toString() {
        return "SheetList{" +
                "sheetId=" + sheetId +
                ", idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                ", score=" + score +
                ", shortComment='" + shortComment + '\'' +
                '}';
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
}
