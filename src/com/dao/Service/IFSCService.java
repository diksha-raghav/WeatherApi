package com.dao.Service;

import java.util.List;

import org.json.simple.JSONObject;

import com.model.dao.IFSCDao;

public class IFSCService 
{
	public static String[] getBank(String ifsc)
	{
		String bank[]=IFSCDao.getBankName(ifsc);
		return bank;
	}
	public static List<String> getBanks()
	{
		return IFSCDao.getBankList();
	}
	public static JSONObject getAllDetails()
	{
		return IFSCDao.getAllBankDetails();
	}
}
