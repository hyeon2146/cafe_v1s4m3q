package dev.mvc.pay;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.member.MemberProcInter;
import dev.mvc.member.MemberVO;
import dev.mvc.mycard.MycardProcInter;
import dev.mvc.mycard.MycardVO;

@Controller
public class PayCont {
  
  @Autowired
  @Qualifier("dev.mvc.pay.PayProc")
  private PayProcInter payProc;
  
  @Autowired
  @Qualifier("dev.mvc.mycard.MycardProc")
  private MycardProcInter mycardProc;
  
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  public PayCont() {
    System.out.println("--> PayCont created.");
  }

  @RequestMapping(value = "/pay/create.do", method = RequestMethod.GET)
  public ModelAndView create(HttpSession session) {
    //  - ��ٱ��Ͽ��� �ֹ� ���� o, ȸ����ȣ �´� �� ���� �������� ��� -> ���� ������
    // ȸ����ȣ
    System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/create"); // webapp/pay/create.jsp

    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
    
    MemberVO memberVO = memberProc.read(mno);
    mav.addObject("memberVO", memberVO);
    
    List<MycardVO> list = mycardProc.list(mno);
    mav.addObject("list", list);
    
    return mav;
  }

  @RequestMapping(value = "/pay/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, PayVO payVO, int mycardno) {
    /*- ���� ���̺� ������ �߰�
    - ���� ���� ���̺� ������ �߰�
    - ��ٱ��� ���̺��� �ҷ��Դ� �����͵� ���� */
    System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/message"); // webapp/pay/message.jsp
    
    MycardVO mycardVO = mycardProc.read(mycardno);
    int total = payVO.getTotal();
    int money = mycardVO.getMoney();
    
    // �ܾ� üũ
    boolean lack = false; 
    if((money - total) < 0 ){
      lack = true;
    } else{
      mycardVO.setMoney(money-total);
    }
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    String root = request.getContextPath();
    if(lack==false){ // �ܾ� ���� �˻� 
      if (payProc.create(payVO) == 1) {
        mycardProc.update_money(mycardVO);
        msgs.add("������ �Ϸ��߽��ϴ�.");
  
      } else { // ���� ����
        msgs.add("������ �����߽��ϴ�.");
        msgs.add("�ٽ��ѹ� �õ����ּ���.");
        links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      }
    } else{ // �ܾ� ������
      msgs.add("�ܾ� �������� ������ �����߽��ϴ�.");
      msgs.add("�ٽ��ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
    }
    links.add("<a class='button' href='./list.do?'>���</a>");
    links.add("<a class='button' href='" + root + "/index.do'>Ȩ������</a>");

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  @RequestMapping(value="/pay/list.do", method=RequestMethod.GET)
  public ModelAndView list(HttpSession session){
    System.out.println("--> list() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/list"); // webapp/pay/list.jsp
    
    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
    String id = (String) session.getAttribute("id");
    mav.addObject("id", id);
    
    List<PayVO> list = payProc.list(mno);
    mav.addObject("list", list);
    
    
    return mav;
  }    
  
  @RequestMapping(value="/pay/list_all.do", method=RequestMethod.GET)
  public ModelAndView list_all(){
    System.out.println("--> list() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/list_all"); // webapp/pay/list_all.jsp
   
    
    List<PayVO> list = payProc.list_all();
    mav.addObject("list", list);
    
    
    return mav;
  }  


  @RequestMapping(value = "/pay/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int payno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/delete"); // /webapp/pay/delete.jsp
    mav.addObject("payno", payno);
    
    return mav;
  }

  @RequestMapping(value = "/pay/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, 
                                        PayVO payVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/message");

    String root = request.getContextPath();
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (payProc.delete(payVO.getPayno()) == 1) {
      msgs.add("������ ����߽��ϴ�.");
      links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">Ȩ������</button>");
      links.add("<button type='button' onclick=\"history.back()\">���</button>");
    } else {
      msgs.add("���� ��ҿ� �����߽��ϴ�.");
      msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">Ȩ������</button>");
    }


    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }

  @RequestMapping(value="/pay/update.do", method=RequestMethod.GET)
  public ModelAndView read(HttpSession session, int payno){
    System.out.println("--> read GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/update"); // webapp/pay/update.jsp
    
    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
    
    PayVO payVO = payProc.read(payno);
    mav.addObject("payVO", payVO);
    
    return mav;
  }  

  @RequestMapping(value="/pay/update.do", method=RequestMethod.POST)
  public ModelAndView update(HttpServletRequest request, 
                                           PayVO payVO){
    System.out.println("--> update() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/pay/message"); // webapp/pay/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    String root = request.getContextPath();
    if (payProc.update(payVO) == 1) {
      msgs.add("���� ���� ������ �Ϸ�Ǿ����ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">Ȯ��</button>");
      
    } else {
      msgs.add("���� ���� ������ �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
      
    }
    links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">Ȩ������</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
}
