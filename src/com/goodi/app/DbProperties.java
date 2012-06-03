package com.goodi.app;

/**
 * DB연결에 필요한 속성 값
 **/
public class DbProperties { //여러명이 프로젝트 작업시 하나의 DB를 공유해서 사용해야 하므로 
	                        //고정된 값으로(상수) 통일함
                            //Properties: 보통 설정문서에 관한경우 써주는 단어
  public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
  public static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL"; 
  public static final String ID = "scott";
  public static final String PWD = "1234";


  
  
}
