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
import javax.servlet.http.HttpSession;

/**
 *
 * @author 636334
 */
public class ShoppingListServlet extends HttpServlet 
{    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        ArrayList<String> itemList;
        String action = request.getParameter("action");
        
        if(action==null)
        {
            if(username==null)
            {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            else
            {
                itemList = (ArrayList<String>)session.getAttribute("itemlist");
                
                if(itemList!=null)
                {
                    int listSize = itemList.size();
                    request.setAttribute("listsize", listSize);
                    request.setAttribute("itemlist", itemList);
                }
                else
                {
                    request.setAttribute("listsize", 0);           
                }
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }
        else if(action.equals("logout"))
        {
            //session.removeAttribute("username");
            //session.removeAttribute("itemList");
            session.invalidate();
            request.setAttribute("registerMessage", "Logged Out");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       HttpSession session = request.getSession();
       
       String action = request.getParameter("action");
       String username = request.getParameter("username");
       
       ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");
       
       if(itemList==null)
       {
           itemList = new ArrayList<String>();
       }

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
               String item = request.getParameter("item");
               
               if(item.equals(""))
               {
                   request.setAttribute("shoppingListMessage", "Please enter a valid item");
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
               }
               else
               {
                   itemList.add(item);
                   session.setAttribute("itemList", itemList);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
               }
            }
           //delete
           else if(action.equals("delete"))
           {
               int index = Integer.parseInt(request.getParameter("itemName"));
               itemList.remove(index);
               session.setAttribute("itemList", itemList);
               getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
           }          
       }
  
    }

}
