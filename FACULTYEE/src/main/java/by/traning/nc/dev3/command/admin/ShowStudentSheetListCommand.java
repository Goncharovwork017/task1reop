package by.traning.nc.dev3.command.admin;

import by.traning.nc.dev3.beans.SheetList;
import by.traning.nc.dev3.command.ActionCommand;
import by.traning.nc.dev3.dao.SheetListDAO;
import by.traning.nc.dev3.finals.Parameters;
import by.traning.nc.dev3.resource.ConfManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ivan on 17.04.2017.
 */
public class ShowStudentSheetListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();

            SheetListDAO sheetListDAO = new SheetListDAO();
            List<SheetList> list = sheetListDAO.findAll();
            session.setAttribute(Parameters.SHEET_LIST, list);
            page = ConfManager.getProperty("path.page.showSheetList");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        System.out.println("ShowStudentSheetListCommand");
        return page;
    }
}
