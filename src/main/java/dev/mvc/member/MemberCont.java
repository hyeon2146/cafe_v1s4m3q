package dev.mvc.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.tool.Tool;

@Controller
public class MemberCont {
  @Autowired
  @Qualifier("dev.mvc.member.MemberProc")
  private MemberProcInter memberProc;
  
  public MemberCont(){
    System.out.println("--> MemberCont created.");
  }
  

//http://localhost:9090/member/member/checkId.do?id=user1
 @ResponseBody
 @RequestMapping(value="/member/checkId.do", method=RequestMethod.GET,
                          produces = "text/plain;charset=UTF-8")
 public String checkId(String id) {
   JSONObject obj = new JSONObject();
   
   int cnt = memberProc.checkId(id);
   
   obj.put("cnt", cnt); // {"cnt": 1}
   
   return obj.toJSONString();
 }

 @RequestMapping(value="/member/create.do", method=RequestMethod.GET)
 public ModelAndView create(){
   System.out.println("--> create() GET called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/create"); // webapp/member/create.jsp
   
   return mav;
 }
 
 @RequestMapping(value="/member/create.do", method=RequestMethod.POST)
 public ModelAndView create(HttpServletRequest request, 
                                       MemberVO memberVO){
   System.out.println("--> create() POST called");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message"); // webapp/member/create.jsp
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();
   
   String root = request.getContextPath();
   if(memberProc.create(memberVO) == 1){
     msgs.add("ȸ�� ������ �Ϸ�Ǿ����ϴ�.");
     msgs.add("�������ּż� �����մϴ�.");
     links.add("<button type='button' onclick=\"location.href='./login.do'\">�α���</button>");
     
   } else {
     msgs.add("ȸ�� ���Կ� �����߽��ϴ�.");        
     msgs.add("�˼������� �ٽ� �� �� �õ����ּ���. �� 123-4567");
     links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
     }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ</button>");
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   return mav;
 }
 
 @RequestMapping(value="/member/list.do", method=RequestMethod.GET)
 public ModelAndView list(){
   System.out.println("--> list() GET called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/list"); // webapp/member/list.jsp
   
   List<MemberVO> list = memberProc.list();
   mav.addObject("list", list);
   
   return mav;
 }  

 @RequestMapping(value="/member/read.do", method=RequestMethod.GET)
 public ModelAndView read(int mno){
   System.out.println("--> read(int mno) GET called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/read"); // webapp/member/read.jsp
   
   MemberVO memberVO = memberProc.read(mno);
   mav.addObject("memberVO", memberVO);
   
   return mav;
 }  

 
 @RequestMapping(value="/member/update.do", method=RequestMethod.POST)
 public ModelAndView update(HttpServletRequest request, 
                                          MemberVO memberVO){
   System.out.println("--> update() POST called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message"); // webapp/member/message.jsp
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();
   
   String root = request.getContextPath();
   if (memberProc.update(memberVO) == 1) {
     msgs.add("ȸ�� ������ �Ϸ�Ǿ����ϴ�.");
     links.add("<button type='button' onclick=\"location.href='./read.do?mno="+memberVO.getMno()+"'\">���� ���� Ȯ��</button>");
     
   } else {
     msgs.add("ȸ�� ������ �����߽��ϴ�.");
     msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���. �� 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
     
   }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ������</button>");
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   
   return mav;
 }
 
 
 // http://localhost:9090/member/member/passwd_check.do?mno=1
 @RequestMapping(value="/member/passwd_update.do", method=RequestMethod.GET)
 public ModelAndView passwd_check(int mno){
   System.out.println("--> passwd_check(int mno) GET called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/passwd_check"); // passwd_check.jsp

   mav.addObject("mno", mno);
   
   return mav;
 }  

 @RequestMapping(value="/member/passwd_update.do", method=RequestMethod.POST)
 public ModelAndView passwd_update(HttpServletRequest request, 
                                                   MemberVO memberVO){
   System.out.println("--> passwd_update() POST called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message"); // webapp/member/message.jsp
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();
   
   String root = request.getContextPath();
   
   if (memberProc.passwd_check(memberVO) != 1) {
     msgs.add("���� �н����尡 ��ġ���� �ʽ��ϴ�.");
     msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���. �� 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
     
   } else if (memberProc.passwd_update(memberVO) == 1) {
     msgs.add("�н����� ������ �Ϸ�Ǿ����ϴ�.");
     
   } else {
     msgs.add("�н����� ���濡 �����߽��ϴ�.");
     msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���. �� 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
     
   }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ������</button>");
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   
   return mav;
 }

 @RequestMapping(value = "/member/delete.do", method = RequestMethod.GET)
 public ModelAndView delete(int mno) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/delete"); // /webapp/member/delete.jsp
   mav.addObject("mno", mno);
   
   return mav;
 }

 @RequestMapping(value = "/member/delete.do", method = RequestMethod.POST)
 public ModelAndView delete(HttpServletRequest request, 
                                       MemberVO memberVO) {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message");

   String root = request.getContextPath();
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();

   if (memberProc.delete(memberVO.getMno()) == 1) {
     msgs.add("ȸ���� �����߽��ϴ�.");
     links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ������</button>");
   } else {
     msgs.add("ȸ�� ������ �����߽��ϴ�.");
     msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���.");
     links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
     links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ������</button>");
   }

   links.add("<button type='button' onclick=\"location.href='"+root+"/member/list.do'\">���</button>");

   mav.addObject("msgs", msgs);
   mav.addObject("links", links);

   return mav;
 }
 
 //http://localhost:9090/member/member/login.do
 @RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
 public ModelAndView login() {
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/login_ck_form"); // /webapp/member/login.jsp
   
   return mav;
 }


 @RequestMapping(value="/member/login.do", method=RequestMethod.POST)
 public ModelAndView login(HttpServletRequest request, 
                                      HttpServletResponse response,
                                      HttpSession session,
                                      MemberVO memberVO){
   System.out.println("--> login() POST called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message"); // webapp/member/message.jsp
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();
   
   String root = request.getContextPath();
   
   String id = memberVO.getId();
   String passwd = memberVO.getPasswd();
   if (memberProc.login(id, passwd) != 1) {
     msgs.add("���� �н����尡 ��ġ���� �ʽ��ϴ�.");
     msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���. �� 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
     
   } else {
     int mno = memberProc.readById(id).getMno();
     session.setAttribute("mno", mno);
     session.setAttribute("id", id);
     session.setAttribute("passwd", passwd);

     // ---------------------------------------------------------
     // id ���� ��Ű ����
     // ---------------------------------------------------------
     String id_save = Tool.checkNull(memberVO.getId_save());
     if(id_save.equals("Y")){
       Cookie ck_id = new Cookie("ck_id", id);
       ck_id. setMaxAge(60 * 60 * 72 * 10); // 30 ��
       response.addCookie(ck_id);
     } else { // N
       Cookie ck_id = new Cookie("ck_id", "");
       ck_id. setMaxAge(0); // 30 ��
       response.addCookie(ck_id);
     }
     Cookie ck_id_save = new Cookie("ck_id_save", id_save);
     ck_id_save. setMaxAge(60 * 60 * 72 * 10); // 30 ��
     response.addCookie(ck_id_save);

     // ---------------------------------------------------------
     // passwd ���� ��Ű ����
     // ---------------------------------------------------------
     String passwd_save = Tool.checkNull(memberVO.getPasswd_save());
     if(passwd_save.equals("Y")){
       Cookie ck_passwd = new Cookie("ck_passwd", passwd);
       ck_passwd. setMaxAge(60 * 60 * 72 * 10); // 30 ��
       response.addCookie(ck_passwd);
     } else { // N
       Cookie ck_passwd = new Cookie("ck_passwd", "");
       ck_passwd. setMaxAge(0); // 30 ��
       response.addCookie(ck_passwd);
     }
     Cookie ck_passwd_save = new Cookie("ck_passwd_save", passwd_save);
     ck_passwd_save. setMaxAge(60 * 60 * 72 * 10); // 30 ��
     response.addCookie(ck_passwd_save);
     // ---------------------------------------------------------
     
     mav.setViewName("redirect:/index.jsp" );
   } 
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   
   return mav;
 }

 @RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
 public ModelAndView logout(HttpServletRequest request, 
                                      HttpSession session){
   System.out.println("--> logout() GET called.");
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/member/message"); // webapp/member/message.jsp
   
   ArrayList<String> msgs = new ArrayList<String>();
   ArrayList<String> links = new ArrayList<String>();
   
   String root = request.getContextPath();

   msgs.add("�̿��� �ּż� �����մϴ�.");
   
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">Ȩ������</button>");
   
   session.invalidate(); // session ���� ����
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   
   return mav;
 }
}

