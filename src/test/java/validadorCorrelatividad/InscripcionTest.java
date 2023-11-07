package validadorCorrelatividad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InscripcionTest {
    @Test
    public void alumno1(){
        Alumno alumno1 = new Alumno("Edgardo", "02020232");
        Materia matematicaI = new Materia("Matematica I");
        Inscripcion inscripcionEdgardo = new Inscripcion(alumno1, matematicaI);

        Assertions.assertTrue(inscripcionEdgardo.aprobada());
    }
    @Test
    public void alumno2(){ //No se debe poder inscribir a la materia
        Alumno alumno2 = new Alumno("Brisa", "12312312");
        Materia inglesI = new Materia("Ingles I");
        Materia inglesII = new Materia("Ingles II");
        inglesII.agregarCorrelativa(inglesI);

        Inscripcion inscripcionBrisa = new Inscripcion(alumno2, inglesII);

        Assertions.assertFalse(inscripcionBrisa.aprobada());
    }

    @Test
    public void alumno3(){
        Alumno alumno3 = new Alumno("Brisa", "12312312");
        Materia inglesI = new Materia("Ingles I");
        Materia inglesII = new Materia("Ingles II");

        inglesII.agregarCorrelativa(inglesI);

        alumno3.agregarMateriaAprobada(inglesI);

        Inscripcion inscripcionBrisa = new Inscripcion(alumno3, inglesII);

        Assertions.assertTrue(inscripcionBrisa.aprobada());
    }
}
