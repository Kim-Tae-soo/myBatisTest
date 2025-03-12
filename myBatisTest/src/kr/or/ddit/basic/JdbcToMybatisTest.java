package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

public class JdbcToMybatisTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SqlSessionFactory factory = null;
        
        
        try (InputStream in = Resources.getResourceAsStream("kr/or/ddit/myBatis/config/myBatis-config.xml")) {
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            System.out.println("myBatis 초기화 작업 실패 !! ");
            e.printStackTrace();
        }

        try (SqlSession session = factory.openSession()) {
        	int maxId = session.selectOne("jdbc.getMaxLprodId");
        	maxId++; 
            
            String gu;
            int count;
            do {
                System.out.println("상품 분류 코드(LPROD_GU) 입력 >> ");
                gu = scan.next();
                count = session.selectOne("jdbc.countLprodGu", gu);
                if (count > 0) {
                    System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
                    System.out.println("다른 코드로 다시 입력하세요...");
                    System.out.println();
                }
            } while (count > 0);
            
            System.out.println("상품 분명 (LPROD_NAME) 입력 >> ");
            String name = scan.next();
            
            LprodVO lvo = new LprodVO();
            lvo.setLprod_id(maxId);
            lvo.setLprod_gu(gu);
            lvo.setLprod_name(name);
            
            int cnt = session.insert("jdbc.insertLprod", lvo);
            
            if (cnt > 0) {
                session.commit();
                System.out.println("등록 성공!!!");
            } else {
                System.out.println("등록 실패!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
