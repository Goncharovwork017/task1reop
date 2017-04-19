package by.traning.nc.dev3.finals;

public class SqlRequests {
    public static final String ADD_STUDENT = "INSERT INTO faculty.user(first_name, last_name, login, password, role_id) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_ID_ROLE = "SELECT role_id FROM faculty.role WHERE role_name = ?;";
    public static final String GET_ID_FACULTY = "SELECT faculty_id FROM faculty.faculty WHERE name_faculty = ?;";
    public static final String IS_AUTH = "SELECT login, password FROM user WHERE login = ? AND password = ?";
    public static final String CHECK_ROLE = "SELECT role_name FROM user u INNER JOIN faculty.role r ON u.role_id = r.role_id WHERE login = ? AND password = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM faculty.user WHERE login = ?;";
    public static final String GET_USER_ID = "SELECT user_id FROM faculty.user WHERE login = ?;";
    public static final String GET_ALL_STUD = "SELECT first_name, last_name, login FROM faculty.user where role_id = '2'";
    public static final String UPDATE_USER = "UPDATE faculty.user SET first_name = ?, last_name = ?, login = ?, password = ? WHERE user_id = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";

    public static final String GET_COURSE_BY_NAME = "SELECT * FROM faculty.course WHERE name = ?;";
    public static final String GET_ALL_COURSE ="SELECT * FROM faculty.course";
    public static final String ADD_COURSE = "INSERT INTO faculty.course(name, id_teacher, description, status) VALUES (?, ?, ?, ?)";



    public static final String GET_ALL_SHEETLIST ="SELECT * FROM faculty.sheetlist";



    private SqlRequests() {
    }
}