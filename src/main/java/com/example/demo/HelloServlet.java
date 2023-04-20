package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  private String message;

  @Override
  public void init() {
    message = "Hello World!";
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");

    // Hello
    PrintWriter out = response.getWriter();
    out.println("HOLA");
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    StringBuilder sb = new StringBuilder();
    BufferedReader reader = req.getReader();
    String line;
    //Leyendo body
    while ((line = reader.readLine()) != null) {
      sb.append(line);
    }
    String requestBody = sb.toString();

    //Respondiendo
    resp.setContentType("application/json");
    PrintWriter out = resp.getWriter();
    out.println(requestBody);
  }


  public void destroy() {
  }
}