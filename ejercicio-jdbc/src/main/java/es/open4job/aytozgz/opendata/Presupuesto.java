package es.open4job.aytozgz.opendata;

import java.util.Iterator;
import java.util.List;

import es.open4job.aytozgz.opendata.model.dao.presupuesto.GastoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.dao.presupuesto.IngresoCorrienteDAO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.GastoCorrienteVO;
import es.open4job.aytozgz.opendata.model.vo.presupuesto.IngresoCorrienteVO;

public class Presupuesto {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String HOST = "54.154.192.80";
	private static final String PUERTO = "1521";
	private static final String SID = "xe";
	private static final String USER = "open4job";
	private static final String PASSWORD = "open4job";
	private static final String URL = "jdbc:oracle:thin:" + USER + "/"
			+ PASSWORD + "@" + HOST + ":" + PUERTO + ":" + SID;

	public static void main(String[] args) {

		GastoCorrienteDAO gastoCorrienteDAO = new GastoCorrienteDAO(DRIVER,
				URL, USER, PASSWORD);

		// Obtener y mostrar el listado de todos los gastos corrientes
		List<GastoCorrienteVO> gastos = gastoCorrienteDAO.getListadoGastos();

		if (gastos != null) {

			Iterator<GastoCorrienteVO> iterator = gastos.iterator();

			while (iterator.hasNext()) {

				GastoCorrienteVO gasto = iterator.next();
				System.out.println(gasto.toString());

			}

		}

		// Obtener el gasto corriente dado el id
		String idGasto = "20140930-14CAF--011--913734";
		GastoCorrienteVO gasto = gastoCorrienteDAO.getDatosGasto(idGasto);
		System.out.println(gasto.toString());

		// Obtener el listado de todos los ingresos corrientes
		IngresoCorrienteDAO ingresoCorrienteDAO = new IngresoCorrienteDAO(
				DRIVER, URL, USER, PASSWORD);

		List<IngresoCorrienteVO> ingresos = ingresoCorrienteDAO
				.getListadoIngresos();

		if (ingresos != null) {

			Iterator<IngresoCorrienteVO> iterator = ingresos.iterator();

			while (iterator.hasNext()) {

				IngresoCorrienteVO ingreso = iterator.next();
				System.out.println(ingreso.toString());

			}

		}

		// Obtener el ingreso corriente dado el id
		String idIngreso = "20140930-42030";
		IngresoCorrienteVO ingreso = ingresoCorrienteDAO
				.getDatosIngreso(idIngreso);
		System.out.println(ingreso.toString());

	}

}
