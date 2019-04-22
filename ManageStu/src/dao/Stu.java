package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import db.C3p0Con;
import entity.Student;

public class Stu {                   
	private static final int PAGESIZE = 5;
	Connection conn = C3p0Con.getConnection();
	QueryRunner runner = new QueryRunner();
	
	public void addStudent(Student n){			
		try {
			String sql = "INSERT INTO student (id,name,birDate,gender) VALUES (?,?,?,?)";
			Object[] params = {n.getId(),n.getName(),n.getBirDate(),n.getGender()};
			runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	public void updateStudent(Student n){
		try {
			String sql = "UPDATE student SET name=?,birDate=?,gender=? WHERE id=?";
			Object[] params = {n.getName(),n.getBirDate(),n.getGender(),n.getId()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	public void delStudent(int id){
		String sql="DELETE FROM student WHERE id=?";
		try {
			runner.update(conn, sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
	}
	
	public Student getStudent(int id){
		try {
			String sql = "SELECT * FROM student WHERE id =?";
			Object[] param = {id};
			Student n = runner.query(conn, sql, new BeanHandler<Student>(Student.class),param);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	
	public List<Student> query(int currentPage){	
		String sql = "SELECT * FROM student LIMIT ?,?";
		try {
			List<Student> nresult = runner.query(conn, sql, new BeanListHandler<Student>(Student.class),(currentPage-1)*PAGESIZE,PAGESIZE);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	 }
	 
	 public List<Student> query1(String name){	
		String sql = "SELECT * FROM student WHERE name =?";
		try {
			List<Student> nresult = runner.query(conn, sql, new BeanListHandler<Student>(Student.class),name);
			return nresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;
	}
	 
	 public int getTotalPage(){
		int totalPage = 0;
		int totalrecords = 0;
		String sql = "SELECT COUNT(*)  FROM student";		
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next()){
				totalrecords = rs.getInt(1);
			}
			totalPage = (totalrecords % PAGESIZE == 0 ? totalrecords / PAGESIZE : totalrecords/PAGESIZE + 1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return totalPage;	
	}
	
}
