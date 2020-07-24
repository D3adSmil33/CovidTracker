package com.example.tracker.Controllers;

import com.example.tracker.Services.CoronaVirusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusData coronaVirusData;

    @RequestMapping("/")
    public ModelAndView home() {

        ModelAndView mv  = new ModelAndView("home");

        mv.addObject("States",coronaVirusData.getAllStates());
        mv.addObject("totalCases", coronaVirusData.getTotalCases());

        return mv;
    }
}
