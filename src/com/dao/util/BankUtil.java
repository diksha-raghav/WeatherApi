package com.dao.util;

import java.util.List;

import org.json.simple.JSONObject;

import com.controllers.servlet.BankListController;
import com.controllers.servlet.IFSCController;
import com.dao.Service.IFSCService;

public class BankUtil 
{
	@SuppressWarnings("rawtypes")
	public static List getBankList()
	{
		if(BankListController.bankList!=null)
		{
			return BankListController.bankList;
		}
		else
		{
			BankListController.bankList=IFSCService.getBanks();
		}
		return BankListController.bankList;
	}
	public static JSONObject getAllBank()
	{
		if(IFSCController.bankdetail!=null)
			return IFSCController.bankdetail;
		else
			return IFSCService.getAllDetails();
	}
}
