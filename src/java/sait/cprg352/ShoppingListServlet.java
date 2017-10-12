/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 636334
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null)
        {
            if(action.equals("logout"))
            {
                request.setAttribute("registerMessage", "You have successfully logged out!");
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String action = request.getParameter("action");
       String username = request.getParameter("username");
       String item = request.getParameter("item");
       ArrayList<String> itemList = new ArrayList<>();
       
       if(action!=null)
       {
           if(action.equals("register"))
           {
               request.setAttribute("username", username);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
           if(action.equals("add"))
           {
               itemList.add(item);
               request.setAttribute("itemList", itemList);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
           if(action.equals("delete"))
           {
               itemList.remove(item);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
           }
           
       }
    }
}
