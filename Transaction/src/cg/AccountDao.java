/**
 * 
 */
package cg;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author aruravic
 *
 */
public class AccountDao {
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Account account) {
		jdbcTemplate.update("INSERT INTO Account_table VALUES(?, ?)",
				account.getNumber(), account.getBalance());
	}

	public void update(Account account) {
		jdbcTemplate.update(
				"UPDATE Account_table SET Balance=? WHERE Account_Number=?",
				account.getBalance(), account.getNumber());
	}

	public Account select(String accountNumber) {
		return (Account) jdbcTemplate.queryForList(
				"select * from Account_table where Account_Number=?",
				new Object[] { accountNumber }, String.class);
		// retrieve account details for an account number
	}

	private class AccountRowMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			Account account = new Account();
			account.setNumber(resultSet.getString("Account_Number"));
			account.setBalance(resultSet.getDouble("Balance"));
			return account;
		}

	}
}
