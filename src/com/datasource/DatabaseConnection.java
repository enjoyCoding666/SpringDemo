package com.datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by lenovo on 2017/5/9.
 */
public class DatabaseConnection {
   private static final String DSNAME="java:comp/env/dao/worker";
   private Connection conn=null;
   public DatabaseConnection() throws Exception {
       try{
           Context ctx=new InitialContext();
           DataSource ds=(DataSource) ctx.lookup(DSNAME);
           this.conn=ds.getConnection();
       }catch (Exception e){
           e.printStackTrace();
       }
   }

     //取得数据库连接
   public Connection getConnection() {
       return  this.conn;
   }

     //关闭数据库
   public  void close() throws  Exception{
       if(this.conn!=null) {
           try{
               this.conn.close();
           }catch (Exception e) {
               throw e;
           }
       }
   }
}
