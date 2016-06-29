import urgencias.Urgencias;

public class PruebaUrgencias {
	public static void main(String[] args) {
		String [] ingresos = {"9, 15, 9, 30, 123415,MI766, 1",
							  "9, 15, 10, 30, 123543, MI765, 0",
							  "9, 17, 9, 30, 123734, TR454, 2",
							  "10, 15, 10, 31, 123465, TR325, 0",
							  "9, 10, 9, 20, 123261, TR325, 0",
							  "9, 15, 9, 35, 124415,MI766, 2",
							  "11, 15, 11, 30, 123243, TR325, 0",
							  "9, 17, 9, 30, 123724, TR454, 2",
							  "10, 15, 10, 31, 123455, TR325, 0",
							  "11, 40, 11, 50, 223261, TR325, 1"};
		
		Urgencias urg = new Urgencias(12, 7);
		for (String ingreso: ingresos) {
			urg.agregaServicio(ingreso);
		}
		
		System.out.println(urg.ingresosPorTiempoDeAtencion());
		System.out.println(urg.pacientesPorMedico());
        System.out.println(urg.idPacientesPorMedico());

		urg.presentaServicio();

	}
}
