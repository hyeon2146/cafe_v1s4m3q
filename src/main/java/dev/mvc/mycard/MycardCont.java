package dev.mvc.mycard;

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

@Controller
public class MycardCont {

  @Autowired
  @Qualifier("dev.mvc.mycard.MycardProc")
  private MycardProcInter mycardProc;
  
  public MycardCont() {
    System.out.println("--> MycardCont created.");
  }

  @RequestMapping(value = "/mycard/create.do", method = RequestMethod.GET)
  public ModelAndView create(HttpSession session) {
    System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/create"); // webapp/mycard/create.jsp

    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
    return mav;
  }

  @RequestMapping(value = "/mycard/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request, MycardVO mycardVO) {
    System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/message"); // webapp/mycard/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    String root = request.getContextPath();
    if (mycardProc.create(mycardVO) == 1) {

      msgs.add("카드 등록을 완료했습니다.");

    } else {
      msgs.add("카드 등록에 실패했습니다.");
      msgs.add("다시한번 시도해주세요.");
      links.add("<a class='button' href='history.back()'>다시 시도</a>");

    }
    links.add("<a class='button' href='./list.do?'>목록</a>");
    links.add("<a class='button' href='" + root + "/index.do'>홈페이지</a>");

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  @RequestMapping(value="/mycard/list.do", method=RequestMethod.GET)
  public ModelAndView list(HttpSession session){
    System.out.println("--> list() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/list"); // webapp/mycard/list.jsp
    
    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
/*    String id = (String) session.getAttribute("id");
    mav.addObject("id", id);
*/    
    List<MycardVO> list = mycardProc.list(mno);
    mav.addObject("list", list);
    
    
    return mav;
  }    
  
  @RequestMapping(value="/mycard/list_all.do", method=RequestMethod.GET)
  public ModelAndView list_all(){
    System.out.println("--> list() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/list_all"); // webapp/mycard/list_all.jsp
   
    
    List<MycardVO> list = mycardProc.list_all();
    mav.addObject("list", list);
    
    
    return mav;
  }  


  @RequestMapping(value = "/mycard/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int mycardno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/delete"); // /webapp/mycard/delete.jsp
    mav.addObject("mycardno", mycardno);
    
    return mav;
  }

  @RequestMapping(value = "/mycard/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(HttpServletRequest request, 
                                        MycardVO mycardVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/message");

    String root = request.getContextPath();
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (mycardProc.delete(mycardVO.getMycardno()) == 1) {
      msgs.add("카드를 삭제했습니다.");
      links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">홈페이지</button>");
      links.add("<button type='button' onclick=\"location.href='"+root+"/mycard/list.do'\">목록</button>");
    } else {
      msgs.add("카드 삭제에 실패했습니다.");
      msgs.add("죄송하지만 다시한번 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
      links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">홈페이지</button>");
    }


    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }

  @RequestMapping(value="/mycard/update.do", method=RequestMethod.GET)
  public ModelAndView read(HttpSession session, int mycardno){
    System.out.println("--> read GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/update"); // webapp/mycard/update.jsp
    
    int mno = (Integer) session.getAttribute("mno");
    mav.addObject("mno", mno);
    
    MycardVO mycardVO = mycardProc.read(mycardno);
    mav.addObject("mycardVO", mycardVO);
    
    return mav;
  }  

  @RequestMapping(value="/mycard/update.do", method=RequestMethod.POST)
  public ModelAndView update(HttpServletRequest request, 
      MycardVO mycardVO){
    System.out.println("--> update() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mycard/message"); // webapp/mycard/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    String root = request.getContextPath();
    if (mycardProc.update(mycardVO) == 1) {
      msgs.add("카드 이름 수정이 완료되었습니다.");
      links.add("<button type='button' onclick=\"history.back()\">확인</button>");
      
    } else {
      msgs.add("카드 이름 수정에 실패했습니다.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
      
    }
    links.add("<button type='button' onclick=\"location.href='"+root+"/index.do'\">홈페이지</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
}
