package by.traning.nc.dev3.finals;

public class SqlRequests {
    public static final String ADD_STUDENT = "INSERT INTO faculty.user(first_name, last_name, login, password, role_id) VALUES (?, ?, ?, ?, ?)";
    public static final String GET_ID_ROLE = "SELECT role_id FROM faculty.role WHERE role_name = ?;";
    public static final String GET_ID_FACULTY = "SELECT faculty_id FROM faculty.faculty WHERE name_faculty = ?;";
    //public static final String IS_AUTH = "SELECT  login, password FROM faculty.user WHERE login = ? AND password = ?";
    public static final String IS_AUTH1 = "SELECT user_id, login, password FROM faculty.user WHERE login = ? AND password = ?";
    public static final String CHECK_ROLE = "SELECT role_name FROM faculty.user u INNER JOIN faculty.role r ON u.role_id = r.role_id WHERE login = ? AND password = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM faculty.user WHERE login = ?";
    public static final String GET_USER_ID = "SELECT user_id FROM faculty.user WHERE login = ?;";
    public static final String GET_ALL_STUD = "SELECT first_name, last_name, login FROM faculty.user where role_id = '2'";
    public static final String GET_F_L_NAME = "SELECT first_name, last_name FROM faculty.user where role_id = '2'";
    public static final String UPDATE_USER = "UPDATE faculty.user SET first_name = ?, last_name = ?, login = ?, password = ? WHERE user_id = ?";

    public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";

    public static final String GET_COURSE_BY_NAME = "SELECT * FROM faculty.course WHERE name = ?;";
    public static final String GET_ALL_COURSE ="SELECT * FROM faculty.course";
    public static final String ADD_COURSE = "INSERT INTO faculty.course(name, id_teacher, description, status) VALUES (?, ?, ?, ?)";

    public static final String COURSE_UPDATE = "UPDATE faculty.course SET status = 'ENDED' WHERE id_course = ?";

    public static final String FIND_CHECK_COURSE = "select * from course where course.id_course not in(select sheetlist.id_course from sheetlist inner join user on user.user_id = sheetlist.user_id where user.login = ?)";
    public static final String FIND_CURRENT_COURSE = "select course.* from sheetlist inner join course on course.id_course = sheetlist.id_course inner join user on user.user_id = sheetlist.user_id where user.login = ?";

    public static final String FIND_ALL_STUDENT_FOR_COURSE = "select sheetlist.sheet_id,sheetlist.score,sheetlist.shortcomment, user.user_id, user.first_name,user.last_name from sheetlist inner join user on sheetlist.user_id = user.user_id where sheetlist.id_course = ?";

    public static final String ADD_SHEETLIST = "INSERT INTO faculty.sheetlist(user_id,id_course,score,shortcomment) VALUES (?,?,?,?)";
    public static final String GET_ALL_SHEETLIST ="SELECT * FROM faculty.sheetlist";
    public static final String SHEET_UPDATE = "UPDATE faculty.sheetlist SET score = ?, shortcomment = ? WHERE sheet_id = ?";


    private SqlRequests() {
    }
}