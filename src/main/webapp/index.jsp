<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> New Guest Book Maven-arch</title>
    </head>
    <h1> Guest Users</h1>
    <body>
        <c:forEach var="guest" items="${guestList}">
            <p>${guest.id} ${guest.firstname} ${guest.lastname}  </p>
        </c:forEach>
        <form method="post" action="GuestBookEJBServlet">
            <h1>Sign On the Guest Book</h1>
            <table>
                <tr><td>ID:</td><td><input type="text" name="guestID" /></td></tr>
                <tr><td>First Name:</td><td><input type="text" name="firstName" /></td></tr>
                <tr><td>Last Name:</td><td><input type="text" name="lastName" /></td></tr>
                <tr><td>	
                        <input type="submit" name="button" value="Sign on Guest Book"/>
                    </td>
                </tr>
            </table>
        </form>
...............................................................................
        <form method="post" action="GuestBookEJBServlet"> 
            <h1>Search a Record by Last Name</h1> 
            <table> 
                <tr><td>Last Name:</td><td><input type="text" name="lastname" /></td></tr> 
                <tr><td> 
                        <input type="submit" name="button" value="Search"/> 
                    </td> 
                </tr> 
            </table> 
        </form> 
        <c:forEach var="guest" items="${last}">
            <p>${guest.id} ${guest.firstname} ${guest.lastname}  </p>
        </c:forEach>                        
     
..............................................................................
        <form method="post" action="GuestBookEJBServlet"> 
            <h1>Show All Records</h1> 
            <table> 
                <tr><td> 
                        <input type="submit" name="button" value="ShowAll"/> 
                    </td> 
                </tr> 
            </table> 
        </form> 
           <c:forEach var="guest" items="${all}">
            <p>${guest.id} ${guest.firstname} ${guest.lastname}  </p>
        </c:forEach> 
................................................................................
        <form method="post" action="GuestBookEJBServlet">
            <h1>Edit a Record</h1>
            <table>
                <tr><td>ID:</td><td><input type="text" name="ID" /></td></tr>
                <tr><td>First Name:</td><td><input type="text" name="firstName" /></td></tr>
                <tr><td>Last Name:</td><td><input type="text" name="lastName" /></td></tr>
                <tr><td>	
                        <input type="submit" name="button" value="Edit"/>
                        <br>
                        Response from the Server:  ${message}
                        
                    </td>
            </table>
                </tr>
        </form>

           
.................................................................................
        <form method="post" action="GuestBookEJBServlet"> 
            <h1>Delete a Record by </h1> 
            <table> 
                <tr><td>ID:</td><td><input type="text" name="ID" /></td></tr> 
                <tr><td> 
                        <input type="submit" name="button" value="Delete"/> 
                        <br>
                        Response from Server: ${message1}
                    </td> 
                </tr> 
                </table> 
        </form> 
             
        
...................................................................................
        <form method="post" action="GuestBookEJBServlet"> 
            <h1>Show Number of Records in the Database </h1> 
            <table> 
                <tr><td> 
                        <input type="submit" name="button" value="Get No Of Records"/> 
                        <br>
                        Number of Records:  ${count}
                    </td> 
                </tr> 
               </table> 
        </form> 
      
    </body>
</html>

