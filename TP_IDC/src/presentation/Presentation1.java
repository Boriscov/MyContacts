package presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

//import com.sun.java.util.jar.pack.Package.Class.Method;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class Presentation1 {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		/*DaoImpl dao = new DaoImpl();
		MetierImpl metier = new MetierImpl();
		//Injection des dependances: couplage de MetierImpl et DaoImpl
		metier.setDao(dao);
		System.out.println(metier.calcul());*/
		
		try {
			Scanner scanner = new Scanner(new File("config.txt"));
			
			String daoClassName = scanner.nextLine();
			Class cDao = Class.forName(daoClassName);
			IDao dao = (IDao) cDao.newInstance();
			
			String metierClassName = scanner.nextLine();
			Class cMetier = Class.forName(metierClassName);
			IMetier metier = (IMetier) cMetier.newInstance();
			
			java.lang.reflect.Method method = cMetier.getMethod("setDao", IDao.class);
			method.invoke(metier, dao);
			
			System.out.println(metier.calcul());
			
			//System.out.println(dao.getData());
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		
	}
		
}
