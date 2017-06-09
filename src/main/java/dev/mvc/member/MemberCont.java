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
     msgs.add("회원 가입이 완료되었습니다.");
     msgs.add("가입해주셔서 감사합니다.");
     links.add("<button type='button' onclick=\"location.href='./login.do'\">로그인</button>");
     
   } else {
     msgs.add("회원 가입에 실패했습니다.");        
     msgs.add("죄송하지만 다시 한 번 시도해주세요. ☎ 123-4567");
     links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
     }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈</button>");
   
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
     msgs.add("회원 수정이 완료되었습니다.");
     links.add("<button type='button' onclick=\"location.href='./read.do?mno="+memberVO.getMno()+"'\">변경 사항 확인</button>");
     
   } else {
     msgs.add("회원 수정에 실패했습니다.");
     msgs.add("죄송하지만 다시한번 시도해주세요. ☏ 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
     
   }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈페이지</button>");
   
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
     msgs.add("현재 패스워드가 일치하지 않습니다.");
     msgs.add("죄송하지만 다시한번 시도해주세요. ☏ 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
     
   } else if (memberProc.passwd_update(memberVO) == 1) {
     msgs.add("패스워드 변경이 완료되었습니다.");
     
   } else {
     msgs.add("패스워드 변경에 실패했습니다.");
     msgs.add("죄송하지만 다시한번 시도해주세요. ☏ 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
     
   }
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈페이지</button>");
   
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
     msgs.add("회원을 삭제했습니다.");
     links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈페이지</button>");
   } else {
     msgs.add("회원 삭제에 실패했습니다.");
     msgs.add("죄송하지만 다시한번 시도해주세요.");
     links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
     links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈페이지</button>");
   }

   links.add("<button type='button' onclick=\"location.href='"+root+"/member/list.do'\">목록</button>");

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
     msgs.add("현재 패스워드가 일치하지 않습니다.");
     msgs.add("죄송하지만 다시한번 시도해주세요. ☏ 000-0000-0000");
     links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
     
   } else {
     int mno = memberProc.readById(id).getMno();
     session.setAttribute("mno", mno);
     session.setAttribute("id", id);
     session.setAttribute("passwd", passwd);

     // ---------------------------------------------------------
     // id 관련 쿠키 저장
     // ---------------------------------------------------------
     String id_save = Tool.checkNull(memberVO.getId_save());
     if(id_save.equals("Y")){
       Cookie ck_id = new Cookie("ck_id", id);
       ck_id. setMaxAge(60 * 60 * 72 * 10); // 30 일
       response.addCookie(ck_id);
     } else { // N
       Cookie ck_id = new Cookie("ck_id", "");
       ck_id. setMaxAge(0); // 30 일
       response.addCookie(ck_id);
     }
     Cookie ck_id_save = new Cookie("ck_id_save", id_save);
     ck_id_save. setMaxAge(60 * 60 * 72 * 10); // 30 일
     response.addCookie(ck_id_save);

     // ---------------------------------------------------------
     // passwd 관련 쿠키 저장
     // ---------------------------------------------------------
     String passwd_save = Tool.checkNull(memberVO.getPasswd_save());
     if(passwd_save.equals("Y")){
       Cookie ck_passwd = new Cookie("ck_passwd", passwd);
       ck_passwd. setMaxAge(60 * 60 * 72 * 10); // 30 일
       response.addCookie(ck_passwd);
     } else { // N
       Cookie ck_passwd = new Cookie("ck_passwd", "");
       ck_passwd. setMaxAge(0); // 30 일
       response.addCookie(ck_passwd);
     }
     Cookie ck_passwd_save = new Cookie("ck_passwd_save", passwd_save);
     ck_passwd_save. setMaxAge(60 * 60 * 72 * 10); // 30 일
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

   msgs.add("이용해 주셔서 감사합니다.");
   
   links.add("<button type='button' onclick=\"location.href='"+root+"/home.do'\">홈페이지</button>");
   
   session.invalidate(); // session 변수 삭제
   
   mav.addObject("msgs", msgs);
   mav.addObject("links", links);
   
   return mav;
 }
}

