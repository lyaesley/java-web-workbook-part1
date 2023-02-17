package com.lyae.workbook.javawebworkbook.todo;

import com.lyae.workbook.javawebworkbook.todo.dto.TodoDTO;
import com.lyae.workbook.javawebworkbook.todo.service.TodoService;
import com.sun.tools.javac.comp.Todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TotoReadContorller extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("/todo/read");

        // /todo/read?tno=123
        Long tno = Long.valueOf(req.getParameter("tno"));

        TodoDTO dto = TodoService.INSTANCE.get(tno);

        req.setAttribute("dto", dto);

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp")
                .forward(req, resp);
    }


}
