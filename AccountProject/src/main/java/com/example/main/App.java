package com.example.main;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.bean.Account;
import com.example.bean.AccountType;
import com.example.service.AccountService;
import com.example.service.AccountServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	AccountService service=ctx.getBean("accountServiceImpl", AccountServiceImpl.class);
    	Account account=ctx.getBean("account", Account.class);
    	String str[]=UUID.randomUUID().toString().split("-");
    	account.setAccountNumber(str[0]);
    	account.setAccountType(AccountType.SAVING);
    	account.setInitialBalance(500000);
   	account=service.insertAccount(account);
//    			service.deleteAccountById(account);
//    			service.updateAccountById(account);
    }
}
