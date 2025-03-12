package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

// myBatis를 이용하여 DB자료를 처리하는 순서 및 방법 

public class LprodMybatisTest {
      
      
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      // 1. myBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서
      //    처리하고 처리가 완료되면 SqlSessionFactory객체를 생성한다.
      
      InputStream   in = null;
      SqlSessionFactory factory = null;
      try {
         // 1-1. 환경설정 파일을 읽어올 스트림 객체를 생성한다.
         //       (환경설정 파일을 지정해서 생성한다.)
         in = Resources.getResourceAsStream("kr/or/ddit/myBatis/config/myBatis-config.xml");
      
         // 1-2. 환경 설정 파일을 읽어와 환경 설정을 완셩하면 SqlSessionFactory 객체가 생성된다.
         factory = new SqlSessionFactoryBuilder().build(in);
      
      
      } catch (Exception e) {
         System.out.println("myBatis 초기화 작업 실패 !! ");
         e.printStackTrace();
      }finally {
         if(in!=null) try {in.close();} catch(IOException e) {}
      }
      
      //----------------------------------------------------------------------
      
      // 2. mapper에 등록된 SQL문 중 실행할 SQL문을 호출해서 처리하기 
      
      // 2-1. insert 연습
//      System.out.println("insert 작업 시작 ..");
//      
//      System.out.print("Lprod_id 입력 > >");
//      int lprodId = scan.nextInt();
//      
//      System.out.print("Lprod_gu 입력 > >");
//      String lprodGu = scan.next();
//      
//      System.out.print("Lprod_name 입력 > >");
//      String lprodName = scan.next();
//      
//      // 입력한 자료를 Vo객체에 저장한다
//      LprodVO lvo = new LprodVO();
//      lvo.setLprod_id(lprodId);
//      lvo.setLprod_gu(lprodGu);
//      lvo.setLprod_name(lprodName);
//      
//      SqlSession session = null;
//      
//      try {
//         // sqlSessionFactory 객체의 openSession() 메서드를 이용하여
//         // SQL문을 호출해서 실행할 수 있는 SqlSession 객체를 생성한다.
//         // 형식) SqlSessionFactory객체.openSession(논리값)
//         //          ==> '논리값' true면 'AutoCommit' 이 활성화 되고,
//         //         ==> '논리값'이 생략되거나 false이면 'AutoCommit'이 비활성화 된다.
//         
//         
//         session = factory.openSession();
//         
//         // SqlSession 객체를 이용해서 처리할 SQL문을 호출해서 실행한다.
//         // 형식) SqlSession객체.insert("namespace속성값.실행할 태그의id속성값", 파라미터)
//         //         ==> 반환값 : 실행에 성공한 레코드 수
//         int insertCnt = session.insert("lprod.insertLprod",lvo);
//         
//         if(insertCnt>0) {
//            session.commit();   // insert, update, delete 작업후 commit을 해줘야한다.
//            System.out.println("insert 작업 성공 ! !");
//         }else {
//            System.out.println(" insert 작업 실패 ~ ~ ");
//         }
//         
//      } catch (Exception e) {
//         e.printStackTrace();
//         
//      }finally {
//         // 자원반납
//         if(session !=null) session.close();
//      }
      /*
      // 2-2 update 연습
      System.out.println("update 작업 시작");
      
      System.out.println("수정할 Lprod_Gu입력 > >");
      String lprodGu2 = scan.next();
      
      System.out.println("새로운 Lprod_id입력 > > ");
      int lprodId2 = scan.nextInt();
      
      System.out.println("새로운 Lprod_name 입력 > >");
      String LprodName2 = scan.next();
      
      // 입력받은 자료를 VO에 저장
      LprodVO lvo2 = new LprodVO();
      lvo2.setLprod_id(lprodId2);
      lvo2.setLprod_gu(lprodGu2);
      lvo2.setLprod_name(LprodName2);
      
      SqlSession session = null;
      try {
         session = factory.openSession();
         // SQL문 호출하여 실행
         // 형식 ) SqlSession객체.update("namespacae속성값.실행할태그의id속성값", 파라미터);
         //       == > 반환값 : 실행에 성공한 레코드 수
         int updateCnt = session.update("lprod.updateLprod",lvo2);
         
         if(updateCnt>0) {
            session.commit();
            System.out.println("update 작업성공");
         }else {
            System.out.println("update 작업실패");
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         if(session != null) session.close();
      }
      */
      
      /*
      // 2-3 delete 연습
      System.out.println("delete 작업 시작");
      
      System.out.print("삭제할 Lprod_gu 입력 >> ");
      String lprodGu3 = scan.next();
      
      SqlSession session = null;
      
      try {
		session = factory.openSession();
		
		// SQL문 호출해서 실행
		// SqlSeesion객체.delete("namespacae속성값.실행할태그의id속성값", 파라미터);
        //       == > 반환값 : 실행에 성공한 레코드 수
		int deleteCnt = session.delete("lprod.deleteLprod", lprodGu3);
		
		if(deleteCnt > 0) {
			session.commit();
			System.out.println("작업 성공");
		} else {
			System.out.println("작업 실패");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
        if(session != null) session.close();
     }
     */
      
      // 2-4. select 연습
      /*
      //1) 응답 결과가 여러개의 레코드 일 경우
      System.out.println("select 작업 시작.. (결과가 여러개 일 경우)");
      
      SqlSession session = null;
      try {
		
    	  session = factory.openSession();
    	  // SQL문을 호출해서 실행 ==> 결과가 여러개일 경우에는 selectList() 메서드를 사용한다.
    	  // 형식) SqlSeesion객체.selectList("namespacae속성값.실행할태그의id속성값", 파라미터);
          //       == > 반환값 : select한 결과중 각각의 레코드를 resultType에 지정한 객체에 저장한 후 이 값을 List에 담아서 반환한다.
    	  
    	  List<LprodVO> lprodList = session.selectList("lprod.getAllLprod");
    	  
    	  for(LprodVO lvo3 : lprodList) {
    		  System.out.println("ID : " + lvo3.getLprod_id());
    		  System.out.println("GU : " + lvo3.getLprod_gu());
    		  System.out.println("NAME : " + lvo3.getLprod_name());
    		  System.out.println("---------------------------");
    	  }
    	  System.out.println("끝");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
        if(session != null) session.close();
     }
      */
      // 2) 응답 결과가 1개의 레코드일 경우
      System.out.println("select 작업 시작 결과가 한개일 경우...");
      System.out.print("검색할 Lprod_gu 입력 >>");
      String lprodGu4 = scan.next();
      
      SqlSession session = null;
      
      try {
		session = factory.openSession();
		
		//SQL문을 호출해서 실헹 ==> 검색한 결과가 1개일 경우에는 selectOne() 메서드를 사용한다.
		// 형식) SqlSession객체.selectOne("namespace속성값.실행할태그의id속성값",파라미터);
		//		==> 반환값 : 검색된 데이터가 있으면 resultType에 지정한 클래세 데이터를 담아서 반환하고
//							검색된 데이터가 없으면 null을 반환한다
		LprodVO lvo4 = session.selectOne("lprod.getLprod",lprodGu4);
		
		if(lvo4 == null) {
			System.out.println("정보 ㄴ");
			return;
		}
		
		System.out.println("	-- 검색 결과 --	");
		System.out.println("ID : " + lvo4.getLprod_id());
		System.out.println("GU : " + lvo4.getLprod_gu());
		System.out.println("NAME : " + lvo4.getLprod_name());
		System.out.println("--------------------------");
	} catch (Exception e) {	
		e.printStackTrace();
	} finally {
        if(session != null) session.close();
     }
   }

}
