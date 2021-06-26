package com.revolut.moneytransfer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.TransferDetails;
import com.revolut.moneytransfer.model.User;

/**
 * @author rohsingh
 *
 */
public class MoneyTransferDao {

	private HsqlDataSource dataSource;

	public MoneyTransferDao() {
		this.dataSource = new HsqlDataSource();
	}

	public User getUser(String id) throws SQLException {
		String query = "select * from user where userId = " + id;
		ResultSet rs = dataSource.query(query);
		while (rs.next()) {
			return new User(rs.getString("userId"), rs.getString("name"));
		}
		return null;
	}

	public Account getAccount(Long accountId) throws SQLException {
		String query = "select * from account where accountId = " + accountId;
		ResultSet rs = dataSource.query(query);
		while (rs.next()) {
			return new Account(null, rs.getLong("accountId"), rs.getDouble("balance"), rs.getDouble("blockAmount"));
		}
		return null;
	}

	public int executeTransfer(TransferDetails transfer) throws SQLException {
		String sql = "insert into transfer_details (transferId, from_account_id, to_account_id, amount, userId, status) VALUES (?,?,?,?,?)";

		PreparedStatement preparedStatement = dataSource.prepare(sql);
		preparedStatement.setLong(1,  transfer.getTransferId());
		preparedStatement.setLong(2, transfer.getFromAccountId());
		preparedStatement.setLong(3, transfer.getToAccountId());
		preparedStatement.setDouble(4, transfer.getAmount());
		preparedStatement.setString(5, transfer.getUserId());

		int row = preparedStatement.executeUpdate();
		return row;
	}

}
