/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.cprg352;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 636334
 */
public class ShoppingListServlet extends HttpServlet 
{

    ArrayList<String> itemList = new ArrayList<>();
    String actionSession;
    int counter;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String whatTheyEntered = (String) session.getAttribute("valueTheyEnteredSession");
       
        //counterArray.add(counter);
        itemList.add("<input type='radio' name=radioButton value='" + counter + "'" + ">" + whatTheyEntered);
        counter++;
        
        session.setAttribute("sessionItemList", itemList);

        String action = request.getParameter("action");
        String actionSession = (String) session.getAttribute("actionStatus");

        if (actionSession == null)
        {
            itemList.clear();
            counter = 0;
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        } else if (actionSession.equals("register") && username != null && action == null)
        {
            session.setAttribute("registeredUsername", username);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (actionSession.equals("add") && username != null && action == null)
        {
            session.setAttribute("theItem", itemList);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (actionSession.equals("delete") && username != null && action == null)
        {
            session.setAttribute("registeredUsername", username);
            session.setAttribute("theItem", itemList);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (username != null && action.equals("logout"))
        {
            session.invalidate();
            itemList.clear();
            counter = 0;
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        */
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
            throws ServletException, IOException 
    {
        
       String action = request.getParameter("action");
       String username = request.getParameter("username");
       
       HttpSession session = request.getSession();
       session.setAttribute("actionStatus", action);
       
       if(action!=null)
       {
           //register
           if(action.equals("register"))
           {
               if(username.equals(""))
               {
                   request.setAttribute("registerMessage", "Please enter a valid username");
                   getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
               }
               else
               {
                   session.setAttribute("username", username);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
               }
               
            }
           //add
           else if(action.equals("add"))
           {
               String input = request.getParameter("item");
               
               if(input.equals(""))
               {
                   request.setAttribute("shoppingListMessage", "Please enter a valid item");
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
               }
               else
               {
                   session.setAttribute("valueTheyEnteredSession", input);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
               }
               
            }
           //delete
           else if(action.equals("delete"))
           {
               session.setAttribute("valueTheyEnteredSession", request.getParameter("item"));
               getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
           }
           
       }
        
        
    }
    
}
