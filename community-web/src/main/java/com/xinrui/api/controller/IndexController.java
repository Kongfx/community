package com.xinrui.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping(value = "/index2")
    public ModelAndView index(Model model){
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/pay")
    public ModelAndView pay(Model model){
        String body = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<form action=\"http://192.168.1.20:5080/buybal-api/v1.0/cashier/initializ/membervip\" id=\"form\" method=\"post\">\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"signature\"  value='luJ3FJ/j1RD9STjgLy3NCe7DpfgKJxUM4cU2CIVVHetCZEcAXjJQmA=='><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"workKey\"  value='636893AE2B0C6F14770750089AD08F59A5072E006F7A46A5C425E62351DA54482BD29528F5BC977048B5CDADC79325A0A739DD0C6578B5EC353FA9C90815A42FE6FCF6C795E75AB880B4CA28CB67CDD63B2E26F7B9CA657A208C8A490EEC011604350E947788EB12DD94F744DE6A0EA7256FF969AC65D138B0F6456C5B53BFF0'><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"funSource\"  value='9'><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"storeId\"  value='o+GTGFfcTXkV9cJj4iBV9w=='><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"outOrderNo\"  value='7837274687155273728'><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"pinKey\"  value='698438C8F7E80B505B005C51A06E9C2342D189399CCA062D6CA7B55F8602AF2EBCE972A807E28D37E27F7406409DA2C917EA9FB7C4468D2A5C12C63B14955253F9554AB8A7C463AC0E49B44B64BCE130F1C6DE83E4F9262CA98776A118D571042AF46A64F49B176646C75AF3ADADC9075261B88D0730AC89B4CB108EF6CCD5C0'><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"mchntId\"  value='o+GTGFfcTXkV9cJj4iBV9w=='><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"transAmt\"  value='bC4+Dtaan9c='><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"notifyUrl\"  value='QTMGhzy1oxT6c5KAHH3HI70LD24GRANEufepNiYlAgPmCk5F4iOx3McPSGNO VCiJ'><br>\n" +
                "\t\t\n" +
                "\t\t\t<input type=\"hidden\" name=\"returnUrl\"  value='QTMGhzy1oxT6c5KAHH3HI70LD24GRANEufepNiYlAgNaoNegzqL3qzZiyWy8 zFKk'><br>\n" +
                "\t\t\n" +
                "\t</form> \n" +
                "\t<script type=\"text/javascript\">\n" +
                "\t\twindow.onload=function(){\n" +
                "\t\t\tdocument.getElementById(\"form\").submit();\n" +
                "\t\t}\n" +
                "\t</script>\n" +
                "</body>\n" +
                "</html>";
        model.addAttribute("content", body);
        return new ModelAndView("paypage");
    }


}
