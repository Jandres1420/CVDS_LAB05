package edu.eci.cvds.servlet.model;

import edu.eci.cvds.servlet.SampleServlet;
import edu.eci.cvds.servlet.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(
        urlPatterns = "/data"
)
public class SampleServlet_2 extends SampleServlet {

    private int Id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Todo> lista = new ArrayList<Todo>();
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            String userId = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "0";
            if (Service.getTodo(Integer.parseInt(userId)) != null) {
                resp.setStatus(HttpServletResponse.SC_OK);
                Id = Integer.parseInt(userId);
                lista.add(Service.getTodo(Id));
                responseWriter.write(Service.todosToHTMLTable(lista));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (MalformedURLException e) {
            System.out.println("MalFormadomvn packa");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (FileNotFoundException e) {
            responseWriter.write("No existe ningun elemento con el id indicado.");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            responseWriter.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Todo> lista = new ArrayList<Todo>();
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
            String userId = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "0";
            if (Service.getTodo(Integer.parseInt(userId)) != null) {
                resp.setStatus(HttpServletResponse.SC_OK);
                Id = Integer.parseInt(userId);
                lista.add(Service.getTodo(Id));
                responseWriter.write(Service.todosToHTMLTable(lista));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (MalformedURLException e) {
            System.out.println("MalFormadomvn packa");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (FileNotFoundException e) {
            responseWriter.write("No existe ningun elemento con el id indicado.");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } finally {
            responseWriter.flush();
        }
    }
}
