package com.timeconverter.TimeConverterDemo;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class SpokenTimeController extends HttpServlet {

    @Autowired
    private SpokenTimeService spokenTimeService;

    private Gson gson = new Gson();

    @GetMapping("/api/spokenTimeServlet")
    protected void getSpokenTime(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String langCode = request.getParameter("lang");
        String clockTime = request.getParameter("clockTime");
        String spokenTime = "not proper clock time for translate to spoken version";

        if (clockTime.matches("([0-1]?[0-2]:[0-5]?[0-9])")) {
            spokenTime = spokenTimeService.convertTimeToSpokenTimeToSpokenDescription(langCode, clockTime);
        }


        String spokenTimeResult = this.gson.toJson(new SpokenTimeResult(clockTime, spokenTime, langCode));

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        out.print(spokenTimeResult);
        out.flush();


    }

}
