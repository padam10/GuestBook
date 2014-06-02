package controller;

import entity.Guestbook;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.GuestbookFacade;

@WebServlet(name = "GuestBookEJBServlet", urlPatterns = {"/GuestBookEJBServlet"})
public class GuestBookEJBServlet extends HttpServlet {

    @EJB
    private GuestbookFacade guestbookSessionObj;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // for lastname
        String action = request.getParameter("button"); //get the label on the submit button
        switch (action) {
            case "Search": {
                String lastname = request.getParameter("lastname");
                guestbookSessionObj.findByLastName(lastname);
                List<Guestbook> last = guestbookSessionObj.findByLastName(lastname);
                request.setAttribute("last", last);
                break;
            }
            case "ShowAll": {
                // write code for showing all records by calling showAllRecords method in Guestbook Facade
                guestbookSessionObj.showAllRecords();
                List<Guestbook> all = guestbookSessionObj.showAllRecords();
                request.setAttribute("all", all);

                break;
            }

            case "Edit": {
                //get id value from the form interface
                int id = Integer.parseInt(request.getParameter("ID"));
                List<Guestbook> guest = guestbookSessionObj.findById(id);
                //get first name from the form interface
                String firstName = request.getParameter("firstName");
                //get last name from the form interface
                String lastName = request.getParameter("lastName");

                guest.get(0).setId(id); //update id of the guest object managed by the EM instance
                guest.get(0).setFirstname(firstName); //update first name
                guest.get(0).setLastname(lastName); //update last name
                try { //edit method throws transaction exception
                    guestbookSessionObj.edit(guest.get(0));
                    String message = "Edit successful";
                    request.setAttribute("message", message);
                } catch (Exception e) {
                    String message = "Edit failure";
                    request.setAttribute("message", message);
                }
                break;

            }
            case "Delete": {
                //get id value from the form interface
                int id = Integer.parseInt(request.getParameter("ID"));
                List<Guestbook> guest = guestbookSessionObj.findById(id);
                guest.get(0).setId(id); //update id of the guest object managed by the EM instance
                
                try {
                    guestbookSessionObj.deleteById(guest.get(0));
                    String message1 = "Delete successful";
                    request.setAttribute("message1", message1);
                    //set an attribute that encapsulates message
                } catch (Exception e) {
                    String message1 = "Delete failure";
                    request.setAttribute("message1", message1);
                    //set an attribute that encapsulates message
                }
                break;
            }
            
            case "Get No Of Records": {
            int count = guestbookSessionObj.getNumberOfRecords();
            //set an attribute that encapsulates message
            request.setAttribute("count",count);
            
            break;
            }
            
            default: {

                int id = Integer.parseInt(request.getParameter("guestID"));
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                guestbookSessionObj.persistGuestBookData(id, firstName, lastName);
                List<Guestbook> guestList = guestbookSessionObj.findAll();
                request.setAttribute("guestList", guestList);

            }
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
