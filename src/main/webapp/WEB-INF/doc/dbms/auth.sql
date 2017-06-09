1. ���� ������ ���� 1
 
1) DBMS ����
M: ������, Y: ȸ��, �α��� ����, N: �α��� �Ұ�, G: �մ�
 
http://127.0.0.1:9090/ojt/member/list.do
 
<A href='/member/list.do'>ȸ�� ����</A>
 
DROP TABLE authurl;
CREATE TABLE authurl(
  authurlno INT                 NOT NULL AUTO_INCREMENT,
  url          VARCHAR(100) NOT NULL,
  act          VARCHAR(10)   DEFAULT 'G' NOT NULL,
  etc          VARCHAR(100) NULL,
  PRIMARY KEY (authurlno)
)
 
INSERT INTO authurl (url, act, etc)
VALUES('/member/list.do', 'M', 'ȸ�� ���');
 
INSERT INTO authurl (url, act, etc)
VALUES('/member/create.do', 'MYG', 'ȸ�� ����');
           
INSERT INTO authurl (url, act, etc)
VALUES('/member/update.do', 'MY', 'ȸ�� ���� ����');
           
INSERT INTO authurl (url, act, etc)
VALUES('/member/delete.do', 'M', 'ȸ�� ���� ����');
           
SELECT authurlno, url, act, etc 
FROM authurl
ORDER BY url ASC;
 
 AUTHURLNO URL               ACT ETC
 --------- ----------------- --- --------
         2 /member/create.do MYG ȸ�� ����
         4 /member/delete.do M   ȸ�� ���� ����
         1 /member/list.do   M   ȸ�� ���
         3 /member/update.do MY  ȸ�� ���� ����
         
         
2) Spring controller���� ���         
  @RequestMapping(value="/blog/create.do", method=RequestMethod.GET)
  public ModelAndView create(HttpServletRequest request, 
                                        HttpSession session, int categoryno){
    // System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    
    if (Tool.authurl(request.getRequestURI(), session) == false) {
      mav.setViewName("redirect:/member/logn_need.jsp");
    } else{
      mav.setViewName("/blog/create"); // webapp/blog/create.jsp
      
      CategoryVO categoryVO = categoryProc.read(categoryno);
      mav.addObject("categoryVO", categoryVO);  // FK column
    }
    
    return mav;
  }
      
 
         
2. ���� ������ ���� 2
 
M: ������, Y: ȸ��, �α��� ����, N: �α��� �Ұ�, G: �մ�
 
http://127.0.0.1:9090/ojt/go?urlid=A0001
http://127.0.0.1:9090/ojt/go?urlid=B0001
http://127.0.0.1:9090/ojt/go?urlid=A0002
http://127.0.0.1:9090/ojt/go?urlid=A0003
 
<A href='/go?urlid=A0003'>ȸ�� ����</A>
 
DROP TABLE authurl2;
CREATE TABLE authurl2(
  authurl2no INT                NOT NULL,
  urlid         VARCHAR(5)    UNIQUE NOT NULL,  
  url            VARCHAR(100) NOT NULL,
  act            VARCHAR(10)   DEFAULT 'G' NOT NULL,
  etc            VARCHAR(100) NULL,
  PRIMARY KEY (authurl2no)
);
 
INSERT INTO authurl2 (authurl2no,
                             urlid, url, act, etc)
VALUES((SELECT NVL(MAX(authurl2no), 0) + 1 as authurl2no FROM authurl2),
           'A0001', '/member/list.do', 'M', 'ȸ�� ���');
 
INSERT INTO authurl2 (authurl2no,
                             urlid, url, act, etc)
VALUES((SELECT NVL(MAX(authurl2no), 0) + 1 as authurl2no FROM authurl2),
           'B0001', '/member/create.do', 'MYG', 'ȸ�� ����');
           
INSERT INTO authurl2 (authurl2no,
                             urlid, url, act, etc)
VALUES((SELECT NVL(MAX(authurl2no), 0) + 1 as authurl2no FROM authurl2),
           'A0002', '/member/update.do', 'MY', 'ȸ�� ��������');
           
SELECT authurl2no, urlid, url, act, etc 
FROM authurl2
ORDER BY urlid ASC;   
           
 AUTHURL2NO URLID URL               ACT ETC
 ---------- ----- ----------------- --- -------
          1 A0001 /member/list.do   M   ȸ�� ���
          3 A0002 /member/update.do MY  ȸ�� ��������
          2 B0001 /member/create.do MYG ȸ�� ����