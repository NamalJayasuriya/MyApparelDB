/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBInterface;

import EntityDB.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author namal
 */
@WebServlet(name = "jsonServlet", urlPatterns = {"/jsonServlet"})
public class jsonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json");       
        JSONParser jsp = new JSONParser();
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            System.out.println("request ="+sb.toString());
            Object obj =jsp.parse(sb.toString().split("=")[1]);
            JSONObject json = (JSONObject)obj;
            String st;
                st = (String)json.get("messagetype");
            if(st.equals("Login")){
                UserControl ucon= new UserControl();
                response.getOutputStream().print(this.login(json,ucon).toJSONString());
                response.getOutputStream().flush();
            }else if(st.equals("Login1")) {
                        
            
            }else if(st.equals("QueryItem")) {
                        
            
            }else if(st.equals("QueryAll")) {
                        
            
            }else if(st.equals("UpdateItemQty")) {
                        
            
            }
            else{
            
            }
    } catch (Exception ex) {
            ex.printStackTrace();
            JSONObject json = new JSONObject();
            json.put("messagetype","loginreply");
            json.put("status", "fail");
            json.put("error","undefined system error");
            response.getOutputStream().print(json.toJSONString());
            response.getOutputStream().flush();
        }
    }
    
    protected JSONObject login(JSONObject json, UserControl ucon){
                String st;
                User usr=new User();
                String status;
                String error = null;
                
                st=(String)json.get("uname");
                
                if(ucon.getUser(st)!=null){
                 usr=ucon.getUser(st);
                   if(usr.getPassword().equals((String)json.get("pwd"))){
                       if(usr.getUserCategory().equals((String)json.get("type"))){
                           status= "success";
                       }else{
                           status="fail";
                           error= "error: user type mismatch";
                       }
                   }else{
                       status="fail";
                       error= "error: password mismatch";
                   }
                }
                else{
                    status="fail";
                    error= "error: username not exist";
                }
                System.out.println(error + status);
                json.clear();
                json.put("messagetype","loginreply");
                json.put("status", status);
                json.put("error",error);
                System.out.println(json.toJSONString());
                return json;
                
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
// </editor-fold>


