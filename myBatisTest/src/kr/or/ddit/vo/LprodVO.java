package kr.or.ddit.vo;

public class LprodVO {

   private int lprod_id;
   private String lprod_gu;
   private String lprod_name;
   
   // 생성자를 만들경우에는 '반드시' 기본 생성자도 같이 만들어야 한다. 
   
   
   
   public int getLprod_id() {
      return lprod_id;
   }
   public void setLprod_id(int lprod_id) {
      this.lprod_id = lprod_id;
   }
   public String getLprod_gu() {
      return lprod_gu;
   }
   public void setLprod_gu(String lprod_gu) {
      this.lprod_gu = lprod_gu;
   }
   public String getLprod_name() {
      return lprod_name;
   }
   public void setLprod_name(String lprod_name) {
      this.lprod_name = lprod_name;
   }
   @Override
   public String toString() {
      return "LpordVO [lprod_id=" + lprod_id + ", lprod_gu=" + lprod_gu + ", lprod_name=" + lprod_name + "]";
   }
   
   
}
