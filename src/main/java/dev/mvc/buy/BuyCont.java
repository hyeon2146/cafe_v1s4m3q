package dev.mvc.buy;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyCont {

  @Autowired
  @Qualifier("dev.mvc.buy.BuyProc")
  private BuyProcInter buyProc;
  public BuyCont() {
    System.out.println("--> BuyCont() created.");
  }
  
  @RequestMapping(value = "/buy/create.do", method = RequestMethod.GET)
  public ModelAndView create() {
    System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/buy/create"); // webapp/buy/create.jsp

    return mav;
  }

  @RequestMapping(value = "/buy/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, BuyVO buyVO) {
    // System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/review/message"); // webapp/buy/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    String root = request.getContextPath();
    if (buyProc.create(buyVO) == 1) {

      // ������ �κ�
      msgs.add("<i class='fa fa-normal fa-check-circle' style='font-size:5em;'></i>");
      msgs.add("�Խù��� ����߽��ϴ�.");
      links.add("<a class='button' href='./create.do?'>��� ���</a>");

    } else {
      // ������ �κ�
      msgs.add("<i class='fa fa-normal fa-exclamation-circle' style='font-size:5em;'></i>");
      msgs.add("�Խù� ��Ͽ� �����߽��ϴ�.");
      msgs.add("�ٽ��ѹ� �õ����ּ���.");
      links.add("<a class='button' href='history.back()'>�ٽ� �õ�</a>");

    }
    // ������ �κ�
    links.add("<a class='button' href='./list.do?'>���</a>");
    links.add("<a class='button' href='" + root + "/home.do'>Ȩ������</a>");

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

}
