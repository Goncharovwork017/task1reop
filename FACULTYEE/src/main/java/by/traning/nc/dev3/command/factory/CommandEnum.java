package by.traning.nc.dev3.command.factory;

import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.command.admin.*;
import by.traning.nc.dev3.command.student.EditInfoStudentCommand;
import by.traning.nc.dev3.command.student.StudentEditPageCommand;
import by.traning.nc.dev3.command.user.*;

/**
 * Created by ivan on 11.04.2017.
 */
public enum  CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGINPAGE {
        {
            this.command = new LoginPageCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    REGISTRATIONPAGE {
        {
            this.command = new RegistrationPageCommand();
        }
    },
    SHOW_STUD {
        {
            this.command = new ShowStudentCommand();
        }
    },

    EDIT_PAGE_ADMIN
            {
                {this.command = new AdminEditPageCommand();
                }
            },
    EDIT_PAGE_STUDENT
            {
                {this.command = new StudentEditPageCommand();
                }
            },
    EDIT_STUDENT_INFO {
        {
            this.command = new EditInfoStudentCommand();
        }
    },
    EDIT_ADMIN_INFO {
        {
            this.command = new EditInfoAdminCommand();
        }
    },

    SHOW_COURSE{
        {
            this.command = new ShowCourseCommand();
        }

    },

    SHOW_COURSE_ADM{{
        this.command = new ShowCourseAdm();
    }},

    SHOW_SHEET_STUDENT{
        {
            this.command = new ShowStudentSheetListCommand();
        }
    },

    ADD_COURSE
            {{
               this.command = new AddCourseCommand();
            }},

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
