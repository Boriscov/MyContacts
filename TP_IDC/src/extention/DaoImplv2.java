package extention;

import dao.IDao;

public class DaoImplv2 implements IDao{

	@Override
	public double getData() {
		System.out.println("Version web service");
		double v2 = 50;
		return 50;
	}

}
