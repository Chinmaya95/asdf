package com.cg.parallel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cg.parallel.bean.TransactionBean;
import com.cg.parallel.bean.WalletAccount;
import com.cg.parallel.exception.WalletException;

public class WalletDAOImpl implements WalletDAO {

	public WalletDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public WalletAccount createAccount(WalletAccount acc) throws WalletException {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		System.out.println("Connected");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from wallets");
		boolean exist=false;
		while(rs.next()) {
			if(rs.getString(1).equals(acc.getUserName())) {
				exist=true;
				break;
			}
		}
		if(exist)
		{
			rs.close();
			st.close();
			conn.close();
			throw new WalletException("Username already exists");
		}
		else
		{
			PreparedStatement pst=conn.prepareStatement("insert into wallets values(?,?,?,?)");
			pst.setString(1,acc.getUserName());
			pst.setString(2,acc.getWalletId());
			pst.setDouble(3,acc.getBalance());
			pst.setString(4,acc.getPassword());
			int i=pst.executeUpdate();
			pst.close();
			rs.close();
			st.close();
			conn.close();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public double showBalance(String username,String password)  throws WalletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			System.out.println("Connected");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select * from wallets");
			boolean exist=false;
			while(rs.next()) {
				if(rs.getString(1).equals(username))
				{
					exist=true;
					break;
				}
			}
			if(exist)
			{
				double balance = rs.getDouble(3);
				rs.close();
				st.close();
				conn.close();
				return balance;
			}
			else
			{
				rs.close();
				st.close();
				conn.close();
				throw new WalletException("No such username or/and wrong password");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public WalletAccount deposit(String username, double amount) throws WalletException  {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		System.out.println("Connected");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from wallets");
		boolean exist=false;
		while(rs.next()) {
			if(rs.getString(1).equals(username))
				{
					exist=true;
					break;
				}
		}
		if(exist)
		{
			PreparedStatement pst=conn.prepareStatement("update wallets set balance=? where username=?");
			pst.setString(1, username);
			pst.setDouble(3, rs.getDouble(3)+amount);
			int i2=pst.executeUpdate();
			String uname = rs.getString(1);
			String id = rs.getString(2);
			double bal = rs.getDouble(3);
			String pass = rs.getString(4);
			rs.close();
			pst.close();
			st.close();
			pst=conn.prepareStatement("insert into transactions values(?,?,?,?)");
			Random rand = new Random();
		    String card = "";
		    for (int i = 0; i < 14; i++)
		    {
		        int n = rand.nextInt(10) + 0;
		        card += Integer.toString(n);
		    }
			pst.setString(1,card);
			pst.setString(2,"Deposit");
			pst.setString(3,LocalDateTime.now().toString());
			pst.setString(4,"Self-Deposit");
			int i1=pst.executeUpdate();
			pst.close();
			conn.close();
			return new WalletAccount(uname,id,bal,pass);
		}
		else
		{
			rs.close();
			st.close();
			conn.close();
			throw new WalletException("Username does not exist");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WalletAccount withdraw(String username,String password, double amount)  throws WalletException {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		System.out.println("Connected");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from wallets");
		while(rs.next()) {
			if(rs.getString(1).equals(username))
				break;
		}
		if(rs.getString(1).equals(username))
		{
			if(rs.getString(4).equals(username))
			{
				PreparedStatement pst=conn.prepareStatement("update wallets set balance=? where username=?");
				pst.setString(1, username);
				pst.setDouble(3, rs.getDouble(3)-amount);
				pst.executeUpdate();
				String uname = rs.getString(1);
				String id = rs.getString(2);
				double bal = rs.getDouble(3);
				String pass = rs.getString(4);
				rs.close();
				pst.close();
				st.close();
				pst=conn.prepareStatement("insert into transactions values(?,?,?,?)");
				Random rand = new Random();
			    String card = "";
			    for (int i = 0; i < 14; i++)
			    {
			        int n = rand.nextInt(10) + 0;
			        card += Integer.toString(n);
			    }
				pst.setString(1,card);
				pst.setString(2,"Withdraw");
				pst.setString(3,LocalDateTime.now().toString());
				pst.setString(4,"Self-Withdraw");
				int i=pst.executeUpdate();
				pst.close();
				conn.close();
				return new WalletAccount(uname,id,bal,pass);
			}
			else
				throw new WalletException("Password incorrect!! Access Denied");
		}
		else
		{
			rs.close();
			st.close();
			conn.close();
			throw new WalletException("Username does not exist");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WalletAccount> fundTransfer(String fromUserName,String fromPassword,String toUserName,double amount) throws WalletException  {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		System.out.println("Connected");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from wallets");
		while(rs.next()) {
			if(rs.getString(1).equals(fromUserName))
				break;
		}
		if(!rs.getString(1).equals(fromUserName))
		{
			rs.close();
			st.close();
			conn.close();
			throw new WalletException("Sender username is incorrect");
		}
		else if(!rs.getString(1).equals(fromPassword))
		{
			rs.close();
			st.close();
			conn.close();
			throw new WalletException("Sender password is incorrect");
		}
		else
		{
			rs.close();
			rs=st.executeQuery("select * from wallets");
			while(rs.next()) {
				if(rs.getString(1).equals(toUserName))
					break;
			}
			if(!rs.getString(1).equals(toUserName))
			{
				rs.close();
				st.close();
				conn.close();
				throw new WalletException("Receiver username is incorrect");
			}
			else
			{
				withdraw(fromUserName, fromPassword, amount);
				deposit(toUserName,amount);
				List<WalletAccount> wList=new ArrayList<WalletAccount>();
				rs.close();
				rs=st.executeQuery("select * from wallets");
				while(rs.next()) {
					if(rs.getString(1).equals(fromUserName))
						break;
				}
				wList.add(new WalletAccount(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
				rs.close();
				rs=st.executeQuery("select * from wallets");
				while(rs.next()) {
					if(rs.getString(1).equals(toUserName))
						break;
				}
				wList.add(new WalletAccount(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
				rs.close();
				st.close();
				conn.close();
				return wList;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransactionBean> printTransactions(String username,String password) throws WalletException  {
		// TODO Auto-generated method stub
		List<TransactionBean> tList=new ArrayList<TransactionBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.register.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			System.out.println("Connected");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select * from transactions");
			rs=st.executeQuery("select * from transactions");
			while(rs.next()) {
				tList.add(new TransactionBean(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			rs.close();
			st.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
