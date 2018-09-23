package com.kaicom.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.kaicom.dao.AccountDao;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {
	private AccountDao dao ;
	private TransactionTemplate tt ;
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from, final Integer to, final Double money) {
		/*tt.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//숑풀
				dao.decreaseMoney(from, money);
				try{
					int i = 1/0;
				}catch (Exception e) {
					e.printStackTrace();
				}
				//속풀
				dao.increaseMoney(to, money);
			}
		});*/
		dao.decreaseMoney(from, money);
		int i = 1/0;
		//속풀
		dao.increaseMoney(to, money);
	}
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}
	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
}
