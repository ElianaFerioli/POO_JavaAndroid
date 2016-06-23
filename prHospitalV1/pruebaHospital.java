import hospital.Categoria;
import hospital.Departamento;
import hospital.Genero;
import hospital.Hospital;
import hospital.Medico;
import hospital.Paciente;

public class pruebaHospital {
    public static void main(String [] args) {
        Medico med1 = new Medico("22626262", "Juan", "Garcia Lopez", 34, Genero.HOMBRE,
                Categoria.ADJUNTO, true, 12);
        Medico med2 = new Medico("73737373", "Pedro", "Marin Perez", 33, Genero.HOMBRE,
                Categoria.INTERINO, true, 12);
        Medico med3 = new Medico("99487474", "Maria", "Velez Lopez", 39, Genero.MUJER,
                Categoria.ADJUNTO, true, 12);
        Medico med4 = new Medico("25252525", "Luisa", "Morilla Antera", 50, Genero.MUJER,
                Categoria.RESIDENTE, false, 12);
        Medico med5 = new Medico("88477444", "Ramon", "Gullon Mande", 46, Genero.HOMBRE,
                Categoria.RESIDENTE, false, 12);
        Medico med6 = new Medico("53536733", "Andres", "Robles Marea", 47, Genero.HOMBRE,
                Categoria.RESIDENTE, true, 12);
        Medico med7 = new Medico("77464564", "Ana", "Peralta Monte", 45, Genero.MUJER,
                Categoria.ADJUNTO, false, 12);
        Medico med8 = new Medico("61261523", "Ramon", "Linde Masa", 34, Genero.HOMBRE,
                Categoria.INTERINO, true, 12);
        Medico med9 = new Medico("99474643", "Joaquin", "Perez Valdes", 59, Genero.HOMBRE,
                Categoria.RESIDENTE, false, 12);
        Departamento dep1 = new Departamento("Oncologia", new Medico[] {med1, med2, med3});
        Departamento dep2 = new Departamento("Radioterapia", new Medico[] {med4, med5});
        Departamento dep3 = new Departamento("Pediatria", new Medico[] {med6, med7, med8, med9});
        Hospital hospital = new Hospital("La Gloria", "Camino del Cielo s/n",
                new Departamento[] {dep1, dep2, dep3}, 5);
        Paciente pac1 = new Paciente("65353535" , "Pedro", "Mal Tratado", 25, Genero.HOMBRE,
                1.80, 76, "1231532514345132513", false);
        Paciente pac2 = new Paciente("88376363" , "Juan", "Mas Malito", 57, Genero.HOMBRE,
                1.83, 86, "38746387467834738467", true);
        Paciente pac3 = new Paciente("44262623" , "Lourdes", "Lisa Manera", 29, Genero.MUJER,
                1.60, 68, "88373636365333345434", false);
        Paciente pac4 = new Paciente("77262562" , "Angela", "Aquime Quedo", 76, Genero.MUJER,
                1.63, 82, "23847283482364723823", false);
        Paciente pac5 = new Paciente("65624524" , "Juan", "Tengo Algo", 20, Genero.HOMBRE,
                1.90, 58, "28937872367283645528", true);
        Paciente pac6 = new Paciente("11525252" , "Jonh", "Vengod Elejos", 82, Genero.HOMBRE,
                1.64, 73, "34374638746834687865", false);
        pac1.asignaMedico(med1);
        pac2.asignaMedico(med2);
        pac3.asignaMedico(med5);
        pac4.asignaMedico(med8);
        pac5.asignaMedico(med8);
        pac6.asignaMedico(med2);
// A partir de aquí podemos probar vuestros metodos
        System.out.println(dep1);
        System.out.println("Medicos adjuntos " +
                dep1.numMedicos(Categoria.ADJUNTO));
        Medico me = dep3.getMedico("99474643");
        if (me == null) {
            System.out.println("No existe el medico en ese departamento");
        } else {
            System.out.println(me);
        }
    }
}
