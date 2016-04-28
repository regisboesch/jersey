package swiss.regisboesch.rest.database;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import swiss.regisboesch.rest.database.model.Currencies;

public class myDao {
	final Logger logger = LoggerFactory.getLogger(myDao.class);
	private Sql2o sql2o;

	public myDao() {
		this.sql2o = new Sql2o("jdbc:h2:~/t", "sa", null);
	}

	public List<Currencies> getAllTasks() {
		String sql = "SELECT id, name, code FROM currencies";
		try {
			Connection con = sql2o.open();
			return con.createQuery(sql).executeAndFetch(Currencies.class);
		} catch (Exception e) {
			logger.error("Error", e);
		}

		return null;
	}
}
