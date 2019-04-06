/**
 * 
 */
package com.cg.wallet.repo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.wallet.bean.Account;


/**
 * @author agupt166
 *
 */
public class StaticDB {
	private static HashMap<String, Account> map=new HashMap<String, Account>();
	private static Map<String,List<String>> tmap = new HashMap<>();
static {
	map.put("Ayush123",new Account("Ayush","Ayush123","Ayush@123"));
	map.put("Yaseen123",new Account("Yaseen","Yaseen123","Ayush@123"));
	
	tmap.put("Ayush123",new ArrayList<String>());
	tmap.put("Yaseen123",new ArrayList<String>());
}

public static HashMap<String, Account> getCustomers()
{
	return map;
}

public static Map<String, List<String>> getTransactions()
{
	return tmap;
}
}