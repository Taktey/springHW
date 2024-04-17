package ru.maxima.calculator_16_04_24;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    @GetMapping("/values")
    public String getParameters(@RequestParam(value = "a", required = false) String a,
                                @RequestParam(value = "b", required = false) String b,
                                @RequestParam(value = "o", required = false) String operation,
                                Model model) {

        double firstValue = Double.parseDouble(a);
        double secondValue = Double.parseDouble(b);

        double res = 0;
        switch (operation) {
            case "plus" -> {
                res = firstValue + secondValue;
                operation = "+";
            }
            case "sub" -> {
                res = firstValue - secondValue;
                operation = "-";
            }
            case "mult" -> {
                res = firstValue * secondValue;
                operation = "*";
            }
            case "div" -> {
                res = firstValue / secondValue;
                operation = "/";
            }
        }
        model.addAttribute("result", a + " " + operation + " " + b + " = " + res);
        return "calcView";
    }
}
