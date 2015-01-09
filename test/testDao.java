import java.sql.SQLException;

import com.wt.dao.DAOManager;
import com.wt.dao.DAOManager.Table;
import com.wt.dao.FirstDAO;


public class testDao {

	public static void main(String[] args) throws Exception {
		DAOManager dao = new DAOManager();
		dao.open();
		FirstDAO fDao = (FirstDAO)dao.getDAO(Table.FIRST);
		System.out.println(fDao.name());
		dao.close();
	}

}
