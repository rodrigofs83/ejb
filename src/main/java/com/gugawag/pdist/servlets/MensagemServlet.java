package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejb.session.MensagemService;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends HttpServlet {
    @EJB(lookup = "java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "1": {//inserir
                long id = Integer.parseInt(request.getParameter("id"));
                String text = request.getParameter("text");
                mensagemService.insere(id, text);


            }
            case "2": { //listar
                for (Mensagem mensagem : mensagemService.list()) {
                    resposta.println(mensagem.getText());

                }

            }
            case "3": {//getByID
                long id = Integer.parseInt(request.getParameter("id"));
                resposta.println(mensagemService.getByID(id).getText());

                break;

            }

        }
    }
}
