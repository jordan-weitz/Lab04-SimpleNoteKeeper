/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 *
 * @author jweit
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        Note note;
        try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            note = getNote(path);
            request.setAttribute("title", note.getTitle());
            request.setAttribute("content", note.getContent());
            String edit = request.getParameter("edit");
            if (edit != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("Title");
        String content = request.getParameter("Content");

        Note note = new Note(title, content);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(note.getTitle());
        pw.println(note.getContent());
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

    }

//    private String getTitle(String path) throws FileNotFoundException, IOException {
//        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//        return br.readLine();
//    }
//
//    private String getContent(String path) throws FileNotFoundException, IOException {
//        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//        String temp = br.readLine();
//        return br.readLine();
//    }

    private Note getNote(String path) throws Exception {
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        Note note = new Note(title, content);
        return note;
    }

}
