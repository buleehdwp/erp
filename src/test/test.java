////package spms.servlets;
////
////import java.io.IOException;
////import java.io.PrintWriter;
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.sql.Statement;
////
////import javax.servlet.GenericServlet;
////import javax.servlet.ServletException;
////import javax.servlet.ServletRequest;
////import javax.servlet.ServletResponse;
////import javax.servlet.annotation.WebServlet;
////
////import oracle.jdbc.OracleDriver;
////
/////**
//// * Servlet implementation class MemberListServlet
//// */
////@WebServlet("/member/list")
////public class MemberListServlet extends GenericServlet {
////   private static final long serialVersionUID = 1L;
////       
////    /**
////     * @see GenericServlet#GenericServlet()
////     */
////    public MemberListServlet() {
////        super();
////        // TODO Auto-generated constructor stub
////    }
////
////   /**
////    * @see Servlet#service(ServletRequest request, ServletResponse response)
////    */
////   public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
////      // TODO Auto-generated method stub
////      Connection conn = null;
////         Statement stmt = null;
////         ResultSet rs = null;
////         
////         try {
////            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
////            conn = DriverManager.getConnection(
////                  "jdbc:oracle:thin:@localhost:1521:xe",
////                  "STUDY",
////                  "STUDY");
////            stmt = conn.createStatement();
////            rs = stmt.executeQuery(
////                  "select MNO,MNAME,EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC");
////            
////            response.setContentType("text/html; charset=UTF-8");
////            PrintWriter out = response.getWriter();
////            out.println("<html><head><title>회원목록</title></head>");
////            out.println("<body><h1>회원목록</h1>");
////            while(rs.next()) {
////               out.println(
////                     rs.getInt("MNO")+","+
////                     rs.getString("MNAME")+","+
////                     rs.getString("EMAIL")+","+
////                     rs.getDate("CRE_DATE")+"<br>");
////                     
////            }
////            out.println("</body></html>");
////                  
////            
////         }catch(Exception e){
////            
////         }finally {
////            if(rs!=null)
////               try {
////                  rs.close();
////               } catch (SQLException e) {
////                  // TODO Auto-generated catch block
////                  e.printStackTrace();
////               }
////            if(stmt!=null)
////               try {
////                  stmt.close();
////               } catch (SQLException e) {
////                  // TODO Auto-generated catch block
////                  e.printStackTrace();
////               }
////            if(conn!=null)
////               try {
////                  conn.close();
////               } catch (SQLException e) {
////                  // TODO Auto-generated catch block
////                  e.printStackTrace();
////               }
////         }
////      
////   }
////
////}
//package test;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.servlet.GenericServlet;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;
//
//import spms.vo.Member;
//
///**
// * Servlet implementation class MemberListServlet
// */
//@WebServlet("/member/list")
//public class MemberListServlet extends GenericServlet {
//   private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see GenericServlet#GenericServlet()
//     */
//    public MemberListServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//   /**
//    * @see Servlet#service(ServletRequest request, ServletResponse response)
//    */
//   public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//      // TODO Auto-generated method stub
//      // JDBC 6단계
//      // 0. JDBC 드라이버를 WEB-INF/lib에 복사한다. 
//      // 1. JDBC 드라이버 로드 
//      // 2. Database 연결 
//      // 3. SQL 실행을 위한 준비
//      // 4. SQL 문장 실행
//      // 5. 결과 확인
//      // 6. Database 연결 해제 
//      
//      Connection conn = null;
//      Statement stmt = null;
//      ResultSet rs = null;
//      try { 
//         //준비단계
//         //web.xml에서 설정한 context-param을 읽어들이는 Class를 사용하여 ㅓ리
//         ServletContext sc= this.getServletContext();
//         // 1단계
//         //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
////         Class.forName(sc.getInitParameter("driver"));
////         // 2단계
//////         conn = DriverManager.getConnection(
//////               "jdbc:oracle:thin:@localhost:1521:xe",
//////            //   JDBC로 oracle을 연결하는데 IP는 localhost이고, Port는 1521이고 SID XE 
//////               "STUDY", "STUDY");
////         conn = DriverManager.getConnection(
////               sc.getInitParameter("url"),
////              //   JDBC로 oracle을 연결하는데 IP는 localhost이고, Port는 1521이고 SID XE 
////               sc.getInitParameter("username"), sc.getInitParameter("password"));
//         // 3단계: Query를 실행할 준비  
//         conn=(Connection) sc.getAttribute("conn");
//         
//         stmt = conn.createStatement();
//         
//         rs = stmt.executeQuery(
//               "SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
//               " FROM MEMBERS" +
//               " ORDER BY MNO ASC");
//         response.setContentType("text/html; charset=UTF8");
//         
//         ArrayList<Member> members = new ArrayList<Member>();
////         out.println("<html><head><title>회원목록</title></head>");
////         out.println("<body><h1>회원목록</h1>");
////         out.println("<p><a href='add'>신규 회원</a></p>");
//         while(rs.next()){
//            // <a href="URL" alt="">링크</a>
//            // <a href="update?no=3">3</a>
//            // <a href="update?no="+mno+">"+mno+"</a>
//            // <a href="update?no="+ rs.getInt("mno")+">"+ rs.getInt("mno")+"</a>"
//            
//           Member member = new Member(); 
//           member.setNo(rs.getInt("mno"));
//           member.setName(rs.getString("mname"));
//           member.setEmail(rs.getString("email"));
//           member.setCreateDate(rs.getDate("CRE_DATE"));
//           members.add(member);
////            out.println(
////               
////               
////            
////               rs.getInt("MNO") + "," +
////               //"<a href='update?no=" + rs.getInt("MNO") + "'>" +
////              rs.getString("MNAME") + "," +
////               rs.getString("EMAIL") + "," + 
////               rs.getDate("CRE_DATE") +
////               "<a href='update?no="+rs.getInt("mno")+"'>[수정]</a> &nbsp;"+ 
////               "<a href='delete?no="+rs.getInt("MNO") +
////               "'>[삭제]</a><br>"
////            );
//         }
////         out.println("</body></html>");
//            request.setAttribute("members", members);
//            
//            RequestDispatcher rd = request.getRequestDispatcher("/member/MemberList.jsp");
//            rd.include(request, response);
//         
//      } catch (Exception e) {
//         e.getStackTrace(); // 에러메세지 console
//      } finally {
//         if (rs != null)
//            try {
//               rs.close();
//            } catch (SQLException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//            }
//         
//         if (stmt != null)
//            try {
//               stmt.close();
//            } catch (SQLException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//            }
////         if (conn != null)
////            try {
////               conn.close();
////            } catch (SQLException e) {
////               // TODO Auto-generated catch block
////               e.printStackTrace();
////            }
//      }
//
//   }
//
//}